package com.sedatram.view.formality.buyer.legal;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;

import com.sedatram.controller.BuyerController;
import com.sedatram.controller.FormalityController;
import com.sedatram.controller.PersonController;
import com.sedatram.controller.auxiliar.CityController;
import com.sedatram.controller.auxiliar.DepartmentController;
import com.sedatram.model.Buyer;
import com.sedatram.model.Formality;
import com.sedatram.model.Person;
import com.sedatram.model.auxiliar.City;
import com.sedatram.model.auxiliar.Department;
import com.sedatram.utils.InputsVerifier;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.utils.Utils;
import com.sedatram.view.abstract_view.DataPanelAbstract;

public class DataPanelLegalBuyer extends DataPanelAbstract<Buyer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> typeDocumentBox;
	private JTextField identificationField;
	private JTextField nameField;
	private JTextField acronymField;
	private JTextField emailField;
	private JTextField phoneField;
	private JTextField cellphoneField;
	private JTextField addressField;
	private JTextField cityField;
	private JTextField departmentField;
	private CELegalBuyer parent;

	public DataPanelLegalBuyer(Buyer data, CELegalBuyer parent) {
		super(data);
	}

	@Override
	protected void defineFields() {
		typeDocumentBox = new JComboBox<>(StringsUtil.LEGAL_CUSTOMER_DOCUMENTS_OPTIONS);
		identificationField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
		identificationField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				String iden = identificationField.getText();
				iden = iden.replaceAll("\\.", "");
				iden = iden.replaceAll("-", "");
				String nit = Utils.formatNit(iden);
				if (nit.equals("")) {
					JOptionPane.showMessageDialog(null, StringsUtil.NIT_NOT_VALID, StringsUtil.TITLE,
							JOptionPane.ERROR_MESSAGE);
					identificationField.setText("");
				} else {
					identificationField.setText(nit);
					Buyer buyer = BuyerController.getInstance().getBuyer(identificationField.getText());
					if (buyer != null) {
						data = buyer;
						fillData();
					} else {
						Person person = PersonController.getInstance().getPerson(identificationField.getText());
						if (person != null) {
							data.getDataFromPerson(person);
							fillData();
						}
					}
				}
				nameField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
				nameField.setInputVerifier(InputsVerifier.toUpper);
				acronymField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
				acronymField.setInputVerifier(InputsVerifier.toUpper);
				emailField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
				emailField.setInputVerifier(InputsVerifier.toLower);
				phoneField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
				phoneField.setInputVerifier(InputsVerifier.formatPhone);
				cellphoneField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
				cellphoneField.setInputVerifier(InputsVerifier.formatCellphone);
				addressField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
				cityField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
				AutoCompleteDecorator.decorate(cityField, CityController.getInstance().getAll(), false,
						ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
				cityField.setInputVerifier(InputsVerifier.toUpper);
				departmentField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
				AutoCompleteDecorator.decorate(departmentField, DepartmentController.getInstance().getAll(), false,
						ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
				departmentField.setInputVerifier(InputsVerifier.toUpper);

			}
		});
	}

	@Override
	public void fillData() {
		if (data.getIdentification() != null) {
			typeDocumentBox.setSelectedItem(data.getTypeDocument());
			identificationField.setText(String.valueOf(data.getIdentification()));
			nameField.setText(data.getFirstName());
			acronymField.setText(data.getAcronym());
			emailField.setText(data.getEmail());
			phoneField.setText(data.getPhone());
			cellphoneField.setText(data.getCell());
			addressField.setText(data.getAddress());
			cityField.setText(data.getCity());
			departmentField.setText(data.getDepartment());
		}

	}

	@Override
	public boolean saveData() {
		ArrayList<Component> error = new ArrayList<>();
		if (typeDocumentBox.getSelectedItem().equals("")) {
			error.add(typeDocumentBox.getEditor().getEditorComponent());
		}
		if (identificationField.getText().isEmpty()) {
			error.add(identificationField);
		}
		if (nameField.getText().isEmpty()) {
			error.add(nameField);
		}
		if (error.isEmpty()) {
			Formality formality = parent.formality;
			data.setTypeDocument((String) typeDocumentBox.getSelectedItem());
			data.setIdentification(identificationField.getText());
			data.setFirstName(nameField.getText());
			data.setAcronym(acronymField.getText());
			data.setEmail(emailField.getText());
			data.setPhone(phoneField.getText());
			data.setCell(cellphoneField.getText());
			data.setAddress(addressField.getText());
			data.setCity(cityField.getText());
			data.setDepartment(departmentField.getText());
			if (formality.existBuyer(data)) {
				formality.removeBuyer(data);
			}
			formality.addBuyer(data);
			FormalityController.getInstance().save(formality);
			PersonController.getInstance().saveBuyerAsPerson(data);
			if (!CityController.getInstance().exist(cityField.getText())) {
				City city = new City(cityField.getText());
				CityController.getInstance().save(city);
			}
			if (!DepartmentController.getInstance().exist(departmentField.getText())) {
				Department department = new Department(departmentField.getText());
				DepartmentController.getInstance().save(department);
			}
			return true;
		} else {
			JOptionPane.showMessageDialog(this, StringsUtil.INCOMPLETE_DATA_MESSAGE);
			for (Component component : error) {
				component.setBackground(Color.pink);
			}
		}
		return false;
	}

	@Override
	protected void setComponentArray() {
		componentArray.add(typeDocumentBox);
		componentArray.add(identificationField);
		componentArray.add(nameField);
		componentArray.add(acronymField);
		componentArray.add(emailField);
		componentArray.add(phoneField);
		componentArray.add(cellphoneField);
		componentArray.add(addressField);
		componentArray.add(cityField);
		componentArray.add(departmentField);
	}

	@Override
	protected void setLabelArray() {
		for (String s : StringsUtil.LEGAL_BUYER_FIELDS) {
			labelArray.add(new JLabel(s));
		}
	}

}

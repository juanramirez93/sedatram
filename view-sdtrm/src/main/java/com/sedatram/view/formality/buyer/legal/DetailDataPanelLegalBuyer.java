package com.sedatram.view.formality.buyer.legal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sedatram.model.Buyer;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.utils.Utils;
import com.sedatram.view.abstract_view.DataPanelAbstract;

public class DetailDataPanelLegalBuyer extends DataPanelAbstract<Buyer> implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField typeDocumentBox;
	private JTextField identificationField;
	private JTextField nameField;
	private JTextField acronymField;
	private JPanel emailPanel;
	private JButton sendEmailButton;
	private JTextField emailField;
	private JTextField phoneField;
	private JTextField cellphoneField;
	private JTextField addressField;
	private JTextField cityField;

	private JTextField departmentField;

	public DetailDataPanelLegalBuyer(Buyer data) {
		super(data);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(sendEmailButton)) {
			Utils.sendEmail(data.getEmail());
		}
	}

	@Override
	protected void defineFields() {
		typeDocumentBox = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
		typeDocumentBox.setEditable(false);
		identificationField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
		identificationField.setEditable(false);
		nameField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
		nameField.setEditable(false);
		acronymField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
		acronymField.setEditable(false);
		emailPanel = new JPanel();
		emailField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
		emailField.setEditable(false);
		sendEmailButton = new JButton(StringsUtil.SEND_EMAIL);
		sendEmailButton.addActionListener(this);
		emailPanel.add(emailField);
		emailPanel.add(sendEmailButton);
		phoneField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
		phoneField.setEditable(false);
		cellphoneField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
		cellphoneField.setEditable(false);
		addressField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
		addressField.setEditable(false);
		cityField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
		cityField.setEditable(false);
		departmentField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
		departmentField.setEditable(false);
	}

	@Override
	public void fillData() {
		typeDocumentBox.setText(data.getTypeDocument());
		identificationField.setText(String.valueOf(data.getIdentification()));
		nameField.setText(data.getFirstName());
		acronymField.setText(data.getLastName());
		emailField.setText(data.getEmail());
		phoneField.setText(data.getPhone());
		cellphoneField.setText(data.getCell());
		addressField.setText(data.getAddress());
		cityField.setText(data.getCity());
		departmentField.setText(data.getDepartment());

	}

	@Override
	public boolean saveData() {
		return false;
	}

	@Override
	protected void setComponentArray() {
		componentArray.add(typeDocumentBox);
		componentArray.add(identificationField);
		componentArray.add(nameField);
		componentArray.add(acronymField);
		componentArray.add(emailPanel);
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

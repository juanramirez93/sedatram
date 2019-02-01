package com.sedatram.view.formality;

import com.sedatram.controller.FormalityController;
import com.sedatram.controller.PersonController;
import com.sedatram.controller.VehicleController;
import com.sedatram.model.Formality;
import com.sedatram.model.Person;
import com.sedatram.model.Vehicle;
import com.sedatram.model.auxiliar.TypeFormality;
import com.sedatram.utils.InputsVerifier;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.utils.Utils;
import com.sedatram.view.abstract_view.CEAbstract;
import com.sedatram.view.abstract_view.DataPanelAbstract;
import com.sedatram.view.customer.legal.CELegalCustomer;
import com.sedatram.view.customer.natural.CENaturalCustomer;
import com.sedatram.view.vehicle.CEVehicle;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Date;

public class DataPanelFormality extends DataPanelAbstract<Formality> implements ActionListener {

	private JComboBox<TypeFormality> typeBox;
	private JDateChooser initDateChooser;
	private JTextField customerField;
	private JTextField vehicleField;

	public DataPanelFormality(Formality data) {
		super(data);
	}

	@Override
	protected void setLabelArray() {
		labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[0]));
		labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[1]));
	}

	@Override
	protected void setComponentArray() {
		componentArray.clear();
		componentArray.add(typeBox);
		componentArray.add(initDateChooser);
		TypeFormality typeFormality = (TypeFormality) typeBox.getSelectedItem();
		if (typeFormality.isCustomer()) {
			labelArray.add((new JLabel(StringsUtil.FORMALITY_FIELDS[2])));
			componentArray.add(customerField);
		}
		if (typeFormality.isVehicle()) {
			labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[3]));
			componentArray.add(vehicleField);
		}
	}

	@Override
	protected void defineFields() {
		typeBox = new JComboBox<>(FormalityController.getInstance().getAllTypes());
		typeBox.addActionListener(this);
		customerField = new JTextField(NumbersUtil.FORMALITY_FIELD);
		customerField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent focusEvent) {
			}

			@Override
			public void focusLost(FocusEvent focusEvent) {
				String idStr = customerField.getText().replaceAll("\\.", "");
				idStr = idStr.replaceAll("\\.", "");
				if (Utils.isNumberOrNull(idStr)) {
					String natId = StringsUtil.formatId(idStr);
					System.out.println(natId);
					String legId = Utils.formatNit(idStr);
					System.out.println(legId);
					if (PersonController.getInstance().existCustomer(natId)) {
						data.setCustomer(PersonController.getInstance().getCustomer(natId));
						customerField.setText(natId);
					} else if (PersonController.getInstance().existCustomer(legId)) {
						data.setCustomer(PersonController.getInstance().getCustomer(legId));
						customerField.setText(legId);
					} else {
						int rta = JOptionPane.showConfirmDialog(null, StringsUtil.CUSTOMER_DO_NOT_EXIST,
								StringsUtil.TITLE, JOptionPane.OK_CANCEL_OPTION);
						if (rta == 0) {
							CEAbstract<Person> ceFrame;
							rta = JOptionPane.showOptionDialog(null, StringsUtil.NATURAL_OR_LEGAL, StringsUtil.TITLE,
									JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
									new Object[] { "Natural", "Jurídico" }, 0);
							if (rta == 0) {
								Person person = PersonController.getInstance().getPerson(natId);
								if (person == null) {
									person = new Person(natId);
								}
								ceFrame = new CENaturalCustomer(null, person);
								data.setCustomer(PersonController.getInstance().getCustomer(natId));
								customerField.setText(natId);
							} else {
								Person person = PersonController.getInstance().getPerson(legId);
								if (person == null) {
									person = new Person(legId);
								}
								ceFrame = new CENaturalCustomer(null, person);
								data.setCustomer(PersonController.getInstance().getCustomer(legId));
								customerField.setText(legId);
							}
							ceFrame.setVisible(true);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, StringsUtil.ONLY_NUMBERS_MESSAGE, StringsUtil.TITLE,
							JOptionPane.ERROR_MESSAGE);
					customerField.setText("");
				}
			}
		});
		initDateChooser = new JDateChooser(new Date());
		vehicleField = new JTextField(NumbersUtil.FORMALITY_FIELD);
		vehicleField.setInputVerifier(InputsVerifier.toUpper);
		vehicleField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				String plaque = vehicleField.getText().trim();
				Vehicle vehicle = VehicleController.getInstance().getVehicle(plaque);
				if (vehicle == null) {
					int rta = JOptionPane.showConfirmDialog(null, StringsUtil.VEHICLE_DO_NOT_EXIST, StringsUtil.TITLE,
							JOptionPane.OK_CANCEL_OPTION);
					if (rta == 0) {
						CEVehicle ceVehicle = new CEVehicle(null, new Vehicle());
						ceVehicle.setVisible(true);
					}
					vehicleField.setText("");
				} else {
					data.setVehicle(vehicle);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public boolean saveData() {
		return false;
	}

	@Override
	public void fillData() {
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource().equals(typeBox)) {
			reloadUI();
		}
	}

	private void reloadUI() {
		setLabelArray();
		setComponentArray();
		fillData();
		printLayout();
	}
}

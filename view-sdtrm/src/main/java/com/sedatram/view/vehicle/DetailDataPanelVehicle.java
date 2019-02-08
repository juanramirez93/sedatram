package com.sedatram.view.vehicle;

import com.sedatram.model.Vehicle;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.utils.Utils;
import com.sedatram.view.abstract_view.DataPanelAbstract;

import javax.swing.*;

public class DetailDataPanelVehicle extends DataPanelAbstract<Vehicle> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField plaqueField;
	private JTextField serviceComboBox;
	private JTextField typeField;
	private JTextField brandField;
	private JTextField lineField;
	private JTextField modelField;
	private JTextField colorField;
	private JTextField serialField;
	private JTextField motorField;
	private JTextField chassisField;
	private JTextField vinField;
	private JTextField displacementField;
	private JTextField bodyworkField;
	private JTextField fuelField;
	private JTextField registrationField;
	private JTextField transitField;
	private JTextField capacityField;
	private JTextField PBVField;
	private JTextField axesField;

	public DetailDataPanelVehicle(Vehicle data) {
		super(data);
	}

	@Override
	protected void defineFields() {
		plaqueField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		serviceComboBox = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		typeField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		brandField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		lineField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		modelField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		colorField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		serialField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		motorField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		chassisField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		vinField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		displacementField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		bodyworkField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		fuelField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		registrationField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		transitField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		capacityField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		PBVField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
		axesField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
	}

	@Override
	public void fillData() {
		plaqueField.setText(data.getPlaque());
		serviceComboBox.setText(data.getService());
		typeField.setText(data.getType());
		brandField.setText(data.getBrand());
		lineField.setText(data.getLine());
		modelField.setText(data.getModel());
		colorField.setText(data.getColor());
		serialField.setText(data.getSerial());
		chassisField.setText(data.getChassis());
		vinField.setText(data.getVin());
		displacementField.setText(data.getDisplacement());
		bodyworkField.setText(data.getBodywork());
		fuelField.setText(data.getGasoline());
		if (data.getRegistration() != null) {
			registrationField.setText(Utils.formatDate(data.getRegistration()));
		}
		transitField.setText(data.getTransit());
		capacityField.setText(data.getCapacity());
		PBVField.setText(data.getPBV());
		axesField.setText(data.getAxes());
	}

	@Override
	public boolean saveData() {
		return false;
	}

	@Override
	protected void setComponentArray() {
		componentArray.add(plaqueField);
		componentArray.add(serviceComboBox);
		componentArray.add(typeField);
		componentArray.add(brandField);
		componentArray.add(lineField);
		componentArray.add(modelField);
		componentArray.add(colorField);
		componentArray.add(serialField);
		componentArray.add(motorField);
		componentArray.add(chassisField);
		componentArray.add(vinField);
		componentArray.add(displacementField);
		componentArray.add(bodyworkField);
		componentArray.add(fuelField);
		componentArray.add(registrationField);
		componentArray.add(transitField);
		componentArray.add(capacityField);
		componentArray.add(PBVField);
		componentArray.add(axesField);
		for (JComponent jComponent : componentArray) {
			((JTextField) jComponent).setEditable(false);
		}
	}

	@Override
	protected void setLabelArray() {
		for (String s : StringsUtil.VEHICLE_FIELDS) {
			labelArray.add(new JLabel(s));
		}
	}
}

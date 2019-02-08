package com.sedatram.view.vehicle;
import com.sedatram.controller.VehicleController;
import com.sedatram.controller.auxiliar.BrandVehicleController;
import com.sedatram.controller.auxiliar.ColorVehicleController;
import com.sedatram.controller.auxiliar.TypeVehicleController;
import com.sedatram.model.Vehicle;
import com.sedatram.utils.InputsVerifier;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.DataPanelAbstract;
import com.sedatram.view.vehicle.owner.MainOwner;
import com.toedter.calendar.JDateChooser;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class DataPanelVehicle extends DataPanelAbstract<Vehicle> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private JTextField plaqueField;
    private JComboBox<String> serviceComboBox;
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
    private JDateChooser registrationField;
    private JTextField transitField;
    private JTextField capacityField;
    private JTextField PBVField;
    private JTextField axesField;

    private boolean isNew = false;

    public DataPanelVehicle(Vehicle data) {
        super(data);
        if(data.getPlaque() == null || data.getPlaque().isEmpty()) {
            isNew = true;
        }
    }

    @Override
    protected void defineFields() {
        plaqueField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
        plaqueField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                Vehicle vehicle = VehicleController.getInstance().getVehicle(plaqueField.getText());
                if(vehicle != null) {
                    data = vehicle;
                    fillData();
                }
            }
        });
        plaqueField.setInputVerifier(InputsVerifier.toUpper);
        serviceComboBox = new JComboBox<>(StringsUtil.VEHICLE_SERVICES);
        typeField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
        AutoCompleteDecorator.decorate(typeField, TypeVehicleController.getInstance().getAll(),
                false, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        typeField.setInputVerifier(InputsVerifier.toUpper);
        brandField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
        AutoCompleteDecorator.decorate(brandField, BrandVehicleController.getInstance().getAll(),
                false, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        brandField.setInputVerifier(InputsVerifier.toUpper);
        lineField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
        modelField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
        colorField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
        AutoCompleteDecorator.decorate(colorField, ColorVehicleController.getInstance().getAll(),
                false, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        colorField.setInputVerifier(InputsVerifier.toUpper);
        serialField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
        motorField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
        chassisField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
        vinField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
        displacementField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
        bodyworkField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
        bodyworkField.setInputVerifier(InputsVerifier.toUpper);
        fuelField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
        registrationField = new JDateChooser();
        transitField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
        transitField.setInputVerifier(InputsVerifier.toUpper);
        capacityField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
        PBVField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
        axesField = new JTextField(NumbersUtil.VEHICLE_FIELDS);
    }

    @Override
    public void fillData() {
        if(data.getPlaque() != null) {
            plaqueField.setText(data.getPlaque());
            serviceComboBox.setSelectedItem(data.getService());
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
            registrationField.setDate(data.getRegistration());
            transitField.setText(data.getTransit());
            capacityField.setText(data.getCapacity());
            PBVField.setText(data.getPBV());
            axesField.setText(data.getAxes());
        }
    }

    @Override
    public boolean saveData() {
        ArrayList<Component> error = new ArrayList<>();
        if(plaqueField.getText().equals("")) {
            error.add(plaqueField);
        }
        if(error.isEmpty()) {
            data.setPlaque(plaqueField.getText());
            data.setService(String.valueOf(serviceComboBox.getSelectedItem()));
            data.setType(typeField.getText());
            data.setBrand(brandField.getText());
            data.setLine(lineField.getText());
            data.setModel(modelField.getText());
            data.setColor(colorField.getText());
            data.setSerial(serialField.getText());
            data.setChassis(chassisField.getText());
            data.setVin(vinField.getText());
            data.setDisplacement(displacementField.getText());
            data.setBodywork(bodyworkField.getText());
            data.setGasoline(fuelField.getText());
            data.setRegistration(registrationField.getDate());
            data.setTransit(transitField.getText());
            data.setCapacity(capacityField.getText());
            data.setPBV(PBVField.getText());
            data.setAxes(axesField.getText());
            VehicleController.getInstance().save(data);
            TypeVehicleController.getInstance().save(typeField.getText());
            BrandVehicleController.getInstance().save(brandField.getText());
            ColorVehicleController.getInstance().save(colorField.getText());
            if(isNew) {
                int rta = JOptionPane.showConfirmDialog(null, StringsUtil.WISH_ADD_OWNER,
                        StringsUtil.TITLE, JOptionPane.YES_NO_OPTION);
                if(rta == 0) {
                    MainOwner mainOwner = new MainOwner(data);
                    mainOwner.setVisible(true);
                }
            }
            return true;
        }
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
    }

    @Override
    protected void setLabelArray() {
        for(String s : StringsUtil.VEHICLE_FIELDS) {
            labelArray.add(new JLabel(s));
        }
    }
}

package com.sedatram.view.vehicle.owner.natural;
import com.sedatram.controller.PersonController;
import com.sedatram.controller.VehicleController;
import com.sedatram.model.Person;
import com.sedatram.model.Vehicle;
import com.sedatram.utils.InputsVerifier;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.DataPanelAbstract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class DataPanelNaturalOwner extends DataPanelAbstract<Person> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CENaturalOwner parent;
    private JComboBox<String> typeDocumentBox;
    private JTextField identificationField;
    private JTextField firstNameField;
    private JTextField lastNameField;

    public DataPanelNaturalOwner(Person data, CENaturalOwner parent) {
        super(data);
        this.parent = parent;
    }

    @Override
    protected void setLabelArray() {
        for(String s : StringsUtil.NATURAL_OWNER_FIELDS) {
            labelArray.add(new JLabel(s));
        }
    }

    @Override
    protected void setComponentArray() {
        componentArray.add(typeDocumentBox);
        componentArray.add(identificationField);
        componentArray.add(firstNameField);
        componentArray.add(lastNameField);
    }

    @Override
    protected void defineFields() {
        typeDocumentBox = new JComboBox<>(StringsUtil.NATURAL_CUSTOMER_DOCUMENTS_OPTIONS);
        identificationField = new JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        identificationField.setInputVerifier(InputsVerifier.isNumberOrNull);
        identificationField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                identificationField.setText(StringsUtil.formatId(identificationField.getText()));
                Person person = PersonController.getInstance()
                        .getPerson(identificationField.getText());
                if(person != null) {
                    data = person;
                    fillData();
                }
            }
        });
        firstNameField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        firstNameField.setInputVerifier(InputsVerifier.toUpper);
        lastNameField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        lastNameField.setInputVerifier(InputsVerifier.toUpper);
    }

    @Override
    public boolean saveData() {
        ArrayList<Component> error = new ArrayList<>();
        if(typeDocumentBox.getSelectedItem().equals("")) {
            error.add(typeDocumentBox.getEditor().getEditorComponent());
        }
        if(identificationField.getText().isEmpty()) {
            error.add(identificationField);
        }
        if(firstNameField.getText().isEmpty()) {
            error.add(firstNameField);
        }
        if(lastNameField.getText().isEmpty()) {
            error.add(lastNameField);
        }
        if(error.isEmpty()) {
            Vehicle vehicle = parent.vehicle;
            data.setTypeDocument((String) typeDocumentBox.getSelectedItem());
            data.setIdentification(identificationField.getText());
            data.setFirstName(firstNameField.getText());
            data.setLastName(lastNameField.getText());
            if(vehicle.existOwner(data)) {
                vehicle.removeOwner(data);
                vehicle.addOwner(data);
            } else {
                vehicle.addOwner(data);
            }
            VehicleController.getInstance().save(vehicle);
            return true;
        } else {
            JOptionPane.showMessageDialog(this, StringsUtil.INCOMPLETE_DATA_MESSAGE);
            for(Component component : error) {
                component.setBackground(Color.pink);
            }

            return false;
        }
    }

    @Override
    public void fillData() {
        if(data.getIdentification() != null) {
            typeDocumentBox.setSelectedItem(data.getTypeDocument());
            identificationField.setText(String.valueOf(data.getIdentification()));
            firstNameField.setText(data.getFirstName());
            lastNameField.setText(data.getLastName());
        }
    }
}

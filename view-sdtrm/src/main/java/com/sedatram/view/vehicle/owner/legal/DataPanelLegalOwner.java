package com.sedatram.view.vehicle.owner.legal;
import com.sedatram.controller.PersonController;
import com.sedatram.controller.VehicleController;
import com.sedatram.model.Person;
import com.sedatram.model.Vehicle;
import com.sedatram.utils.InputsVerifier;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.utils.Utils;
import com.sedatram.view.abstract_view.DataPanelAbstract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class DataPanelLegalOwner extends DataPanelAbstract<Person> {
    private CELegalOwner parent;
    private JComboBox<String> typeDocumentBox;
    private JTextField identificationField;
    private JTextField nameField;
    private JTextField acronymField;

    public DataPanelLegalOwner(Person data, CELegalOwner parent) {
        super(data);
        this.parent = parent;
    }

    @Override
    protected void setLabelArray() {
        for(String s : StringsUtil.LEGAL_OWNER_FIELDS) {
            labelArray.add(new JLabel(s));
        }
    }

    @Override
    protected void setComponentArray() {
        componentArray.add(typeDocumentBox);
        componentArray.add(identificationField);
        componentArray.add(nameField);
        componentArray.add(acronymField);
    }

    @Override
    protected void defineFields() {
        typeDocumentBox = new JComboBox<>(StringsUtil.LEGAL_CUSTOMER_DOCUMENTS_OPTIONS);
        identificationField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
        identificationField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                boolean valid;
                String iden = identificationField.getText();
                iden = iden.replaceAll("\\.", "");
                iden = iden.replaceAll("-", "");
                String nit = "";
                int dvTest;
                switch(iden.length()) {
                    case 9:
                        if(NumbersUtil.isNumber(iden)) {
                            int dv = Utils.calculateDV(iden);
                            nit = StringsUtil.formatId(iden);
                            identificationField.setText(nit + "-" + dv);
                            valid = true;
                        } else {
                            valid = false;
                        }
                        break;
                    case 10:
                        dvTest = Integer.valueOf(iden.substring(9, 10));
                        nit = iden.substring(0, 9);
                        if(NumbersUtil.isNumber(nit)) {
                            if(dvTest == Utils.calculateDV(nit)) {
                                identificationField
                                        .setText(StringsUtil.formatId(nit) + "-" + dvTest);
                                valid = true;
                            } else {
                                valid = false;
                            }
                        } else {
                            valid = false;
                        }
                        break;
                    case 0:
                        nit = "0";
                        valid = true;
                        break;
                    default:
                        valid = false;
                }
                if(!valid) {
                    JOptionPane.showMessageDialog(null, StringsUtil.NIT_NOT_VALID,
                            StringsUtil.TITLE, JOptionPane.ERROR_MESSAGE);
                    identificationField.setText("");
                } else {
                    Person person =
                            PersonController.getInstance().getPerson(identificationField.getText());
                    if(person != null) {
                        data = person;
                        fillData();
                    }
                }
            }
        });
        nameField = new
                JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
        nameField.setInputVerifier(InputsVerifier.toUpper);
        acronymField = new
                JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
        acronymField.setInputVerifier(InputsVerifier.toUpper);
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
        if(nameField.getText().isEmpty()) {
            error.add(nameField);
        }
        if(error.isEmpty()) {
            Vehicle vehicle = parent.vehicle;
            data.setTypeDocument((String) typeDocumentBox.getSelectedItem());
            data.setIdentification(identificationField.getText());
            data.setFirstName(nameField.getText());
            data.setAcronym(acronymField.getText());
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
            nameField.setText(data.getFirstName());
            acronymField.setText(data.getAcronym());
        }
    }
}

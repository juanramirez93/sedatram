package com.sedatram.view.customer.natural;

import com.sedatram.controller.PersonController;
import com.sedatram.controller.auxiliar.CityController;
import com.sedatram.controller.auxiliar.DepartmentController;
import com.sedatram.model.Person;
import com.sedatram.model.auxiliar.City;
import com.sedatram.model.auxiliar.Department;
import com.sedatram.utils.InputsVerifier;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.utils.Utils;
import com.sedatram.view.abstract_view.DataPanelAbstract;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class DataPanelNaturalCustomer extends DataPanelAbstract<Person> {

    private JComboBox<String> typeDocumentBox;
    private JTextField identificationField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField cellphoneField;
    private JTextField addressField;
    private JTextField cityField;
    private JTextField departmentField;

    public DataPanelNaturalCustomer(Person data) {
        super(data);
    }

    @Override
    protected void setLabelArray() {
        for (String s : StringsUtil.NATURAL_CUSTOMER_FIELDS) {
            labelArray.add(new JLabel(s));
        }
    }

    @Override
    protected void setComponentArray() {
        componentArray.add(typeDocumentBox);
        componentArray.add(identificationField);
        componentArray.add(firstNameField);
        componentArray.add(lastNameField);
        componentArray.add(emailField);
        componentArray.add(phoneField);
        componentArray.add(cellphoneField);
        componentArray.add(addressField);
        componentArray.add(cityField);
        componentArray.add(departmentField);
    }

    @Override
    protected void defineFields() {
        typeDocumentBox = new JComboBox<>(StringsUtil.NATURAL_CUSTOMER_DOCUMENTS_OPTIONS);
        identificationField = new JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        identificationField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                String idStr = identificationField.getText().replaceAll("\\.", "");
                if (Utils.isNumberOrNull(idStr)) {
                    identificationField.setText(StringsUtil.formatId(idStr));
                    Person person = PersonController.getInstance()
                            .getPerson(identificationField.getText());
                    if (person != null) {
                        data = person;
                        fillData();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, StringsUtil.ONLY_NUMBERS_MESSAGE,
                            StringsUtil.TITLE, JOptionPane.ERROR_MESSAGE);
                    identificationField.setText("");
                }
            }
        });
        firstNameField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        firstNameField.setInputVerifier(InputsVerifier.toUpper);
        lastNameField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        lastNameField.setInputVerifier(InputsVerifier.toUpper);
        emailField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        emailField.setInputVerifier(InputsVerifier.toLower);
        phoneField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        phoneField.setInputVerifier(InputsVerifier.formatPhone);
        cellphoneField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        cellphoneField.setInputVerifier(InputsVerifier.formatCellphone);
        addressField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        cityField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        AutoCompleteDecorator.decorate(cityField, CityController.getInstance().getAll(),
                false,
                ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        cityField.setInputVerifier(InputsVerifier.toUpper);
        departmentField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        AutoCompleteDecorator.decorate(departmentField, DepartmentController.getInstance().getAll(),
                false,
                ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        departmentField.setInputVerifier(InputsVerifier.toUpper);
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
        if (firstNameField.getText().isEmpty()) {
            error.add(firstNameField);
        }
        if (lastNameField.getText().isEmpty()) {
            error.add(lastNameField);
        }
        if (!emailField.getText().isEmpty() && !Utils.validateEmail(emailField.getText())) {
            error.add(emailField);
        }
        if (error.isEmpty()) {
            data.setCustomer(true);
            data.setTypeDocument((String) typeDocumentBox.getSelectedItem());
            data.setIdentification(identificationField.getText());
            data.setFirstName(firstNameField.getText());
            data.setLastName(lastNameField.getText());
            data.setEmail(emailField.getText());
            data.setPhone(phoneField.getText());
            data.setCell(cellphoneField.getText());
            data.setAddress(addressField.getText());
            data.setCity(cityField.getText());
            data.setDepartment(departmentField.getText());
            PersonController.getInstance().save(data);
            if (!CityController.getInstance().exist(cityField.getText())) {
                City city = new City(cityField.getText());
                CityController.getInstance().save(city);
            }
            if (!DepartmentController.getInstance().exist(departmentField.getText())) {
                Department department = new Department(departmentField.getText());
                DepartmentController.getInstance().save(department);
            }
            return true;
        }
        else {
            JOptionPane.showMessageDialog(this, StringsUtil.INCOMPLETE_DATA_MESSAGE);
            for (Component component : error) {
                component.setBackground(Color.pink);
            }
            return false;
        }
    }

    @Override
    public void fillData() {
        if (data.getIdentification() != null) {
            typeDocumentBox.setSelectedItem(data.getTypeDocument());
            identificationField.setText(String.valueOf(data.getIdentification()));
            firstNameField.setText(data.getFirstName());
            lastNameField.setText(data.getLastName());
            emailField.setText(data.getEmail());
            phoneField.setText(data.getPhone());
            cellphoneField.setText(data.getCell());
            addressField.setText(data.getAddress());
            cityField.setText(data.getCity());
            departmentField.setText(data.getDepartment());
        }
    }
}

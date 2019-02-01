package com.sedatram.view.customer.legal;
import com.sedatram.model.Person;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.utils.Utils;
import com.sedatram.view.abstract_view.DataPanelAbstract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailDataPanelLegalCustomer extends DataPanelAbstract<Person> implements
        ActionListener {

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
    private JTextField managerNameField;
    private JTextField managerIdField;
    private JTextField contactNameField;
    private JTextField contactPhoneField;

    private JPanel managerPanel;
    private JPanel contactPanel;

    public DetailDataPanelLegalCustomer(Person data) {
        super(data);
    }

    @Override
    protected void setLabelArray() {
        for(String s : StringsUtil.LEGAL_CUSTOMER_FIELDS) {
            labelArray.add(new JLabel(s));
        }
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
        componentArray.add(managerPanel);
        componentArray.add(contactPanel);
    }

    @Override
    protected void defineFields() {
        typeDocumentBox = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
        typeDocumentBox.setEditable(false);
        identificationField = new JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
        identificationField.setEditable(false);
        nameField = new
                JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
        nameField.setEditable(false);
        acronymField = new
                JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
        acronymField.setEditable(false);
        emailPanel = new JPanel();
        emailField = new
                JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
        emailField.setEditable(false);
        sendEmailButton = new JButton(StringsUtil.SEND_EMAIL);
        sendEmailButton.addActionListener(this);
        emailPanel.add(emailField);
        emailPanel.add(sendEmailButton);
        phoneField = new
                JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
        phoneField.setEditable(false);
        cellphoneField = new
                JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
        cellphoneField.setEditable(false);
        addressField = new
                JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
        addressField.setEditable(false);
        cityField = new
                JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
        cityField.setEditable(false);
        departmentField = new
                JTextField(NumbersUtil.LEG_CUSTOMER_FIELD);
        departmentField.setEditable(false);
        managerPanel = new JPanel();
        managerPanel.setLayout(new GridLayout(2, 2));
        JLabel managerIdLabel = new JLabel(StringsUtil.IDENTIFICATION);
        JLabel managerNameLabel = new JLabel(StringsUtil.NAME);
        managerIdField = new JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        managerIdField.setEnabled(false);
        managerNameField = new JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        managerNameField.setEditable(false);
        managerPanel.add(managerIdLabel);
        managerPanel.add(managerIdField);
        managerPanel.add(managerNameLabel);
        managerPanel.add(managerNameField);
        contactPanel = new JPanel();
        contactPanel.setLayout(new GridLayout(2, 2));
        JLabel contactNameLabel = new JLabel(StringsUtil.NAME);
        JLabel contactPhoneLabel = new JLabel(StringsUtil.PHONE);
        contactNameField = new JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        contactNameField.setEditable(false);
        contactPhoneField = new JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        contactPhoneField.setEditable(false);
        contactPanel.add(contactNameLabel);
        contactPanel.add(contactNameField);
        contactPanel.add(contactPhoneLabel);
        contactPanel.add(contactPhoneField);
    }

    @Override
    public boolean saveData() {
        return false;
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
        managerIdField.setText(String.valueOf(data.getManagerId()));
        managerNameField.setText(data.getManagerName());
        contactNameField.setText(data.getContact());
        contactPhoneField.setText(data.getCellContact());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(sendEmailButton)) {
            Utils.sendEmail(data.getEmail());
        }
    }
}

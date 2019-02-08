package com.sedatram.view.customer.natural;
import com.sedatram.model.Person;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.utils.Utils;
import com.sedatram.view.abstract_view.DataPanelAbstract;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailDataPanelNaturalCustomer extends DataPanelAbstract<Person> implements
        ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField typeDocumentBox;
    private JTextField identificationField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JPanel emailPanel;
    private JButton sendEmailButton;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField cellphoneField;
    private JTextField addressField;
    private JTextField cityField;
    private JTextField departmentField;

    DetailDataPanelNaturalCustomer(Person data) {
        super(data);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(sendEmailButton)){
            Utils.sendEmail(data.getEmail());
        }
    }

    @Override
    protected void defineFields() {
        typeDocumentBox = new JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        typeDocumentBox.setEditable(false);
        identificationField = new JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        identificationField.setEditable(false);
        firstNameField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        firstNameField.setEditable(false);
        lastNameField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        lastNameField.setEditable(false);
        emailPanel = new JPanel();
        emailField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        emailField.setEditable(false);
        sendEmailButton = new JButton(StringsUtil.SEND_EMAIL);
        sendEmailButton.addActionListener(this);
        emailPanel.add(emailField);
        emailPanel.add(sendEmailButton);
        phoneField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        phoneField.setEditable(false);
        cellphoneField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        cellphoneField.setEditable(false);
        addressField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        addressField.setEditable(false);
        cityField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        cityField.setEditable(false);
        departmentField = new
                JTextField(NumbersUtil.NAT_CUSTOMER_FIELD);
        departmentField.setEditable(false);
    }

    @Override
    public void fillData() {
        typeDocumentBox.setText(data.getTypeDocument());
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

    @Override
    public boolean saveData() {
        return false;
    }

    @Override
    protected void setComponentArray() {
        componentArray.add(typeDocumentBox);
        componentArray.add(identificationField);
        componentArray.add(firstNameField);
        componentArray.add(lastNameField);
        componentArray.add(emailPanel);
        componentArray.add(phoneField);
        componentArray.add(cellphoneField);
        componentArray.add(addressField);
        componentArray.add(cityField);
        componentArray.add(departmentField);
    }

    @Override
    protected void setLabelArray() {
        for(String s : StringsUtil.NATURAL_CUSTOMER_FIELDS) {
            labelArray.add(new JLabel(s));
        }
    }
}

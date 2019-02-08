package com.sedatram.view.vehicle.owner.natural;
import com.sedatram.model.Person;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.DataPanelAbstract;

import javax.swing.*;

public class DetailDataPanelNaturalOwner extends DataPanelAbstract<Person> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField typeDocumentBox;
    private JTextField identificationField;
    private JTextField firstNameField;
    private JTextField lastNameField;

    public DetailDataPanelNaturalOwner(Person data) {
        super(data);
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
    }

    @Override
    public void fillData() {
        typeDocumentBox.setText(data.getTypeDocument());
        identificationField.setText(String.valueOf(data.getIdentification()));
        firstNameField.setText(data.getFirstName());
        lastNameField.setText(data.getLastName());
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
    }

    @Override
    protected void setLabelArray() {
        for(String s : StringsUtil.NATURAL_OWNER_FIELDS) {
            labelArray.add(new JLabel(s));
        }
    }
}

package com.sedatram.view.vehicle.owner.legal;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sedatram.model.Person;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.DataPanelAbstract;

public class DetailDataPanelLegalOwner extends DataPanelAbstract<Person> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField typeDocumentBox;
    private JTextField identificationField;
    private JTextField nameField;
    private JTextField acronymField;

    public DetailDataPanelLegalOwner(Person data) {
        super(data);
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
    }

    @Override
    public void fillData() {
        typeDocumentBox.setText(data.getTypeDocument());
        identificationField.setText(String.valueOf(data.getIdentification()));
        nameField.setText(data.getFirstName());
        acronymField.setText(data.getLastName());
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
    }

    @Override
    protected void setLabelArray() {
        for(String s : StringsUtil.LEGAL_OWNER_FIELDS) {
            labelArray.add(new JLabel(s));
        }
    }
}

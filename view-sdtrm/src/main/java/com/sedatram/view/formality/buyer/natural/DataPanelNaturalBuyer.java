package com.sedatram.view.formality.buyer.natural;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sedatram.controller.PersonController;
import com.sedatram.model.Buyer;
import com.sedatram.model.Person;
import com.sedatram.utils.InputsVerifier;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.DataPanelAbstract;

public class DataPanelNaturalBuyer extends DataPanelAbstract<Buyer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CENaturalBuyer parent;
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

	public DataPanelNaturalBuyer(Buyer data, CENaturalBuyer parent) {
		super(data);
		this.parent = parent;
	}

	@Override
	protected void setLabelArray() {
		for (String s : StringsUtil.NATURAL_BUYER_FIELD) {
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
		identificationField = new JTextField(NumbersUtil.NAT_BUYER_FIELDS);
		identificationField.setInputVerifier(InputsVerifier.isNumberOrNull);
        identificationField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                identificationField.setText(StringsUtil.formatId(identificationField.getText()));
                Buyer buyer = PersonController.getInstance()
                        .getPerson(identificationField.getText());
                if(buyer != null) {
                    data = buyer;
                    fillData();
                }
            }
        });
	}

	@Override
	public boolean saveData() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void fillData() {
		// TODO Auto-generated method stub

	}

}

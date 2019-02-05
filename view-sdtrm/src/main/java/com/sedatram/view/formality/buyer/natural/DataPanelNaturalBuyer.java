package com.sedatram.view.formality.buyer.natural;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sedatram.model.Buyer;
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
		componentArray.add()
	}

	@Override
	protected void defineFields() {
		// TODO Auto-generated method stub

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

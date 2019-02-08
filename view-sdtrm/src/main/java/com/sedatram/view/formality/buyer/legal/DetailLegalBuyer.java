package com.sedatram.view.formality.buyer.legal;

import com.sedatram.model.Buyer;
import com.sedatram.model.Formality;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.DetailAbstract;
import com.sedatram.view.abstract_view.MainAbstract;

public class DetailLegalBuyer extends DetailAbstract<Buyer> {

	private Formality formality;

	public DetailLegalBuyer(MainAbstract<Buyer> parent, Buyer t, Formality formality) {
		super(parent, StringsUtil.BUYER, t);
		this.formality = formality;
		setSize(NumbersUtil.LEG_OWNER_WIDTH, NumbersUtil.LEG_OWNER_HEIGHT);
		setLocationRelativeTo(null);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void setDataPanel(Buyer t) {
		formality.removeBuyer(data);
		parent.refreshTable(formality.getBuyers());
		this.dispose();

	}

	@Override
	public void editAction() {
		CELegalBuyer ceBuyer = new CELegalBuyer(null, data, formality);
		ceBuyer.setVisible(true);
		this.dispose();
	}

	@Override
	protected void deleteAction() {
		formality.removeBuyer(data);
		parent.refreshTable(formality.getBuyers());
		this.dispose();

	}

	@Override
	protected void recordAction() {
		// TODO Auto-generated method stub

	}

}

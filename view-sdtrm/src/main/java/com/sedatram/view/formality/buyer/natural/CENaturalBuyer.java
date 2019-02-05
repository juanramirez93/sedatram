package com.sedatram.view.formality.buyer.natural;

import com.sedatram.model.Buyer;
import com.sedatram.model.Formality;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.CEAbstract;
import com.sedatram.view.abstract_view.MainAbstract;

public class CENaturalBuyer extends CEAbstract<Buyer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Formality formality;

	protected CENaturalBuyer(MainAbstract<Buyer> parent, Buyer t, Formality formality) {
		super(parent, StringsUtil.BUYER, t);
		this.formality = formality;
		this.setSize(NumbersUtil.NAT_BUYER_WIDTH, NumbersUtil.NAT_BUYER_HEIGHT);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void setDataPanel(Buyer t) {

	}

	@Override
	public void saveAction() {
		// TODO Auto-generated method stub

	}

}

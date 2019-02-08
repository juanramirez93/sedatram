package com.sedatram.view.formality.buyer.natural;

import com.sedatram.model.Buyer;
import com.sedatram.model.Formality;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.utils.Utils;
import com.sedatram.view.abstract_view.DetailAbstract;
import com.sedatram.view.abstract_view.MainAbstract;

public class DetailNaturalBuyer extends DetailAbstract<Buyer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Formality formality;

	public DetailNaturalBuyer(MainAbstract<Buyer> parent, Buyer t, Formality formality) {
		super(parent, StringsUtil.BUYER, t);
		this.formality = formality;
		setSize(NumbersUtil.NAT_CUSTOMER_WIDTH, NumbersUtil.NAT_CUSTOMER_HEIGHT);
		setLocationRelativeTo(null);
	}

	@Override
	protected void deleteAction() {
		formality.removeBuyer(data);
		parent.refreshTable(formality.getBuyers());
		this.dispose();
	}

	@Override
	public void editAction() {
		CENaturalBuyer ceBuyer = new CENaturalBuyer(null, data, formality);
		ceBuyer.setVisible(true);
		this.dispose();
	}

	@Override
	protected void recordAction() {
		Utils.openDirectory("Cliente\\Natural\\" + data.getIdentification());
	}

	@Override
	public void setDataPanel(Buyer buyer) {
		dataPanel = new DetailDataPanelNaturalBuyer(buyer);
	}

}

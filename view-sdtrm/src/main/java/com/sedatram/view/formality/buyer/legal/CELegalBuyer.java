package com.sedatram.view.formality.buyer.legal;

import com.sedatram.model.Buyer;
import com.sedatram.model.Formality;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.CEAbstract;
import com.sedatram.view.abstract_view.MainAbstract;

public class CELegalBuyer extends CEAbstract<Buyer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Formality formality;

	public CELegalBuyer(MainAbstract<Buyer> parent, Buyer t, Formality formality) {
		super(parent, StringsUtil.BUYER, t);
		this.formality = formality;
		setSize(NumbersUtil.LEG_OWNER_WIDTH, NumbersUtil.LEG_OWNER_HEIGHT);
		setLocationRelativeTo(null);
	}

	@Override
	public void saveAction() {
		if (dataPanel.saveData()) {
			if (parent != null) {
				parent.refreshTable(formality.getBuyers());
			}
			this.setVisible(false);
		}

	}

	@Override
	public void setDataPanel(Buyer t) {
		dataPanel = new DataPanelLegalBuyer(data, null);
	}
}

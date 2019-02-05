package com.sedatram.view.formality.buyer;

import com.sedatram.controller.FormalityController;
import com.sedatram.model.Buyer;
import com.sedatram.model.Formality;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.MainAbstract;

public class MainBuyer extends MainAbstract<Buyer> {

	private Formality formality;

	public MainBuyer(Formality formality) {
		super(StringsUtil.BUYER);
		this.formality = formality;
		this.refreshTable(formality.getBuyers());
		this.exportButton.setVisible(false);
		this.setSize(NumbersUtil.MAIN_BUYER_WIDHT, NumbersUtil.MAIN_BUYER_HEIGHT);
		this.setLocationRelativeTo(null);
	}

	@Override
	protected void setTable() {
		table = new TableBuyer();

	}

	@Override
	protected void setSearch() {
		search = new SearchBuyer(null);
		search.setVisible(false);
	}

	@Override
	protected void exportAction() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void deleteAction() {
		Buyer buyer = table.getSelected();
		if (buyer != null) {
			this.formality.removeBuyer(buyer);
			FormalityController.getInstance().save(this.formality);
			refreshTable(formality.getBuyers());
		}
	}

	@Override
	protected void editAction() {
		
	}

	@Override
	protected void detailAction() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addAction() {
		// TODO Auto-generated method stub

	}

}

package com.sedatram.view.formality.buyer;

import java.util.Arrays;

import javax.swing.JOptionPane;

import com.sedatram.controller.FormalityController;
import com.sedatram.model.Buyer;
import com.sedatram.model.Formality;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.MainAbstract;
import com.sedatram.view.formality.buyer.legal.CELegalBuyer;
import com.sedatram.view.formality.buyer.legal.DetailLegalBuyer;
import com.sedatram.view.formality.buyer.natural.CENaturalBuyer;
import com.sedatram.view.formality.buyer.natural.DetailNaturalBuyer;

public class MainBuyer extends MainAbstract<Buyer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		Buyer buyer = table.getSelected();
        if(buyer != null) {
            if(ceFrame != null) {
                ceFrame.dispose();
            }
            if(Arrays.binarySearch(StringsUtil.NATURAL_CUSTOMER_DOCUMENTS_OPTIONS,
                    buyer.getTypeDocument()) >= 0) {
                ceFrame = new CENaturalBuyer(this, buyer, formality);
            } else {
                ceFrame = new CELegalBuyer(this, buyer, formality);
            }
            ceFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, StringsUtil.SELECT_REGISTER);
        }
	}

	@Override
	protected void detailAction() {
		Buyer buyer = table.getSelected();
        if(buyer != null) {
            if(detailFrame != null) {
                detailFrame.dispose();
            }
            if(Arrays.binarySearch(StringsUtil.NATURAL_CUSTOMER_DOCUMENTS_OPTIONS,
                    buyer.getTypeDocument()) >= 0) {
                detailFrame = new DetailNaturalBuyer(this, buyer, formality);
            } else {
                detailFrame = new DetailLegalBuyer(this, buyer, formality);
            }
            detailFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, StringsUtil.SELECT_REGISTER);
        }

	}

	@Override
	protected void addAction() {
		int rta = JOptionPane.showOptionDialog(null, StringsUtil.NATURAL_OR_LEGAL,
                StringsUtil.TITLE, JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, new Object[]{"Natural", "Jurídico"}, 0);
        if(ceFrame != null) {
            ceFrame.dispose();
        }
        if(rta == 0) {
            ceFrame = new CENaturalBuyer(this, new Buyer(), formality);
        } else {
            ceFrame = new CELegalBuyer(this, new Buyer(), formality);
        }
        ceFrame.setVisible(true);
	}

}

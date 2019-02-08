package com.sedatram.view.formality.buyer;

import com.sedatram.model.Buyer;
import com.sedatram.view.abstract_view.TableModelAbstract;

public class TableModelBuyer extends TableModelAbstract<Buyer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableModelBuyer(String[] columns) {
		super(columns);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Buyer buyer = tList.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return buyer.getIdentification();
		case 1:
			return buyer.getName();
		case 2:
			return buyer.getCell();
		case 3:
			return buyer.getEmail();
		}
		return null;
	}

}

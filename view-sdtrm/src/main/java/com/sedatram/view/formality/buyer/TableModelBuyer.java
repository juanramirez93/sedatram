package com.sedatram.view.formality.buyer;

import com.sedatram.model.Buyer;
import com.sedatram.view.abstract_view.TableModelAbstract;

public class TableModelBuyer extends TableModelAbstract<Buyer>{

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
		}
		return null;
	}

}

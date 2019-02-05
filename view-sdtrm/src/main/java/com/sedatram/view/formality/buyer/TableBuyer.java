package com.sedatram.view.formality.buyer;

import com.sedatram.model.Buyer;
import com.sedatram.model.Person;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.TableAbstract;

public class TableBuyer extends TableAbstract<Buyer>{

	@Override
	protected void setModel() {
		model = new TableModelBuyer(StringsUtil.TABLE_COLUMNS_BUYER);
		table.setModel(model);
		
	}

	@Override
	public void setColumnLayout() {
		// TODO Auto-generated method stub
		
	}

}

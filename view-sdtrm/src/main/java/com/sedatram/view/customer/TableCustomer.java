package com.sedatram.view.customer;

import javax.swing.table.TableColumnModel;

import com.sedatram.model.Person;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.TableAbstract;

public class TableCustomer extends TableAbstract<Person> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public void setColumnLayout() {
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(3).setPreferredWidth(200);
    }

    @Override
    protected void setModel() {
        model = new TableModelCustomer(StringsUtil.TABLE_COLUMNS_CUSTOMER);
        table.setModel(model);
    }
}

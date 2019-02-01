package com.sedatram.view.customer;

import com.sedatram.model.Person;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.TableAbstract;

import javax.swing.table.TableColumnModel;

public class TableCustomer extends TableAbstract<Person> {

    @Override
    protected void setModel() {
        model = new TableModelCustomer(StringsUtil.TABLE_COLUMNS_CUSTOMER);
        table.setModel(model);
    }

    @Override
    public void setColumnLayout() {
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(3).setPreferredWidth(200);
    }
}

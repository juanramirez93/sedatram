package com.sedatram.view.formality;

import com.sedatram.model.Formality;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.TableAbstract;

import javax.swing.table.TableColumnModel;

public class TableFormality extends TableAbstract<Formality> {

    @Override
    protected void setModel() {
        model = new TableModelFormality(StringsUtil.TABLE_COLUMNS_FORMALITY);
        table.setModel(model);
    }

    @Override
    public void setColumnLayout() {
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
    }
}

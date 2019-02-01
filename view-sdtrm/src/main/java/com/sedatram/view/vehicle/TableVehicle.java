package com.sedatram.view.vehicle;
import com.sedatram.model.Vehicle;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.TableAbstract;

import javax.swing.table.TableColumnModel;

public class TableVehicle extends TableAbstract<Vehicle> {

    @Override
    protected void setModel() {
        model = new TableModelVehicle(StringsUtil.TABLE_COLUMNS_VEHICULES);
        table.setModel(model);
    }

    @Override
    public void setColumnLayout() {
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(3).setPreferredWidth(80);
        columnModel.getColumn(4).setPreferredWidth(80);
        columnModel.getColumn(5).setPreferredWidth(80);
    }
}

package com.sedatram.view.vehicle.owner;
import com.sedatram.model.Person;
import com.sedatram.view.abstract_view.TableAbstract;

import javax.swing.table.TableColumnModel;

public class TableOwner extends TableAbstract<Person> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public void setColumnLayout() {
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(200);
    }

    @Override
    protected void setModel() {
        model = new TableModelOwner();
        table.setModel(model);
    }
}

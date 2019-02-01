package com.sedatram.view.formality;

import com.sedatram.model.Formality;
import com.sedatram.view.abstract_view.TableModelAbstract;

public class TableModelFormality extends TableModelAbstract<Formality> {

    public TableModelFormality(String[] columns) {
        super(columns);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Formality formality = tList.get(rowIndex);
        switch (columnIndex){
            case 0:
                return formality.getInitDate();
            case 1:
                return formality.getCustomer().getIdentification();
            case 2:
                return formality.getCustomer().getName();
            case 3:
                return formality.getType().getName();
            case 4:
                return formality.getStatus();
        }
        return null;
    }
}

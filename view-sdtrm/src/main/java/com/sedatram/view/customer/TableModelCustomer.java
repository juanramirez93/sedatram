package com.sedatram.view.customer;

import com.sedatram.model.Person;
import com.sedatram.view.abstract_view.TableModelAbstract;

public class TableModelCustomer extends TableModelAbstract<Person> {

    public TableModelCustomer(String[] columns) {
        super(columns);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = tList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return person.getIdentification();
            case 1:
                return person.getName();
            case 2:
                return person.getCell();
            case 3:
                return person.getEmail();
        }
        return null;
    }
}

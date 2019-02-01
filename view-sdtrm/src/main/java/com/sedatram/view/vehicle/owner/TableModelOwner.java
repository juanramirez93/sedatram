package com.sedatram.view.vehicle.owner;
import com.sedatram.model.Person;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.TableModelAbstract;

public class TableModelOwner extends TableModelAbstract<Person> {
    public TableModelOwner() {
        super(StringsUtil.TABLE_OWNERS_FIELD);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = tList.get(rowIndex);
        switch(columnIndex){
            case 0:
                return person.getIdentification();
            case 1:
                return person.getName();
        }
        return null;
    }
}

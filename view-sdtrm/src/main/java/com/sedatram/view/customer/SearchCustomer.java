package com.sedatram.view.customer;
import com.sedatram.controller.PersonController;
import com.sedatram.model.Person;
import com.sedatram.view.abstract_view.MainAbstract;
import com.sedatram.view.abstract_view.SearchAbstract;

import java.util.List;

public class SearchCustomer extends SearchAbstract<Person> {

    public SearchCustomer(MainAbstract<Person> parent) {
        super(parent);
    }

    @Override
    protected void search() {
        List<Person> people;
        if(searchField.getText().equals("") || searchField.getText().isEmpty()) {
            people = PersonController.getInstance().getAllCustomers();
        } else {
            String str = searchField.getText();
            people = PersonController.getInstance().searchCustomer(str);
        }
        if(filterPanel != null) {
            people = filter(people);
        }
        parent.refreshTable(people);
    }

    @Override
    protected void setFilterPanel() {
    }

    @Override
    public List<Person> filter(List<Person> people) {
        return null;
    }
}

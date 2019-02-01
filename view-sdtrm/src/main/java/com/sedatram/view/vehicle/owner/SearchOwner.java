package com.sedatram.view.vehicle.owner;
import com.sedatram.model.Person;
import com.sedatram.view.abstract_view.MainAbstract;
import com.sedatram.view.abstract_view.SearchAbstract;

import java.util.List;

public class SearchOwner extends SearchAbstract<Person> {
    public SearchOwner(
            MainAbstract<Person> parent) {
        super(parent);
    }

    @Override
    protected void search() {
    }

    @Override
    protected void setFilterPanel() {
    }

    @Override
    public List<Person> filter(List<Person> people) {
        return null;
    }
}

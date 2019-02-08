package com.sedatram.view.vehicle.owner;
import com.sedatram.model.Person;
import com.sedatram.view.abstract_view.MainAbstract;
import com.sedatram.view.abstract_view.SearchAbstract;

import java.util.List;

public class SearchOwner extends SearchAbstract<Person> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchOwner(
            MainAbstract<Person> parent) {
        super(parent);
    }

    @Override
    public List<Person> filter(List<Person> people) {
        return null;
    }

    @Override
    protected void search() {
    }

    @Override
    protected void setFilterPanel() {
    }
}

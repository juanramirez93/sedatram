package com.sedatram.view.formality;

import java.util.List;

import com.sedatram.controller.FormalityController;
import com.sedatram.model.Formality;
import com.sedatram.view.abstract_view.MainAbstract;
import com.sedatram.view.abstract_view.SearchAbstract;

public class SearchFormality extends SearchAbstract<Formality> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchFormality(MainAbstract<Formality> parent) {
        super(parent);
    }

    @Override
    public List<Formality> filter(List<Formality> formalities) {
        return null;
    }

    @Override
    protected void search() {
        List<Formality> formalities;
        if (searchField.getText().equals("") || searchField.getText().isEmpty()) {
            formalities = FormalityController.getInstance().getAll();
        }
        else {
            String str = searchField.getText();
            formalities = FormalityController.getInstance().search(str);
        }
        if (filterPanel != null) {
            formalities = filter(formalities);
        }
        parent.refreshTable(formalities);
    }

    @Override
    protected void setFilterPanel() {
    }
}

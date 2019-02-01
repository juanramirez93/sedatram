package com.sedatram.view.formality;

import com.sedatram.controller.FormalityController;
import com.sedatram.model.Formality;
import com.sedatram.view.abstract_view.MainAbstract;
import com.sedatram.view.abstract_view.SearchAbstract;

import java.util.List;

public class SearchFormality extends SearchAbstract<Formality> {

    public SearchFormality(MainAbstract<Formality> parent) {
        super(parent);
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

    @Override
    public List<Formality> filter(List<Formality> formalities) {
        return null;
    }
}

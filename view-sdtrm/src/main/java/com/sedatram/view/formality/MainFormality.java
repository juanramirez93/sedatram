package com.sedatram.view.formality;

import com.sedatram.controller.FormalityController;
import com.sedatram.model.Formality;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.MainAbstract;

public class MainFormality extends MainAbstract<Formality> {

    public MainFormality() {
        super(StringsUtil.FORMALITY);
        initialize();
    }

    private void initialize() {
        refreshTable(FormalityController.getInstance().getAll());
        setSize(NumbersUtil.MAIN_FORMALITY_WIDTH, NumbersUtil.MAIN_FORMALITY_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    protected void setTable() {
        table = new TableFormality();
    }

    @Override
    protected void setSearch() {
        search = new SearchFormality(this);
    }

    @Override
    protected void exportAction() {
    }

    @Override
    protected void deleteAction() {
    }

    @Override
    protected void editAction() {
    }

    @Override
    protected void detailAction() {
    }

    @Override
    protected void addAction() {
        if(ceFrame != null) {
            ceFrame.dispose();
        }
        ceFrame = new CEFormality(this, new Formality());
        ceFrame.setVisible(true);
    }
}

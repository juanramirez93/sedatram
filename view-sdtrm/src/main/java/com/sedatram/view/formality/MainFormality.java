package com.sedatram.view.formality;

import com.sedatram.controller.FormalityController;
import com.sedatram.model.Formality;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.MainAbstract;

public class MainFormality extends MainAbstract<Formality> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFormality() {
        super(StringsUtil.FORMALITY);
        initialize();
    }

    @Override
    protected void addAction() {
        if(ceFrame != null) {
            ceFrame.dispose();
        }
        ceFrame = new CEFormality(this, new Formality());
        ceFrame.setVisible(true);
    }

    @Override
    protected void deleteAction() {
    }

    @Override
    protected void detailAction() {
    }

    @Override
    protected void editAction() {
    }

    @Override
    protected void exportAction() {
    }

    private void initialize() {
        refreshTable(FormalityController.getInstance().getAll());
        setSize(NumbersUtil.MAIN_FORMALITY_WIDTH, NumbersUtil.MAIN_FORMALITY_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    protected void setSearch() {
        search = new SearchFormality(this);
    }

    @Override
    protected void setTable() {
        table = new TableFormality();
    }
}

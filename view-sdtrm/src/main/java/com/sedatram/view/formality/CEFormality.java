package com.sedatram.view.formality;

import com.sedatram.model.Formality;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.CEAbstract;
import com.sedatram.view.abstract_view.MainAbstract;

public class CEFormality extends CEAbstract<Formality> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected CEFormality(MainAbstract<Formality> parent,
            Formality formality) {
        super(parent, StringsUtil.FORMALITY, formality);
        setSize(NumbersUtil.FORMALITY_WIDTH, NumbersUtil.FORMALITY_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    public void saveAction() {
    }

    @Override
    public void setDataPanel(Formality formality) {
        dataPanel = new DataPanelFormality(formality);
    }
}

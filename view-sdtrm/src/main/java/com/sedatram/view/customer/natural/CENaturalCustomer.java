package com.sedatram.view.customer.natural;
import com.sedatram.controller.PersonController;
import com.sedatram.model.Person;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.CEAbstract;
import com.sedatram.view.abstract_view.MainAbstract;

public class CENaturalCustomer extends CEAbstract<Person> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CENaturalCustomer(MainAbstract<Person> parent, Person person) {
        super(parent, StringsUtil.CUSTOMERS, person);
        setSize(NumbersUtil.NAT_CUSTOMER_WIDTH, NumbersUtil.NAT_CUSTOMER_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    public void saveAction() {
        if(dataPanel.saveData()) {
            if(parent != null) {
                parent.refreshTable(PersonController.getInstance().getAllCustomers());
            }
            this.setVisible(false);
        }
    }

    @Override
    public void setDataPanel(Person person) {
        dataPanel = new DataPanelNaturalCustomer(person);
    }
}

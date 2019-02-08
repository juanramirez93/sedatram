package com.sedatram.view.customer.legal;
import com.sedatram.controller.PersonController;
import com.sedatram.model.Person;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.utils.Utils;
import com.sedatram.view.abstract_view.DetailAbstract;
import com.sedatram.view.abstract_view.MainAbstract;

public class DetailLegalCustomer extends DetailAbstract<Person> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DetailLegalCustomer(MainAbstract<Person> parent, Person person) {
        super(parent, StringsUtil.CUSTOMERS, person);
        setSize(NumbersUtil.LEG_CUSTOMER_WIDTH + 100, NumbersUtil.LEG_CUSTOMER_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    protected void deleteAction() {
        data.setCustomer(false);
        PersonController.getInstance().save(data);
        parent.refreshTable(PersonController.getInstance().getAllCustomers());
        this.dispose();
    }

    @Override
    public void editAction() {
        CELegalCustomer ceCustomer = new CELegalCustomer(null, data);
        ceCustomer.setVisible(true);
        this.dispose();
    }

    @Override
    protected void recordAction() {
        Utils.openDirectory("Cliente\\Juridico\\" + data.getIdentification());
    }

    @Override
    public void setDataPanel(Person person) {
        dataPanel = new DetailDataPanelLegalCustomer(person);
    }
}

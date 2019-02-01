package com.sedatram.view.customer.natural;
import com.sedatram.controller.PersonController;
import com.sedatram.model.Person;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.utils.Utils;
import com.sedatram.view.abstract_view.DetailAbstract;
import com.sedatram.view.abstract_view.MainAbstract;

public class DetailNaturalCustomer extends DetailAbstract<Person> {

    public DetailNaturalCustomer(MainAbstract<Person> parent, Person person) {
        super(parent, StringsUtil.CUSTOMERS, person);
        setSize(NumbersUtil.NAT_CUSTOMER_WIDTH, NumbersUtil.NAT_CUSTOMER_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    public void setDataPanel(Person person) {
        dataPanel = new DetailDataPanelNaturalCustomer(person);
    }

    @Override
    public void editAction() {
        CENaturalCustomer ceCustomer = new CENaturalCustomer(null, data);
        ceCustomer.setVisible(true);
        this.dispose();
    }

    @Override
    protected void deleteAction() {
        data.setCustomer(false);
        PersonController.getInstance().save(data);
        parent.refreshTable(PersonController.getInstance().getAllCustomers());
        this.dispose();
    }

    @Override
    protected void recordAction() {
        Utils.openDirectory("Cliente\\Natural\\" + data.getIdentification());
    }
}

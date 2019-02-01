package com.sedatram.view.customer.legal;
import com.sedatram.controller.PersonController;
import com.sedatram.model.Person;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.CEAbstract;
import com.sedatram.view.abstract_view.MainAbstract;

public class CELegalCustomer extends CEAbstract<Person> {

    public CELegalCustomer(MainAbstract<Person> parent, Person person) {
        super(parent, StringsUtil.CUSTOMERS, person);
        setSize(NumbersUtil.LEG_CUSTOMER_WIDTH, NumbersUtil.LEG_CUSTOMER_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    public void setDataPanel(Person person) {
        dataPanel = new DataPanelLegalCustomer(person);
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
}

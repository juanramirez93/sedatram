package com.sedatram.view.vehicle.owner.legal;
import com.sedatram.controller.PersonController;
import com.sedatram.model.Person;
import com.sedatram.model.Vehicle;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.CEAbstract;
import com.sedatram.view.abstract_view.MainAbstract;
import com.sedatram.view.vehicle.owner.natural.DetailDataPanelNaturalOwner;

public class CELegalOwner extends CEAbstract<Person> {

    public Vehicle vehicle;

    public CELegalOwner(MainAbstract<Person> parent, Person person, Vehicle vehicle) {
        super(parent, StringsUtil.OWNER, person);
        this.vehicle = vehicle;
        setSize(NumbersUtil.LEG_OWNER_WIDTH, NumbersUtil.LEG_OWNER_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    public void setDataPanel(Person person) {
        dataPanel = new DataPanelLegalOwner(person, this);
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

package com.sedatram.view.vehicle.owner.natural;
import com.sedatram.controller.VehicleController;
import com.sedatram.model.Person;
import com.sedatram.model.Vehicle;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.CEAbstract;
import com.sedatram.view.abstract_view.MainAbstract;

public class CENaturalOwner extends CEAbstract<Person> {

    public Vehicle vehicle;

    public CENaturalOwner(MainAbstract<Person> parent, Person person, Vehicle vehicle) {
        super(parent, StringsUtil.OWNER, person);
        this.vehicle = vehicle;
        setSize(NumbersUtil.OWNER_NAT_WIDTH, NumbersUtil.OWNER_NAT_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    public void setDataPanel(Person person) {
        dataPanel = new DataPanelNaturalOwner(person, this);
    }

    @Override
    public void saveAction() {
        if(dataPanel.saveData()) {
            if(parent != null) {
                parent.refreshTable(vehicle.getOwners());
            }
            this.setVisible(false);
        }
    }
}

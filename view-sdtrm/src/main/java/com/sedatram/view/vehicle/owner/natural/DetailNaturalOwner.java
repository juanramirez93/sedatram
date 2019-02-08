package com.sedatram.view.vehicle.owner.natural;
import com.sedatram.controller.VehicleController;
import com.sedatram.model.Person;
import com.sedatram.model.Vehicle;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.DetailAbstract;
import com.sedatram.view.abstract_view.MainAbstract;

import javax.swing.*;

public class DetailNaturalOwner extends DetailAbstract<Person> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vehicle vehicle;

    public DetailNaturalOwner(MainAbstract<Person> parent, Person person, Vehicle vehicle) {
        super(parent, StringsUtil.OWNER_DETAIL, person);
        this.vehicle = vehicle;
        setSize(NumbersUtil.NAT_OWNER_WIDTH, NumbersUtil.NAT_OWNER_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    protected void deleteAction() {
        if(data != null) {
            vehicle.removeOwner(data);
            VehicleController.getInstance().save(vehicle);
        }
    }

    @Override
    public void editAction() {
        CENaturalOwner ceNaturalOwner = new CENaturalOwner(null, data, vehicle);
        ceNaturalOwner.setVisible(true);
        this.dispose();
    }

    @Override
    protected void recordAction() {
        JOptionPane.showMessageDialog(this, StringsUtil.OPTION_NO_AVAILABLE);
    }

    @Override
    public void setDataPanel(Person person) {
        dataPanel = new DetailDataPanelNaturalOwner(person);
    }
}

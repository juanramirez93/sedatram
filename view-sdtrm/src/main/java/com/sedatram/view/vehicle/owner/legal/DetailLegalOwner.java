package com.sedatram.view.vehicle.owner.legal;
import javax.swing.JOptionPane;

import com.sedatram.controller.VehicleController;
import com.sedatram.model.Person;
import com.sedatram.model.Vehicle;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.DetailAbstract;
import com.sedatram.view.abstract_view.MainAbstract;

public class DetailLegalOwner extends DetailAbstract<Person> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vehicle vehicle;

    public DetailLegalOwner(
            MainAbstract<Person> parent, Person person, Vehicle vehicle) {
        super(parent, StringsUtil.OWNER_DETAIL, person);
        this.vehicle = vehicle;
        setSize(NumbersUtil.LEG_OWNER_WIDTH, NumbersUtil.LEG_OWNER_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    public void setDataPanel(Person person) {
        dataPanel = new DetailDataPanelLegalOwner(person);
    }

    @Override
    public void editAction() {
        CELegalOwner ceCustomer = new CELegalOwner(null, data, vehicle);
        ceCustomer.setVisible(true);
        this.dispose();
    }

    @Override
    protected void deleteAction() {
        if(data != null) {
            vehicle.removeOwner(data);
            VehicleController.getInstance().save(vehicle);
        }
    }

    @Override
    protected void recordAction() {
        JOptionPane.showMessageDialog(this, StringsUtil.OPTION_NO_AVAILABLE);
    }
}

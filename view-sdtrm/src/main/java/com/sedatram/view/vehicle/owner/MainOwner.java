package com.sedatram.view.vehicle.owner;
import java.util.Arrays;

import javax.swing.JOptionPane;

import com.sedatram.controller.VehicleController;
import com.sedatram.model.Person;
import com.sedatram.model.Vehicle;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.MainAbstract;
import com.sedatram.view.vehicle.owner.legal.CELegalOwner;
import com.sedatram.view.vehicle.owner.legal.DetailLegalOwner;
import com.sedatram.view.vehicle.owner.natural.CENaturalOwner;
import com.sedatram.view.vehicle.owner.natural.DetailNaturalOwner;

public class MainOwner extends MainAbstract<Person> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vehicle vehicle;

    public MainOwner(Vehicle vehicle) {
        super(StringsUtil.OWNERS);
        this.vehicle = vehicle;
        refreshTable(vehicle.getOwners());
        exportButton.setVisible(false);
        setSize(NumbersUtil.MAIN_OWNER_WIDTH, NumbersUtil.MAIN_OWNER_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    protected void setTable() {
        table = new TableOwner();
    }

    @Override
    protected void setSearch() {
        search = new SearchOwner(this);
        search.setVisible(false);
    }

    @Override
    protected void exportAction() {
    }

    @Override
    protected void deleteAction() {
        Person person = table.getSelected();
        if(person != null) {
            vehicle.removeOwner(person);
            VehicleController.getInstance().save(vehicle);
            refreshTable(vehicle.getOwners());
        }
    }

    @Override
    protected void editAction() {
        Person owner = table.getSelected();
        if(owner != null) {
            if(ceFrame != null) {
                ceFrame.dispose();
            }
            if(Arrays.binarySearch(StringsUtil.NATURAL_CUSTOMER_DOCUMENTS_OPTIONS,
                    owner.getTypeDocument()) >= 0) {
                ceFrame = new CENaturalOwner(this, owner, vehicle);
            } else {
                ceFrame = new CELegalOwner(this, owner, vehicle);
            }
            ceFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, StringsUtil.SELECT_REGISTER);
        }
    }

    @Override
    protected void detailAction() {
        Person owner = table.getSelected();
        if(owner != null) {
            if(detailFrame != null) {
                detailFrame.dispose();
            }
            if(Arrays.binarySearch(StringsUtil.NATURAL_CUSTOMER_DOCUMENTS_OPTIONS,
                    owner.getTypeDocument()) >= 0) {
                detailFrame = new DetailNaturalOwner(this, owner, vehicle);
            } else {
                detailFrame = new DetailLegalOwner(this, owner, vehicle);
            }
            detailFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, StringsUtil.SELECT_REGISTER);
        }
    }

    @Override
    protected void addAction() {
        int rta = JOptionPane.showOptionDialog(null, StringsUtil.NATURAL_OR_LEGAL,
                StringsUtil.TITLE, JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, new Object[]{"Natural", "Jurídico"}, 0);
        if(ceFrame != null) {
            ceFrame.dispose();
        }
        if(rta == 0) {
            ceFrame = new CENaturalOwner(this, new Person(), vehicle);
        } else {
            ceFrame = new CELegalOwner(this, new Person(), vehicle);
        }
        ceFrame.setVisible(true);
    }
}

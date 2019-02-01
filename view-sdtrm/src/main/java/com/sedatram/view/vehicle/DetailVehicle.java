package com.sedatram.view.vehicle;
import com.sedatram.model.Vehicle;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.DetailAbstract;
import com.sedatram.view.abstract_view.MainAbstract;
import com.sedatram.view.vehicle.owner.MainOwner;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DetailVehicle extends DetailAbstract<Vehicle> {

    private JButton ownersButton;

    public DetailVehicle(
            MainAbstract<Vehicle> parent, Vehicle vehicle) {
        super(parent, StringsUtil.VEHICLES, vehicle);
        addExtraButton();
        setSize(NumbersUtil.DETAIL_VEHICLE_WIDTH, NumbersUtil.DETAIL_VEHICLE_HEIGHT);
        setLocationRelativeTo(null);
    }

    private void addExtraButton() {
        ownersButton = new JButton(StringsUtil.VIEW_OWNERS);
        ownersButton.addActionListener(this);
        buttonPanel.add(ownersButton);
    }

    @Override
    public void setDataPanel(Vehicle vehicle) {
        dataPanel = new DetailDataPanelVehicle(vehicle);
        dataPanel.setEnabled(false);
    }

    @Override
    public void editAction() {
    }

    @Override
    protected void deleteAction() {
    }

    @Override
    protected void recordAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if(e.getSource() == ownersButton){
            MainOwner mainOwner = new MainOwner(data);
            mainOwner.setVisible(true);
        }
    }
}

package com.sedatram.view.vehicle;
import com.sedatram.controller.VehicleController;
import com.sedatram.model.Vehicle;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.CEAbstract;
import com.sedatram.view.abstract_view.MainAbstract;

public class CEVehicle extends CEAbstract<Vehicle> {
    public CEVehicle(
            MainAbstract<Vehicle> parent, Vehicle vehicle) {
        super(parent, StringsUtil.VEHICLES, vehicle);
        setSize(NumbersUtil.VEHICLE_WIDTH, NumbersUtil.VEHICLE_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    public void setDataPanel(Vehicle vehicle) {
        dataPanel = new DataPanelVehicle(vehicle);
    }

    @Override
    public void saveAction() {
        if(dataPanel.saveData()) {
            if(parent != null) {
                parent.refreshTable(VehicleController.getInstance().getAll());
            }
            this.setVisible(false);
        }
    }
}

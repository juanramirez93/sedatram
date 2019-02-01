package com.sedatram.view.vehicle;
import com.sedatram.controller.VehicleController;
import com.sedatram.model.Vehicle;
import com.sedatram.view.abstract_view.MainAbstract;
import com.sedatram.view.abstract_view.SearchAbstract;

import java.util.List;

public class SearchVehicle extends SearchAbstract<Vehicle> {

    public SearchVehicle(
            MainAbstract<Vehicle> parent) {
        super(parent);
    }

    @Override
    protected void search() {
        List<Vehicle> vehicles;
        if(searchField.getText().equals("") || searchField.getText().isEmpty()) {
            vehicles = VehicleController.getInstance().getAll();
        } else {
            String str = searchField.getText();
            vehicles = VehicleController.getInstance().search(str);
        }
        if(filterPanel != null) {
            vehicles = filter(vehicles);
        }
        parent.refreshTable(vehicles);
    }

    @Override
    protected void setFilterPanel() {
    }

    @Override
    public List<Vehicle> filter(List<Vehicle> vehicles) {
        return null;
    }
}

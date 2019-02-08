package com.sedatram.view.vehicle;
import java.util.List;

import com.sedatram.controller.VehicleController;
import com.sedatram.model.Vehicle;
import com.sedatram.view.abstract_view.MainAbstract;
import com.sedatram.view.abstract_view.SearchAbstract;

public class SearchVehicle extends SearchAbstract<Vehicle> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchVehicle(
            MainAbstract<Vehicle> parent) {
        super(parent);
    }

    @Override
    public List<Vehicle> filter(List<Vehicle> vehicles) {
        return null;
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
}

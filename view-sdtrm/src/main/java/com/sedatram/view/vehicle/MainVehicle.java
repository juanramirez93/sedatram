package com.sedatram.view.vehicle;
import java.util.List;

import javax.swing.JOptionPane;

import com.sedatram.controller.VehicleController;
import com.sedatram.model.Person;
import com.sedatram.model.Vehicle;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.utils.Utils;
import com.sedatram.view.abstract_view.MainAbstract;

public class MainVehicle extends MainAbstract<Vehicle> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainVehicle() {
        super(StringsUtil.VEHICLES);
        refreshTable(VehicleController.getInstance().getAll());
        setSize(NumbersUtil.MAIN_VEHICLE_WIDTH, NumbersUtil.MAIN_VEHICLE_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    protected void addAction() {
        if(ceFrame != null) {
            ceFrame.dispose();
        }
        ceFrame = new CEVehicle(this, new Vehicle());
        ceFrame.setVisible(true);
    }

    @Override
    protected void deleteAction() {
        Vehicle vehicle = table.getSelected();
        if(vehicle != null) {
            VehicleController.getInstance().delete(vehicle);
            refreshTable(VehicleController.getInstance().getAll());
        }
    }

    @Override
    protected void detailAction() {
        Vehicle vehicle = table.getSelected();
        if(vehicle != null) {
            if(detailFrame != null) {
                detailFrame.dispose();
            }
            detailFrame = new DetailVehicle(this, vehicle);
            detailFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, StringsUtil.SELECT_REGISTER);
        }
    }

    @Override
    protected void editAction() {
        Vehicle vehicle = table.getSelected();
        if(vehicle != null) {
            if(ceFrame != null) {
                ceFrame.dispose();
            }
            ceFrame = new CEVehicle(this, vehicle);
            ceFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, StringsUtil.SELECT_REGISTER);
        }
    }

    @Override
    protected void exportAction() {
        List<Vehicle> vehicles = table.getList();
        String[][] vehiclesString =
                new String[vehicles.size() + 1][StringsUtil.EXPORT_VEHICLES_FIELDS.length];
        vehiclesString[0] = StringsUtil.EXPORT_VEHICLES_FIELDS;
        int i = 1;
        for(Vehicle v : vehicles) {
            vehiclesString[i][0] = v.getPlaque();
            vehiclesString[i][1] = v.getService();
            vehiclesString[i][2] = v.getType();
            vehiclesString[i][3] = v.getBrand();
            vehiclesString[i][4] = v.getLine();
            vehiclesString[i][5] = v.getModel();
            vehiclesString[i][6] = v.getColor();
            vehiclesString[i][7] = v.getSerial();
            vehiclesString[i][8] = v.getMotor();
            vehiclesString[i][9] = v.getChassis();
            vehiclesString[i][10] = v.getVin();
            vehiclesString[i][11] = v.getDisplacement();
            vehiclesString[i][12] = v.getBodywork();
            vehiclesString[i][13] = v.getGasoline();
            if(v.getRegistration() != null) {
                vehiclesString[i][14] = Utils.formatDate(v.getRegistration());
            }
            vehiclesString[i][15] = v.getTransit();
            vehiclesString[i][16] = v.getCapacity();
            vehiclesString[i][17] = v.getPBV();
            vehiclesString[i][18] = v.getAxes();
            String cedula = "";
            String nombres = "";
            for(Person owner : v.getOwners()) {
                cedula += owner.getIdentification() + '\n';
                nombres += owner.getName() + '\n';
            }
            if(!v.getOwners().isEmpty()) {
                vehiclesString[i][19] = cedula.substring(0, cedula.length() - 1);
                vehiclesString[i][20] = nombres.substring(0, nombres.length() - 1);
            }
            i++;
        }
        if(Utils.exportTable("Clientes", vehiclesString)) {
            JOptionPane.showMessageDialog(this, StringsUtil.EXPORT_SUCCESSFUL);
        } else {
            JOptionPane.showMessageDialog(this, StringsUtil.EXPORT_FAILURE);
        }
    }

    @Override
    protected void setSearch() {
        search = new SearchVehicle(this);
    }

    @Override
    protected void setTable() {
        table = new TableVehicle();
    }
}

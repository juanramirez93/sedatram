package com.sedatram.view.vehicle;
import com.sedatram.model.Vehicle;
import com.sedatram.view.abstract_view.TableModelAbstract;

public class TableModelVehicle extends TableModelAbstract<Vehicle> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableModelVehicle(String[] columns) {
        super(columns);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vehicle vehicle = tList.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return vehicle.getPlaque();
            case 1:
                return vehicle.getService();
            case 2:
                return vehicle.getType();
            case 3:
                return vehicle.getBrand();
            case 4:
                return vehicle.getLine();
            case 5:
                return vehicle.getModel();
        }
        return null;
    }
}

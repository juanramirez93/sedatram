package com.sedatram.view.abstract_view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public abstract class TableModelAbstract<T> extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int colCount;
    protected List<T> tList;
    private String[] columns;

    public TableModelAbstract(String[] columns) {
        this.columns = columns;
        this.colCount = columns.length;
        tList = new ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public List<T> getList() {
        return tList;
    }

    @Override
    public int getRowCount() {
        return tList.size();
    }

    public T getSelected(int selectedRow) {
        return tList.get(selectedRow);
    }

    @Override
	public abstract Object getValueAt(int rowIndex, int columnIndex);

    public void setList(List<T> ts) {
        tList = ts;
    }

    public void updateTable() {
        fireTableDataChanged();
    }
}

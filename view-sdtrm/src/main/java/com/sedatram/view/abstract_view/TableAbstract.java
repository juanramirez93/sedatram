package com.sedatram.view.abstract_view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public abstract class TableAbstract<T> extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTable table;
    protected TableModelAbstract<T> model;
    protected JLabel countLabel;

    public TableAbstract() {
        super();
        initializeVariables();
        initializeLayout();
        setColumnLayout();
    }

    public List<T> getList() {
        return model.getList();
    }

    public T getSelected() {
        if(table.getSelectedRow() == -1) {
            return null;
        }
        return model.getSelected(table.getSelectedRow());
    }

    private void initializeLayout() {
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(15, 15, 15, 15));
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(countLabel, BorderLayout.SOUTH);
    }

    private void initializeVariables() {
        setTable();
        setModel();
        setCountLabel();
    }

    public abstract void setColumnLayout();

    private void setCountLabel() {
        countLabel = new JLabel();
    }

    public void setList(List<T> ts) {
        model.setList(ts);
    }

    protected abstract void setModel();

    private void setTable() {
        table = new JTable();
    }

    public void updateTable() {
        this.countLabel.setText(model.getList().size() + " registros.");
        this.model.updateTable();
    }
}

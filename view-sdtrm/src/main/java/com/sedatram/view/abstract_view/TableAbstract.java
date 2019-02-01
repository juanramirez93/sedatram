package com.sedatram.view.abstract_view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public abstract class TableAbstract<T> extends JPanel {

    protected JTable table;
    protected TableModelAbstract<T> model;
    protected JLabel countLabel;

    private void setTable() {
        table = new JTable();
    }

    protected abstract void setModel();

    private void setCountLabel() {
        countLabel = new JLabel();
    }

    public void setList(List<T> ts) {
        model.setList(ts);
    }

    public List<T> getList() {
        return model.getList();
    }

    public TableAbstract() {
        super();
        initializeVariables();
        initializeLayout();
        setColumnLayout();
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

    public void updateTable() {
        this.countLabel.setText(model.getList().size() + " registros.");
        this.model.updateTable();
    }

    public T getSelected() {
        if(table.getSelectedRow() == -1) {
            return null;
        }
        return (T) model.getSelected(table.getSelectedRow());
    }

    public abstract void setColumnLayout();
}

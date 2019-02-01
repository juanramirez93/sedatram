package com.sedatram.view.abstract_view;

import com.sedatram.utils.StringsUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public abstract class MainAbstract<T> extends JFrame implements ActionListener {

    protected JButton addButton;
    protected JButton backButton;
    protected JButton detailButton;
    protected JButton editButton;
    protected JButton deleteButton;
    protected JButton exportButton;

    protected CEAbstract<T> ceFrame;
    protected DetailAbstract<T> detailFrame;

    protected JPanel buttonPanel;
    protected TableAbstract<T> table;
    protected SearchAbstract<T> search;

    public MainAbstract(String name) {
        super(name);
        initializeVariables();
        setTable();
        setSearch();
        initializeLayout();
    }

    private void initializeLayout() {
        setLayout(new BorderLayout());
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(backButton);
        buttonPanel.add(detailButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(addButton);
        buttonPanel.add(exportButton);
        add(table, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(search, BorderLayout.NORTH);
    }

    protected abstract void setTable();

    protected abstract void setSearch();

    protected void initializeVariables() {
        addButton = new JButton(StringsUtil.ADD);
        addButton.addActionListener(this);
        backButton = new JButton(StringsUtil.BACK);
        backButton.addActionListener(this);
        detailButton = new JButton(StringsUtil.DETAIL);
        detailButton.addActionListener(this);
        editButton = new JButton(StringsUtil.EDIT);
        editButton.addActionListener(this);
        deleteButton = new JButton(StringsUtil.DELETE);
        deleteButton.addActionListener(this);
        exportButton = new JButton(StringsUtil.EXPORT);
        exportButton.addActionListener(this);
        buttonPanel = new JPanel();
    }

    public void refreshTable(List<T> t) {
        table.setList(t);
        table.updateTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(addButton)) {
            addAction();
        } else if(e.getSource().equals(backButton)) {
            this.dispose();
        } else if(e.getSource().equals(detailButton)) {
            detailAction();
        } else if(e.getSource().equals(editButton)) {
            editAction();
        } else if(e.getSource().equals(deleteButton)) {
            deleteAction();
        } else if(e.getSource().equals(exportButton)) {
            exportAction();
        }
    }

    protected abstract void exportAction();

    protected abstract void deleteAction();

    protected abstract void editAction();

    protected abstract void detailAction();

    protected abstract void addAction();
}

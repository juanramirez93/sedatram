package com.sedatram.view.abstract_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sedatram.utils.StringsUtil;

public abstract class MainAbstract<T> extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

    protected abstract void addAction();

    protected abstract void deleteAction();

    protected abstract void detailAction();

    protected abstract void editAction();

    protected abstract void exportAction();

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

    protected abstract void setSearch();

    protected abstract void setTable();
}

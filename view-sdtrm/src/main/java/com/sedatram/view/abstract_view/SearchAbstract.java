package com.sedatram.view.abstract_view;

import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public abstract class SearchAbstract<T> extends JPanel implements ActionListener {

    protected JLabel searchLabel;
    protected JTextField searchField;
    protected JButton searchButton;
    protected JButton cancelButton;

    protected MainAbstract<T> parent;
    protected FilterAbstract<T> filterPanel;

    public SearchAbstract(MainAbstract<T> parent) {
        super();
        this.parent = parent;
        initializeVariables();
        setFilterPanel();
        initializeLayout();

    }

    private void initializeVariables() {
        searchLabel = new JLabel(StringsUtil.SEARCH);
        searchField = new JTextField(NumbersUtil.SEARCH_FIELD);
        searchButton = new JButton(StringsUtil.SEARCH);
        searchButton.addActionListener(this);
        cancelButton = new JButton("X");
        cancelButton.addActionListener(this);
    }

    private void initializeLayout() {
        if(filterPanel == null) {
            setLayout(new FlowLayout());
            add(searchLabel);
            add(searchField);
            add(searchButton);
            add(cancelButton);
        } else {
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            panel.add(searchLabel);
            panel.add(searchField);
            panel.add(searchButton);
            panel.add(cancelButton);
            setLayout(new BorderLayout());
            this.add(panel, BorderLayout.SOUTH);
            this.add(filterPanel, BorderLayout.NORTH);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton) {
            search();
        } else if(e.getSource() == cancelButton) {
            searchField.setText("");
            search();
        }
    }

    protected abstract void search();

    protected abstract void setFilterPanel();

    public abstract List<T> filter(List<T> tList);
}

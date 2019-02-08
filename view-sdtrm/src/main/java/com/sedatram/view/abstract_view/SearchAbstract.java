package com.sedatram.view.abstract_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;

public abstract class SearchAbstract<T> extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton) {
            search();
        } else if(e.getSource() == cancelButton) {
            searchField.setText("");
            search();
        }
    }

    public abstract List<T> filter(List<T> tList);

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

    private void initializeVariables() {
        searchLabel = new JLabel(StringsUtil.SEARCH);
        searchField = new JTextField(NumbersUtil.SEARCH_FIELD);
        searchButton = new JButton(StringsUtil.SEARCH);
        searchButton.addActionListener(this);
        cancelButton = new JButton("X");
        cancelButton.addActionListener(this);
    }

    protected abstract void search();

    protected abstract void setFilterPanel();
}

package com.sedatram.view.abstract_view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class DataPanelAbstract<T> extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ArrayList<JLabel> labelArray;
    protected ArrayList<JComponent> componentArray;
    protected T data;

    public DataPanelAbstract(T data) {
        super();
        this.data = data;
        defineFields();
        initializeVariables();
        setLabelArray();
        setComponentArray();
        fillData();
        printLayout();
    }

    protected abstract void defineFields();

    public abstract void fillData();

    private void initializeVariables() {
        labelArray = new ArrayList<>();
        componentArray = new ArrayList<>();
    }

    protected void printLayout() {
    	this.removeAll();
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        Insets rightPadding = new Insets(0, 0, 0, 15);
        Insets noPadding = new Insets(0, 0, 0, 0);
        gc.gridy = 0;
        for(JLabel jL : labelArray) {
            gc.weightx = 1;
            gc.weighty = 1;
            gc.fill = GridBagConstraints.NONE;
            gc.gridx = 0;
            gc.anchor = GridBagConstraints.EAST;
            gc.insets = rightPadding;
            add(jL, gc);
            gc.gridy++;
        }
        gc.gridy = 0;
        for(JComponent jTF : componentArray) {
            gc.weightx = 1;
            gc.weighty = 1;
            gc.fill = GridBagConstraints.NONE;
            gc.gridx = 1;
            gc.anchor = GridBagConstraints.WEST;
            gc.insets = noPadding;
            add(jTF, gc);
            gc.gridy++;
        }
        updateUI();
    }

    public abstract boolean saveData();

    protected abstract void setComponentArray();

    protected abstract void setLabelArray();
}

package com.sedatram.view.abstract_view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sedatram.utils.StringsUtil;

public abstract class DetailAbstract<T> extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton backButton;
    protected JButton deleteButton;
    protected JButton editButton;
    protected JButton recordsButton;

    protected JPanel buttonPanel;

    protected DataPanelAbstract<T> dataPanel;
    protected MainAbstract<T> parent;

    protected T data;

    public DetailAbstract(MainAbstract<T> parent, String title, T t) {
        super("Detalles " + title);
        this.parent = parent;
        this.data = t;
        initialize();
        initializeLayout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(backButton)) {
            setVisible(false);
        } else if(e.getSource().equals(editButton)) {
            editAction();
        } else if(e.getSource().equals(deleteButton)) {
            deleteAction();
        }else if(e.getSource().equals(recordsButton)){
            recordAction();
        }
    }

    protected abstract void deleteAction();

    public abstract void editAction();

    private void initialize() {
        buttonPanel = new JPanel();
        editButton = new JButton(StringsUtil.EDIT);
        editButton.addActionListener(this);
        deleteButton = new JButton(StringsUtil.DELETE);
        deleteButton.addActionListener(this);
        backButton = new JButton(StringsUtil.BACK);
        backButton.addActionListener(this);
        recordsButton = new JButton(StringsUtil.RECORDS);
        recordsButton.addActionListener(this);
        setDataPanel(data);
    }

    private void initializeLayout() {
        this.setLayout(new BorderLayout());
        this.add(dataPanel, BorderLayout.CENTER);
        buttonPanel.add(backButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        buttonPanel.add(recordsButton);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    protected abstract void recordAction();

    public abstract void setDataPanel(T t);
}

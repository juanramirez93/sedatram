package com.sedatram.view.abstract_view;
import com.sedatram.utils.StringsUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class CEAbstract<T> extends JFrame implements ActionListener {
    protected JButton backButton;
    protected JButton saveButton;

    protected JPanel buttonPanel;

    protected DataPanelAbstract<T> dataPanel;
    protected MainAbstract<T> parent;

    protected T data;

    protected CEAbstract(MainAbstract<T> parent, String title, T t) {
        super("Agregar " + title);
        this.parent = parent;
        this.data = t;
        initialize();
        initializeLayout();
    }

    private void initializeLayout() {
        this.setLayout(new BorderLayout());
        this.add(dataPanel, BorderLayout.CENTER);
        buttonPanel.add(backButton);
        buttonPanel.add(saveButton);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void initialize() {
        buttonPanel = new JPanel();
        saveButton = new JButton(StringsUtil.SAVE);
        saveButton.addActionListener(this);
        backButton = new JButton(StringsUtil.BACK);
        backButton.addActionListener(this);
        setDataPanel(data);
    }

    public abstract void setDataPanel(T t);

    public abstract void saveAction();

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(backButton)) {
            setVisible(false);
        } else if(e.getSource().equals(saveButton)) {
            saveAction();
        }
    }
}

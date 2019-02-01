package com.sedatram.view.general;

import com.sedatram.utils.StringsUtil;
import com.sedatram.view.formality.MainFormality;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessesPanel extends JPanel implements ActionListener {

    private JButton formalityButton;
    private MainFormality mainFormality;

    public ProcessesPanel() {
        initialize();
        initializeVariables();
        initializeLayout();
    }

    private void initializeLayout() {
        this.setLayout(new FlowLayout());
        this.add(formalityButton);
    }

    private void initializeVariables() {
        formalityButton = new JButton(StringsUtil.FORMALITY);
        formalityButton.addActionListener(this);
    }

    private void initialize() {
        this.setBorder(BorderFactory.createTitledBorder(StringsUtil.PROCESSES));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(formalityButton)){
            if(mainFormality == null){
                mainFormality = new MainFormality();
            }
            mainFormality.setVisible(true);
        }
    }
}

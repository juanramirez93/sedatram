package com.sedatram.view.general;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.sedatram.utils.StringsUtil;
import com.sedatram.view.formality.MainFormality;

public class ProcessesPanel extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton formalityButton;
    private MainFormality mainFormality;

    public ProcessesPanel() {
        initialize();
        initializeVariables();
        initializeLayout();
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

    private void initialize() {
        this.setBorder(BorderFactory.createTitledBorder(StringsUtil.PROCESSES));
    }

    private void initializeLayout() {
        this.setLayout(new FlowLayout());
        this.add(formalityButton);
    }

    private void initializeVariables() {
        formalityButton = new JButton(StringsUtil.FORMALITY);
        formalityButton.addActionListener(this);
    }
}

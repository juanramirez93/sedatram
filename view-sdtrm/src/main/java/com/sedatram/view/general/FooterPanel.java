package com.sedatram.view.general;
import com.sedatram.controller.SessionController;
import com.sedatram.utils.StringsUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FooterPanel extends JPanel implements ActionListener {
    private JLabel sessionLabel;
    private JButton changePassButton;

    public FooterPanel() {
        initializeVariables();
        initializeLayout();
    }

    private void initializeLayout() {
        this.setLayout(new FlowLayout());
        this.add(sessionLabel);
        this.add(changePassButton);
        changePassButton.addActionListener(this);
    }

    private void initializeVariables() {
        this.sessionLabel = new JLabel(SessionController.getInstance().getUserSession().getName());
        this.changePassButton = new JButton(StringsUtil.CHANGE_PASS);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(changePassButton)) {
            ChangePasswordFrame changePasswordFrame = new ChangePasswordFrame();
            changePasswordFrame.setVisible(true);
        }
    }
}

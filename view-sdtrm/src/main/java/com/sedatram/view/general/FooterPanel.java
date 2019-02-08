package com.sedatram.view.general;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sedatram.controller.SessionController;
import com.sedatram.utils.StringsUtil;

public class FooterPanel extends JPanel implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel sessionLabel;
    private JButton changePassButton;

    public FooterPanel() {
        initializeVariables();
        initializeLayout();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(changePassButton)) {
            ChangePasswordFrame changePasswordFrame = new ChangePasswordFrame();
            changePasswordFrame.setVisible(true);
        }
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
}

package com.sedatram.view.general;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;

import com.sedatram.controller.SessionController;
import com.sedatram.controller.UserController;
import com.sedatram.model.User;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;

public class ChangePasswordFrame extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel oldPassLabel;
    private JLabel newPassLabel;
    private JLabel confirmPassLabel;
    private JPasswordField oldPassField;
    private JPasswordField newPassField;
    private JPasswordField confirmPassField;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JPanel southPanel;
    private JPanel dataPanel;
    private JButton changeButton;

    public ChangePasswordFrame() {
        initialize();
        initializeVariables();
        initializeLayout();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(changeButton)) {
            changePassword();
        }
    }

    private void changePassword() {
        User user = SessionController.getInstance().getUserSession();
        if(StringsUtil.verifyPassword(oldPassField.getPassword(),
                user.getPassword().toCharArray())) {
            if(StringsUtil
                    .verifyPassword(newPassField.getPassword(), confirmPassField.getPassword())) {
                user.setPassword(String.valueOf(newPassField.getPassword()));
                UserController.getInstance().save(user);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, StringsUtil.NOT_SAME);
            }
        } else {
            JOptionPane.showMessageDialog(this, StringsUtil.ENTER_DENIED);
            oldPassField.setText("");
        }
    }

    private void initialize() {
        setSize(NumbersUtil.PASSWORD_WIDTH, NumbersUtil.PASSWORD_HEIGHT);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initializeLayout() {
        this.setLayout(new BorderLayout());
        dataPanel.setLayout(new FlowLayout());
        northPanel.setLayout(new FlowLayout());
        northPanel.add(oldPassLabel);
        northPanel.add(oldPassField);
        dataPanel.add(northPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new FlowLayout());
        centerPanel.add(newPassLabel);
        centerPanel.add(newPassField);
        dataPanel.add(centerPanel, BorderLayout.CENTER);
        southPanel.setLayout(new FlowLayout());
        southPanel.add(confirmPassLabel);
        southPanel.add(confirmPassField);
        dataPanel.add(southPanel, BorderLayout.CENTER);
        this.add(dataPanel, BorderLayout.CENTER);
        this.add(changeButton, BorderLayout.SOUTH);
    }

    private void initializeVariables() {
        oldPassLabel = new JLabel(StringsUtil.OLD_PASSWORD);
        newPassLabel = new JLabel(StringsUtil.NEW_PASSWORD);
        confirmPassLabel = new JLabel(StringsUtil.CONFIRM_PASSWORD);
        oldPassField = new JPasswordField(NumbersUtil.PASSWORD_FIELD);
        newPassField = new JPasswordField(NumbersUtil.PASSWORD_FIELD);
        confirmPassField = new JPasswordField(NumbersUtil.PASSWORD_FIELD);
        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        dataPanel = new JPanel();
        changeButton = new JButton(StringsUtil.CHANGE_PASS);
        changeButton.addActionListener(this);
    }
}

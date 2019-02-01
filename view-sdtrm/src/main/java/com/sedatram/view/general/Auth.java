package com.sedatram.view.general;

import com.sedatram.controller.SessionController;
import com.sedatram.controller.UserController;
import com.sedatram.model.User;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Auth extends JFrame implements ActionListener, KeyListener {

    /**
     *
     */
    private static final long serialVersionUID = 4976257625704467497L;
    private JButton enterButton;
    private JPanel dataPanel;
    private JPanel buttonPanel;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JLabel capsOnLabel;
    private JComboBox<User> userComboBox;
    private JPasswordField password;

    public Auth() {
        super(StringsUtil.AUTH);
        initializeVariables();
        initializeLayout();
        setVisible(true);
        try {
            if (InetAddress.getLocalHost().getHostName().equals("JUANCHO-WIN10")) {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
                this.dispose();
            }
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private void initializeLayout() {
        setSize(NumbersUtil.AUTH_FRAME_WIDTH, NumbersUtil.AUTH_FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        password.addKeyListener(this);
        dataPanel.setLayout(new FlowLayout());
        dataPanel.add(userLabel);
        dataPanel.add(userComboBox);
        dataPanel.add(passwordLabel);
        dataPanel.add(password);
        capsOnLabel.setVisible(false);
        dataPanel.add(capsOnLabel);
        this.add(dataPanel, BorderLayout.CENTER);
        buttonPanel.add(enterButton);
        buttonPanel.setLayout(new FlowLayout());
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.getRootPane().setDefaultButton(enterButton);
    }

    private void initializeVariables() {
        enterButton = new JButton(StringsUtil.ENTER);
        enterButton.addActionListener(this);
        dataPanel = new JPanel();
        buttonPanel = new JPanel();
        userLabel = new JLabel(StringsUtil.USER);
        capsOnLabel = new JLabel(StringsUtil.CAPS_ON);
        passwordLabel = new JLabel(StringsUtil.PASSWORD);
        userComboBox = new JComboBox<>(UserController.getInstance().getAllUsers());
        password = new JPasswordField(NumbersUtil.AUTH_LENGTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterButton) {
            enter();
        }
    }

    private void enter() {
        User user = (User) userComboBox.getSelectedItem();
        if (user != null
                && StringsUtil
                .verifyPassword(password.getPassword(), user.getPassword().toCharArray())) {
            SessionController.getInstance().setUserSession(user);
            //                Session.INSTANCE.setPathFolderDocs(new Config().comprobar());
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(this, StringsUtil.ENTER_DENIED);
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        capsOnLabel.setVisible(Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK));
        this.repaint();
    }
}

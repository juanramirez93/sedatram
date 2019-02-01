package com.sedatram.view.general;
import com.sedatram.controller.SessionController;
import com.sedatram.utils.StringsUtil;
import com.sedatram.utils.Utils;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {
    private JLabel imagePanel;
    private JLabel titlePanel;

    public HeaderPanel() {
        initializeVariables();
        initializeLayout();
    }

    private void initializeLayout() {
        setImage();
        this.setLayout(new FlowLayout());
        this.add(this.imagePanel);
        titlePanel.setHorizontalAlignment(SwingConstants.RIGHT);
        titlePanel.setForeground(Utils.appColor);
        titlePanel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));
        this.add(this.titlePanel);
    }

    private void setImage() {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/logo.jpg"));
        imagePanel.setIcon(imageIcon);
    }

    private void initializeVariables() {
        this.imagePanel = new JLabel();
        this.titlePanel = new JLabel(StringsUtil.TITLE);
    }
}

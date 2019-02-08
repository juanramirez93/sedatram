package com.sedatram.view.general;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sedatram.utils.StringsUtil;
import com.sedatram.utils.Utils;

public class HeaderPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

    private void initializeVariables() {
        this.imagePanel = new JLabel();
        this.titlePanel = new JLabel(StringsUtil.TITLE);
    }

    private void setImage() {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/logo.jpg"));
        imagePanel.setIcon(imageIcon);
    }
}

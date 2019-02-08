package com.sedatram.view.general;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sedatram.utils.NumbersUtil;

public class MainFrame extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BDPanel bdPanel;
    private JPanel mainPanel;
    private HeaderPanel headerPanel;
    private FooterPanel footerPanel;
    private ProcessesPanel processesPanel;

    public MainFrame() {
        initialize();
        initializeVariables();
        initializeLayout();
    }

    private void initialize() {
        setSize(NumbersUtil.MAIN_WIDTH, NumbersUtil.MAIN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initializeLayout() {
        this.setLayout(new BorderLayout());
        this.mainPanel.setLayout(new FlowLayout());
        this.mainPanel.add(this.bdPanel);
        this.mainPanel.add(this.processesPanel);
        this.add(this.mainPanel, BorderLayout.CENTER);
        this.add(this.headerPanel, BorderLayout.NORTH);
        this.add(this.footerPanel, BorderLayout.SOUTH);
    }

    private void initializeVariables() {
        this.bdPanel = new BDPanel();
        this.mainPanel = new JPanel();
        this.headerPanel = new HeaderPanel();
        this.footerPanel = new FooterPanel();
        this.processesPanel = new ProcessesPanel();
    }
}

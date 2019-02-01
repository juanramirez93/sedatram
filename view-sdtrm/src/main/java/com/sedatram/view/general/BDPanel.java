package com.sedatram.view.general;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.customer.MainCustomer;
import com.sedatram.view.vehicle.MainVehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BDPanel extends JPanel implements ActionListener {

    private JButton customerButton;
    private MainCustomer mainCustomer;
    private JButton vehicleButton;
    private MainVehicle mainVehicle;

    public BDPanel() {
        initialize();
        initializeVariables();
        initializeLayout();
    }

    private void initializeLayout() {
        this.setLayout(new FlowLayout());
        this.add(customerButton);
        this.add(vehicleButton);
    }

    private void initialize() {
        this.setBorder(BorderFactory.createTitledBorder(StringsUtil.DATA_BASES));
    }

    private void initializeVariables() {
        this.customerButton = new JButton(StringsUtil.CUSTOMERS);
        this.customerButton.addActionListener(this);
        this.vehicleButton = new JButton(StringsUtil.VEHICLES);
        this.vehicleButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(customerButton)) {
            if(mainCustomer != null) {
                mainCustomer.dispose();
            }
            mainCustomer = new MainCustomer();
            mainCustomer.setVisible(true);
        }else if(e.getSource().equals(vehicleButton)) {
            if(mainVehicle != null) {
                mainVehicle.dispose();
            }
            mainVehicle = new MainVehicle();
            mainVehicle.setVisible(true);
        }
    }
}

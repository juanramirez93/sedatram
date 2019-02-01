package com.sedatram.utils;
import com.sedatram.controller.PersonController;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class InputsVerifier {

    public static InputVerifier verifyCustomId = new InputVerifier() {
        @Override
        public boolean verify(JComponent input) {
            String idStr = ((JTextField) input).getText();
            if(idStr.isEmpty()) return true;
            if(NumbersUtil.isNumber(idStr)) {
                if(!PersonController.getInstance().existCustomer(idStr)) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, StringsUtil.ALREADY_EXIST_MESSAGE,
                            StringsUtil.TITLE, JOptionPane.ERROR_MESSAGE);
                    ((JTextField) input).setText("");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, StringsUtil.ONLY_NUMBERS_MESSAGE,
                        StringsUtil.TITLE, JOptionPane.ERROR_MESSAGE);
                ((JTextField) input).setText("");
                return false;
            }
        }
    };

    public static InputVerifier toUpper = new InputVerifier() {

        @Override
        public boolean verify(JComponent input) {
            JTextComponent in = (JTextComponent) input;
            in.setText(in.getText().toUpperCase());
            return true;
        }
    };

    public static InputVerifier toLower = new InputVerifier() {

        @Override
        public boolean verify(JComponent input) {
            JTextComponent in = (JTextComponent) input;
            in.setText(in.getText().toLowerCase());
            return true;
        }
    };

    public static InputVerifier formatPhone = new InputVerifier() {

        @Override
        public boolean verify(JComponent input) {
            String phone = ((JTextField) input).getText();
            if(!phone.isEmpty()) {
                if(((JTextField) input).getText().length() == 8) {
                    ((JTextField) input).setText(Utils.formatPhone(phone));
                } else {
                    JOptionPane.showMessageDialog(null, StringsUtil.PHONE_ERROR_MESSAGE,
                            StringsUtil.TITLE, JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            return true;
        }
    };

    public static InputVerifier formatCellphone = new InputVerifier() {

        @Override
        public boolean verify(JComponent input) {
            String phone = ((JTextField) input).getText();
            if(!phone.isEmpty()) {
                if(((JTextField) input).getText().length() == 10) {
                    ((JTextField) input).setText(Utils.formatPhone(phone));
                } else {
                    JOptionPane.showMessageDialog(null, StringsUtil.CELLPHONE_ERROR_MESSAGE,
                            StringsUtil.TITLE, JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            return true;
        }
    };
    public static InputVerifier isNumberOrNull = new InputVerifier() {
        @Override
        public boolean verify(JComponent input) {
            String idStr = ((JTextField) input).getText();
            if(idStr.isEmpty()) return true;
            if(NumbersUtil.isNumber(idStr)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, StringsUtil.ONLY_NUMBERS_MESSAGE,
                        StringsUtil.TITLE, JOptionPane.ERROR_MESSAGE);
                ((JTextField) input).setText("");
                return false;
            }
        }
    };
}

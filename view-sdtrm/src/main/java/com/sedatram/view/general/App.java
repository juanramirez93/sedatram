package com.sedatram.view.general;

import javax.swing.*;

import com.sedatram.controller.UserController;
import com.sedatram.model.User;

public class App {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (UserController.getInstance().getAll().isEmpty()) {
			User user = new User();
			user.setName("admin");
			user.setPassword("admin");
			user.setUser("admin");
			UserController.getInstance().save(user);
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Auth();
			}
		});
	}
}

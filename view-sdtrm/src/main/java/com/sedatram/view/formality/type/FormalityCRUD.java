package com.sedatram.view.formality.type;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sedatram.controller.FormalityController;
import com.sedatram.model.auxiliar.TypeFormality;
import com.sedatram.utils.StringsUtil;

public class FormalityCRUD extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<TypeFormality> comboBox;
	private List<TypeFormality> formalities;
	private List<JCheckBox> checkBoxs;
	private TypeFormality actualFormality;
	private JPanel buttonPanel;
	private JButton addButton;
	private JButton saveButton;
	private JButton deleteButton;

	/**
	 * Create the frame.
	 */
	public FormalityCRUD() {
		initialize();
		setTypes();
		setPanel();
		setButtonPanel();
		fillFields();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, 38 * StringsUtil.TYPE_FORMALITY_COLUMNS.length);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		comboBox = new JComboBox<TypeFormality>();
		checkBoxs = new ArrayList<JCheckBox>();
		formalities = FormalityController.getInstance().getAllTypes();
		if (formalities.isEmpty()) {
			TypeFormality formality = new TypeFormality("");
			formalities.add(formality);
			actualFormality = formality;
		} else {
			actualFormality = formalities.get(0);
		}
	}

	private void setButtonPanel() {
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		addButton = new JButton(StringsUtil.ADD);
		addButton.addActionListener(this);
		buttonPanel.add(addButton);
		saveButton = new JButton(StringsUtil.SAVE_CHANGES);
		saveButton.addActionListener(this);
		buttonPanel.add(saveButton);
		deleteButton = new JButton(StringsUtil.DELETE);
		deleteButton.addActionListener(this);
		buttonPanel.add(deleteButton);
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
	}

	private void setTypes() {
		comboBox.removeAllItems();
		for (TypeFormality typeFormality : formalities) {
			comboBox.addItem(typeFormality);
		}
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(comboBox, BorderLayout.NORTH);
		comboBox.addActionListener(this);
	}

	private void setPanel() {
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0 };
		gbl_panel.rowHeights = new int[] { 0 };
		gbl_panel.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		for (int i = 1; i < StringsUtil.TYPE_FORMALITY_COLUMNS.length; i++) {
			JCheckBox chckbxNewCheckBox = new JCheckBox(StringsUtil.TYPE_FORMALITY_COLUMNS[i]);
			checkBoxs.add(chckbxNewCheckBox);
			GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
			gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 10, 0);
			gbc_chckbxNewCheckBox.gridx = 0;
			gbc_chckbxNewCheckBox.gridy = i - 1;
			panel.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(comboBox)) {
			saveActualType();
			actualFormality = (TypeFormality) comboBox.getSelectedItem();
			fillFields();
		} else if (e.getSource().equals(addButton)) {
			String type = JOptionPane.showInputDialog("Ingrese el nuevo tipo de trámite");
			TypeFormality formality = new TypeFormality(type.toUpperCase());
			formalities.add(formality);
			setTypes();
		} else if (e.getSource().equals(saveButton)) {
			saveAll();
			dispose();
		} else if (e.getSource().equals(deleteButton)) {
			int rta = JOptionPane.showConfirmDialog(null, StringsUtil.SURE_DELETE, StringsUtil.TITLE,
					JOptionPane.OK_CANCEL_OPTION);
			if (rta == 0) {
				FormalityController.getInstance().remove(actualFormality);
			}
		}
	}

	private void saveAll() {
		saveActualType();
		for (TypeFormality typeFormality : formalities) {
			if (!typeFormality.getName().equals("")) {
				FormalityController.getInstance().saveType(typeFormality);
			}
		}
	}

	private void saveActualType() {
		if (actualFormality != null) {
			List<Boolean> booleans = new ArrayList<Boolean>();
			for (JCheckBox box : checkBoxs) {
				booleans.add(box.isSelected());
			}
			actualFormality.setArray(booleans);
		}
	}

	private void fillFields() {
		if (actualFormality != null && !actualFormality.getName().isEmpty()) {
			int i = 0;
			for (Boolean bool : actualFormality.toArray()) {
				checkBoxs.get(i).setSelected(bool);
				i++;
			}
		}
	}

}

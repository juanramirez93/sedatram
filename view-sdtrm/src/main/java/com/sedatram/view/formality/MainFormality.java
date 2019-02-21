package com.sedatram.view.formality;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.sedatram.controller.FormalityController;
import com.sedatram.model.Formality;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.view.abstract_view.MainAbstract;
import com.sedatram.view.formality.type.FormalityCRUD;

public class MainFormality extends MainAbstract<Formality> {

	private JButton typeFormalitiesButton;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFormality() {
		super(StringsUtil.FORMALITY);
		initialize();
	}

	@Override
	protected void addAction() {
		if (!FormalityController.getInstance().getAllTypes().isEmpty()) {
			if (ceFrame != null) {
				ceFrame.dispose();
			}
			ceFrame = new CEFormality(this, new Formality());
			ceFrame.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, StringsUtil.NO_TYPE_FORMALITY);
		}
	}

	@Override
	protected void deleteAction() {
	}

	@Override
	protected void detailAction() {
	}

	@Override
	protected void editAction() {
	}

	@Override
	protected void exportAction() {
	}

	private void initialize() {
		refreshTable(FormalityController.getInstance().getAll());
		setSize(NumbersUtil.MAIN_FORMALITY_WIDTH, NumbersUtil.MAIN_FORMALITY_HEIGHT);
		setLocationRelativeTo(null);
		typeFormalitiesButton = new JButton(StringsUtil.TYPE_FORMALITY);
		typeFormalitiesButton.addActionListener(this);
		buttonPanel.add(typeFormalitiesButton);
	}

	@Override
	protected void setSearch() {
		search = new SearchFormality(this);
	}

	@Override
	protected void setTable() {
		table = new TableFormality();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if (e.getSource().equals(typeFormalitiesButton)) {
			FormalityCRUD crud = new FormalityCRUD();
			crud.setVisible(true);
		}
	}
}

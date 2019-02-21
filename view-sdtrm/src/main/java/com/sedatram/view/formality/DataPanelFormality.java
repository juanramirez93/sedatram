package com.sedatram.view.formality;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sedatram.controller.FormalityController;
import com.sedatram.controller.PersonController;
import com.sedatram.controller.VehicleController;
import com.sedatram.model.Formality;
import com.sedatram.model.Person;
import com.sedatram.model.Session;
import com.sedatram.model.Vehicle;
import com.sedatram.model.auxiliar.FormalityHandler;
import com.sedatram.model.auxiliar.TypeFormality;
import com.sedatram.utils.InputsVerifier;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.utils.Utils;
import com.sedatram.view.abstract_view.CEAbstract;
import com.sedatram.view.abstract_view.DataPanelAbstract;
import com.sedatram.view.customer.natural.CENaturalCustomer;
import com.sedatram.view.vehicle.CEVehicle;
import com.toedter.calendar.JDateChooser;

public class DataPanelFormality extends DataPanelAbstract<Formality> implements ActionListener, FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<TypeFormality> typeBox;
	private JDateChooser initDateChooser;
	private JTextField customerField;
	private JTextField vehicleField;
	private JComboBox<FormalityHandler> handlerBox;
	private JTextField taxesField;
	private JTextField rigthsField;
	private JTextField signalingField;
	private JTextField retentionField;
	private JTextField goodStandingField;
	private JTextField othersField;
	private JTextField handlerServiceField;
	private JTextField serviceSedatramField;
	private JTextField shipmentsField;
	private JTextField totalField;
	private JComboBox<String> payStatusBox;
	private JComboBox<String> statusBox;
	private JDateChooser finalDateChooser;

	private List<JTextField> components;

	public DataPanelFormality(Formality data) {
		super(data);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource().equals(typeBox)) {
			setLabelArray();
			setComponentArray();
			printLayout();
			updateUI();;
		}
	}

	@Override
	protected void defineFields() {
		components = new ArrayList<JTextField>();
		typeBox = new JComboBox<>(FormalityController.getInstance().getAllTypesArray());
		typeBox.addActionListener(this);
		customerField = new JTextField(NumbersUtil.FORMALITY_FIELD);
		customerField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent focusEvent) {
			}

			@Override
			public void focusLost(FocusEvent focusEvent) {
				String idStr = customerField.getText().replaceAll("\\.", "");
				idStr = idStr.replaceAll("\\.", "");
				if (Utils.isNumberOrNull(idStr)) {
					String natId = StringsUtil.formatId(idStr);
					String legId = Utils.formatNit(idStr);
					if (PersonController.getInstance().existCustomer(natId)) {
						data.setCustomer(PersonController.getInstance().getCustomer(natId));
						customerField.setText(natId);
					} else if (PersonController.getInstance().existCustomer(legId)) {
						data.setCustomer(PersonController.getInstance().getCustomer(legId));
						customerField.setText(legId);
					} else {
						int rta = JOptionPane.showConfirmDialog(null, StringsUtil.CUSTOMER_DO_NOT_EXIST,
								StringsUtil.TITLE, JOptionPane.OK_CANCEL_OPTION);
						if (rta == 0) {
							CEAbstract<Person> ceFrame;
							rta = JOptionPane.showOptionDialog(null, StringsUtil.NATURAL_OR_LEGAL, StringsUtil.TITLE,
									JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
									new Object[] { "Natural", "Jurídico" }, 0);
							if (rta == 0) {
								Person person = PersonController.getInstance().getPerson(natId);
								if (person == null) {
									person = new Person(natId);
								}
								ceFrame = new CENaturalCustomer(null, person);
								ceFrame.setVisible(true);
							} else if (rta == 1) {
								Person person = PersonController.getInstance().getPerson(legId);
								if (person == null) {
									person = new Person(legId);
								}
								ceFrame = new CENaturalCustomer(null, person);
								ceFrame.setVisible(true);
							}
						}
						customerField.setText("");
					}
				} else {
					JOptionPane.showMessageDialog(null, StringsUtil.ONLY_NUMBERS_MESSAGE, StringsUtil.TITLE,
							JOptionPane.ERROR_MESSAGE);
					customerField.setText("");
				}
			}
		});
		initDateChooser = new JDateChooser(new Date());
		initDateChooser.setDateFormatString("dd/MM/yy");
		vehicleField = new JTextField(NumbersUtil.FORMALITY_FIELD);
		vehicleField.setInputVerifier(InputsVerifier.toUpper);
		vehicleField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				String plaque = vehicleField.getText().trim();
				Vehicle vehicle = VehicleController.getInstance().getVehicle(plaque);
				if (vehicle == null) {
					int rta = JOptionPane.showConfirmDialog(null, StringsUtil.VEHICLE_DO_NOT_EXIST, StringsUtil.TITLE,
							JOptionPane.OK_CANCEL_OPTION);
					if (rta == 0) {
						CEVehicle ceVehicle = new CEVehicle(null, new Vehicle());
						ceVehicle.setVisible(true);
					}
					vehicleField.setText("");
				} else {
					data.setVehicle(vehicle);
				}
			}
		});
		handlerBox = new JComboBox<FormalityHandler>(FormalityController.getInstance().getAllHandlers());
		taxesField = new JTextField(NumbersUtil.FORMALITY_FIELD);
		taxesField.setInputVerifier(InputsVerifier.isNumberOrNull);
		taxesField.addFocusListener(this);
		components.add(taxesField);
		rigthsField = new JTextField(NumbersUtil.FORMALITY_FIELD);
		rigthsField.setInputVerifier(InputsVerifier.isNumberOrNull);
		rigthsField.addFocusListener(this);
		components.add(rigthsField);
		signalingField = new JTextField(NumbersUtil.FORMALITY_FIELD);
		signalingField.setInputVerifier(InputsVerifier.isNumberOrNull);
		signalingField.addFocusListener(this);
		components.add(signalingField);
		retentionField = new JTextField(NumbersUtil.FORMALITY_FIELD);
		retentionField.setInputVerifier(InputsVerifier.isNumberOrNull);
		retentionField.addFocusListener(this);
		components.add(retentionField);
		goodStandingField = new JTextField(NumbersUtil.FORMALITY_FIELD);
		goodStandingField.setInputVerifier(InputsVerifier.isNumberOrNull);
		goodStandingField.addFocusListener(this);
		components.add(goodStandingField);
		othersField = new JTextField(NumbersUtil.FORMALITY_FIELD);
		othersField.setInputVerifier(InputsVerifier.isNumberOrNull);
		othersField.addFocusListener(this);
		components.add(othersField);
		handlerServiceField = new JTextField(NumbersUtil.FORMALITY_FIELD);
		handlerServiceField.setInputVerifier(InputsVerifier.isNumberOrNull);
		handlerServiceField.addFocusListener(this);
		components.add(handlerServiceField);
		serviceSedatramField = new JTextField(NumbersUtil.FORMALITY_FIELD);
		serviceSedatramField.setInputVerifier(InputsVerifier.isNumberOrNull);
		serviceSedatramField.addFocusListener(this);
		components.add(serviceSedatramField);
		shipmentsField = new JTextField(NumbersUtil.FORMALITY_FIELD);
		shipmentsField.setInputVerifier(InputsVerifier.isNumberOrNull);
		shipmentsField.addFocusListener(this);
		components.add(shipmentsField);
		totalField = new JTextField(NumbersUtil.FORMALITY_FIELD);
		totalField.setInputVerifier(InputsVerifier.isNumberOrNull);
		totalField.setEnabled(false);
		payStatusBox = new JComboBox<String>(StringsUtil.PAY_STATUS_OPTIONS);
		statusBox = new JComboBox<String>(StringsUtil.STATUS_OPTIONS);
		finalDateChooser = new JDateChooser();
		finalDateChooser.setDateFormatString("dd/MM/yy");
		getTotal();
	}

	@Override
	public void fillData() {
		if (data.getCustomer() != null) {
			typeBox.setSelectedItem(data.getType());
			customerField.setText(data.getCustomer().getIdentification());
			initDateChooser.setDate(data.getInitDate());
			vehicleField.setText(data.getVehicle().getPlaque());
			handlerBox.setSelectedItem(data.getHandlerService());
			taxesField.setText(String.valueOf(data.getTaxes()));
			rigthsField.setText(String.valueOf(data.getFormalityRight()));
			signalingField.setText(String.valueOf(data.getSignaling()));
			retentionField.setText(String.valueOf(data.getRetention()));
			goodStandingField.setText(String.valueOf(data.getGoodStanding()));
			othersField.setText(String.valueOf(data.getGoodStanding()));
			handlerServiceField.setText(String.valueOf(data.getHandlerService()));
			serviceSedatramField.setText(String.valueOf(data.getServiceSedatram()));
			shipmentsField.setText(String.valueOf(data.getShipments()));
			totalField.setText(String.valueOf(data.getTotal()));
			payStatusBox.setSelectedItem(data.getPayStatus());
			finalDateChooser.setDate(data.getFinishDate());
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		getTotal();
		updateUI();
	}

	private void getTotal() {
		int total = 0;
		for (JTextField jComponent : components) {
			if (!jComponent.getText().isEmpty()) {
				total += Integer.parseInt(jComponent.getText());
			} else {
				jComponent.setText("0");
			}
		}
		totalField.setText(String.valueOf(total));
	}

	@Override
	public boolean saveData() {
		ArrayList<Component> error = new ArrayList<>();
		if (customerField.getText().equals("")) {
			error.add(customerField);
		}
		if (initDateChooser.getDate() == null) {
			error.add(customerField);
		}
		if (error.isEmpty()) {
			data.setType((TypeFormality) typeBox.getSelectedItem());
			data.setInitDate(initDateChooser.getDate());
			data.setHandler((FormalityHandler) handlerBox.getSelectedItem());
			data.setTaxes(Integer.parseInt(taxesField.getText()));
			data.setFormalityRight(Integer.parseInt(rigthsField.getText()));
			data.setSignaling(Integer.parseInt(signalingField.getText()));
			data.setRetention(Integer.parseInt(retentionField.getText()));
			data.setGoodStanding(Integer.parseInt(goodStandingField.getText()));
			data.setOthers(Integer.parseInt(othersField.getText()));
			data.setHandlerService(Integer.parseInt(handlerServiceField.getText()));
			data.setServiceSedatram(Integer.parseInt(serviceSedatramField.getText()));
			data.setShipments(Integer.parseInt(shipmentsField.getText()));
			data.setTotal(Integer.parseInt(totalField.getText()));
			data.setPayStatus((String) payStatusBox.getSelectedItem());
			data.setFinishDate(finalDateChooser.getDate());
			data.setEditedAt(new Date());
			data.setEditedBy(Session.userActive.getName());
			FormalityController.getInstance().save(data);
			return true;
		} else {
			JOptionPane.showMessageDialog(this, StringsUtil.INCOMPLETE_DATA_MESSAGE);
			for (Component component : error) {
				component.setBackground(Color.pink);
			}
			return false;
		}
	}

	@Override
	protected void setComponentArray() {
		componentArray.clear();
		componentArray.add(typeBox);
		TypeFormality typeFormality = (TypeFormality) typeBox.getSelectedItem();
		componentArray.add(customerField);
		componentArray.add(initDateChooser);
		if (typeFormality.isVehicle()) {
			labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[3]));
			componentArray.add(vehicleField);
		}
		if (typeFormality.isHandler()) {
			labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[4]));
			componentArray.add(handlerBox);
		}
		if (typeFormality.isTaxes()) {
			labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[5]));
			componentArray.add(taxesField);
		}
		if (typeFormality.isRights()) {
			labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[6]));
			componentArray.add(rigthsField);
		}
		if (typeFormality.isSignaling()) {
			labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[7]));
			componentArray.add(signalingField);
		}
		if (typeFormality.isRetention()) {
			labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[8]));
			componentArray.add(retentionField);
		}
		if (typeFormality.isGoodStanding()) {
			labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[9]));
			componentArray.add(goodStandingField);
		}
		if (typeFormality.isOthers()) {
			labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[10]));
			componentArray.add(othersField);
		}
		if (typeFormality.isHandlerService()) {
			labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[11]));
			componentArray.add(handlerServiceField);
		}
		if (typeFormality.isServiceSedatram()) {
			labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[12]));
			componentArray.add(serviceSedatramField);
		}
		if (typeFormality.isShipments()) {
			labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[13]));
			componentArray.add(shipmentsField);
		}
		if (typeFormality.isTotal()) {
			labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[14]));
			componentArray.add(totalField);
		}
		if (typeFormality.isPayStatus()) {
			labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[15]));
			componentArray.add(payStatusBox);
		}
		if (typeFormality.isStatus()) {
			labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[16]));
			componentArray.add(statusBox);
		}
		if (typeFormality.isFinishDate()) {
			labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[17]));
			componentArray.add(finalDateChooser);
		}
	}

	@Override
	protected void setLabelArray() {
		labelArray.clear();
		labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[0]));
		labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[2]));
		labelArray.add(new JLabel(StringsUtil.FORMALITY_FIELDS[1]));
	}

}

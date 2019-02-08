package com.sedatram.view.customer;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import com.sedatram.controller.PersonController;
import com.sedatram.model.Person;
import com.sedatram.utils.NumbersUtil;
import com.sedatram.utils.StringsUtil;
import com.sedatram.utils.Utils;
import com.sedatram.view.abstract_view.MainAbstract;
import com.sedatram.view.customer.legal.CELegalCustomer;
import com.sedatram.view.customer.legal.DetailLegalCustomer;
import com.sedatram.view.customer.natural.CENaturalCustomer;
import com.sedatram.view.customer.natural.DetailNaturalCustomer;

public class MainCustomer extends MainAbstract<Person> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainCustomer() {
        super(StringsUtil.CUSTOMERS);
        initialize();
    }

    @Override
    protected void addAction() {
        int rta = JOptionPane.showOptionDialog(null, StringsUtil.NATURAL_OR_LEGAL,
                StringsUtil.TITLE, JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, StringsUtil.NATURAL_LEGAL, 0);
        if(ceFrame != null) {
            ceFrame.dispose();
        }
        if(rta == 0) {
            ceFrame = new CENaturalCustomer(this, new Person());
        } else {
            ceFrame = new CELegalCustomer(this, new Person());
        }
        ceFrame.setVisible(true);
    }

    @Override
    protected void deleteAction() {
        Person customer = table.getSelected();
        if(customer != null) {
            customer.setCustomer(false);
            PersonController.getInstance().save(customer);
            refreshTable(PersonController.getInstance().getAllCustomers());
        }
    }

    @Override
    protected void detailAction() {
        Person customer = table.getSelected();
        if(customer != null) {
            if(detailFrame != null) {
                detailFrame.dispose();
            }
            if(Arrays.binarySearch(StringsUtil.NATURAL_CUSTOMER_DOCUMENTS_OPTIONS,
                    customer.getTypeDocument()) >= 0) {
                detailFrame = new DetailNaturalCustomer(this, customer);
            } else {
                detailFrame = new DetailLegalCustomer(this, customer);
            }
            detailFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, StringsUtil.SELECT_REGISTER);
        }
    }

    @Override
    protected void editAction() {
        Person customer = table.getSelected();
        if(customer != null) {
            if(ceFrame != null) {
                ceFrame.dispose();
            }
            if(Arrays.binarySearch(StringsUtil.NATURAL_CUSTOMER_DOCUMENTS_OPTIONS,
                    customer.getTypeDocument()) >= 0) {
                ceFrame = new CENaturalCustomer(this, customer);
            } else {
                ceFrame = new CELegalCustomer(this, customer);
            }
            ceFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, StringsUtil.SELECT_REGISTER);
        }
    }

    @Override
    protected void exportAction() {
        List<Person> people = table.getList();
        String[][] peopleStrings =
                new String[people.size() + 1][StringsUtil.EXPORT_CUSTOMER_FIELDS.length];
        peopleStrings[0] = StringsUtil.EXPORT_CUSTOMER_FIELDS;
        int i = 1;
        for(Person p : people) {
            peopleStrings[i][0] = p.getTypeDocument();
            peopleStrings[i][1] = p.getIdentification();
            peopleStrings[i][2] = p.getName();
            peopleStrings[i][3] = p.getEmail();
            peopleStrings[i][4] = p.getPhone();
            peopleStrings[i][5] = p.getCell();
            peopleStrings[i][6] = p.getAddress();
            peopleStrings[i][7] = p.getCity();
            peopleStrings[i][8] = p.getDepartment();
            peopleStrings[i][9] = p.getManagerId() + "/" + p.getManagerName();
            peopleStrings[i][10] = p.getContact() + "/" + p.getCellContact();
            i++;
        }
        if(Utils.exportTable("Clientes", peopleStrings)) {
            JOptionPane.showMessageDialog(this, StringsUtil.EXPORT_SUCCESSFUL);
        } else {
            JOptionPane.showMessageDialog(this, StringsUtil.EXPORT_FAILURE);
        }
    }

    private void initialize() {
        refreshTable(PersonController.getInstance().getAllCustomers());
        setSize(NumbersUtil.MAIN_CUSTOMER_WIDTH, NumbersUtil.MAIN_CUSTOMER_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    protected void setSearch() {
        search = new SearchCustomer(this);
    }

    @Override
    protected void setTable() {
        table = new TableCustomer();
    }
}

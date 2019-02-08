package com.sedatram.view.abstract_view;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sedatram.utils.StringsUtil;

public abstract class FilterAbstract<T> extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel filtrarLabel;

    protected ArrayList<JCheckBox> checkBoxes;
    protected SearchAbstract<T> mainParent;
    protected JPanel panelOptions;

    public FilterAbstract(SearchAbstract<T> mainParent) {
        super();
        this.mainParent = mainParent;
        this.checkBoxes = new ArrayList<>();
        filtrarLabel = new JLabel(StringsUtil.FILTER);
        setCheckBoxes();
        setLayout();
    }

    public ArrayList<JCheckBox> getCheckBoxes() {
        return checkBoxes;
    }

    protected abstract void setCheckBoxes();

    private void setLayout() {
        panelOptions = new JPanel();
        for(JCheckBox checkBox : checkBoxes) {
            checkBox.addActionListener(this);
            panelOptions.add(checkBox);
        }

        setLayout(new FlowLayout());
        this.add(filtrarLabel);
        this.add(panelOptions);
    }

}

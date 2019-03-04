package View;

import javax.swing.*;

public abstract class RepeatedTaskFillingFormWithIntervalGUI extends RepeatedTaskFillingFormGUI {
    protected JComboBox cmbDaysInreval;
    protected JComboBox cmbSecondsInreval;
    protected JComboBox cmbMinutesInreval;
    protected JComboBox cmbHoursInreval;
    protected JComboBox cmbYearsInreval;
    protected JComboBox cmbMonthesInreval;

    protected int getInputedInterval(){
        return Integer.parseInt( (String) cmbSecondsInreval.getSelectedItem())
                + Integer.parseInt( (String) cmbMinutesInreval.getSelectedItem()) * 60
                + Integer.parseInt( (String) cmbHoursInreval.getSelectedItem())   * 60 * 60
                + Integer.parseInt( (String) cmbDaysInreval.getSelectedItem())    * 60 * 60 * 24
                + Integer.parseInt( (String) cmbMonthesInreval.getSelectedItem()) * 60 * 60 * 30
                + Integer.parseInt( (String) cmbYearsInreval.getSelectedItem())   * 60 * 60 * 365;
    }
}

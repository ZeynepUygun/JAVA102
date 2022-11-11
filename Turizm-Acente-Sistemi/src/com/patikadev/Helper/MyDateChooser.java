package com.patikadev.Helper;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyDateChooser extends JDialog implements MouseListener, ActionListener, ItemListener {
    //JDialog sınıfınfan kalıtım yaptık.
    private static final String[] MONTHS =
            new String[]{
                    "Ocak",
                    "Şubat",
                    "Mart",
                    "Nisan",
                    "Mayıs",
                    "Haziran",
                    "Temmuz",
                    "Ağustos",
                    "Eylül",
                    "Ekim",
                    "Kasım",
                    "Aralık"
            };
    private static final String[] DAYS =
            new String[]{
                    "P.tesi",
                    "Salı",
                    "Çrş.",
                    "Perş.",
                    "Cuma",
                    "C.tesi",
                    "Pazar"
            };
    private static final Color WEEK_DAYS_FOREGROUND = Color.black;
    private static final Color DAYS_FOREGROUND = Color.blue;
    private static final Color SELECTED_DAY_FOREGROUND = Color.white;
    private static final Color SELECTED_DAY_BACKGROUND = Color.blue;
    private static final Border EMPTY_BORDER = BorderFactory.createEmptyBorder(1, 1, 1, 1);
    private static final Border FOCUSED_BORDER = BorderFactory.createLineBorder(Color.yellow, 1);
    private static GregorianCalendar calendar;
    private static JLabel lbl_day;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private JComboBox cmb_month;
    private JComboBox cmb_year;
    private int start_year;
    private JButton btn_ok;
    private JLabel[][] days;
    private FocusablePanel daysGrid;
    private int offset;
    private int lastDay;
    private boolean okClicked;

    public MyDateChooser(Frame owner, int subtracted_number_year, int add_number_year) {
        //start_year = now_year - subtracted_number_year
        //end_year = now_year + add_number_year

        super(owner, "Tarih", true);
        contractor(subtracted_number_year, add_number_year);
    }

    public static void main(String[] args) {
        MyDateChooser my = new MyDateChooser(new JFrame(), 10, 10);
        my.select();
    }

    public int getSelectedDay() {
        if (lbl_day == null) {
            return -1;
        }
        try {
            return Integer.parseInt(lbl_day.getText());
        } catch (NumberFormatException e) {

        }
        return -1;
    }
    public int getSelectedMonth(){
        return this.cmb_month.getSelectedIndex()+1;
    }
    public String getSelectedYear(){
        return String.valueOf(this.cmb_year.getSelectedItem());
    }




    private void contractor(int subtracted_number_year, int add_number_year) {
        calendar = new GregorianCalendar();

        this.cmb_month = new JComboBox(MONTHS);//combobox'a aylar eklendi.
        this.cmb_month.addItemListener(this);


        this.start_year = calendar.get(Calendar.YEAR) - subtracted_number_year;
        int end_year = calendar.get(Calendar.YEAR) + add_number_year;


        this.cmb_year = new JComboBox();
        for (int i = start_year; i <= end_year; i++) {
            cmb_year.addItem(Integer.toString(i));
        }//combobox'a yıllar eklendi.
        this.cmb_year.addItemListener(this);

        this.days = new JLabel[7][7];
        for (int i = 0; i < 7; i++) {
            days[0][i] = new JLabel(DAYS[i], JLabel.RIGHT);
            days[0][i].setForeground(WEEK_DAYS_FOREGROUND);

        }//ilk oluşturduğumuz label'lara günlerin ismini atadık.Yani matrisin ilk satırına atadık.

        for (int i = 1; i < 7; i++)
            for (int j = 0; j < 7; j++) {
                days[i][j] = new JLabel(" ", JLabel.RIGHT);
                days[i][j].setForeground(DAYS_FOREGROUND);
                days[i][j].setBackground(SELECTED_DAY_BACKGROUND);
                days[i][j].setBorder(EMPTY_BORDER);
                days[i][j].addMouseListener(this);
            }

        this.btn_ok = new JButton("Tamam");
        this.btn_ok.addActionListener(this);


        JPanel pnl_monthYear = new JPanel();
        pnl_monthYear.add(cmb_month);
        pnl_monthYear.add(cmb_year);

        daysGrid = new FocusablePanel(new GridLayout(7, 7, 5, 0));
        daysGrid.addFocusListener(this);
        daysGrid.addKeyListener(this);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                daysGrid.add(days[i][j]);

            }
        }

        daysGrid.setBackground(Color.white);
        daysGrid.setBorder(BorderFactory.createEmptyBorder());

        JPanel daysPanel = new JPanel();
        daysPanel.add(daysGrid);

        JPanel pnl_button = new JPanel();
        pnl_button.add(btn_ok);


        Container dialog = getContentPane();
        dialog.add("North", pnl_monthYear);
        dialog.add("Center", daysPanel);
        dialog.add("South", pnl_button);
        Toolkit kit = Toolkit.getDefaultToolkit();

        this.setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));// Pencerenin ekranın tam ortasında açılması için



        pack();
        setResizable(false);
    }

    private Date select(Date date) {
        calendar.setTime(date);
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        cmb_year.setSelectedIndex(year - start_year);
        cmb_month.setSelectedIndex(month - Calendar.JANUARY);
        setSelected(day);
        okClicked = false;
        show();
        if (!okClicked) {
            return null;
        }
        calendar.set(Calendar.DATE, getSelectedDay());
        calendar.set(Calendar.MONTH, cmb_month.getSelectedIndex() + Calendar.JANUARY);
        calendar.set(Calendar.YEAR, cmb_year.getSelectedIndex() + start_year);

        return calendar.getTime();
    }

    private void setSelected(int newDay) {
        setSelected(days[(newDay + this.offset - 1) / 7 + 1][(newDay + this.offset - 1) % 7]);
    }

    private void setSelected(JLabel newDay) {
        if (lbl_day != null) {
            lbl_day.setForeground(DAYS_FOREGROUND);
            lbl_day.setOpaque(false);
            lbl_day.setBorder(EMPTY_BORDER);
        }
        lbl_day = newDay;
        lbl_day.setForeground(SELECTED_DAY_FOREGROUND);
        lbl_day.setOpaque(true);
        if (daysGrid.hasFocus())
            lbl_day.setBorder(FOCUSED_BORDER);
    }


    public Date select() {
        return select(new Date());
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel day = (JLabel) e.getSource();
        if (!day.getText().equals(" "))
            setSelected(day);
        daysGrid.requestFocus();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_ok) {
            okClicked = true;
        }
        hide();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        update();
    }

    public void focusGained(FocusEvent e) {
        setSelected(lbl_day);
    }

    public void focusLost(FocusEvent e) {
        setSelected(lbl_day);
    }


    public void keyPressed(KeyEvent e) {
        int iday = getSelectedDay();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (iday > 1)
                    setSelected(iday - 1);
                break;
            case KeyEvent.VK_RIGHT:
                if (iday < lastDay)
                    setSelected(iday + 1);
                break;
            case KeyEvent.VK_UP:
                if (iday > 7)
                    setSelected(iday - 7);
                break;
            case KeyEvent.VK_DOWN:
                if (iday <= lastDay - 7)
                    setSelected(iday + 7);
                break;
        }
    }

    private void update() {
        int iday = getSelectedDay();
        for (int i = 0; i < 7; i++) {
            days[1][i].setText(" ");
            days[5][i].setText(" ");
            days[6][i].setText(" ");
        }
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.MONTH, cmb_month.getSelectedIndex() + Calendar.JANUARY);
        calendar.set(Calendar.YEAR, cmb_year.getSelectedIndex() + start_year);

        offset = calendar.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY;
        lastDay = calendar.getActualMaximum(Calendar.DATE);
        for (int i = 0; i < lastDay; i++)
            days[(i + offset) / 7 + 1][(i + offset) % 7].setText(String.valueOf(i + 1));
        if (iday != -1) {
            if (iday > lastDay)
                iday = lastDay;
            setSelected(iday);
        }
    }


}

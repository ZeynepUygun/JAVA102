package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerGUI extends JFrame{
    private JPanel wrapper;
    private JScrollPane scrl_warpper;
    private JPanel pnl_customer_reservation;
    private JTextField fld_customer_name;
    private JLabel lbl_customer_name;
    private JLabel lbl_customer_lastname;
    private JTextField fld_customer_lastname;
    private JLabel lbl_customer_phone;
    private JTextField fld_customer_phone;
    private JLabel lbl_customer_email;
    private JTextField fld_customer_email;
    private JButton kaydetButton;
    private int reservation_id;

    public CustomerGUI(int reservation_id) {
        this.reservation_id=reservation_id;
        add(wrapper);
        setSize(800, 100);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.project_title);
        setVisible(true);


        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Helper.isFieldEmpty(fld_customer_email)||
                Helper.isFieldEmpty(fld_customer_lastname)||
                Helper.isFieldEmpty(fld_customer_name)||
                Helper.isFieldEmpty(fld_customer_phone)){
                    Helper.showMsg("empty");
                }else {
                    if(Helper.confirm("sure")){
                        if(Customer.add(fld_customer_name.getText(),fld_customer_lastname.getText(),
                                getReservation_id(),fld_customer_phone.getText(),fld_customer_email.getText())){
                            Helper.showMsg("done");
                            dispose();
                        }
                    }
                }
            }
        });
    }

    public int getReservation_id() {
        return reservation_id;
    }


}

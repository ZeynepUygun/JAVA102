package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUPGUI extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_singUP;
    private JLabel lbl_name;
    private JLabel lbl_userName;
    private JLabel lbl_password;
    private JLabel lbl_confirmation;
    private JTextField fld_name;
    private JTextField fld_userName;
    private JTextField fld_password;
    private JTextField fld_confirm;
    private JButton btn_signUp;

    public SignUPGUI() {
        add(wrapper);
        setSize(400, 400);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        btn_signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Helper.isFieldEmpty(fld_password) || Helper.isFieldEmpty(fld_confirm) || Helper.isFieldEmpty(fld_name) || Helper.isFieldEmpty(fld_userName)) {
                    Helper.showMsg("fill");
                } else {

                    if (fld_password.getText().equals(fld_confirm.getText())) {
                        if (User.add(fld_name.getText(), fld_userName.getText(), fld_password.getText(), "student")) {
                            Helper.showMsg("Kaydınız Yapılmıştır. Lütfen Giriş Yapınız.");
                            dispose();
                            LoginGUI log = new LoginGUI();

                        } else {
                            Helper.showMsg("error");
                        }
                    } else {
                        Helper.showMsg("Şifreler uyuşmamaktadır.");
                    }
                }

            }
        });
    }
}

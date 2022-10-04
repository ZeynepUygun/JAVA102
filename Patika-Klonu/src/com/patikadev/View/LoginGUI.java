package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Operator;
import com.patikadev.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_user_uname;
    private JPasswordField fld_user_pass;
    private JButton btn_login;
    private JButton btn_signUP;


    public LoginGUI() {
        add(wrapper);
        setSize(400, 400);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_user_uname) || Helper.isFieldEmpty(fld_user_pass)) {
                    Helper.showMsg("fill");
                } else {

                    User u = User.getFetch(fld_user_uname.getText(), fld_user_pass.getText());
                    if (u == null) {
                        Helper.showMsg("Kullacı Bulunamadı !");
                    } else {

                        Helper.showMsg(u.getName());
                        switch (u.getType()) {
                            case "operator":
                                OperatorGUI opGUI;
                                opGUI = new OperatorGUI((Operator) u);


                                break;
                            case "Education":
                                EducatorGUI edUI = new EducatorGUI(u.getId());

                                edUI.getLbl_educator_name().setText("HoşGeldiniz " + u.getName());


                                break;
                            case "student":
                                StudentGUI stGUI = new StudentGUI(u.getId());


                                stGUI.setUser_id(u.getId());

                                break;


                        }
                        dispose();
                    }
                }
            }
        });
        btn_signUP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SignUPGUI sign = new SignUPGUI();
            }
        });
    }

    public static void main(String[] args) {
        LoginGUI login = new LoginGUI();
    }


}

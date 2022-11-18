package com.patikadev.Helper;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;

public class Helper {
    //GUI için pencere tipi seçilir.
    public static void setLayout(){
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
    //******************************************
    //GUI için pencere boyutu ayarlanır.
    public static int screenCenterPoint(String eksen, Dimension size){
        int point;
        switch (eksen){
            case "x":
                point=(Toolkit.getDefaultToolkit().getScreenSize().width-size.width)/2;
                break;
            case "y":
                point=(Toolkit.getDefaultToolkit().getScreenSize().height-size.height)/2;
                break;
            default:
                point=0;
        }
        return point;
    }
    //*************************************************************************
    public static Boolean isFieldEmpty(JTextField jtextField){
        return jtextField.getText().trim().isEmpty();
    }
    //pencere mesajlarının opsiyonları.
    public static void optionPageTR(){
        UIManager.put("OptionPane.okButtonText","Tamam");
        UIManager.put("OptionPane.yesButtonText","Evet");
        UIManager.put("OptionPane.noButtonText","Hayır");
    }
    //***************************************************
    //Pencere mesajları.
    public static void showMsg(String str){
        optionPageTR();
        String msg;
        String title;
        switch (str){
            case "empty":
                msg ="Lütfen Tüm alanları doldurunuz.";
                title="Hata";
                break;
            case "done":
                msg="İşlem Başarılı";
                title="Sonuç";
                break;
            case "iptal":
                msg="İşlem iptal edildi.";
                title="Sonuç";
                break;
            default:
                msg=str;
                title="Uyarı";
        }

        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }
    //**************************************************
    //Pencere onay mesajı.
    public static boolean confirm(String str){
        String msg;
        switch (str){
            case "sure":
                msg="Bu işlemi gerçekleştirmek istediğinize emin misiniz?";
                break;
            default:
                msg=str;
        }
        return JOptionPane.showConfirmDialog(null,msg,"Son Kararınız mı?",JOptionPane.INFORMATION_MESSAGE)==0;
    }
    //****************************************************
}

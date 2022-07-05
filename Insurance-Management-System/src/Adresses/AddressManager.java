package Adresses;

import UserOperations.User;

import java.util.Scanner;

public class AddressManager {
    private static Scanner scanner=new Scanner(System.in);

    public static void addAddress(User user){
        Address newAddress;
        System.out.println("Yeni adres ekleme alanı");
        System.out.print("1- Ev Adresi \n2- İş Adresi\nAdres seçimini giriniz : ");
        int address=scanner.nextInt();
        System.out.print("Şehir giriniz :");
        String city = scanner.next();
        System.out.print("İlçe giriniz : ");
        String district = scanner.next();
        scanner.nextLine();
        System.out.print("Sokak giriniz : ");
        String street=scanner.nextLine();
        System.out.print("Detaylı adresi yazınız :");
        String detailAddress= scanner.nextLine();
        if(address==1){
            newAddress=new HomeAddress(city,district,street,detailAddress);
        }
        else {
            newAddress = new BusinessAddress(city,district,street,detailAddress);
        }
        user.setAddressList(newAddress);
    }

    public static void deleteAddress(User user,int id){
        user.getAddressList().remove(id-1);
        System.out.println("Silme işlemi gerçekleşti.");
    }
}
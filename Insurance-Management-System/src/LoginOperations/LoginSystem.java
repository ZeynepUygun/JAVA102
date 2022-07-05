package LoginOperations;
import AccountOperations.Account;
import AccountOperations.AccountManager;
import java.util.Scanner;
public class LoginSystem {
    Scanner scanner=new Scanner(System.in);
    AccountManager accountManager=new AccountManager();
    public void login(){
        System.out.println("Sisteme hoşgeldiniz.");
        System.out.print("Email giriniz : ");
        String email=scanner.nextLine();
        System.out.print("Şifre giriniz : ");
        String password=scanner.nextLine();
        Account loginAccount = accountManager.login(email,password);
        if(loginAccount!=null){
            loginAccount.showUserInfo();
            run(loginAccount);
        }
        else System.out.println("Geçersiz kullanıcı");

    }
    private void run(Account account){
        while (true){
            System.out.println("İşlem listesi");
            System.out.println("1- Kullanıcı bilgilerini göster\n" +
                    "2- Kullanıcıya yeni poliçe yap\n" +
                    "3- Kullanıcıya yeni adres ekle\n" +
                    "4- Kullanıcı adresi sil\n" +
                    "9- Programdan çıkış yap.");
            System.out.print("Yapmak istediğiniz işlem numarasını yazın : ");
            int value=scanner.nextInt();
            switch (value) {
                case 1:
                    account.showUserInfo();
                    break;
                case 2:
                    account.addPolicy();
                    break;
                case 3:
                    account.addAddress();
                    break;
                case 4:
                    account.deleteAddress();
                    break;
                case 9:
                default:
                    System.exit(0);
            }
        }
    }
}

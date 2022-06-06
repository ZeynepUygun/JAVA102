import javax.swing.*;
import java.util.Scanner;

public class Game {

    String location;
    //private => sınıf içi erişim
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera oyununa hosgelidiniz !");
        System.out.print("Lutfen bir isim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.print("Sayin "+player.getName() + " Adaya Hosgeldiniz.");
        System.out.println("Bu karanlik adada yasananlarin hepsi gercek. ");
        System.out.println("Lutfen bir karakter seciniz.");
        player.selectChar();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("*************** Bolgeler ******************");
            System.out.println();
            System.out.println("1-Guvenli Ev --> Burasi sizin icin guvenli bir ev, dusman yoktur.");
            System.out.println("2-Magaza     --> Silah yada zirh alabilirsiniz.");
            System.out.println("0-Cikis yap  --> Oyunu sonlandir.");
            System.out.print("Lutfen gitmek istediginiz bolgeyi seciniz");
            int selectLoc = input.nextInt();
            //Polimorfizim : Aynı görevin yada işin farklı yollarla yapılabilmesi
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if(location == null){
                System.out.println("Oyun bitti gorusmek uzere. Yine bekleriz.");
                break;
            }
            if(!location.onLocation()) {
                System.out.println("GAME OVER !");
                break;
            }

        }
    }
}

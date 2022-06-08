import javax.swing.*;
import java.util.Scanner;


public class Game {
    public Location location = null;

    public String locationMine="";
    //private => sınıf içi erişim
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera oyununa hosgelidiniz !");
        System.out.print("Lutfen bir isim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);



        System.out.print("Sayin "+player.getName() + " Adaya Hosgeldiniz.");
        System.out.println("Bu karanlik adada yasananlarin hepsi gercek. ");
        System.out.println();


        System.out.println("KARAKTERLER");
        player.selectChar();
        System.out.println();




        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("*************** Bolgeler ******************");
            System.out.println();
            System.out.println("1- Guvenli Ev    --> Burasi sizin icin guvenli bir ev, dusman yoktur.");
            System.out.println("2- Esya dukkani  --> Silah yada zirh alabilirsiniz.");
            System.out.println("3- Magara        --> Odul <yemek> Dikkatli ol zombi cikabilir.");
            System.out.println("4- Orman         --> Odul <odun> Dikkatli ol vampir cikabilir.");
            System.out.println("5- Nehir         --> Odul <su> Dikkatli ol ayi cikabilir.");
            System.out.println("6- Maden         --> -------");
            System.out.println("0- Cikis yap     --> Oyunu sonlandir.");
            System.out.print("Lutfen gitmek istediginiz bolgeyi seciniz : ");
            int selectLoc = input.nextInt();
            System.out.println();

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
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6 :
                    location = new Mine(player);
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

import javax.swing.*;
import java.util.Objects;
import java.util.Scanner;


public class Game {
    public Location location = null;


    //private => sınıf içi erişim
    private Scanner input = new Scanner(System.in);


    public void start(){

        String[] locationName = {"Maden","Magara","Orman","Nehir"};

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
            player.setCount(0);

            System.out.println("***********  Alinan Oduller ************** \n");
            for(int i=0;i<4;i++){

                System.out.println(locationName[i] + " <---------> " + player.itemLists(i));
                if(player.itemLists(i) != null){
                     player.setCount(player.getCount()+1);
                     if(player.getCount() == 4){
                         System.out.println("Oyunu bitirmek icin guvenli eve gidiniz.");
                     }
                }
            }


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
                    if(player.itemLists(1) == null){
                        location = new Cave(player);

                        break;
                    }
                    if(player.itemLists(1) != null){
                        System.out.println("Bolgeye giremezsiniz! Odulleri basari ile almissiniz.");

                        continue;
                    }
                case 4:
                    if(player.itemLists(2) == null){
                        location = new Forest(player);

                        break;
                    }
                    if(player.itemLists(2) != null){
                        System.out.println("Bolgeye giremezsiniz! Odulleri basari ile almissiniz.");

                        continue;
                    }
                case 5:
                    if(player.itemLists(3) == null){
                        location = new River(player);

                        break;
                    }
                    if(player.itemLists(3) != null){
                        System.out.println("Bolgeye giremezsiniz! Odulleri basari ile almissiniz.");


                        continue;
                    }
                case 6 :

                    if(player.itemLists(0) == null){
                        location = new Mine(player);
                         break;
                    }
                    if(player.itemLists(0) != null){
                        System.out.println("Bolgeye giremezsiniz! Odulleri basari ile almissiniz.");

                        continue;
                    }
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
            if(location.getName() == "Guvenli Ev"  && player.getCount()==4){
                System.out.println();
                System.out.println("------------------------------------------------------------------");
                System.out.println();
                System.out.println("Tebrikler Oyunu Basari Ile Tamamladiniz.");
                System.out.println("Tum Bolgelerde Zafer Sagladiniz.");
                System.out.println("Yeniden oynamaniz dilegiyle.");
                System.out.println();
                System.out.println("------------------------------------------------------------------");
                System.out.println();
                break;
            }


        }
    }

}

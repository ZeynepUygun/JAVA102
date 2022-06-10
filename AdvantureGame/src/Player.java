import java.util.Random;
import java.util.Scanner;

public class Player {
    //private => sinif içi erişim
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private  int originalHealth;

    private String awardItem;
    private int count;



    private final String[] itemList = new String[4];








    public int SnakeFirstDamage() {
        int minimum = 3;
        int maximum = 6;


        return new Random().nextInt((maximum - minimum ) + 1) + minimum;
    }



    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        //Polimorfizim
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};


        System.out.println("-------------------------------------------------------------------");
        //for each kullanıldı.
        for (GameChar gameChar : charList) {
            System.out.println("Id : " + gameChar.getId() + "\tKarakter : " + gameChar.getName() +
                    "\t Hasar : " + gameChar.getDamage() +
                    "\t Saglik : " + gameChar.getHealth() +
                    "\t Para : " + gameChar.getMoney());

        }
        System.out.println("-------------------------------------------------------------------");
        System.out.print("\nLutfen bir karakter seciniz.");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }

        System.out.println("\nSecilen Karakter : " + this.getCharName() +
                "\n Hasar : " + this.getDamage() +
                "\n Saglik : " + this.getHealth() +
                "\n Para : " + this.getMoney());


    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo() {

        System.out.println(
                "\n\nSilahiniz : " + this.getInventory().getWeapon().getName() +
                        "\nZirhiniz : " + this.getInventory().getArmor().getName() +
                        "\nBloklama : " + this.getInventory().getArmor().getBlock() +
                        "\nHasariniz : " + this.getTotalDamage() +
                        "\nSaglik : " + this.getHealth() +
                        "\nPara : " + this.getMoney());


    }
    public String itemLists(int id){

        return this.itemList[id];
    }
    public String items(int id){
        this.itemList[id] = getAwardItem();
        return this.itemList[id];

    }


    //setter ve getter methodları yazıldı.
    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public String getAwardItem(){
        return awardItem;
    }
    public void setAwardItem(String awardItem){
        this.awardItem = awardItem;
    }
    public int getCount(){
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}


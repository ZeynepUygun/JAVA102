import java.util.Scanner;

public class Player {
    //private => sinif içi erişim
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;

    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        //Polimorfizim
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};


        System.out.println("-------------------------------------");
        //for each kullanıldı.
        for (GameChar gameChar : charList) {
            System.out.println("Id : " + gameChar.getId() + "\tKarakter : " + gameChar.getName() +
                    "\t Hasar : " + gameChar.getDamage() +
                    "\t Saglik : " + gameChar.getHealth() +
                    "\t Para : " + gameChar.getMoney());

        }
        System.out.println("-------------------------------------");
        System.out.print("Lutfen bir karakter seciniz.");
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
        System.out.println("Secilen Karakter : " + this.getCharName() +
                "\t Hasar : " + this.getDamage() +
                "\t Saglik : " + this.getHealth() +
                "\t Para : " + this.getMoney());

    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo() {
        System.out.println(
                "Silahiniz : " + this.getInventory().getWeapon().getName() +
                        " Zirhiniz : " + this.getInventory().getArmor().getName() +
                        " Bloklama : " + this.getInventory().getArmor().getBlock() +
                        ", Hasariniz : " + this.getTotalDamage() +
                        ", Saglik : " + this.getHealth() +
                        ", Para : " + this.getMoney());

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
}


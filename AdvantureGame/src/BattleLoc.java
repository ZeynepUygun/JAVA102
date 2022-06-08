import java.util.Locale;
import java.util.Random;

public class BattleLoc extends Location{

    private Obstacle obstacle;
    private String  award;
    private int maxObstacle;



    public BattleLoc(Player player,String name,Obstacle obstacle,String award,int maxObstacle){
        super(player,name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }
    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();

        System.out.println("Suan buradasiniz : " + this.getName());
        System.out.println("Dikkatli ol! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " Yasiyor !");
        System.out.print("<S>avas veya <K>ac  :  ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)) {
            if (combat(obsNumber)) {
                System.out.println(this.getName() + " tüm düsmanlari yendiniz.");
                return true;
            }


        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Cenazeniz var. !");
            return false;
        }
        return true;
    }
    public boolean combat(int obsNumber){


        for(int i=0; i<obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            System.out.println();
            playerStarts();
            obstacleStarts();
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){
                System.out.print("<V>ur veya <K>ac   :");
                String selectCombat = input.nextLine().toUpperCase();
                if(selectCombat.equals("V")){
                    System.out.println("Siz vurdunuz.");
                    this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if(this.getObstacle().getHealth() > 0){
                        System.out.println();
                        System.out.println("Canavar size vurdu !");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if(obstacleDamage < 0){
                            obstacleDamage =0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                        afterHit();
                    }
                }else {

                   return false;
                }
            }

        }
        if(this.getObstacle().getHealth() < this.getPlayer().getHealth()){
            System.out.println("Bolgedeki dusmanlar yenildi !");


            if( getObstacle().getName() == "Yilan"){
                if(this.getAward() == "Tufek"){
                    //Tüfek kazanır.
                    Weapon selectedWeapon = Weapon.getWeaponObjById(3);
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println(this.getAward() + " Silahini Kazandiniz.");

                }
                if(this.getAward() == "Kilic"){
                    //Kılıç kazanır.
                    Weapon selectedWeapon = Weapon.getWeaponObjById(2);
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println(this.getAward() + " Silahini Kazandiniz.");
                }
                if(this.getAward() == "Tabanca"){
                    //Tabanca kazanır.
                    Weapon selectedWeapon = Weapon.getWeaponObjById(1);
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println(this.getAward() + " Silahini Kazandiniz.");
                }
                if(this.getAward() == "Agir"){
                    Armor selectedArmor = Armor.getArmorObjById(3);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println(this.getAward() + " Zirhini Kazandiniz.");
                }
                if(this.getAward() == "Orta"){
                    Armor selectedArmor = Armor.getArmorObjById(2);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println(this.getAward() + " Zirhini Kazandiniz.");
                }
                if(this.getAward() == "Hafif"){
                    Armor selectedArmor = Armor.getArmorObjById(1);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println(this.getAward() + " Zirhini Kazandiniz.");

                }
                if(this.getAward() == "10"){
                    int money =Integer.valueOf(this.getAward());
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + money);
                    System.out.println(this.getAward() + " Para Kazandiniz.");
                }
                if(this.getAward() == "5"){
                    int money =Integer.valueOf(this.getAward());
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + money);
                    System.out.println(this.getAward() + " Para Kazandiniz.");
                }
                if(this.getAward() == "1"){
                    int money =Integer.valueOf(this.getAward());
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + money);
                    System.out.println(this.getAward() + " Para Kazandiniz.");
                }



            }
            else {
                System.out.println(this.getObstacle().getAward() + " para " + "kazandiniz.");
                System.out.println(this.getAward() + " " + " kazandiniz.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());



                System.out.println("Guncel Paraniz : " + this.getPlayer().getMoney());
            }
        }
        return false;
    }
    public void afterHit(){
        System.out.println("Caniniz : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Cani " + this.getObstacle().getHealth());
        System.out.println();
    }
    public  void playerStarts(){
        System.out.println("Oyuncu degerleri");
        System.out.println("-------------------------");
        System.out.println("Saglik : " + this.getPlayer().getHealth());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Zirh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para : " + this.getPlayer().getMoney());
        System.out.println();

    }
    public void obstacleStarts(){
        System.out.println(this.getObstacle().getName() + " Degerleri");
        System.out.println("-------------------");
        System.out.println("Saglik : " + this.getObstacle().getHealth());
        System.out.println("Hasar : " + this.getObstacle().getDamage());
        System.out.println("Odul : " + this.getObstacle().getAward());
        System.out.println();
    }
    public  int randomObstacleNumber(){
        Random r = new Random();
        //0,1,2 sayı elde edilir +1 ile sıfır olması engellenir.(getMaxObstacle = 3)
        return r.nextInt(this.getMaxObstacle())+1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }
    public String getAward(){
        return award;
    }
    public void setAward(String award){
        this.award = award;
    }
    public int getMaxObstacle() {
        return maxObstacle;
    }
    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}

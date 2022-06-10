
import java.util.Random;

public class BattleLoc extends Location{

    private Obstacle obstacle;
    private String  award;
    private int maxObstacle;




    public BattleLoc(Player player,String name,Obstacle obstacle,String award,int maxObstacle){
        super(player,name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle =maxObstacle;




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
      int randomNum = new Random().nextInt(2);

        for(int i=0; i<obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            System.out.println();
            playerStarts();
            obstacleStarts();
            //Kimin ilk vuracağını 50% olasılık  ile karar verir.
            if(randomNum == 0){
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
            }else{
                while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){
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
                    System.out.print("<V>ur veya <K>ac   :");
                    String selectCombat = input.nextLine().toUpperCase();
                    if(selectCombat.equals("V")){
                        System.out.println("Siz vurdunuz.");
                        this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();

                    }else {
                        return false;
                    }
                }
            }
            /*if(this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                System.out.println("Dusmani yendiniz !");
                System.out.println(this.getObstacle().getAward() + " para kazandiniz.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Guncel Paraniz : " + this.getPlayer().getMoney());
            }*/
        }if(this.getObstacle().getHealth() <= 0){
            System.out.println("Bolgedeki dusmanlar yenildi !");
            if( getObstacle().getName().equals("Zombi")){
                getPlayer().setAwardItem(award);
                getPlayer().items(1);
            }
            else if( getObstacle().getName().equals("Vampir")){
                getPlayer().setAwardItem(award);
                getPlayer().items(2);
            }
            else if( getObstacle().getName().equals("Ayi")){
                getPlayer().setAwardItem(award);

                getPlayer().items(3);
            }

            if( getObstacle().getName().equals("Yilan")){
                if(this.getAward().equals("Tufek")){
                    //Tüfek kazanır.
                    Weapon selectedWeapon = Weapon.getWeaponObjById(3);
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println(this.getAward() + " Silahini Kazandiniz.");


                }
                if(this.getAward().equals("Kilic")){
                    //Kılıç kazanır.
                    Weapon selectedWeapon = Weapon.getWeaponObjById(2);
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println(this.getAward() + " Silahini Kazandiniz.");
                }
                if(this.getAward().equals("Tabanca")){
                    //Tabanca kazanır.
                    Weapon selectedWeapon = Weapon.getWeaponObjById(1);
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println(this.getAward() + " Silahini Kazandiniz.");
                }
                if(this.getAward().equals("Agir")){
                    Armor selectedArmor = Armor.getArmorObjById(3);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println(this.getAward() + " Zirhini Kazandiniz.");
                }
                if(this.getAward().equals("Orta")){
                    Armor selectedArmor = Armor.getArmorObjById(2);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println(this.getAward() + " Zirhini Kazandiniz.");
                }
                if(this.getAward().equals("Hafif")){
                    Armor selectedArmor = Armor.getArmorObjById(1);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println(this.getAward() + " Zirhini Kazandiniz.");

                }
                if(this.getAward().equals("10")){
                    int money =Integer.parseInt(this.getAward());
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + money);
                    System.out.println(this.getAward() + " Para Kazandiniz.");
                }
                if(this.getAward().equals("5")){
                    int money =Integer.parseInt(this.getAward());
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + money);
                    System.out.println(this.getAward() + " Para Kazandiniz.");
                }
                if(this.getAward().equals("1")){
                    int money =Integer.parseInt(this.getAward());
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + money);
                    System.out.println(this.getAward() + " Para Kazandiniz.");
                }
                if(this.getAward().equals("Malesef bos odul kutusu ")){

                    System.out.println(this.getAward() + " Para Kazandiniz.");
                }
                getPlayer().setAwardItem(award);

                getPlayer().items(0);


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

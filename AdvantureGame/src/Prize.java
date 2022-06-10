import java.util.Random;

public class Prize  extends Location{
    public int money;
    private String award;
    int obstacleMax;


    public Prize(Player player) {
        super(player,"Maden");



    }

    public String Surprise() {

        Random r = new Random(); //random sınıfı
        int a = r.nextInt(1001);

        /*
        Weapon selectedWeapon = Weapon.getWeaponObjById(3);
        this.getPlayer().getInventory().setWeapon(selectedWeapon);
        this.award = "Tufek";
         */
    if(a <= 550){
        if(a <= 150){
            //silahlar
            if(a <= 30){

                this.award = "Tufek";

            }else if(a <= 75){

                this.award = "Kilic";

            }else {

                this.award = "Tabanca";

            }
        }
        else if (a <= 300){
            if (a <= 180){
                this.award ="Agir";
            }
            else if(a <= 225){
                this.award ="Orta";
            }else {
                this.award = "Hafif";
            }
        }
        else {
            if(a <= 350){
                award = "10";
            }else if (a <= 425){
                award = "5";
            }else {
                award = "1";
            }

        }
    }else{
        this.award = "Malesef bos odul kutusu ";
    }



        return award ;
    }
    @Override
    boolean onLocation() {
        return false;
    }

}






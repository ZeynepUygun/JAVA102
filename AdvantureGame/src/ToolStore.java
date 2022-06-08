import java.util.Random;

public class ToolStore extends NormalLoc{
    public ToolStore(Player player){
        super(player,"Magaza");
    }
    @Override
    public boolean onLocation(){
        System.out.println("--------- Magazaya hosgeldiniz. --------------");
        boolean showMenu = true;
       while (showMenu){
           System.out.println("1- Silahlar\n2- Zirhlar\n3- Cikis yap.");
           int selectCase = Location.input.nextInt();
           while (selectCase < 1 || selectCase > 3){
               System.out.println("Gecersiz deger, tekrar giriniz.");
               selectCase = input.nextInt();
           }
           switch (selectCase){
               case 1:
                   printWeapon();
                   buyWeapon();
                   break;
               case 2:
                   printArmor();
                   buyArmor();
                   break;
               case 3:
                   System.out.println("Bir daha bekleriz.");
                   showMenu = false;
                   break;
           }
       }
        return true;

    }
    public void printWeapon(){
        System.out.println("-------------Silahlar-----------------");

        //for each
        for(Weapon w :Weapon.weapons()){
            System.out.println(w.getId()+"-"+w.getName() + "\t<Para : " + w.getPrice() + " Hasar : " + w.getDamage()+">");
        }
        System.out.println("0 - Cikis yap.");



    }
    public void buyWeapon(){
        System.out.println();
        System.out.print("Bir silah seciniz : ");
        int selectWeapon = input.nextInt();

        while (selectWeapon < 0 || selectWeapon > Weapon.weapons().length){
            System.out.println();
            System.out.print("Gecersiz deger, tekrar giriniz : ");
            selectWeapon = input.nextInt();
        }
        if(selectWeapon != 0){

            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeapon);

            if(selectedWeapon != null){
                if(selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                    System.out.println();
                    System.out.println("Yeterli paraniz bulunmamaktadir.");
                }
                else{
                    //Satın alma işlemi gerçekleşir.
                    System.out.println();
                    System.out.println(selectedWeapon.getName()+" silahini satin aldiniz.");
                    int balance = this.getPlayer().getMoney()-selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println();
                    System.out.println("Kalan paraniz : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }

        }

    }
    public void printArmor(){
        System.out.println("-------------Zirhlar-----------------");

        //for each
        for(Armor a : Armor.armors()){
            System.out.println(a.getId() + " - " + a.getName() + " < Para : " +a.getPrice()  + "  Zirh : " + a.getBlock() );
        }

    }
    public void buyArmor(){
        System.out.println();
        System.out.print("Bir zirh seciniz : ");
        int selectArmorID = input.nextInt();

        while (selectArmorID < 1 || selectArmorID > Armor.armors().length){
            System.out.print("Gecersiz deger, tekrar giriniz : ");
            selectArmorID = input.nextInt();
        }
        Armor selectedArmor = Armor.getArmorObjById(selectArmorID);
        if(selectArmorID != 0){
            if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Yeterli paraniz bulunmamaktadir.");
            }
            else {
                System.out.println(selectedArmor.getName() + " zirhini satin aldiniz.");
                this.getPlayer().setMoney(this.getPlayer().getMoney()-selectedArmor.getPrice());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Kalan paraniz : " + this.getPlayer().getMoney());
            }
        }

    }

}

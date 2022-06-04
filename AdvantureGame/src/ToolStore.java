public class ToolStore extends NormalLoc{
    public ToolStore(Player player){
        super(player,"Magaza");
    }
    @Override
    public boolean onLocation(){
        System.out.println("--------- Magazaya hosgeldiniz. --------------");
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
                break;
            case 3:
                System.out.println("Bir daha bekleriz.");
                return true;
        }
        return true;
    }
    public void printWeapon(){
        System.out.println("Silahlar");

        //for each
        for(Weapon w :Weapon.weapons()){
            System.out.println(w.getId()+"-"+w.getName() + "\t<Para : " + w.getPrice() + " Hasar : " + w.getDamage()+">");
        }



    }
    public void buyWeapon(){
        System.out.print("Bir silah seciniz : ");
        int selectWeapon = input.nextInt();

        while (selectWeapon < 1 || selectWeapon > Weapon.weapons().length){
            System.out.print("Gecersiz deger, tekrar giriniz : ");
            selectWeapon = input.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeapon);

        if(selectedWeapon != null){
            if(selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                System.out.println("Yeterli paraniz bulunmamaktadir.");
            }
            else{
                //Satın alma işlemi gerçekleşir.
                System.out.println(selectedWeapon.getName()+" silahini satin aldiniz.");
                int balance = this.getPlayer().getMoney()-selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paraniz : " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
            }
        }
    }
    public void printArmor(){

    }
}

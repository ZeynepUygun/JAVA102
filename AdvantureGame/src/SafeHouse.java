public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player){
        super(player,"Guvenli Ev");
    }
    @Override
    public boolean onLocation(){
        System.out.println("Guvenli evdesiniz.\nCaniniz yenilendi !");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        return true;
    }
}

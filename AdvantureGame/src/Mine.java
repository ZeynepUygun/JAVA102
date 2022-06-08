public class Mine extends BattleLoc{

    public Mine(Player player){
        super(player,"Maden",new Snake(player),new Prize(player).Surprise(),2);
        //super(player,"Maden",new Snake(player.SnakeFirstDamage(),player),new Prize(player).Surprise(),2);

    }

}

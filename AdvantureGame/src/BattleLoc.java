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
    public boolean onLocation(){
        int obsNumber = this.randomObstacleNumber();

        System.out.println("Suan buradasiniz : " + this.getName());
        System.out.println("Dikkatli ol! Burada " +obsNumber + " tane " + this.getObstacle().getName() + " Yasiyor !");
        System.out.print("<S>avas veya <K>ac  :  ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("S")){
            System.out.println("Savas islemleri olacak !");
            //Savas islemi
        }
        return true;
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

public class Obstacle {
    //Canavarlar
    private int id;
    private int damage;
    private int health;
    private String  name;
    private int award;

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    private  int originalHealth;

    public Obstacle(int id,String name,int damage,int health,int award){
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.originalHealth = health;
        this.award = award;

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public  int getDamage(){
        return damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        if(health<0){
            health = 0;
        }
        this.health = health;
    }
    public int getAward() {
        return award;
    }
    public void setAward(int award) {
        this.award = award;
    }
}

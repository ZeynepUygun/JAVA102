public class Obstacle {
    //Canavarlar
    private int id;
    private int damage;
    private int health;
    private String  name;

    public Obstacle(int id,String name,int damage,int health){
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;

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
        this.health = health;
    }

}

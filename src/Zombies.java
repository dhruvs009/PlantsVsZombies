//DiscoZombie: super(120,5,3,2, zombieAppearance);
//NormalZombie: super(100,3,3,2, zombieAppearance);

public abstract class Zombies extends Living implements Attacking{
    protected int attackVal;
    protected int attackInterval;
    protected int speed;
    protected Image zombieAppearance;
    public Zombies(int HP, int attackVal, int attackInterval, int speed, Image zombieAppearance){
        super(HP);
        this.attackVal=attackVal;
        this.speed=speed;
        this.zombieAppearance=zombieAppearance;
    }
    public abstract Zombies appear();
    @Override
    public int attack(){
        return this.attackVal;
    }
}
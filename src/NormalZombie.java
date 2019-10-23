public class NormalZombie extends Zombies {
    public NormalZombie(Image zombieAppearance){
        super(100,3,3,2, zombieAppearance);
    }
    @Override
    public Zombies appear(){
        return this;
    }
}
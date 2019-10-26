public class DiscoZombie extends Zombies{       //implements clonable
    public DiscoZombie(Image zombieAppearance){
        super(120,5,3,2, zombieAppearance);
    }
    @Override
    public Zombies appear(){
        return this;
    }
}
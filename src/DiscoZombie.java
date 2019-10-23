public class DiscoZombie extends Zombies{       //implements clonable
    public DiscoZombie(Image zombieAppearance){
        super(100,5,3,2, zombieAppearance);
    }
    @Override
    public Zombies appearAtRow(int row){
        return this;
    }
}
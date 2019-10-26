public abstract class Bomber extends Plants implements Attacking{
    protected int radius;
    Bomber(int HP, int sunPower,int waitForNew, Image plantAppearance){
        super(HP, sunPower, waitForNew, plantAppearance);
    }
    @Override
    public int attack(){
    }
    public abstract Plants plantThis();
}
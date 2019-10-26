public abstract class Blocker extends Plants{
    public Blocker(int HP,int sunPower, int waitForNew,Image plantAppearance){
        super(HP, sunPower, waitForNew, plantAppearance);
    }
    @Override
    public abstract Plants plantThis();
}
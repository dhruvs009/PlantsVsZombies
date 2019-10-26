public class SunProvider extends Plants{
    protected int toGiveOut;
    private Sun toShow;
    SunProvider(int HP, int sunPower,int waitForNew, Image plantAppearance){
        super(HP, sunPower, waitForNew, plantAppearance);
    }
    public abstract Plants plantThis();
    public Sun giveSun(){

    }
}
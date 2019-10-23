public abstract class Plants extends Living{
    protected int sunPower;
    protected int waitForNew;
    protected boolean plantable;
    protected Image plantAppearance;
    public Plants(int HP, int waitForNew, Image plantAppearance){
        super(HP);
        this.waitForNew=waitForNew;
        this.plantAppearance=plantAppearance;
    }
    protected abstract Plants plantThis();
}
public class LawnMower implements Attacking{
    private int attackVal;
    private int rowPos;
    private Image lawnMowerAppearance;
    public LawnMower(Image lawnMowerAppearance){
        this.lawnMowerAppearance=lawnMowerAppearance;
        this.attackVal=rowPos*10000;
    }
    @Override
    public int attack(){
        return attackVal;
    }
}
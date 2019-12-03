interface Attacking{
    public int attack();
}

public class Living{
    private int HP;
    public Living(int HP){
        this.HP=HP;
    }
    protected int getHP(){
        return this.HP;
    }
    public void setHP(int HP){
        this.HP=HP;
    }
    protected void isAttacked(int attackVal){
        this.HP-=attackVal;
    }
}
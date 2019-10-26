public class Land extends Tile{
    public Land(Image tileAppearance){
        super(tileAppearance);
    }
    public void plant(Plants toPlant){
        super.setPlant(toPlant);
    }
    public void emptyTile(){
        super.setPlant(null);
    }
}
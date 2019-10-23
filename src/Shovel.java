public class Shovel{
    Image shovelAppearance;
    public Shovel(Image shovelAppearance){
        this.shovelAppearance=shovelAppearance;
    }
    public void emptyTile(Tile toEmpty){
        if(toEmpty!=null){
            if(toEmpty.getClass()==new Land.getClass()){
                toEmpty= (Land) toEmpty;
                toEmpty.emptyTile();
            }
        }
    }
}
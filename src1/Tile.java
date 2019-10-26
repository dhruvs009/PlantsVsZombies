public abstract class Tile{
    protected Plants toPlantHere;
    protected Image tileAppearance;
    public Tile(Image tileAppearance){
        this.tileAppearance=tileAppearance;
        this.toPlantHere=null;
    }
    protected void setPlant(Plants toPlantHere){
        this.toPlantHere=toPlantHere;
    }
    protected Plants getPlant(){
        return this.toPlantHere;
    }
}
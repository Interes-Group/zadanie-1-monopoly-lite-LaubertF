package sk.stuba.fei.uim.oop;


public class Property extends Tile {

    private int price = 4000;
    private int fee = 400;
    private Player owner = null;
    
    public int getPrice() {
        return price;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public int getFee() {
        return fee;
    }
}

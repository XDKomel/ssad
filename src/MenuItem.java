import java.awt.Image;
import java.util.Vector;


public abstract class MenuItem {
    private int ID;
    private String description;
    private Vector<Integer> ratings;
    private Image largeImage;

    public MenuItem(int ID, String description, Vector<Integer> ratings, Image largeImage) {
        this.ID = ID;
        this.description = description;
        this.ratings = ratings;
        this.largeImage = largeImage;
    }

    public int getID() {
        return this.ID;
    }

    public String getDescription() {
        return new String(this.description);
    }

    public Image getLargeImage() {
        return this.largeImage;
    }

    public Vector<Integer> getRatings() {
        return new Vector<Integer>(this.ratings);
    }

    abstract public double getCost();
}



class SingleMenuItem extends MenuItem {

    private double price;

    public SingleMenuItem(int ID, String description, Vector<Integer> ratings, Image largeImage, double price) {
        super(ID, description, ratings, largeImage);
        this.price = price;
    }

    @Override
    public double getCost() {
        return this.price;
    }
}

class ComboMenuItem extends MenuItem {
    private Vector<SingleMenuItem> items;

    public ComboMenuItem(int ID, Vector<SingleMenuItem> items, String description, Vector<Integer> ratings, Image largeImage) {
        super(ID, description, ratings, largeImage);
        this.items = items;
    }

    @Override
    public double getCost() {
        double cost = 0;
        for(MenuItem item : this.items) {
            cost += item.getCost();
        }
        return cost;
    }
}
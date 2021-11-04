import java.util.Vector;

public class Order {
    private Vector<MenuItem> items;
    private Vector<Integer> itemsIDs;

    public Order(Vector<MenuItem> items) {
        this.items = items;
    }
    public Order() {
        this.items = new Vector<>();
        this.itemsIDs = new Vector<>();
    }

    public Vector<MenuItem> getItems() {
        return this.items;
    }
    public Vector<Integer> getItemsIDs() {
        return this.itemsIDs;
    }

    public void add(MenuItem menuItem, int id) {
        this.items.add(menuItem);
        this.itemsIDs.add(id);
    }

    public void remove(MenuItem menuItem, int id) {
        this.items.removeElement(menuItem);
        this.itemsIDs.removeElement(id);
    }

    public double getCost() {
        double cost = 0;
        for(MenuItem menuItem : this.items) {
            cost += menuItem.getCost();
        }
        return cost;
    }
}

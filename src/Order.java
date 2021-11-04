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
}

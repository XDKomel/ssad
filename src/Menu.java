import java.util.HashMap;
import java.util.Vector;

public class Menu {
    private Vector<MenuItem> items = new Vector<>();

    private void updateData() {
        DBConnector dbConnection = DBConnector.getInstance();
        HashMap<String, Object> response = dbConnection.request(APIRequestType.GET_MENU, new HashMap<>());
        items = (Vector<MenuItem>) response.get("menu_items");
    }

    public void orderMeal(Vector<Integer> itemsIDs, int servingTableID) {
        HashMap<String, Object> query = new HashMap<>();
        query.put("item_ids", itemsIDs);
        query.put("serving_table_id", servingTableID);
        DBConnector dbConnection = DBConnector.getInstance();
        dbConnection.request(APIRequestType.BUY_MENU_ITEMS, query);
    }

    public Vector<MenuItem> getItems() {
        this.updateData();
        return new Vector<>(this.items);
    }
}
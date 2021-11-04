import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

public class DBConnector {
    private static DBConnector dbConnection;

    private DBConnector() {

    }

    public static DBConnector getInstance() {
        // singleton
        if(DBConnector.dbConnection == null) {
            DBConnector.dbConnection = new DBConnector();
        }
        return dbConnection;
    }

    public HashMap<String, Object> request(APIRequestType requestType, HashMap<String, Object> query) {
        HashMap<String, Object> response = new HashMap<>();
        switch (requestType) {
            case GET_MENU -> {
                // in real project we will get the items via Internet
                // there we mock it
                Vector<MenuItem> items = new Vector<>();

                items.add(new SingleMenuItem(0, "Pizza Pepperony", new Vector<Integer>(), null, 349));
                items.add(new SingleMenuItem(1, "Burger Diablo", new Vector<Integer>(), null, 666));
                items.add(new ComboMenuItem(4, new Vector<>(Arrays.asList(
                        new SingleMenuItem(2, "Salad Cezar", new Vector<Integer>(), null, 199),
                        new SingleMenuItem(3, "Juice Orange", new Vector<Integer>(), null, 129)
                )), "Healthy ", new Vector<Integer>(), null));
                response.put("menu_items", items);
            }
            case GET_TABLES -> {
                // in real project we will get the tables via Internet
                // there we mock it
                Vector<Table> tables = new Vector<>();
                tables.add(new Table(0, new TimePeriod(LocalDateTime.now().minusSeconds(1),
                        LocalDateTime.now().minusSeconds(1))));
                tables.add(new Table(1, new TimePeriod(LocalDateTime.now().minusSeconds(1),
                        LocalDateTime.now().minusSeconds(1))));
                tables.add(new Table(2, new TimePeriod(LocalDateTime.now().minusSeconds(1),
                        LocalDateTime.now().minusSeconds(1))));
                response.put("table_reserving_tables", tables);
            }
            case RESERVE_TABLE -> {
                int tableID = (int) query.get("table_id");
                TimePeriod timePeriod = (TimePeriod) query.get("time_period");
                // in real project we will post request via Internet
                // there we mock it
            }
            case BUY_MENU_ITEMS -> {
                Vector<Integer> itemsIDs = (Vector<Integer>) query.get("item_ids");
                int servingTableID = (int) query.get("serving_table_id");
                // in real project we will post request via Internet
                // there we mock it
            }
        }
        return response;
    }
}

import java.util.HashMap;
import java.util.Vector;

public class TableReserving {
    private Vector<Table> tables = new Vector<>();

    private void updateData() {
        DBConnector dbConnection = DBConnector.getInstance();
        HashMap<String, Object> response = dbConnection.request(APIRequestType.GET_TABLES, new HashMap<>());
        tables = (Vector<Table>) response.get("table_reserving_tables");
    }

    public void reserveTable(int tableID, TimePeriod timePeriod) {
        HashMap<String, Object> query = new HashMap<>();
        query.put("table_id", tableID);
        query.put("time_period", timePeriod);
        DBConnector dbConnection = DBConnector.getInstance();
        dbConnection.request(APIRequestType.RESERVE_TABLE, query);
    }

    public Vector<Table> getFreeTables(TimePeriod timePeriod) {
        this.updateData();
        Vector<Table> freeTables = new Vector<Table>();
        for(Table table : tables) {
            if(!table.isBusy(timePeriod)) {
                freeTables.add(new Table(table));
            }
        }
        return freeTables;
    }
}
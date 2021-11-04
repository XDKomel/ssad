import java.util.Vector;

public class ViewController {
    private Menu menu = new Menu();
    private TableReserving tableReserving = new TableReserving();

    public void buildView() {
        // In real project there should be user GUI. User could interact with the interface: select table, menu items.
        // There we just showed use case of the application.
        System.out.println("Welcome to iPad Restaurant Application");

        TimePeriod timePeriod = new TimePeriod();
        Vector<Table> freeTables = tableReserving.getFreeTables(timePeriod);
        Table selectedTable = freeTables.elementAt(0);
        int selectedTableID = selectedTable.getID();
        tableReserving.reserveTable(selectedTableID, timePeriod);
        System.out.printf("You have reserved table # %d\n", selectedTableID);

        Vector<MenuItem> menuItems = menu.getItems();
        Vector<MenuItem> selectedMenuItems = new Vector<>();
        Vector<Integer> selectedMenuItemsIDs = new Vector<>();
        for(int i = 0; i < 3; i++) {
            selectedMenuItems.add(menuItems.elementAt(i));
            selectedMenuItemsIDs.add(menuItems.elementAt(i).getID());
        }
        menu.orderMeal(selectedMenuItemsIDs, selectedTableID);
        System.out.println("You have ordered following menu items:");
        for(MenuItem menuItem : selectedMenuItems) {
            System.out.printf("$%f - %s\n", menuItem.getCost(), menuItem.getDescription());
        }
    }
}
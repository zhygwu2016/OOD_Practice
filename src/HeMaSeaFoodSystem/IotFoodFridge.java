package HeMaSeaFoodSystem;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The class to store the food
 */
public class IotFoodFridge {

    //Id of the fridge
    private final String fridgeId;

    //The address of this fridge
    private final String address;

    //The service that used to fetch and update order data
    private final ISeaFoodService seaFoodService;

    //List of cells
    private final List<Cell> cells;

    /*
     * The Map of cell.
     * Key is the code generated by service
     * Value is the Cell in this fridge
     */
    private final Map<String,Cell> cellMap;


    /*
     * Constructor
     *
     * @param fridgeId          The id of the fridge
     * @param address           The physical address of the fridge
     * @param seaFoodService    The service that used to fetch/update order
     */
    public IotFoodFridge(@NotNull final String fridgeId,
                         @NotNull final String address,
                         @NotNull final ISeaFoodService seaFoodService){
        this.fridgeId = fridgeId;
        this.address = address;
        this.seaFoodService = seaFoodService;

        cells = new ArrayList<Cell>();
        cellMap = new HashMap<String, Cell>();
    }

    @NotNull
    public String getFridgeId(){
        return fridgeId;
    }

    @NotNull
    public String getAddress(){
        return address;
    }

    @NotNull
    public List<Cell> getCells(){
        return cells;
    }

    @NotNull
    public Cell getCell(final int index){
        if(index < 0 || index >= cells.size()) {
            return null;
        }

        return cells.get(index);
    }

    public void addCell(@NotNull Cell cell){
        cells.add(cell);
    }

    /*
     * The method for user to take the item from the cell.
     * @param code   The code that generated by the service
     */
    @Nullable
    public SeaFoodItem takeItem(@NotNull final String code){
        if(!cellMap.containsKey(code)) {
            return null;
        }

        final Cell cell = cellMap.remove(code);

        return cell.getItem();
    }

    /*
     * Constructor
     *
     * @param   orderId         The id of the order that contains the sea food item
     * @param   seaFoodItem     The sea food item that needs to be delivered to the customer
     * @param   cell            The cell that used to hold the sea food
     */
    public boolean putItem(@NotNull final String orderId, @NotNull final SeaFoodItem seaFoodItem, @NotNull final Cell cell ){
        if(!cell.isEmpty()) {
            return false;
        }

        if(cell.getSize() < seaFoodItem.getSize()) {
            return false;
        }

        cell.setItem(seaFoodItem);

        //Use the service to generate the pass code which can be used to open the cell
        final String passCode = seaFoodService.generateCode(seaFoodItem.getItemId());

        //Update the cell
        cellMap.put(passCode,cell);

        //Update the order
        updateOrder(orderId,seaFoodItem,passCode);

        return true;
    }

    /*
     * The method for fridge operator to put the item into the cell.
     * @param   orderId         The id of the order that contains the sea food item
     * @param   seaFoodItem     The sea food item that needs to be delivered to the customer
     * @param   passCode        The pass code that generated by service to open the cell
     */
    private void updateOrder(@NotNull final String orderId, @NotNull final SeaFoodItem seaFoodItem, String passCode) {
        final Order order = seaFoodService.getSeaFoodOrder(orderId);
        final int orderSize = order.getSeaFoodItems().size();
        final List<SeaFoodItem> delieveredItems = order.getDeliveredItems();

        delieveredItems.add(seaFoodItem);

        seaFoodService.updateOrder(order,passCode);

        //If all the items are delivered, service should notice client
        if(delieveredItems.size() == orderSize) {
            seaFoodService.noticeClient(orderId);
        }
    }
}
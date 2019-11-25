package RestaurantReseverationSystem;

/**
 * Created by FLK on 2019-02-16.
 * The interface used to listen to the state change of the table
 */
public interface ITableEventListener {
    /*
     * The method to notify listeners
     * @param tableId       The id of the table
     * @param fromState     The initial state of the table
     * @param toState       The current state if the table
     */
    void onTableStateChanged(final String tableId, final RestaurantReseverationSystem.TableState fromState, final RestaurantReseverationSystem.TableState toState);
}

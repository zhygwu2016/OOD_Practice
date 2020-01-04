package Class4.RestaurantReseverationSystem;

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
    void onTableStateChanged(final String tableId, final Class4.RestaurantReseverationSystem.TableState fromState, final Class4.RestaurantReseverationSystem.TableState toState);
}

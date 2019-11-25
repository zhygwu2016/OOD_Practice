package RestaurantReseverationSystem;

import com.sun.istack.internal.NotNull;

import java.util.*;

import static RestaurantReseverationSystem.TableType.*;

/**
 * Created by FLK on 2019-02-16.
 * The class to represent a Restaurant
 */
public class Restaurant implements ITableEventListener {

    //The id of restaurant id
    private final String id;

    /*
     *  The map that is used to map the table id this table object
     *  Key: table ID
     *  Value: table Object
     */
    private final Map<String,BaseTable> tableMap;

    /*
     *  The Map to track reservations and tables
     *  Key: reservation ID
     *  Value: table ID
     */
    private final Map<String,String> reservationMap;

    /*
     *  The Map to track serverID and the actual Server object
     *  Key: server ID
     *  Value: server object
     */
    private final Map<String,Server> serverMap;

    //The list of empty table
    private final List<String> emptyTables;

    //The list of tables which have reservations
    private final List<String> reversedTables;

    //The list of tables that is currently being used
    private final List<String> occupiedTables;

    //The list of small tables
    private final List<String> smallTables;

    //The list of medium tables
    private final List<String> mediumTables;

    //The list of large tables
    private final List<String> largeTables;

    //The handler to handler all the filtering of tables
    private final ReservationHandler mReservationHandler;

    /*
     * Constructor
     * @param id    The table id
     */
    public Restaurant(@NotNull final String id){
        this.id = id;
        tableMap = new HashMap<>();
        serverMap = new HashMap<>();
        reservationMap = new HashMap<>();

        emptyTables = new ArrayList<>();
        reversedTables = new ArrayList<>();
        occupiedTables = new ArrayList<>();

        smallTables = new ArrayList<>();
        mediumTables = new ArrayList<>();
        largeTables = new ArrayList<>();

        mReservationHandler = new ReservationHandler();
    }

    /*
     * The method to check a reservation can be made or not
     * @return  boolean           Return whether this reservation can be taken or not
     * @param   reservation       The reservation object
     */
    public boolean canReserve(@NotNull final Reservation reservation){
        final int partySize = reservation.getSize();
        final long[] timeStamp = reservation.getReservationPeriod();

        //Get the list of tables that can be used for this reservation
        final List<String> availableTables = mReservationHandler.filteredTables(partySize,timeStamp);

        return availableTables.size() == 0;
    }

    /*
     * The method to make a reservation for a table
     * @return  boolean           Return whether this reservation is successful or not
     * @param   reservation       The reservation object
     */
    public boolean takeReservation(final Reservation reservation){
        if(!canReserve(reservation)) return false;

        final int partySize = reservation.getSize();
        final long[] timeStamp = reservation.getReservationPeriod();
        final String reservationId = reservation.getId();

        //Get the list of tables that can be used for this reservation
        final List<String> availableTables = mReservationHandler.filteredTables(partySize,timeStamp);

        //Always get the first available table
        final BaseTable table = tableMap.get(availableTables.get(0));

        //Reserve this table
        table.reserve(reservationId,timeStamp);

        //Update the reservation map
        reservationMap.put(reservationId,table.getTableId());

        return true;
    }

    /*
     * The method to cancel a reservation
     * @return  boolean           Return whether this reservation can be cancelled or not
     * @param   reservation       The reservation object
     */
    public boolean cancelReservation(@NotNull final Reservation reservation){
        final String reservationId = reservation.getId();

        if(!reservationMap.containsKey(reservationId)) return false;

        //Find the table for this reservation
        final BaseTable table = tableMap.get(reservationMap.get(reservationId));

        //Cancel the reservation
        table.cancel(reservationId);

        //Remove the reservation from reservation map
        reservationMap.remove(reservationId);

        return true;
    }

    //Adders
    public void addSmallTable(final SmallTable smallTable){
        smallTables.add(smallTable.getTableId());
        tableMap.put(smallTable.getTableId(),smallTable);
    }

    public void addMediumTable(final MediumTable mediumTable){
        mediumTables.add(mediumTable.getTableId());
        tableMap.put(mediumTable.getTableId(),mediumTable);
    }

    public void addLargeTable(final LargeTable largeTable){
        largeTables.add(largeTable.getTableId());
        tableMap.put(largeTable.getTableId(),largeTable);
    }


    @Override
    public void onTableStateChanged(final String tableId,final TableState fromState,final TableState toState) {
        if(tableId == null || fromState == toState) return;

        final List<String> fromStateTableList = mReservationHandler.filteredTables(fromState);
        final List<String> toStateTableList = mReservationHandler.filteredTables(toState);

        fromStateTableList.remove(tableId);
        toStateTableList.add(tableId);
    }

    /*
     * The handler to handler all the filtering of tables
     * Mainly responsible for filtering the tables with certain conditions
     */
    public class ReservationHandler {

        /*
         * The method to filter table by given state
         * @return  List<String>      Return list of ids of table with given state
         * @param   state             The TableState
         */
        public List<String> filteredTables(final TableState state) {
            switch (state) {
                case Empty: return emptyTables;
                case Occupy: return occupiedTables;
                case Reserved: return reversedTables;
                default: return new ArrayList<>();
            }
        }

        /*
         * The method to filter table by given table type
         * @return  List<String>      Return list of ids of table with table type
         * @param   tableType         The table type
         */
        public List<String> filteredTables(final TableType tableType){
            switch (tableType) {
                case SMALL: return smallTables;
                case MEDIUM: return mediumTables;
                case LARGE: return largeTables;
                default: return new ArrayList<>();
            }
        }

        /*
         * The method to filter table by given party size
         * @return  List<String>      Return list of ids of table with party size
         * @param   partySize         The int of party size
         */
        public List<String> filteredTables(final int partySize){
            if( partySize <= SMALL.getCapacity()) {
                return filteredTables(SMALL);
            } else if (partySize <= MEDIUM.getCapacity()) {
                return filteredTables(MEDIUM);
            } else if (partySize <= LARGE.getCapacity()) {
                return filteredTables(LARGE);
            } else {
                return new ArrayList<>();
            }
        }

        /*
         * The method to filter table by given timeStamp
         * @return  List<String>      Return list of ids of table with timeStamp
         * @param   timeStamp         The long[] of start and end time
         */
        public List<String> filteredTables(final long[] timeStamp){
            final List<String> result = new ArrayList<>(emptyTables);

            for (String tableId : reversedTables){
                if (tableMap.get(tableId).isAvailable(timeStamp)){
                    result.add(tableId);
                }
            }

            return result;
        }

        //The combination of filtering by table type and table state
        public List<String> filteredTables(final TableType tableType, final TableState state){
            final List<String> result = new ArrayList<>();

            final List<String> tableTypeList = filteredTables(tableType);
            final List<String> stateList = filteredTables(state);

            for(String id : tableTypeList){
                if(stateList.contains(id)) {
                    result.add(id);
                }
            }

            return result;
        }

        //The combination of filtering by partySize and timeStamp
        public List<String> filteredTables(int partySize, long[] timeStamp) {
            final List<String> result = new ArrayList<>();

            final List<String> sizeList = filteredTables(partySize);
            final List<String> timeList = filteredTables(timeStamp);

            for (String id : sizeList){
                if (timeList.contains(id)) {
                    result.add(id);
                }
            }

            return result;
        }
    }
}

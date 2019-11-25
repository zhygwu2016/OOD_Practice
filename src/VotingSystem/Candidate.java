package VotingSystem;

import java.util.*;

/**
 * Created by FLK on 4/18/18.
 */
public class Candidate implements Comparable {

    //Why we need an id? --> To avoid duplicate names
    private final String id;
    private final String name;

    /*
    *  1.Data structure to save ticket?
    *   Set,list,queue,priority queue
    *
    *  2.Which one to use?
    *   List, Queue, priority queue?
    *   List --> since the ticket won't be poped and they are in time order
    * */
    private final List<Ticket> tickets;

    //Set the number that can be used in compareTo() method
    private long compareNumber;

    //Constructor
    public Candidate(final String name, final String id){
        this.id = id;
        this.name = name;
        tickets = new ArrayList<Ticket>();
    }

    //Getters
    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public List<Ticket> getTickets(){
        return tickets;
    }

    //Add ticket to the candidate
    public boolean addTicket(Ticket ticket){
        if(ticket == null) return false;
        tickets.add(ticket);
        return true;
    }

    public int getTotalVoteNumber(){
        return tickets.size();
    }

    //Get the totcal number of ticket before a certain time
    public int getTicketNumber(final long time){
        //Coner case
        if(tickets.isEmpty()) return 0;

        // Any algorithm ? Binary Search
        int start = 0;
        int end = tickets.size() - 1;
        int mid;
        Ticket temp;

        while(start + 1 < end){
            mid = (end - start)/2 + start;
            temp = tickets.get(mid);
            if(temp.getTime() <= time){
                start = mid;
            } else {
                end = mid;
            }
        }
        return tickets.get(end).getTime() > time ? start + 1 : end + 1;
    }

    //Setter for the compareNumber
    public void setCompareNumber(final long compareNumber){
        this.compareNumber = compareNumber;
    }

    //Getter for the compareNumber
    public long getCompareNumber(){
        return compareNumber;
    }

    //Override the compareTo() method
    @Override
    public int compareTo(Object o) {
        Candidate other = (Candidate) o;

        if(compareNumber == other.getCompareNumber()) return 0;

        return other.getCompareNumber() > compareNumber ? 1 : -1;
    }
}

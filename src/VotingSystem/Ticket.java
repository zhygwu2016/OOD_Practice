package VotingSystem;

/**
 * Created by FLK on 4/18/18.
 */
public class Ticket {

    //The basic information for the ticket
    private final String id;

    //The candidate's information
    private final String candidateId;

    //Vote time that will be used for search
    private final long voteTime;

    //Constructor
    public Ticket(final String id, final String candidateId, final long voteTime){

        /*
        *  In industry, id should be unique in the data base.
        *  One way to generate an id is:
        *  a special piece of string + the current system time
        *
        * */
        this.id = id;
        this.candidateId = candidateId;
        this.voteTime = voteTime;
    }

    //Getters
    public String getId(){
        return id;
    }

    public String getCandidateId(){
        return candidateId;
    }

    public long getTime(){
        return voteTime;
    }
}

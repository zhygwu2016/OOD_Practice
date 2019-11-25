package VotingSystem;

import java.util.*;

/**
 * Created by FLK on 4/18/18.
 */
public class VoteSystem {

    //Data Structure to save candidate
    private final HashSet<Candidate> candidates;

    //Assuming there is only one VoteSystem, so VoteSystem need to be a singleton
    private static VoteSystem instance = null;

    private VoteSystem(){
        candidates = new HashSet<Candidate>();
    }

    public static VoteSystem getInstance(){
        if(instance == null){
            instance = new VoteSystem();
        }

        return instance;
    }


    //Method to add candidate
    public boolean addCandidate(final Candidate candidate){
        return candidates.add(candidate);
    }

    //Method to vote for candidate
    public boolean voteForCandidate(final Candidate candidate, final long time){
        if(!candidates.contains(candidate)) return false;

        //Generate a ticket according to the time
        final Ticket ticket = new Ticket(System.currentTimeMillis() + "",candidate.getId(), time);

        //Add the ticket to candidate list
        candidate.addTicket(ticket);
        return true;
    }

    //Getters
    public List<Candidate> getCandidates(){
        final List<Candidate> temp = new LinkedList<Candidate>();

        for (Candidate candidate : candidates) {
            temp.add(candidate);
        }

        return temp;
    }

    //Method to find top k candidate for a certain time according to the total tickets they get by that time
    public List<Candidate> findTopK(final long time, final int k){
        //Conner case
        if(time > System.currentTimeMillis() || k <= 0) return null;

        //Add all candidate into a list so that it can be sorted
        final List<Candidate> temp = new ArrayList<Candidate>();

        for (Candidate candidate : candidates){
            //Set the comparable number so that it can be sorted according to the number od ticket they get
            candidate.setCompareNumber(candidate.getTicketNumber(time));
            temp.add(candidate);
        }

        //Directly use sort method
        Collections.sort(temp);

        //Return the subList if k is less than total candidate number,otherwise return the list
        if (k > temp.size()) return temp;
        else return temp.subList(0,k);
    }
}

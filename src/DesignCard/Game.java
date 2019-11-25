package DesignCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank Fang on 8/18/18.
 */
public class Game {

    private final List<Player> players;

    private final Deck deck;

    private final String id;

    public Game(final String id){
        this.id = id;
        players = new ArrayList<Player>();
        deck = new Deck();
    }

    public Game(final String id, final List<Player> players){
        this.id = id;
        this.players = players;
        deck = new Deck();
    }

    public boolean init(){
        if(players.size() <= 1) return false;

        deck.init();
        deck.shuffle();

        while (deck.getSize() > 0){

            for (Player player : players){
                player.getCard(deck.dealCard());
            }
        }

        return true;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean addPlayer(Player player){
        if (player == null) return  false;

        players.add(player);
        return true;
    }
}

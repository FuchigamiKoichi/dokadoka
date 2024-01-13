package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Dokapon_game;

import java.util.ArrayList;
import java.util.Collections;

public class UserManager {
    ArrayList<User> users = new ArrayList<>();

    public UserManager(){
        this.users = new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    public void displayRankings(){
        System.out.println("プレイヤーランキング:");
        for(User user : users){
            System.out.println(user.getPlayerName() + " - ランキング: " + user.getPlayerRanking());
        }
    }

    public void updateRankings(){
        Collections.sort(users,Collections.reverseOrder());

        for(int i=0;i < users.size();i++){
            users.get(i).setPlayerRanking(i + 1);
        }
    }
}
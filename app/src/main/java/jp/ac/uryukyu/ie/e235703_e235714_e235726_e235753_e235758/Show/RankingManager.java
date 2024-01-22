package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle.*;

import java.util.ArrayList;
import java.util.Collections;

public class RankingManager {
    private ArrayList<User> Users;

    public String getRanking(){
        //ランキングを取得する処理
        ArrayList<User> sortedUsers = new ArrayList<>(Users);
        Collections.sort(sortedUsers);

        StringBuilder rankingText = new StringBuilder();
        int rank = 1;
        for(User User: sortedUsers){
            rankingText.append(rank).append("位. ").append(User.getPlayerName()).append(" - ").append(User.getMoney()).append("円\n");
            rank++;
        }

        return rankingText.toString();
    }
}
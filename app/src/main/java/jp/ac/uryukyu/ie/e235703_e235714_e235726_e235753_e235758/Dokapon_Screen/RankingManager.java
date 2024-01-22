package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Dokapon_Screen;
import java.util.ArrayList;
import java.util.Collections;

public class RankingManager {
    private ArrayList<Player> players;

    public RankingManager(){
        //プレイヤーリストの初期化
        players = new ArrayList<>();
        players.add(new Player("プレイヤー１", 1000));
        players.add(new Player("プレイヤー２", 1500));

    }

    public String getRanking(){
        //ランキングを取得する処理
        ArrayList<Player> sortedPlayers = new ArrayList<>(players);
        Collections.sort(sortedPlayers);

        StringBuilder rankingText = new StringBuilder();
        int rank = 1;
        for(Player player: sortedPlayers){
            rankingText.append(rank).append("位. ").append(player.getName()).append(" - ").append(player.getMoney()).append("円\n");
            rank++;
        }

        return rankingText.toString();
    }
}

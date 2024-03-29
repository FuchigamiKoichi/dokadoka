package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_sugoroku.Space;

public class User implements Comparable<User>{
    private String playerName;
    private int playerRanking;
    private double totalAssets;
    private Space point;
    private FightCharacter fighter;

    public User(String playerName,double totalAssets,Space point, FightCharacter fighter){
        this.playerName = playerName;
        this.totalAssets = totalAssets;
        this.point = point;
        this.fighter = fighter;
    }

    public FightCharacter getFighter() {
        return fighter;
    }

    public void setFighter(FightCharacter fighter) {
        this.fighter = fighter;
    }

    public Space getSpace() {
        return point;
    }

    public int getMoney(){
        int money = this.getFighter().getMoney();
        return money;
    }

    public void setSpace(Space point) {
        this.point = point;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public double getTotalAssets(){
        return this.totalAssets;
    }

    public int getPlayerRanking(){
        return this.playerRanking;
    }
    
    public void setPlayerRanking(int playerRanking){
        this.playerRanking = playerRanking;
    }

    @Override
    public int compareTo(User other){
        //所持金の比較
        return Integer.compare(other.getMoney(), this.getMoney());
    }
}
package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_sugoroku.Space;

public class User implements Comparable<User>{
    private String playerName;
    private int playerRanking;
    private double totalAssets;
    private Space point;

    public User(String playerName,double totalAssets,Space point){
        this.playerName = playerName;
        this.totalAssets = totalAssets;
        this.point = point;
    }

    public Space getSpace() {
        return point;
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

    public int compareTo(User otherUser){
        
        return Integer.compare(this.playerRanking,otherUser.playerRanking);
    }
}
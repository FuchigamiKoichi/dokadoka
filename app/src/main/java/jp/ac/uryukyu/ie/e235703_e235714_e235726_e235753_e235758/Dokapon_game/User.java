package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
public class User implements Comparable<User>{
    private String playerName;
    private int playerRanking;
    private double totalAssets;

    public User(String playerName,double totalAssets){
        this.playerName = playerName;
        this.totalAssets = totalAssets;
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

    //未履修
}

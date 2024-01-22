package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Dokapon_Screen;

public class Player implements Comparable<Player>{
    private String name;
    private int money;

    public Player(String name,int money){
        this.name = name;
        this.money = money;
    }

    public String getName(){
        return this.name;
    }

    public int getMoney(){
        return this.money;
    }

    @Override
    public int compareTo(Player other){
        //所持金の比較
        return Integer.compare(other.getMoney(), this.money);
    }
}

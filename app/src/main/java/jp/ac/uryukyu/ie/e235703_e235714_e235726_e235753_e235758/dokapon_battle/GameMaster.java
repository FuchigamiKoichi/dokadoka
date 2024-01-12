package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
import java.util.ArrayList;
import java.util.Random;

public class GameMaster{
    String[] monsters;
    private FightCharacter target1;
    ArrayList <FightCharacter> order;
    Warrior warrior1;
    Enemy slime;
    

    GameMaster(){
        order = new ArrayList<>();
        
        //order.add(new Enemy("スライム",60, 4, 5, 3, 6));
        //order.add(new Player("戦士", 100, 0, 0, 0, 0));
        
        //target1 = order.get(0);

    }
    /*先行後攻を決めるメソッド
    引数に敵を選択して、Playerと敵の先行後攻をランダムで決めるメソッド
    */
    public void determineTurn(FightCharacter target1){
        //ランダムな0または1を生成
        int randomValue = new Random().nextInt(2);
        
        //先行後攻を表示
        if (randomValue == 0){
            System.out.println("先行 : " + target1.getName());
            System.out.println(target1.getName() + "のターン!!!");
        }else{
            System.out.println("先行 : プレイヤー");
            System.out.println("プレイヤーのターン");
        }
    }

    public static void main(String[] args) {
        var master = new GameMaster();
        var warrior1 = new Warrior("戦士", 0, 0, 0, 0,0,0,"健康");
        var slime = new Enemy("スライム",0,0, 0, 0,0,0,"通常");
        ArrayList <FightCharacter> order = new ArrayList<>();
        
        order.add(slime);
        order.add(warrior1);
        System.out.println(order);
        FightCharacter target1 = order.get(0);
        
        
        master.determineTurn(target1);
        
    }
}
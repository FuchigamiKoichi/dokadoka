package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Dokapon_game;
import java.util.ArrayList;
import java.util.Random;

import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle.Enemy;
import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle.FightCharacter;
import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle.Warrior;

public class TurnDecision{
    String[] monsters;
    private FightCharacter target1;
    ArrayList <FightCharacter> order;
    FightCharacter warrior1;
    Enemy slime;
    int randomValue;


    TurnDecision(){
        order = new ArrayList<>();
    }
    /*先行後攻を決めるメソッド
    引数に敵を選択して、Playerと敵の先行後攻をランダムで決めるメソッド
    */
    public void determineTurn(FightCharacter target1){
        //ランダムな0または1を生成
        randomValue = new Random().nextInt(2);
        
        //先行後攻を表示
        if (randomValue == 0){
            System.out.println("先行 : " + target1.getName());
            System.out.println(target1.getName() + "のターン!!!");
        }else{
            System.out.println("先行 : プレイヤー");
            System.out.println("プレイヤーのターン");
        }
    }
}
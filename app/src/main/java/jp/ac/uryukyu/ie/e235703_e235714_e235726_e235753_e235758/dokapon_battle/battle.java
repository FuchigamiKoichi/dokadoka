package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

import java.util.ArrayList;
import java.util.Random;
//健太のコードとドッキングさせる
public class battle {
    static double result;
    
    public static double ToNatureNum(double num){// 負の数を0にするメソッド
        if(num < 0){
            result = 0;
        }else{
            result = num;
        }
        return result;
    }

    public void docaponBattle(FightCharacter p1,FightCharacter p2){
        //ここに下で書いたバトルについてのコードをメソッド化したい
    }
}

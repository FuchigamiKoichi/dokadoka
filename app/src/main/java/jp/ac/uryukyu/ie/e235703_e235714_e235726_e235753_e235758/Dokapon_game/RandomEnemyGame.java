package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
import java.util.Scanner;
import java.util.Random;

public class RandomEnemyGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ゲームを開始します");

        if(encounterEnemy()){
            System.out.println("敵が現れました");
        }else{
            System.out.println("何も...なかった!!!");
        }
    }

    //一定の確率でモンスターに出会うメソッド
    public static boolean encounterEnemy(){
        Random random = new Random();
        int encounterChance = random.nextInt(100);
        //モンスター個別で、出現率を設定したい
        Enemy[] enemyList;

        //60%の確率で敵が出現する
        return encounterChance < 60;
    }


    
}
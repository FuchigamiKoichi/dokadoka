package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

import java.util.Random;
//java.util.Scannerクラスで、標準入力を取得できるようにする。
import java.util.Scanner;

/*じゃんけんさせるクラス
使っても使わなくてもいいよ(アイテム屋を襲うときには使ってくれ)
今のところ先行後攻はじゃんけん関係なく、ランダムで仮実装してる
*/
//アイテム屋は実装するか不明
public class JankenGame {
    
    public static void playJanken(){
        Scanner scanner = new Scanner(System.in);//Systemクラスのinフィールドで標準入力を取得
        Random random = new Random();

        System.out.println("じゃんけんを始めるぞ!!");
        //数字を入力することでじゃんけんの手をきめられるようにしたい
        System.out.println("1: グー, 2: チョキ, 3: パー");

        System.out.println("あなたの手を選んでください");
        //"nextInt()"を使用して、プレイヤーが入力した整数を取り込む
        int UserChoice = scanner.nextInt();

        //NPCが出す手を決める
        int ComputerChoice = random.nextInt(3) + 1;
        System.out.println("コンピュータの手: " + ComputerChoice);

        //determineの意味は "決定する"
        determineWinner(UserChoice, ComputerChoice);

    }

    //じゃんけんの勝敗を決めるメソッド
    public static void determineWinner(int user_Hand,int CPU_Hand){
        //引き分けの場合
        if(user_Hand == CPU_Hand){
            System.out.println("引き分け!!");
            //もう一度じゃんけんさせる
            playJanken();
        //プレイヤーが勝った場合
        }else if(user_Hand == 1 && CPU_Hand == 2){
            System.out.println("あなたの勝ち!!");
        //NPCが買った場合
        }else{
            System.out.println("あなたの負け!!");
        }
    }

    public static void main(String[] args) {
        playJanken();
    }
}
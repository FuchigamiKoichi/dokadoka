package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758;

import java.util.Random;
import java.util.Scanner;

public class JankenGame {
    public static void playJanken(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("じゃんけんを始めるぞ!!");
        System.out.println("1: グー, 2: チョキ, 3: パー");

        System.out.println("あなたの手を選んでください");
        int UserChoice = scanner.nextInt();

        int ComputerChoice = random.nextInt(3) + 1;
        System.out.println("コンピュータの手: " + ComputerChoice);

        determineWinner(UserChoice, ComputerChoice);

    }

    //じゃんけんの勝敗を決めるメソッド
    public static void determineWinner(int user_Hand,int CPU_Hand){
        if(user_Hand == CPU_Hand){
            System.out.println("引き分け!!");
            playJanken();
        }else if(user_Hand == 1 && CPU_Hand == 2){
            System.out.println("あなたの勝ち!!");
        }else{
            System.out.println("あなたの負け!!");
        }
    }

    public static void main(String[] args) {
        playJanken();
    }
}

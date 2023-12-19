package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
import java.util.Random;

public class Dice {
    public static void main(String[] args) {
        //ランダムな整数を生成
        int randomValue = getRandomNumber(1, 6);
        System.out.println("ランダムな数値 : " + randomValue);
    }
    public static int getRandomNumber(int min,int max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}

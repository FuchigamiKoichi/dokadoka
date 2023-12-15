package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Calculation;
import java.util.Scanner;

//import org.checkerframework.common.value.qual.StringVal;

public class ComandSelect {//コマンドを選択させるクラス

    public int A_comand_Select(){
        Scanner sc = new Scanner(System.in);

        System.out.println("数字を選択してください");
        System.out.println("[1:こうげき 2:まほう 3:ひっさつ 4:バフ]");
        int comand1 = sc.nextInt();
        //ここにコマンド変数に保存する機能を入れたい
        

        return comand1;
    }

    public int D_comand_Select(){
        Scanner sc = new Scanner(System.in);

        System.out.println("数字を選択してください");
        System.out.println("[1:防御 2:魔法防御 3:カウンター 4:こうさん]");
        int comand = sc.nextInt();
        //ここにコマンド変数に保存する機能を入れたい
        return comand;
    }

    public void main(String[] args) {
        int COMAND = A_comand_Select();
        System.out.println(COMAND+"を選択しました！");
    }
}

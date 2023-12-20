package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Calculation;
import java.util.Scanner;

//import org.checkerframework.common.value.qual.StringVal;

public class ComandSelect {//コマンドを選択させるクラス

    public int A_comand_Select(Character仮 attacker){
        Scanner sc = new Scanner(System.in);

        System.out.println(attacker.getName()+"は数字を選択してください");
        System.out.println("[1:こうげき 2:まほう 3:ひっさつ 4:バフ]");
        int comand1 = sc.nextInt();
        
        return comand1;
    }

    public int D_comand_Select(Character仮 defancer){
        Scanner sc = new Scanner(System.in);

        System.out.println(defancer.getName()+"は数字を選択してください");
        System.out.println("[1:防御 2:魔法防御 3:カウンター 4:こうさん]");
        int comand = sc.nextInt();
        //ここにコマンド変数に保存する機能を入れたい
        return comand;
    }
}

//ここのクラスで4は扱う。4が選ばれれば強制的に違うクラスに飛ばす
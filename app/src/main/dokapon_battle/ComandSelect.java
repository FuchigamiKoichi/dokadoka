package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

//java.util.Scannerクラスで、標準入力を取得できるようにする。
import java.util.Scanner;

//コマンド選択を定義
public class ComandSelect {

    //攻撃に関するコマンド選択を定義
    public int A_comand_Select(FightCharacter attacker){
        //Scannerの省略がsc
        Scanner sc = new Scanner(System.in); //Systemクラスのinフィールドで標準入力を取得
        
        //数字を入力することでコマンドを選べるようにする
        System.out.println(attacker.getName()+"は数字を選択してください");
        System.out.println("[1:こうげき 2:まほう 3:ひっさつ 4:バフ]");
        int comand1 = sc.nextInt();
        
        return comand1;
    }

    //防御に関するコマンド選択を定義
    public int D_comand_Select(FightCharacter defender){
        Scanner sc = new Scanner(System.in);//Systemクラスのinフィールドで標準入力を取得

        //数字を入力することでコマンドを選べるようにする
        System.out.println(defender.getName()+"は数字を選択してください");
        System.out.println("[1:防御 2:魔法防御 3:カウンター 4:こうさん]");
        int comand = sc.nextInt();
        //ここにコマンド変数に保存する機能を入れたい
        return comand;
    }

}

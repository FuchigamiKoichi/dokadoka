package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Calculation;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayList<Character仮> characters = new ArrayList<>();

        //本来は同じマス目にいるキャラクターがここに入ってくる
        //アレイリスト使ったら良さそう
        Character仮 p1 = new Character仮("勇者1",15,5,2,13,2);
        Character仮 p2 = new Character仮("勇者2",50,12,8,15,4);

        characters.add(p1);
        characters.add(p2);

        ComandSelect comandSelect = new ComandSelect();
        計算分別 計算分別 = new 計算分別();

        /*ここ一般化するのは難しい、いや、できる
        ランダムで0か１が出る。その数字でアレイリストのインデックス指定
        */
        int randomValue = new Random().nextInt(2);
        Character仮 先行の人 = characters.get(randomValue);
        /*
        選ばれた人が先攻に入る
        次は引数に入れるプレイヤーを逆にして攻撃する
        */

        //ターン開始
        if(先行の人 == p2){
            System.out.println(先行の人.getName()+"のターン");
            //先行の人がp2
            int comand1_先攻 = comandSelect.A_comand_Select(p2);
            double allAttack_先攻 = 計算分別.Calculation(comand1_先攻,p2/*攻撃する人*/,p1);
            System.out.println(p2.getName()+"は"+p1.getName()+"に"+allAttack_先攻+"ダメージ！！！");

            //後攻p1の攻撃
            int comand1_後攻 = comandSelect.A_comand_Select(p1);
            double allAttack_後攻 = 計算分別.Calculation(comand1_後攻,p1/*攻撃する人*/,p2);
             System.out.println(p1.getName()+"は"+p2.getName()+"に"+allAttack_後攻+"ダメージ！！！");
        }

        else{
            System.out.println(先行の人.getName() +"のターン");
            //先行の人がp1
            int comand1_先攻 = comandSelect.A_comand_Select(p1);
            double allAttack_先攻 = 計算分別.Calculation(comand1_先攻,p1/*攻撃する人*/,p2);
            System.out.println(p1.getName()+"は"+p2.getName()+"に"+allAttack_先攻+"ダメージ！！！");

            //後攻p1の攻撃
            int comand1_後攻 = comandSelect.A_comand_Select(p2);
            double allAttack_後攻 = 計算分別.Calculation(comand1_後攻,p2/*攻撃する人*/,p1);
            System.out.println(p2.getName()+"は"+p1.getName()+"に"+allAttack_後攻+"ダメージ！！！");
        }    
    }
} 


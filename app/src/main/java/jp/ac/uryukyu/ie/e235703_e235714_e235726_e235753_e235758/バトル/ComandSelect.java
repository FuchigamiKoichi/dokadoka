package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.バトル;

import java.util.Scanner;

public class ComandSelect {
    public int A_comand_Select(FightCharacter attacker){
        Scanner sc = new Scanner(System.in);
        
        System.out.println(attacker.getName()+"は数字を選択してください");
        System.out.println("[1:こうげき 2:まほう 3:ひっさつ 4:バフ]");
        int comand1 = sc.nextInt();
        
        return comand1;
    }

    public int D_comand_Select(FightCharacter defender){
        Scanner sc = new Scanner(System.in);

        System.out.println(defender.getName()+"は数字を選択してください");
        System.out.println("[1:防御 2:魔法防御 3:カウンター 4:こうさん]");
        int comand = sc.nextInt();
        
        return comand;
    }

}

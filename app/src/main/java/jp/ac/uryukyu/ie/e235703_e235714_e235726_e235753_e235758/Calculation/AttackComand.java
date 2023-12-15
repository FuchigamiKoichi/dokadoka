package jp.ac.uryukyu.ie.e235703.Calculation;
import java.util.ArrayList;


public class AttackComand {

    public double attackComand(){
        ComandSelect CS = new ComandSelect();
        int comand2 = CS.D_comand_Select();
        double allAttack = (player.getAttack()*7/3*target.getDefance())*attack_DefanceRate(comand2)*weaponRate*Math.random();
        return allAttack;
    }

    
    
    //防御コマンド選択メソッド
    public static double attack_DefanceRate(int comand2){
        double reslut = 0;
        if(comand2 == 1){
            reslut = a_df;
        }
        if (comand2 == 2) {
            reslut = a_mdf;
        }
        if (comand2 == 3) {
            reslut = a_counter;
        }
        return reslut;
    }
    
    //防御コマンド倍率
    static double a_df = 1.2;
    static double a_mdf = 1.68;
    static double a_counter = 2.16;
    static double a_down = 2.4;


    //得意武器判断メソッド
    double weaponRate = 1.0;

}

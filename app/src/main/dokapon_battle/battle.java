package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

import java.util.ArrayList;
import java.util.Random;
//健太のコードとドッキングさせる
public class battle {
    static double result;
    
    public static double ToNatureNum(double num){// 負の数を0にするメソッド
        if(num < 0){
            result = 0;
        }else{
            result = num;
        }
        return result;
    }
    
    public static void main(String[] args) {

        //戦闘するキャラクターを定義する
        ArrayList<FightCharacter> characters = new ArrayList<>();
        battle battle1 = new battle();

        //仮でキャラクターを作成
        FightCharacter p1 = new FightCharacter("ぽん骨裕太",100,5,2,8,10,100,"健康");
        FightCharacter p2 = new FightCharacter("五条悟らない",50,12,4,10,10,1000,"健康");

        //プレイヤーを、p1・p2として作成
        characters.add(p1);//p1は一人目のプレイヤー
        characters.add(p2);//p2は二人目のプレイヤー
        
        //ComandSelectで数字を入力することでコマンドを選べるようにする
        ComandSelect comandSelect = new ComandSelect();
        //どの数にどのコマンドが含まれているかが判別される？
        計算分別 計算分別 = new 計算分別();
        
        
        計算分別.getComand2_アタッククラス_計算分別();

        /*-------------------------------------------------------------------------------------------------- */

        //0以上2未満の乱数を取得
        int randomValue = new Random().nextInt(2);
        //どちらのプレイヤーが先行かを決める
        FightCharacter 先行の人 = characters.get(randomValue);
        
        //p1のHPが０以下かを確認する
        while(p1.getHP() > 0){
            //p2が先行の場合
            if(先行の人 == p2){
                System.out.println(先行の人.getName() + "のターン");
                //先行p2のターン
                System.out.println("相手のHP: " + (int)ToNatureNum(p1.getHP()));
                //p2が攻撃時のコマンドを選択する
                int comand1_先攻 = comandSelect.A_comand_Select(p2);
                double allAttack_先攻 = 計算分別.Calculation(comand1_先攻,p2,p1);

                //自分が必殺の時、相手がカウンターか判断。その場合、自分がダメージをくらう
                //自分が必殺技の時、相手がカウンターを選択した場合
                if(計算分別.getComand2_アタッククラス_計算分別() == 3){  //3が入力された場合必殺技が出る
                    System.out.println(p1.getName()+"は"+p2.getName()+"に"+ (int)Math.ceil(allAttack_先攻) +"ダメージ！！！");
                    System.out.println();
                    System.out.println(p2.getName() + "の残りHP: " + (int)ToNatureNum(p2.getHP()));//自分がダメージ食らったから自分のhp表示
                    System.out.println();
                    //カウンターのダメージで死んだ場合
                    if(p2.getHP() <= 0){
                        p2.die();
                        System.out.println(p1.getName() + "の勝ち!!");
                        break;
                    }
                //自分が必殺技の時、相手がカウンター以外を選択した場合
                }else{
                    System.out.println(p2.getName()+"は"+p1.getName()+"に"+ (int)Math.ceil(allAttack_先攻) +"ダメージ！！！");
                    System.out.println();
                    System.out.println(p1.getName() + "の残りHP: " + (int)ToNatureNum(p1.getHP()));
                    System.out.println();
                }
                
                //p1を倒しきった場合
                if(p1.getHP() <= 0){
                    p1.die();
                    System.out.println(先行の人.getName() + "の勝ち!!");
                    break;
                }

                //p1のターン
                System.out.println(p1.getName() + "のターン");
                
                System.out.println("相手のHP: " + (int)ToNatureNum(p2.getHP()));
                //p１が攻撃時のコマンドを選択する
                int comand1_後攻 = comandSelect.A_comand_Select(p1);
                double allAttack_後攻 = 計算分別.Calculation(comand1_後攻,p1/*攻撃する人*/,p2);

                //自分が必殺の時、相手がカウンターか判断。その場合、自分のダメージくらう
                //自分が必殺技の時、相手がカウンターを選択した場合
                if (計算分別.getComand2_アタッククラス_計算分別() == 3) {  //3が入力された場合必殺技が出る
                    System.out.println(p2.getName()+"は"+p1.getName()+"に" + (int)Math.ceil(allAttack_後攻) +"ダメージ！！！");
                    System.out.println();
                    System.out.println(p1.getName()+"の残りHP: " + (int)ToNatureNum(p1.getHP()));//自分がダメージ食らったから自分のhp表示
                    System.out.println();
                    //カウンターのダメージで死んだ場合
                    if(p1.getHP() <= 0){
                        p1.die();
                        System.out.println(p2.getName() + "の勝ち!!");
                        break;
                    }
                //自分が必殺技の時、相手がカウンター以外を選択した場合
                }else{
                    System.out.println(p1.getName()+"は"+p2.getName()+"に" + (int)Math.ceil(allAttack_後攻) +"ダメージ！！！");
                    System.out.println();
                    System.out.println(p2.getName()+"の残りHP: " + (int)ToNatureNum(p2.getHP()));
                    System.out.println();
                }

                //p2を倒しきった場合
                if(p2.getHP() <= 0){
                    p2.die();
                    System.out.println(p1.getName() + "の勝ち!!");
                    break;
                }
            }else{ //p1が先行の場合
                System.out.println(先行の人.getName() + "のターン");
                //p1のターン
                System.out.println("相手のHP: " + (int)ToNatureNum(p2.getHP()));
                //p1が攻撃時のコマンドを選択する
                int comand1_先攻 = comandSelect.A_comand_Select(p1);
                double allAttack_先攻 = 計算分別.Calculation(comand1_先攻,p1/*攻撃する人*/,p2);
                
                //自分が必殺の時、相手がカウンターか判断。その場合、自分のダメージくらう
                //自分が必殺技の時、相手がカウンターを選択した場合
                if (計算分別.getComand2_アタッククラス_計算分別() == 3) {
                    System.out.println(p2.getName()+"は"+p1.getName()+"に" + (int)Math.ceil(allAttack_先攻) +"ダメージ！！！");
                    System.out.println();
                    System.out.println(p1.getName()+"の残りHP: " + (int)ToNatureNum(p1.getHP()));//自分がダメージ食らったから自分のhp表示
                    System.out.println();
                    //カウンターのダメージで死んだ場合
                    if(p1.getHP() <= 0){
                        p1.die();
                        System.out.println(p2.getName() + "の勝ち!!");
                        break;
                    }
                //自分が必殺技の時、相手がカウンター以外を選択した場合
                }else{
                    System.out.println(p1.getName()+"は"+p2.getName()+"に" + (int)Math.ceil(allAttack_先攻) +"ダメージ！！！");
                    System.out.println();
                    System.out.println(p2.getName()+"の残りHP: " + (int)ToNatureNum(p2.getHP()));
                    System.out.println();
                }

                //p2を倒しきった場合
                if(p2.getHP() <= 0){
                    p2.die();
                    System.out.println(先行の人.getName() + "の勝ち!!");
                    break;
                }

                //p2のターン
                System.out.println(p2.getName() + "のターン");
                
                System.out.println("相手のHP: " + (int)ToNatureNum(p1.getHP()));
                //p2が攻撃時のコマンドを選択する
                int comand1_後攻 = comandSelect.A_comand_Select(p2);
                double allAttack_後攻 = 計算分別.Calculation(comand1_後攻,p2/*攻撃する人*/,p1);

                //自分が必殺の時、相手がカウンターか判断。その場合、自分のダメージくらう
                //自分が必殺技の時、相手がカウンターを選択した場合
                if(計算分別.getComand2_アタッククラス_計算分別() == 3){
                    System.out.println(p1.getName()+"は"+p2.getName()+"に"+ (int)Math.ceil(allAttack_後攻) +"ダメージ！！！");
                    System.out.println();
                    System.out.println(p2.getName() + "の残りHP: " + (int)ToNatureNum(p2.getHP()));//自分がダメージ食らったから自分のhp表示
                    System.out.println();
                    //カウンターのダメージで死んだ場合
                    if(p2.getHP() <= 0){
                        p2.die();
                        System.out.println(p1.getName() + "の勝ち!!");
                        break;
                    }
                //自分が必殺技の時、相手がカウンター以外を選択した場合
                }else{
                    System.out.println(p2.getName()+"は"+p1.getName()+"に"+ (int)Math.ceil(allAttack_後攻) +"ダメージ！！！");
                    System.out.println();
                    System.out.println(p1.getName() + "の残りHP: " + (int)ToNatureNum(p1.getHP()));
                    System.out.println();
                }
                //p1を倒しきった場合
                if(p1.getHP() <= 0){
                    p1.die();
                    System.out.println(p2.getName() + "の勝ち!!");
                    break;
                }
            }
        }
    }
}
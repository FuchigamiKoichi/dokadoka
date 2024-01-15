package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

import java.util.Random;

//攻撃時の処理を書く
public abstract class Attack {
    public abstract double Attack(FightCharacter execter, FightCharacter target);
}
/*------------------------------------------------------------------------------------------- */
/**
 * Attack
 */

class AttackComand extends Attack{
    double allAttack;
    @Override
    public double Attack(FightCharacter execter, FightCharacter target){
        //呼び出し時；attackComand(勇者, スライム)
        //CS = 選択するコマンド
        ComandSelect CS = new ComandSelect();
        int comand2 = CS.D_comand_Select(target);//相手のコマンドが入力される
        if(comand2 == 4){ //相手が降参する場合
            System.out.println("降参しました");
            System.out.println(target.getName() + "の負け!!");
            System.exit(0);
        }else{ //戦闘が継続する場合
            allAttack = (execter.getAttack()*7/3-target.getDefance())*attack_DefanceRate(comand2)*weaponRate/*generateRandomNumbers()*/;
            System.out.println(execter.getAttack());
            System.out.println(execter.getAttack()*7/3-target.getDefance());
            target.takenDamage(allAttack);
        }
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

    //0.95〜1.05の乱数を生成
    public static int generateRandomNumbers(){
        Random random = new Random();
        //random.nextInt　指定した範囲で乱数を生成
        int number = random.nextInt(11) + 95;
        // 1/100　倍して0.95〜1.05以内にする
        number = number*1/100;
        return number;
    }

}

/*------------------------------------------------------------------------------------------- */
/**
 * Magical
 */

//魔法での攻撃を定義
class MagicalComand extends Attack{
    double allAttack;
    int comand2;
    @Override
    public double Attack(FightCharacter execter, FightCharacter target){
        ComandSelect CS = new ComandSelect();
        ZenyTake zenyTake = new ZenyTake(); //＊ZenyTakeは魔法
        comand2 = CS.D_comand_Select(target);//相手のコマンドが入力される
        if(comand2 == 4){ //相手が降参する場合
            System.out.println("降参しました");
            System.out.println(target.getName() + "の負け!!");
            System.exit(0);
        }else{ //戦闘が継続する場合
            zenyTake.execute(execter,target);
            allAttack = (execter.getMG()*7/3-target.getMG())*magical_DefanceRate(comand2)*magicalRate()*magical_D_Rate()/*generateRandomNumbers()*/;
            target.takenDamage(allAttack);
        }
        return allAttack;
    }

    //防御コマンド選択メソッド
    public static double magical_DefanceRate(int comand2){
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
    static double a_df = 1.54;
    static double a_mdf = 1.1;
    static double a_counter = 1.98;
    static double a_down = 2.2;

    //魔法の種類によって倍率が変わる
    //今回は固定だが本来はプレイヤーが持つ魔法によって倍率が変わる
    public static double magicalRate(){
        double ゼニテイク = 1.36;
        return ゼニテイク;
    }

    //魔法防御のの種類によって倍率が変わる
    public static double magical_D_Rate(){
        double まほがど = 0.8; //まほがど　は魔法専用の防御方法
        return まほがど;
    }

    //0.95〜1.05の乱数を生成
    public static int generateRandomNumbers(){
        Random random = new Random();
        //random.nextInt　指定した範囲で乱数を生成
        int number = random.nextInt(11) + 95;
        // 1/100　倍して0.95〜1.05以内にする
        number = number*1/100;
        return number;
    }
}

/*------------------------------------------------------------------------------------------- */
/**
 * SpecialComand
 */

//必殺技を定義 
class SpecialComand extends Attack{
    double allAttack;
    FightCharacter player;
    FightCharacter enemy;
    int comand2;//battleで呼び出す
    @Override
    public double Attack(FightCharacter execter, FightCharacter target){
        //必殺カウンターで使う
        this.player = execter;
        this.enemy = target;

        ComandSelect CS = new ComandSelect();
        comand2 = CS.D_comand_Select(target);//相手のコマンドが入力される
        
        if(comand2 == 4){ //相手が降参する場合
            System.out.println("降参しました");
            System.out.println(target.getName() + "の負け!!");
            System.exit(0);
        }else if(comand2 == 3){ //戦闘が継続する場合
            allAttack = (execter.getAttack()+execter.getMG()+execter.getSP())*2.5-(target.getDefance()+target.getMG()+target.getSP())*7/3*defanceRate(comand2,execter,target)*weaponRate/*generateRandomNumbers()*/;
            execter.takenDamage(allAttack);
        }else{
            allAttack = (execter.getAttack()+execter.getMG()+execter.getSP())*2.5-(target.getDefance()+target.getMG()+target.getSP())*7/3*defanceRate(comand2,execter,target)*weaponRate/*generateRandomNumbers()*/;
            target.takenDamage(allAttack);
        }
        return allAttack;
    }

    //comand2の情報を呼び出す
    public int getComand2_アタッククラス(){
        return comand2;
    }

    //防御コマンド選択メソッド
    public double defanceRate(int comand2,FightCharacter execter, FightCharacter target){
        double result = 0;
        if(comand2 == 1){
            result = a_df;
        }
        if (comand2 == 2) {
            result = a_mdf;
        }
        if (comand2 == 3) {
            result = a_counter;
        }
        return result;
    }

    //必殺*カウンターコマンド
    double value; //必殺カウンターは必殺技のみに対応
    public double 必殺カウンター(FightCharacter execter, FightCharacter target){
        value = ((enemy.getAttack()+enemy.getMG()+enemy.getSP())*2+player.getAttack()-player.getDefance())*2.0*weaponRate/*generateRandomNumbers()*/;
        return value;
    }

    
    //防御コマンド倍率
    double a_df = 0.68;
    double a_mdf = 0.73;
    double a_counter = value;
    double a_down = 1.07;

    //得意武器判断メソッド
    double weaponRate = 1.0;

    

    //0.95〜1.05の乱数を生成
    public static int generateRandomNumbers(){
        Random random = new Random();
        //random.nextInt　指定した範囲で乱数を生成
        int number = random.nextInt(11) + 95;
        // 1/100　倍して0.95〜1.05以内にする
        number = number*1/100;
        return number;
    }
}
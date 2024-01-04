package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.バトル;

import java.util.ArrayList;
public class FightCharacter extends Character{;
    final int defaultHP = 100;
    double HP;
    int gainHP;
    int SP;
    int DF;
    int AT;
    int MP;
    String health;
    private int EXP;
    final int defaultLevel = 1;
    private final int EXPERIENCE_TO_NEXTLEVEL = 100;
    private int level = 1;
    
    

    public FightCharacter(String name,double HP ,int SP,int DF,int AT,int MP,int money,String health){
        super(name,money);
        this.HP = HP;
        this.MP = MP;
        this.SP = SP;
        this.DF = DF;
        this.AT = AT;
        this.health = health;
    }
    
    public int getAttack(){
        return this.AT;
    }

    public int getDefance(){
        return this.DF;
    }

    public int getMG(){
        return this.MP;
    }

    public int getSP(){
        return this.SP;
    }
    
    public double getEXP(){
        return this.EXP;
    }

    public void addEXP(double obtainedEXP){
        this.EXP += obtainedEXP;
    }

    public int getLevel(){
        return this.level;
    }

    public void setLevel(int newLevel){
        this.level = newLevel;
    }

    public String getHealth(){
        return this.health;
    }

    public void setHealth(String health){
        this.health = health;
    }

    public double getHP(){
        return this.HP;
    }
    public void setHP(double HP){
        this.HP = HP;
    }

    public void takenDamage(double damage){
        this.HP -= damage;
    }

    @Override
    //キャラ情報を表示するためのメソッド
    public void displayInfo(){
        System.out.println("name: " + this.getName());
        System.out.println("health: " + this.health);
        System.out.println("money: " + this.getMoney());
        System.out.println("Level: " + this.level);
    }

    //レベルアップについてのメソッド
    public void LevelUp(){
        System.out.println(this.getName() + ": レベル" + this.level + "→" + "レベル" + (level + 1) + "!!!");
        this.level ++;
        int gainHP = 10;
        this.HP = defaultHP + gainHP;//仮実装
        this.EXP -= EXPERIENCE_TO_NEXTLEVEL;
    }

    //経験値を入手するメソッド
    public void gainEXP(double obtainedEXP){
        this.EXP += obtainedEXP;
        System.out.println("獲得経験値(" + this.getName() + ") :" + obtainedEXP + "EXP");

        while(this.EXP >= EXPERIENCE_TO_NEXTLEVEL){
            LevelUp();
        }
    }

    public void die(){
        dead = true;
        System.out.println(this.getName() + "はやられた!");
    }

    public void revival(){
        if(this.dead){
            this.HP = defaultHP;
            this.dead = false;
            System.out.println(this.getName() + "は生き返った!!");
        }
    }

    /* 
    @Override
    public void execute(FightCharacter executer,FightCharacter target){
        target.HP -= executer.AT;//仮実装
        System.out.println(executer.getName() + "のこうげき");
        System.out.println(executer.getName() + "は" + target.getName() + "に" + executer.AT + "ダメージを与えた!!");

        if(target.HP <= 0){
            target.die();
        }
    }
    */

    public static void main(String[] args) {
        FightCharacter FC = new FightCharacter("Ken",30, 0, 0, 0, 0, 0,"健康");
        System.out.println(FC.getName() + " - Level:" + FC.getLevel() + " " + "EXP:" + FC.getEXP());
        
        FC.gainEXP(100);
        System.out.println(FC.getName() + " - Level:" + FC.getLevel() + " " +"EXP:" + FC.getEXP());

        FC.gainEXP(80);
        System.out.println(FC.getName() + " - Level:" + FC.getLevel() + " " +"EXP:" + FC.getEXP());


    }   
}
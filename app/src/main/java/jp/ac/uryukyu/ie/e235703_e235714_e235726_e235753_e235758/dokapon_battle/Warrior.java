package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

public class Warrior extends Occupation{
    int money;
    private double EXP;
    private int level = 1;
    public Warrior(String name,int HP ,int SP,int DF,int AT,int MP,int money,String health){
        super(name, HP, SP, DF, AT, MP,money,health);
        this.money = money;
        System.out.println(name + "のHPは" + HP + "です");
        System.out.println("所持金は" + money + "円です");
        System.out.println(name + "のレベルは" + this.level + "です!!!");
        System.out.println();
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

    public int getMoney(){
        return this.money;
    }

    public void setMoney(int obtainedMoney){
        this.money = obtainedMoney;
    } 
    
}
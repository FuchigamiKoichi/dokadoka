package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

import java.util.ArrayList;

//Occupationの意味は "職業"
//プレイヤーは"職業"を持つ
public class Occupation extends FightCharacter{
    ArrayList <FightCharacter> jobNames = new ArrayList<>();
    int money;
    private double EXP;
    private int level = 1;

    Occupation(String name,int HP ,int SP,int DF,int AT,int MP,int money,String health){
        super(name, HP, SP, DF, AT, MP,money,health);
    }

    
    public void addJob(FightCharacter job){
        jobNames.add(job);
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
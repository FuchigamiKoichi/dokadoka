package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

public class Magician extends Occupation{
    private double EXP;
    private int level = 1;
    public Magician(String name){
        super(name, 40, 3, 2, 5, 3,500,"健康");
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
    
}
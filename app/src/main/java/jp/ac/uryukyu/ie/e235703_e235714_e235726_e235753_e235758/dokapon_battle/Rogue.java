package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
public class Rogue extends Enemy{
    double obtainedEXP = 100;
    
    public Rogue(String name,int HP,int SP,int DF,int AT,int MP,int money,String health){
        super(name, HP, SP, DF, AT, MP, money, health);
    }

    @Override
    public void EnemyDead(){
        this.dead = true;
        System.out.println(this.getName() + "は倒された");
        System.out.println("経験値: " + obtainedEXP);
        FightCharacter FC = new FightCharacter("ken", 10, 1, 2, 3, 1, 50, "健康");
        FC.gainEXP(obtainedEXP);
    }
}

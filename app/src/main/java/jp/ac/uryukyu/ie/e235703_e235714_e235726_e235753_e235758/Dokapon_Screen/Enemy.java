package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Dokapon_Screen;

//スライムなどのモンスターを扱うクラス
public class Enemy extends FightCharacter{
    private int money;
    public double obtainedEXP;
    private int level;

    public Enemy(String name,int HP,int SP,int DF,int AT,int MP,int money,String health){
        super(name,HP,SP,DF,AT,MP,money,health);
        System.out.println(name + "のHPは" + HP + "です");
        System.out.println(name + "は" + money + "円持っています");
        System.out.println();
    }

    //モンスターが倒された際を想定
    public void EnemyDead(){
        this.dead = true;
        System.out.println(this.getName() + "は倒された");
        System.out.println("経験値: " + this.obtainedEXP + "を獲得!!!");
        FightCharacter FC = new FightCharacter("ken", HP, SP, DF, AT, MP,money, health);
        FC.gainEXP(obtainedEXP);
    }

    public void setObtainedEXP(double eachEXP){
        this.obtainedEXP = eachEXP;
    }

}

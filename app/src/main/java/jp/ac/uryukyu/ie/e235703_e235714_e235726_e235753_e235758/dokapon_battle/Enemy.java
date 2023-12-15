package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
public class Enemy extends FightCharacter{
    private int money;
    private double obtainedEXP;
    private int level;

    public Enemy(String name,int HP,int SP,int DF,int AT,int MP,int money,String health){
        super(name,HP,SP,DF,AT,MP,health);
        System.out.println(name + "のHPは" + HP + "です");
        System.out.println(name + "は" + money + "円持っています");
        System.out.println();
    }

    
    public void EnemyDead(){
        System.out.println(this.getName() + "は倒された");
        System.out.println("経験値: " + this.obtainedEXP + "を獲得!!!");
    }

}

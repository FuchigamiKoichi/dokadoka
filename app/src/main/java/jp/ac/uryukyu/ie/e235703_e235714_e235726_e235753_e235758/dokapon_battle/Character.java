package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
public class Character {
    private String name;
    boolean dead = false;
    private int money;

    Character(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getMoney(){
        return this.money;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public void addMoney(int money){
        this.money += money;
    }

    public boolean getDead(){
        return this.dead;
    }


    public void displayInfo(){
        System.out.println("Name: " + this.name);
        System.out.println("money: " + this.money);
    }

    /* 
    @Override
    public void execute(FightCharacter executer,FightCharacter target){
        target.HP -= executer.AT;//仮実装
        System.out.println(this.name + "のこうげき");
        System.out.println(executer.getName() + "は" + target.getName() + "に" + executer.AT + "ダメージを与えた!!");
    }
    */
}
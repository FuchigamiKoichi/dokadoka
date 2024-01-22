package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
public class ZenyTake implements Action{
    //技名の表示
    @Override
    public String getName(){
        return "ゼニテイク";
    }
    //お金を奪うコマンド
    @Override
    public void execute(FightCharacter executer,FightCharacter target){
        double stolenMoney = target.getMoney() * 0.25;
        target.setMoney(target.getMoney() - (int)stolenMoney);
    }
}
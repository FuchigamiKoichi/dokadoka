package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
public class Attack implements Action{
    @Override
    public String getName(){
        return "たたかう";
    }
    @Override
    public void execute(FightCharacter executer,FightCharacter target){
        //HP -= executer.総攻撃力,ATは仮
        target.HP -= executer.AT;
        System.out.println(executer.getName() + "の攻撃");
        System.out.println(target.getName() + "に" + executer.AT + "ダメージを与えた");
    }
}

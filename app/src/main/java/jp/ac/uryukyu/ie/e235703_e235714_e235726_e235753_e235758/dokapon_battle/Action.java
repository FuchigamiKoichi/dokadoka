package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

public interface Action {
    String getName();
   void execute(FightCharacter executer, FightCharacter target);
}

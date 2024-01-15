package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
//実行内容を定義する
public interface Action {
    String getName();
    //execute = 実行
    //executer = 実行者
    //実行内容とターゲットを定義
   void execute(FightCharacter executer, FightCharacter target);
}
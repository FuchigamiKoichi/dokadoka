package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

public class 計算分別 {
    double allAttack;
     public double Calculation(int comand1,FightCharacter execter, FightCharacter target){
         if(comand1 == 1){ //こうげきクラス
            AttackComand AC = new AttackComand();
            allAttack = AC.Attack(execter, target);
         }
         if(comand1 == 2){
            MagicalComand MC = new MagicalComand();
            allAttack = MC.Attack(execter, target);
         }
         if(comand1 == 3){
            SpecialComand specal = new SpecialComand();
            allAttack = specal.Attack(execter, target);
         }
         /* 
         if(comand1 == 4){
            allAttack = 
         }*/
         return allAttack;
      }
}

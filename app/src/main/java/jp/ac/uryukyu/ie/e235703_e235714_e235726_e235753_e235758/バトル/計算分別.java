package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.バトル;

public class 計算分別 {
   double allAttack;
   int comand2;//battleで使う
   
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
            comand2 = specal.getComand2_アタッククラス();
         }
         /* 
         if(comand1 == 4){
            allAttack = 
         }*/
         return allAttack;
      }

      public int getComand2_アタッククラス_計算分別(){
         return comand2;
      }
}
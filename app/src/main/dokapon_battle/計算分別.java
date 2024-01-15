package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

public class 計算分別 {
   double allAttack;
   int comand2;//battleで使う
   
     //Calculation = 計算
     public double Calculation(int comand1,FightCharacter execter, FightCharacter target){
         if(comand1 == 1){ //こうげきクラス
            //AttackComandの省略が AC 
            AttackComand AC = new AttackComand();
            allAttack = AC.Attack(execter, target);
         }
         if(comand1 == 2){  //攻撃に関する魔法クラス
            //MagicalComandの省略が　MC
            MagicalComand MC = new MagicalComand();
            allAttack = MC.Attack(execter, target);
         }
         if(comand1 == 3){  //必殺技クラス
            //SpecialComandの省略がspecal
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
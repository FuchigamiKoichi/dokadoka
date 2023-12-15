package jp.ac.uryukyu.ie.e235703.Calculation;

import org.checkerframework.checker.units.qual.s;

 public class 計算分別 {
     public static double Calculation(int comand1){
      double allAttack = 0;
         if(comand1 == 1){ //こうげきクラス
            AttackComand AC = new AttackComand();
            allAttack = AC.attackComand();
         }
         /*if(comand1 == 2){
            double allAttack = magicalComand();
         }
         if(comand1 == 3){
            double allAttack = specialComand();
         }
         if(comand1 == 4){
            double allAttack = 
         }*/
      return allAttack;
     }
 }

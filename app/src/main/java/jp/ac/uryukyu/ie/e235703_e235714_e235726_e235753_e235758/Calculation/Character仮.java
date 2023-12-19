package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Calculation;

public class Character仮 {
    private String name;
    private double hitPoint;
    private int attack;
    private int defance;
    private int mg;
    private int sp;
    private boolean dead;

       //getterメソッド//
   public String getName(){
    return this.name;
   }

   public int getAttack(){
    return this.attack;
   }

   public boolean getDead(){
    return this.dead;
   }

   public void setDead(boolean state){
    dead = state;
}

   public double getHitPoint(){
    return this.hitPoint;
   }

   public int getMG(){
    return this.mg;
   }

   public void setHitPoint(double aftarHitPoint){
    hitPoint = aftarHitPoint;
   }
   
   public int getDefance(){
    return this.defance;
   }

   public int getSP(){
    return this.sp;
   }

   //コマンドを更新
   /*public void setComand(int comand1){
    comand = comand1;
   }*/


   Character仮(String name,int hitPoint,int attack,int defance,int mg,int sp){
    this.name = name;
    this.hitPoint = hitPoint;
    this.attack = attack;
    this.defance = defance;
    this.mg = mg;
    this.sp = sp;
   }

   /*public void attack(Character opponent){
    if(hitPoint > 0){int damage = (int)(Math.random() * attack);
    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
    opponent.wounded(damage);
    }
}*/

    /*public void wounded(double damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }*/
   
} 



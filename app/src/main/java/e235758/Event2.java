package e235758;
//Eventの実装のために思いついたやつをひたすらやってみるやつ

import java.util.ArrayList;
import java.util.Random;
    public class Event2 implements Happening{
        int[] eventNumbers = {1,2};
        int num = (int) Math.random()*(eventNumbers.length);
        if(num =1){
            System.out.println("火事が発生しました！！");
            return this.HP - 3;
        }
        else{
            System.out.println("祝福を受けました！！");
            return this.HP + 3;
        }
        
    }
package e235758;


import java.util.ArrayList;
import java.util.Random;;
public class Event {
    String eventName;

    Random random = new Random();
    //ランダムに数字を出力させてその値によって起きるイベントを変えたい
    int[] eventNumbers = {1,2};
    int num = (int) Math.random()*(eventNumbers.length);
        if(num= 1){
            eventName ="火事";
            System.out.println(eventName + "が発生しました！！");
            return this.HP-3;
        }
        else{
            eventName = "祝福";
            System.out.println(eventName + "が発生しました！！");
            return this.HP-3;
        }

}

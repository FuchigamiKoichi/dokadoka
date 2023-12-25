package e235758;


public class Dice {
    public Dice(){
    //ランダムな数を生成し、１〜６の数を取り出す
    double rand = Math.random() * 6 +1; 
    //小数点以下を切り捨てる
    int number = (int)rand;
    System.out.println(number);
    }
}

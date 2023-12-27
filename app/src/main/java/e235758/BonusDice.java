package e235758;


//追加される分のサイコロを作る。
//競争相手との差が大きくなりすぎないように出目は１〜３にする。

public class BonusDice {
    public BonusDice(){
        //ランダムな数を生成し、１〜３の数を取り出す
        double bo_rand = Math.random() * 3 +1; 
        //小数点以下を切り捨てる
        int bo_number = (int)bo_rand;
        System.out.println(bo_number);
        }
}
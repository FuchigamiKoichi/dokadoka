package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

//プレイヤーの初期情報を設定するためのクラス
public class RegisterInfo {
    private int playNum;

    //プレイ人数におけるゲッターとセッター
    public int getPlayNum(){
        return playNum;
    }
    public void setPlayNum(int playNum){
        this.playNum = playNum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        RegisterInfo RI = new RegisterInfo();

        //人数入力
        System.out.println("人数を入力してください");
        RI.setPlayNum(scanner.nextInt());
        System.out.println("遊ぶ人数 : " + RI.playNum + "人");//人数をコマンドラインから取得
        scanner.nextLine();//改行文字をクリア


        String[] names = new String[RI.playNum];
        String[] jobs = new String[4];
        Map<String,String> job = new HashMap<>();
        
        for(int i = 0;i < RI.playNum; i++){
            System.out.println("名前を入力してください (" + (i + 1) + "/" + RI.playNum + "):");
            names[i] = scanner.nextLine();//名前を取得
            
            //人数分の職業を選択
            System.out.println("職業を選択してください");
            System.out.println("1. ウォリアー");
            System.out.println("2. マジシャン");
            System.out.println("3. シーフ");
            System.out.println("選択肢の番号を入力してください");

            int jobChoice = scanner.nextInt();
            scanner.nextLine();//改行文字をクリア

            switch (jobChoice) {
                case 1:
                    jobs[i] = "ウォリアー";
                    break;
                case 2:
                    jobs[i] = "マジシャン";
                    break;
                case 3:
                    jobs[i] = "シーフ";
                    break;
                default:
                    jobs[i] = "不明";
                    break;
            }
            System.out.println("選択された職業:" + jobs[i]);
            System.out.println();
            job.put(names[i],jobs[i]);//Map型のjobに,名前とそれに対応する職業を追加
            
            System.out.println("設定完了");
            System.out.println(names[i] + ":" + job.get(names[i]));
            System.out.println();
        }

        //入力された名前を表示
        System.out.println("入力された名前:");
        for(String name : names){
            System.out.println(name);
        }
        System.out.println();

        System.out.println("設定確認");
        for(int i = 0;i < RI.playNum;i++){
            System.out.println(names[i] + ":" + job.get(names[i]));
        }
        //サイコロを振る順番をランダムで決めるコード
        shuffleArray(names);//names内の要素をシャッフル
        System.out.println();
        System.out.println("順番が決まったよ!!!");
        System.out.println("サイコロを振る順番:");
        
        for(int i=0;i < names.length;i++){
            System.out.println((i + 1) + ". " + names[i]);
        }
    }
        
    //配列内をシャッフルするメソッド
    public static void shuffleArray(String[] array){
        Random r = new Random();
        for(int i = array.length ; i > 0;i--){
            int index = r.nextInt(i);//ランダムなインデックスを生成
            //要素入れ替え
            String temp = array[i - 1];
            array[i - 1] = array[index];//配列の中の箱を入れ替えているイメージ
            array[index] = temp;
        }
    }
}
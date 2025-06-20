package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_sugoroku;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {
    ArrayList<Space> spaces;

    public Map(int map) throws Exception{
        this.spaces = new ArrayList<>();
        //ファイルから読み込むFIleInputStreamのインスタンスを作り、それをScannerクラスに渡す
        // String path = System.getProperty("user.dir") + "/app/src/main/java/jp/ac/uryukyu/ie/e235703_e235714_e235726_e235753_e235758/WORLD/map"+map+".csv";
		InputStream fis = getClass().getClassLoader().getResourceAsStream("WORLD/map1.csv");
		Scanner scanner = new Scanner(fis);
        int i = 1; //読み込み行数

		try (scanner) {
            String Line;
			while (scanner.hasNext()) { //次に読み込むべき行があるか判定
				Line = scanner.next(); //nextメソッドで1行ずつ読み込んでLineに格納

                i++;

                if(i<3){
                    continue;
                }

                Line = Line.replace("\"", "");
                String[] data = Line.split(",");

                Event e = new Event(data[1]);
                Space s = new Space(i - 2, e);
                
                s.addWays(Integer.parseInt(data[2]));
                int j = data.length - 3;  //移動可能マスの数
                for(int m = 0; m < j; m++){
                    s.addWays(Integer.parseInt(data[m+3]));
                }

                spaces.add(s);
            }
        }
    }

    static String trimDoubleQuot(String str){
    char c = '"';
    if(str.charAt(0) == c && str.charAt(str.length()-1) == c) {
      return str.substring(1, str.length()-1);
    }else {
      return str;
        }
    }

    public ArrayList<Space> getSpaces() {
        return spaces;
    }
}
package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758;

    public class MapExample {
        public static void main(String[] args) {
            // マップのサイズを定義する（100マス）
            int mapSize = 10; // 仮に10x10のマップとします
    
            // マップを作成するための2次元配列
            char[][] map = new char[mapSize][mapSize];
    
            // マップの初期化（例として全てのマスを'.'で初期化）
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    map[i][j] = '.';
                }
            }
    
            // マップの表示（この例ではコンソールに表示）
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println(); // 改行
            }
        }
    }
    


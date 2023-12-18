package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758;

import java.util.HashMap;

public class GameMapTest {
    /*public static void main(String[] args) {
        testGameMapInitialization();
        testPlayerInitialization();
    }

    private static void testGameMapInitialization() {
        int mapSize = 5;
        GameMap gameMap = new GameMap(mapSize);

        if (gameMap.getSize() == mapSize) {
            System.out.println("Map size initialized correctly.");
        } else {
            System.out.println("Map size not initialized correctly.");
        }

        for (int i = 0; i < mapSize; i++) {
            if (gameMap.getSquare(i) != null) {
                System.out.println("Map square at index " + i + " initialized correctly.");
            } else {
                System.out.println("Map square at index " + i + " not initialized correctly.");
            }
        }
        
        System.out.println("GameMap initialization test completed.");
    }

    private static void testPlayerInitialization() {
        String playerName = "TestPlayer";
        Player player = new Player(playerName);

        if (player.getName().equals(playerName)) {
            System.out.println("Player name initialized correctly.");
        } else {
            System.out.println("Player name not initialized correctly.");
        }

        if (player.getMoney() == 0) {
            System.out.println("Player money initialized correctly.");
        } else {
            System.out.println("Player money not initialized correctly.");
        }
        
        System.out.println("Player initialization test completed.");
    }*/
    // テストケース1: マップの生成と情報表示のテスト
    public static void testMapCreation() {
        int mapSize = 10; // テスト用の小さなマップサイズを設定
        GameMap gameMap = new GameMap(mapSize); // マップを生成

        // マップサイズが正しく設定されているかを確認
        int actualSize = gameMap.getSize();
        System.out.println("Map Size: " + actualSize);
        
        // マス目が正しく初期化されているかを確認
        HashMap<Integer, MapSquare> squares = gameMap.getSquares();
        System.out.println("Squares: " + squares);
    }

    public static void main(String[] args) {
        // マップの生成と情報表示のテストを実行
        testMapCreation();
    }
}



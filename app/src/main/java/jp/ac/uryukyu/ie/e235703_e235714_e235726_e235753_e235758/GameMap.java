package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758;

//public class MapSquare {
import java.util.HashMap;

// マス目を表すクラス
class MapSquare {
    // ここにマス目のプロパティや動作を追加できます
    // 例えば、ショップかどうか、プレイヤーがいるかどうかなど
}

// ゲームのマップを表すクラス
public class GameMap {
    private int size; // マップのサイズ
    private HashMap<Integer, MapSquare> squares; // マス目を保持するマップ

    public GameMap(int size) {
        this.size = size;
        squares = new HashMap<>();
        initializeMap();
    }

    // マップを初期化するメソッド
    private void initializeMap() {
        for (int i = 0; i < size; i++) {
            squares.put(i, new MapSquare()); // マス目を初期化する（必要に応じてプロパティを設定）
        }
        // ショップのマスなど、特定のマス目に特別なプロパティを設定する処理を追加できます
    }

    // 他の必要なメソッドや動作を追加できます
    // 例えば、プレイヤーの移動やショップの処理など

    // ゲームのメインクラス
    public static void main(String[] args) {
        int mapSize = 100; // マップのサイズを設定
        GameMap gameMap = new GameMap(mapSize); // マップを生成

        // プレイヤーを作成
        //Player player1 = new Player("Player1");
        //Player player2 = new Player("Player2");

        // それぞれのプレイヤーの初期位置などを設定する処理を追加できます
        // 例えば、特定のマスにプレイヤーを配置するなど
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public HashMap<Integer, MapSquare> getSquares() {
        return squares;
    }

    public void setSquares(HashMap<Integer, MapSquare> squares) {
        this.squares = squares;
    }
}

// プレイヤーを表すクラス
/*class Player {
    private String name;
    private int money;

    public Player(String name) {
        this.name = name;
        this.money = 0; // 初期状態ではお金は0でスタート
    }

    // 他の必要なメソッドや動作を追加できます
    // 例えば、お金の増減や移動など
}*/


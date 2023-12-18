package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758;

import java.util.Arrays;

// イベントを表すクラス
class Event {
    private String description;

    public Event(String description) {
        this.description = description;
    }

    public void triggerEvent() {
        System.out.println("イベント発生: " + description);
        // イベントが発生した際の処理を記述
    }
}

// マップを表すクラス
class Map {
    private int size; // マップのサイズ
    private Event[] events; // 各マスのイベントを配列で管理

    public Map(int size) {
        this.size = size;
        events = new Event[size];
        Arrays.fill(events, null); // イベントがないマスはnullで初期化
    }

    // マップにイベントを追加するメソッド
    public void addEvent(int position, Event event) {
        events[position] = event;
    }

    // プレイヤーの位置にイベントがあるかをチェックするメソッド
    public void checkEvent(int position) {
        if (events[position] != null) {
            Event event = events[position];
            event.triggerEvent();
        } else {
            System.out.println("何も起こりませんでした。");
        }
    }

    // マップ全体の状態を表示するメソッド
    public void displayMap() {
        for (int i = 0; i < size; i++) {
            if (events[i] != null) {
                System.out.print("[E] "); // マスにイベントがある場合
            } else {
                System.out.print("[ ] "); // イベントがない場合
            }

            // 10マスごとに改行して表示
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }

    // メインクラス

    public static void main(String[] args) {
        int mapSize = 100; // マップのサイズを設定
        Map gameMap = new Map(mapSize);

        // 例としていくつかのイベントを追加してみます
        gameMap.addEvent(9, new Event("ラッキーコインを手に入れた！"));
        gameMap.addEvent(10, new Event("急に雨が降ってきた。"));
        gameMap.addEvent(50, new Event("秘密の宝物を見つけた！"));

        // プレイヤーの位置を設定（仮定）
        int playerPosition = 10;

        // プレイヤーが進んだ位置にイベントがあるかチェック
        gameMap.checkEvent(playerPosition);

        // マップ全体の状態を表示
        gameMap.displayMap();
    }
}

package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
import java.util.Random;

public class MonsterAppearance {
    public static void main(String[] args) {
        Enemy roag = new Enemy("ローグ", 0, 0, 0, 0, 0,0,"通常");
        Enemy zonbie = new Enemy("ゾンビ", 0, 0, 0,0, 0,0,"通常");
        //モンスターの種類を配列に定義
        Enemy[] monsters = {roag,zonbie};

        //ランダムにモンスターを選択
        Random random = new Random();
        int index = random.nextInt(monsters.length);
        FightCharacter selectedMonster = monsters[index];

        //選択されたモンスターを表示
        System.out.println("モンスターが現れた!!!" + selectedMonster.getName());
    }
}

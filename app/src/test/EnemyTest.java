package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
import org.junit.jupiter.api.Test;
import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle.*;
class EnemyTest{
    /**
     * 倒れたはずの敵は攻撃できないことを検証。
     * 検証手順
     *  (1) プレイヤーと敵を準備。プレイヤーの攻撃力は敵を一撃で倒せるほど強い状態とする。
     *  (2) プレイヤーが殴り、敵も殴る。敵は一撃で倒されていることを期待。
     *  (3) 敵が死んだ状態ならば攻撃できないはず。
     * 　　つまり攻撃実行後にプレイヤーのHPは減っていないことを期待。これを検証する。
     * 
     * 　備考
     *  ＃(4) PvPは今の所想定していない
     *  ＃(5) とりあえず敵は"ローグ"とする。
     */
    @Test

    void AttackTest(){
        FightCharacter demoPlayer = new FightCharacter
        Enemy rogue = new Rogue("ローグ", 1, 1, 1, 1, 1, 1,"健康");
        demoPlayer.a

    }
}
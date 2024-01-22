import org.junit.jupiter.api.Test;
import java.dokapon_battle.*;
public class AttackTest {

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
    
    @Test void appHasAGreeting() {
        int defaulPlayerAttack = 100;
        int defaulRogueHP = 1; 
        Character demoPlayer = new FightCharacter("デモプレイヤー", 100, 100, 100, defaulPlayerAttack, 100, "デバックモード");
        Character demoRogue = new Rogue("デモローグ", defaulRogueHP, 1, 1, 1, 1,1, "死にかけ");

        //失敗が無いように5回ずつ攻撃させる
        for(int count= 0; count<5; count++){
            demoPlayer.execute(demoPlayer, demoRogue);
        }
        assertEquals(defaulRogueHP - demoRogue.getHP());

    }
}
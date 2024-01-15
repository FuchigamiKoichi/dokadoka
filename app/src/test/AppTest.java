package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle.FightCharacter;
import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_sugoroku.*;

class AppTest {
    FightCharacter ft = new FightCharacter(null, 0, 0, 0, 0, 0, 0, null);
    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}

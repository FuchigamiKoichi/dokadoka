package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class Battle extends JPanel{

    FightCharacter first;
    FightCharacter second;

    Font fm = new Font("ＭＳ ゴシック", Font.BOLD, 40);

    boolean finish;

    int attackerschoice;

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public boolean getFinish(){
        return this.finish;
    }

    public int getAttackerschoice() {
        return attackerschoice;
    }

    public void setAttackerschoice(int attackerschoice) {
        this.attackerschoice = attackerschoice;
    }

    public FightCharacter getFirst() {
        return first;
    }

    public void setFirst(FightCharacter first) {
        this.first = first;
    }

    public FightCharacter getSecond() {
        return second;
    }

    public void setSecond(FightCharacter second) {
        this.second = second;
    }

    Battle(FightCharacter first, Zombie second){
        setLayout(null);

        this.finish = false;
        this.first = first;
        this.second = second;

        AttackPanel atp = new AttackPanel();
        atp.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
        add(atp);
    }


    /**
     * AttackPanel
     */
    class AttackPanel extends JPanel{
        AttackPanel(){
            setLayout(null);
            FightCharacter f = getFirst();
            FightCharacter s = getSecond();

            Random r = new Random();
            int rN = r.nextInt(2) + 1;
            if(rN == 1){
                setFirst(s);
                setSecond(f);
            }

            JButton attackButton = new JButton("攻撃");
            attackButton.setFont(fm);
            attackButton.setBounds(Main.WIDTH/6 - 100, Main.HEIGHT - 110, 200, 100);
            add(attackButton);

            JButton magickButton = new JButton("魔法攻撃");
            magickButton.setFont(fm);
            magickButton.setBounds((Main.WIDTH/6 * 2) - 100, Main.HEIGHT - 110, 200, 100);
            add(magickButton);

            JButton onepunchButton = new JButton("必殺攻撃");
            onepunchButton.setFont(fm);
            onepunchButton.setBounds((Main.WIDTH/6 * 3) - 100, Main.HEIGHT - 110, 200, 100);
            add(onepunchButton);

            JButton buffButton = new JButton("バフ攻撃");
            buffButton.setFont(fm);
            buffButton.setBounds(Main.WIDTH - 310, Main.HEIGHT - 110, 200, 100);
            add(buffButton);

            JLabel turn = new JLabel(first.getName()+"のターン");
            turn.setBounds(0, 10, 1470, 500);
            turn.setFont(fm);
            add(turn);

            JLabel HP = new JLabel("相手のHPは"+String.valueOf(second.getHP())+"です");
            HP.setFont(fm);
            HP.setBounds(0, 300, 1470, 500);
            add(HP);

            ActionListener attackAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setAttackerschoice(1);
                    defencePanel dp = new defencePanel();
                    dp.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
                    setVisible(false);
                    add(dp);
                    repaint();
                }
            };
            attackButton.addActionListener(attackAction);

            ActionListener magicAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setAttackerschoice(2);
                    defencePanel dp = new defencePanel();
                    dp.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
                    setVisible(false);
                    add(dp);
                    repaint();
                }
            };
            magickButton.addActionListener(magicAction);

            ActionListener onepuchAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setAttackerschoice(3);
                    defencePanel dp = new defencePanel();
                    dp.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
                    setVisible(false);
                    add(dp);
                    repaint();
                }
            };
            onepunchButton.addActionListener(onepuchAction);

            ActionListener buffAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getFirst().setAttack(getFirst().getAttack() * 2);
                    defencePanel dp = new defencePanel();
                    dp.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
                    setVisible(false);
                    add(dp);
                    repaint();
                }
            };
            buffButton.addActionListener(buffAction);
        }
    }

    /**
     * defencePanel
     */
    public class defencePanel extends JPanel{
        defencePanel(){
            setLayout(null);

            JButton defence = new JButton("防御");
            defence.setFont(fm);
            defence.setBounds((Main.WIDTH/6 * 1) - 100, Main.HEIGHT - 110, 200, 100);
            add(defence);

            JButton magickDefence = new JButton("魔法防御");
            magickDefence.setFont(fm);
            magickDefence.setBounds((Main.WIDTH/6 * 2) - 100, Main.HEIGHT - 110, 200, 100);
            add(magickDefence);

            JButton surrender = new JButton("降参");
            surrender.setFont(fm);
            surrender.setBounds((Main.WIDTH/6 * 3) - 100, Main.HEIGHT - 110, 200, 100);
            add(surrender);

            JButton counter = new JButton("カウンター");
            counter.setFont(fm);
            counter.setBounds((Main.WIDTH/6 * 4) - 100, Main.HEIGHT - 110, 200, 100);
            add(counter);

            JLabel turn = new JLabel(second.getName()+"のターン");
            turn.setBounds(0, 10, 1470, 500);
            turn.setFont(fm);
            add(turn);

            JLabel HP = new JLabel("相手のHPは"+String.valueOf(first.getHP())+"です");
            HP.setFont(fm);
            HP.setBounds(0, 300, 1470, 500);
            add(HP);

            ActionListener defenceAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(getAttackerschoice() == 1){
                        AttackComand atc = new AttackComand();
                        double damage = atc.Attack_method(first, second, 1);
                        first.takenDamage(damage);
                        if(second.getDead()){
                            setVisible(false);

                            Win win = new Win();
                            win.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
                            add(win);

                            repaint();
                        }else{
                            setVisible(false);

                            AttackPanel atp = new AttackPanel();
                            atp.setBounds(0,0,Main.WIDTH,Main.HEIGHT);
                            add(atp);

                            repaint();
                        }
                    }else if(getAttackerschoice() == 2){
                        MagicalComand mgc = new MagicalComand();
                        double damage = mgc.Attack_method(first, second, 1);
                        second.takenDamage(damage);
                        if(second.getDead()){
                            setVisible(false);

                            Win win = new Win();
                            win.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
                            add(win);

                            repaint();
                        }else{
                            setVisible(false);

                            AttackPanel atp = new AttackPanel();
                            atp.setBounds(0,0,Main.WIDTH,Main.HEIGHT);
                            add(atp);

                            repaint();
                        }
                    }else if(getAttackerschoice() == 3){
                        SpecialComand spc = new SpecialComand();
                        double damage = spc.Attack_method(first, second, 1);
                        second.takenDamage(damage);
                        if(second.getDead()){
                            setVisible(false);

                            Win win = new Win();
                            win.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
                            add(win);

                            repaint();
                        }else{
                            setVisible(false);

                            AttackPanel atp = new AttackPanel();
                            atp.setBounds(0,0,Main.WIDTH,Main.HEIGHT);
                            add(atp);

                            repaint();
                        }
                    }
                }
            };
            defence.addActionListener(defenceAction);

            ActionListener magickAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(getAttackerschoice() == 1){
                        setVisible(false);

                        AttackComand atc = new AttackComand();
                        double damage = atc.Attack_method(first, second, 2);
                        second.takenDamage(damage);
                        if(second.getDead()){
                            setVisible(false);

                            Win win = new Win();
                            win.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
                            add(win);

                            repaint();
                        }else{
                            setVisible(false);

                            AttackPanel atp = new AttackPanel();
                            atp.setBounds(0,0,Main.WIDTH,Main.HEIGHT);
                            add(atp);

                            repaint();
                        }
                    }else if(getAttackerschoice() == 2){
                        MagicalComand mgc = new MagicalComand();
                        double damage = mgc.Attack_method(first, second, 2);
                        second.takenDamage(damage);
                        if(second.getDead()){
                            setVisible(false);

                            Win win = new Win();
                            win.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
                            add(win);

                            repaint();
                        }else{
                            setVisible(false);

                            AttackPanel atp = new AttackPanel();
                            atp.setBounds(0,0,Main.WIDTH,Main.HEIGHT);
                            add(atp);

                            repaint();
                        }
                    }else if(getAttackerschoice() == 3){
                        SpecialComand spc = new SpecialComand();
                        double damage = spc.Attack_method(first, second, 2);
                        second.takenDamage(damage);
                        if(second.getDead()){
                            setVisible(false);

                            Win win = new Win();
                            win.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
                            add(win);

                            repaint();
                        }else{
                            setVisible(false);

                            AttackPanel atp = new AttackPanel();
                            atp.setBounds(0,0,Main.WIDTH,Main.HEIGHT);
                            add(atp);

                            repaint();
                        }
                    }
                }
            };
            magickDefence.addActionListener(magickAction);

            ActionListener counterAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(getAttackerschoice() == 1){
                        AttackComand atc = new AttackComand();
                        double damage = atc.Attack_method(first, second, 3);
                        second.takenDamage(damage);
                        if(second.getDead()){
                            setVisible(false);

                            Win win = new Win();
                            win.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
                            add(win);

                            repaint();
                        }else{
                            setVisible(false);

                            AttackPanel atp = new AttackPanel();
                            atp.setBounds(0,0,Main.WIDTH,Main.HEIGHT);
                            add(atp);

                            repaint();
                        }
                    }else if(getAttackerschoice() == 2){
                        MagicalComand mgc = new MagicalComand();
                        double damage = mgc.Attack_method(first, second, 3);
                        second.takenDamage(damage);
                        if(second.getDead()){
                            setVisible(false);

                            Win win = new Win();
                            win.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
                            add(win);

                            repaint();
                        }else{
                            setVisible(false);

                            AttackPanel atp = new AttackPanel();
                            atp.setBounds(0,0,Main.WIDTH,Main.HEIGHT);
                            add(atp);

                            repaint();
                        }
                    }else if(getAttackerschoice() == 3){
                        SpecialComand spc = new SpecialComand();
                        double damage = spc.Attack_method(first, second, 3);
                        second.takenDamage(damage);
                        if(second.getDead()){
                            setVisible(false);

                            Win win = new Win();
                            win.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
                            add(win);

                            repaint();
                        }else{
                            setVisible(false);

                            AttackPanel atp = new AttackPanel();
                            atp.setBounds(0,0,Main.WIDTH,Main.HEIGHT);
                            add(atp);

                            repaint();
                        }
                    }
                }
            };
            counter.addActionListener(counterAction);
        }
    }

    class AttackComand implements Attack{
        double allAttack;

        @Override
        public double Attack_method(FightCharacter execter, FightCharacter target,int command2){
            //呼び出し時；attackComand(勇者, スライム)
            
            if(command2 != 4){
                allAttack = (execter.getAttack()*7/3-target.getDefance())*attack_DefanceRate(command2)*weaponRate/*generateRandomNumbers()*/;
                target.takenDamage(allAttack);
                
            }
            return allAttack;
        }

        //防御コマンド選択メソッド
        public static double attack_DefanceRate(int comand2){
            double reslut = 0;
            if(comand2 == 1){
                reslut = a_df;
            }
            if (comand2 == 2) {
                reslut = a_mdf;
            }
            if (comand2 == 3) {
                reslut = a_counter;
            }
            return reslut;
        }

        //防御コマンド倍率
        static double a_df = 1.2;
        static double a_mdf = 1.68;
        static double a_counter = 2.16;
        static double a_down = 2.4;


        //得意武器判断メソッド
        double weaponRate = 1.0;

        //0.95〜1.05の乱数を生成
        public static int generateRandomNumbers(){
            Random random = new Random();
            int number = random.nextInt(11) + 95;
            number = number*1/100;
            return number;
        }

    }

    /*------------------------------------------------------------------------------------------- */
    /**
     * Magical
     */
    class MagicalComand implements Attack{
        double allAttack;
        int command2;
        @Override
        public double Attack_method(FightCharacter execter, FightCharacter target,int command2){
            ZenyTake zenyTake = new ZenyTake();
            if(command2 != 4){
                zenyTake.execute(execter,target);
                allAttack = (execter.getMG()*7/3-target.getMG())*magical_DefanceRate(command2)*magicalRate()*magical_D_Rate()/*generateRandomNumbers()*/;
                target.takenDamage(allAttack);
            }
            return allAttack;
        }

        //防御コマンド選択メソッド
        public static double magical_DefanceRate(int command2){
            double result = 0;
            if(command2 == 1){
                result = a_df;
            }
            if (command2 == 2) {
                result = a_mdf;
            }
            if (command2 == 3) {
                result = a_counter;
            }
            return result;
        }

        //防御コマンド倍率
        static double a_df = 1.54;
        static double a_mdf = 1.1;
        static double a_counter = 1.98;
        static double a_down = 2.2;

        //魔法の種類によって倍率が変わる
        //今回は固定だが本来はプレイヤーが持つ魔法によって倍率が変わる
        public static double magicalRate(){
            double ゼニテイク = 1.36;
            return ゼニテイク;
        }

        //魔法防御のの種類によって倍率が変わる
        public static double magical_D_Rate(){
            double まほがど = 0.8;
            return まほがど;
        }

        //0.95〜1.05の乱数を生成
        public static int generateRandomNumbers(){
            Random random = new Random();
            int number = random.nextInt(11) + 95;
            number = number*1/100;
            return number;
        }
        }

    /*------------------------------------------------------------------------------------------- */
    /**
     * SpecialComand
     */
    class SpecialComand implements Attack{
    double allAttack;
    FightCharacter first;
    FightCharacter second;
    int command2;//battleで呼び出す
    @Override
    public double Attack_method(FightCharacter execter, FightCharacter target,int command2){
        //必殺カウンターで使う
        this.first = execter;
        this.second = target;
        
        if(command2 == 3){
            allAttack = (execter.getAttack()+execter.getMG()+execter.getSP())*2.5-(target.getDefance()+target.getMG()+target.getSP())*7/3*defanceRate(execter,target,command2)*weaponRate/*generateRandomNumbers()*/;
            execter.takenDamage(allAttack);
        }else if(command2 == 1 || command2 == 2){
            allAttack = (execter.getAttack()+execter.getMG()+execter.getSP())*2.5-(target.getDefance()+target.getMG()+target.getSP())*7/3*defanceRate(target,execter,command2)*weaponRate/*generateRandomNumbers()*/;
            target.takenDamage(allAttack);
        }
        return allAttack;
    }

    //comand2の情報を呼び出す
    public int getComand2_アタッククラス(){
        return command2;
    }

    //防御コマンド選択メソッド
    public double defanceRate(FightCharacter execter, FightCharacter target,int command2){
        double result = 0;
        if(command2 == 1){
            result = a_df;
        }
        if (command2 == 2) {
            result = a_mdf;
        }
        if (command2 == 3) {
            result = a_counter;
        }
        return result;
    }

    //必殺*カウンターコマンド
    double value;
    public double 必殺カウンター(FightCharacter execter, FightCharacter target){
        value = ((second.getAttack()+second.getMG()+second.getSP())*2+first.getAttack()-first.getDefance())*2.0*weaponRate/*generateRandomNumbers()*/;
        return value;
    }


    //防御コマンド倍率
    double a_df = 0.68;
    double a_mdf = 0.73;
    double a_counter = value;
    double a_down = 1.07;

    //得意武器判断メソッド
    double weaponRate = 1.0;



    //0.95〜1.05の乱数を生成
    public static int generateRandomNumbers(){
        Random random = new Random();
        int number = random.nextInt(11) + 95;
        number = number*1/100;
        return number;
    }
    }

    class Win extends JPanel{
        Win(){
            setLayout(null);

            JButton map = new JButton("マップに戻る");
            map.setBounds(0,Main.HEIGHT-200, Main.WIDTH, 200);
            map.setFont(fm);
            add(map);

            ActionListener returnAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setFinish(true);

                    setVisible(false);

                    repaint();
                }
            };
            map.addActionListener(returnAction);

            JLabel winner = new JLabel();
            winner.setFont(fm);
            winner.setBounds(100, 10, 1300, 300);
            winner.setText(first.getName()+"が勝利しました！　"+first.getName()+"は"+second.getName()+"から"+(int) second.getMoney()/10+"円をもらいます！");
            first.setMoney(first.getMoney() + ((int) second.getMoney()/10));
            add(winner);
        }
    }
}
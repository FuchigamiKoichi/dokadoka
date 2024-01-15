package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class Pvn extends JPanel{
    FightCharacter player;
    FightCharacter enemy;

    static int WIDTH = Main.WIDTH/4 * 3;
    static int HEIGHT = Main.HEIGHT/4 * 3;

    Font fm = new Font("ＭＳ ゴシック", Font.BOLD, 40);

    boolean finish;

    int enemyschoice;

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public boolean getFinish(){
        return this.finish;
    }

    public int getenemyschoice() {
        return this.enemyschoice;
    }

    public void setenemyschoice() {
        Random random = new Random();
        this.enemyschoice = random.nextInt(3) + 1;
    }

    public FightCharacter getplayer() {
        return player;
    }

    public void setplayer(FightCharacter player) {
        this.player = player;
    }

    public FightCharacter getenemy() {
        return enemy;
    }

    public void setenemy(FightCharacter enemy) {
        this.enemy = enemy;
    }

    Pvn(FightCharacter player, FightCharacter enemy){
        setLayout(null);

        setPreferredSize(new Dimension(Pvn.WIDTH, Pvn.HEIGHT));

        this.finish = false;
        this.player = player;
        this.enemy = enemy;

        PlayerPanel pp = new PlayerPanel();
        pp.setBounds(0, 0, Pvn.WIDTH, Pvn.HEIGHT);
        add(pp);

        JLabel show = new JLabel("PVNが起動中");
        show.setFont(fm);
        show.setBounds(Pvn.WIDTH/3 * 2, 200, Pvn.WIDTH, Pvn.HEIGHT);
        pp.add(show);
    }


    /**
     * PlayerPanel
     */
    class PlayerPanel extends JPanel{
        PlayerPanel(){
            setLayout(null);

            Random r = new Random();
            int order = r.nextInt(2) + 1;

            if(order == 1){
                JButton attackButton = new JButton("攻撃");
                attackButton.setFont(fm);
                attackButton.setBounds(10, Pvn.HEIGHT - 110, 200, 100);
                add(attackButton);
    
                JButton magickButton = new JButton("魔法攻撃");
                magickButton.setFont(fm);
                magickButton.setBounds(220, Pvn.HEIGHT - 110, 200, 100);
                add(magickButton);
    
                JButton onepunchButton = new JButton("必殺攻撃");
                onepunchButton.setFont(fm);
                onepunchButton.setBounds(430, Pvn.HEIGHT - 110, 200, 100);
                add(onepunchButton);
    
                JButton buffButton = new JButton("バフ攻撃");
                buffButton.setFont(fm);
                buffButton.setBounds(640, Pvn.HEIGHT - 110, 200, 100);
                add(buffButton);
    
                JLabel turn = new JLabel(player.getName()+"のターン");
                turn.setBounds(0, 10, Pvn.WIDTH, 500);
                turn.setFont(fm);
                add(turn);
    
                JLabel HP = new JLabel(enemy.getName()+"のHPは"+String.valueOf(enemy.getHP())+"です");
                HP.setFont(fm);
                HP.setBounds(0, 300, Pvn.WIDTH, 500);
                add(HP);
    
                ActionListener attackAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setenemyschoice();
                        AttackComand atc = new AttackComand();
                        double damage = atc.Attack_method(player, enemy, getenemyschoice());
                        enemy.takenDamage(damage);
                        if(enemy.getDead()){
                            removeAll();

                            Win win = new Win(player,enemy);
                            win.setBounds(0, 0, Pvn.WIDTH, Pvn.HEIGHT);
                            add(win);

                            repaint();
                        }else{
                            removeAll();

                            PlayerPanel pp = new PlayerPanel();
                            pp.setBounds(0,0,Pvn.WIDTH,Pvn.HEIGHT);
                            add(pp);

                            repaint();
                        }
                    }
                };
                attackButton.addActionListener(attackAction);
    
                ActionListener magicAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setenemyschoice();
                        MagicalComand mc = new MagicalComand();
                        double damage = mc.Attack_method(player, enemy, getenemyschoice());
                        enemy.takenDamage(damage);
                        if(enemy.getDead()){
                            removeAll();

                            Win win = new Win(player,enemy);
                            win.setBounds(0, 0, Pvn.WIDTH, Pvn.HEIGHT);
                            add(win);

                            repaint();
                        }else{
                            removeAll();

                            PlayerPanel pp = new PlayerPanel();
                            pp.setBounds(0,0,Pvn.WIDTH,Pvn.HEIGHT);
                            add(pp);

                            repaint();
                        }
                    }
                };
                magickButton.addActionListener(magicAction);
    
                ActionListener onepuchAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setenemyschoice();
                        SpecialComand spc = new SpecialComand();
                        double damage = spc.Attack_method(player, enemy, getenemyschoice());
                        enemy.takenDamage(damage);
                        if(enemy.getDead()){
                            removeAll();

                            Win win = new Win(player, enemy);
                            win.setBounds(0, 0, Pvn.WIDTH, Pvn.HEIGHT);
                            add(win);

                            repaint();
                        }else{
                            removeAll();

                            PlayerPanel pp = new PlayerPanel();
                            pp.setBounds(0,0,Pvn.WIDTH,Pvn.HEIGHT);
                            add(pp);

                            repaint();
                        }
                    }
                };
                onepunchButton.addActionListener(onepuchAction);
    
                ActionListener buffAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getplayer().setAttack(getplayer().getAttack() * 2);

                        removeAll();

                        PlayerPanel pp = new PlayerPanel();
                        pp.setBounds(0,0,Pvn.WIDTH,Pvn.HEIGHT);
                        add(pp);

                        repaint();
                    }
                };
                buffButton.addActionListener(buffAction);
            }else{
                JButton defence = new JButton("防御");
                defence.setFont(fm);
                defence.setBounds(10, Pvn.HEIGHT - 110, 200, 100);
                add(defence);

                JButton magickDefence = new JButton("魔法防御");
                magickDefence.setFont(fm);
                magickDefence.setBounds(220, Pvn.HEIGHT - 110, 200, 100);
                add(magickDefence);

                JButton surrender = new JButton("降参");
                surrender.setFont(fm);
                surrender.setBounds(430, Pvn.HEIGHT - 110, 200, 100);
                add(surrender);

                JButton counter = new JButton("カウンター");
                counter.setFont(fm);
                counter.setBounds(640, Pvn.HEIGHT - 110, 200, 100);
                add(counter);

                JLabel turn = new JLabel(player.getName()+"のターン");
                turn.setBounds(0, 10, Pvn.WIDTH, 500);
                turn.setFont(fm);
                add(turn);

                JLabel HP = new JLabel("相手のHPは"+String.valueOf(enemy.getHP())+"です");
                HP.setFont(fm);
                HP.setBounds(0, 300, Pvn.WIDTH, 500);
                add(HP);

                ActionListener defenceAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setenemyschoice();
                        if(getenemyschoice() == 1){
                            AttackComand atc = new AttackComand();
                            double damage = atc.Attack_method(enemy, player, 1);
                            player.takenDamage(damage);
                            if(player.getDead()){
                                removeAll();

                                Win win = new Win(enemy, player);
                                win.setBounds(0, 0, Pvn.WIDTH, Pvn.HEIGHT);
                                add(win);

                                repaint();
                            }else{
                                removeAll();

                                PlayerPanel pp = new PlayerPanel();
                                pp.setBounds(0,0,Pvn.WIDTH,Pvn.HEIGHT);
                                add(pp);

                                repaint();
                            }
                        }else if(getenemyschoice() == 2){
                            MagicalComand mgc = new MagicalComand();
                            double damage = mgc.Attack_method(enemy, player, 1);
                            player.takenDamage(damage);
                            if(player.getDead()){
                                removeAll();

                                Win win = new Win(enemy, player);
                                win.setBounds(0, 0, Pvn.WIDTH, Pvn.HEIGHT);
                                add(win);

                                repaint();
                            }else{
                                removeAll();

                                PlayerPanel pp = new PlayerPanel();
                                pp.setBounds(0,0,Pvn.WIDTH,Pvn.HEIGHT);
                                add(pp);

                                repaint();
                            }
                        }else if(getenemyschoice() == 3){
                            SpecialComand spc = new SpecialComand();
                            double damage = spc.Attack_method(enemy, player, 1);
                            player.takenDamage(damage);
                            if(player.getDead()){
                                removeAll();

                                Win win = new Win(enemy, player);
                                win.setBounds(0, 0, Pvn.WIDTH, Pvn.HEIGHT);
                                add(win);

                                repaint();
                            }else{
                                removeAll();

                                PlayerPanel pp = new PlayerPanel();
                                pp.setBounds(0,0,Pvn.WIDTH,Pvn.HEIGHT);
                                add(pp);

                                repaint();
                            }
                        }
                    }
                };
                defence.addActionListener(defenceAction);

                ActionListener magickAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(getenemyschoice() == 1){
                            removeAll();

                            AttackComand atc = new AttackComand();
                            double damage = atc.Attack_method(enemy, player, 2);
                            player.takenDamage(damage);
                            if(player.getDead()){
                                removeAll();

                                Win win = new Win(enemy, player);
                                win.setBounds(0, 0, Pvn.WIDTH, Pvn.HEIGHT);
                                add(win);

                                repaint();
                            }else{
                                removeAll();

                                PlayerPanel pp = new PlayerPanel();
                                pp.setBounds(0,0,Pvn.WIDTH,Pvn.HEIGHT);
                                add(pp);

                                repaint();
                            }
                        }else if(getenemyschoice() == 2){
                            MagicalComand mgc = new MagicalComand();
                            double damage = mgc.Attack_method(enemy, player, 2);
                            player.takenDamage(damage);
                            if(player.getDead()){
                                removeAll();

                                Win win = new Win(enemy, player);
                                win.setBounds(0, 0, Pvn.WIDTH, Pvn.HEIGHT);
                                add(win);

                                repaint();
                            }else{
                                removeAll();

                                PlayerPanel pp = new PlayerPanel();
                                pp.setBounds(0,0,Pvn.WIDTH,Pvn.HEIGHT);
                                add(pp);

                                repaint();
                            }
                        }else if(getenemyschoice() == 3){
                            SpecialComand spc = new SpecialComand();
                            double damage = spc.Attack_method(enemy, player, 2);
                            player.takenDamage(damage);
                            if(player.getDead()){
                                removeAll();

                                Win win = new Win(enemy, player);
                                win.setBounds(0, 0, Pvn.WIDTH, Pvn.HEIGHT);
                                add(win);

                                repaint();
                            }else{
                                removeAll();

                                PlayerPanel pp = new PlayerPanel();
                                pp.setBounds(0,0,Pvn.WIDTH,Pvn.HEIGHT);
                                add(pp);

                                repaint();
                            }
                        }
                    }
                };
                magickDefence.addActionListener(magickAction);

                ActionListener counterAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(getenemyschoice() == 1){
                            AttackComand atc = new AttackComand();
                            double damage = atc.Attack_method(enemy, player, 3);
                            player.takenDamage(damage);
                            if(player.getDead()){
                                removeAll();

                                Win win = new Win(enemy, player);
                                win.setBounds(0, 0, Pvn.WIDTH, Pvn.HEIGHT);
                                add(win);

                                repaint();
                            }else{
                                removeAll();

                                PlayerPanel pp = new PlayerPanel();
                                pp.setBounds(0,0,Pvn.WIDTH,Pvn.HEIGHT);
                                add(pp);

                                repaint();
                            }
                        }else if(getenemyschoice() == 2){
                            MagicalComand mgc = new MagicalComand();
                            double damage = mgc.Attack_method(enemy, player, 3);
                            player.takenDamage(damage);
                            if(player.getDead()){
                                removeAll();

                                Win win = new Win(enemy, player);
                                win.setBounds(0, 0, Pvn.WIDTH, Pvn.HEIGHT);
                                add(win);

                                repaint();
                            }else{
                                removeAll();

                                PlayerPanel pp = new PlayerPanel();
                                pp.setBounds(0,0,Pvn.WIDTH,Pvn.HEIGHT);
                                add(pp);

                                repaint();
                            }
                        }else if(getenemyschoice() == 3){
                            SpecialComand spc = new SpecialComand();
                            double damage = spc.Attack_method(enemy, player, 3);
                            player.takenDamage(damage);
                            if(player.getDead()){
                                removeAll();

                                Win win = new Win(enemy, player);
                                win.setBounds(0, 0, Pvn.WIDTH, Pvn.HEIGHT);
                                add(win);

                                repaint();
                            }else{
                                removeAll();

                                PlayerPanel pp = new PlayerPanel();
                                pp.setBounds(0,0,Pvn.WIDTH,Pvn.HEIGHT);
                                add(pp);

                                repaint();
                            }
                        }
                    }
                };
                counter.addActionListener(counterAction);
            }
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
    FightCharacter player;
    FightCharacter enemy;
    int command2;//battleで呼び出す
    @Override
    public double Attack_method(FightCharacter execter, FightCharacter target,int command2){
        //必殺カウンターで使う
        this.player = execter;
        this.enemy = target;
        
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
        value = ((enemy.getAttack()+enemy.getMG()+enemy.getSP())*2+player.getAttack()-player.getDefance())*2.0*weaponRate/*generateRandomNumbers()*/;
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
        Win(FightCharacter winner, FightCharacter looser){
            setLayout(null);
            setFinish(true);
            
            JLabel win = new JLabel();
            win.setFont(fm);
            win.setBounds(0, 10, Pvn.WIDTH, 300);
            win.setText(winner.getName()+"が勝利しました！");

            JLabel get = new JLabel();
            get.setFont(fm);
            get.setBounds(0,200, Pvn.WIDTH, 300);
            get.setText(winner.getName()+"は"+looser.getName()+"から"+(int) looser.getMoney()/10+"円をもらいます！");

            winner.setMoney(winner.getMoney() + ((int) looser.getMoney()));
            add(win);
            add(get);
        }
    }
}
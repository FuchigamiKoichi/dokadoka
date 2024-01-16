package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle.*;
import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_sugoroku.*;

import javax.imageio.ImageIO;

class Test extends JPanel{
    int width;
    int height;
    String job;
    Test(String job, int width, int height){
        this.width = width;
        this.height = height;
        this.job = job;
        setPreferredSize(new Dimension(400,400));
        setOpaque(false);
    }

    public void paintComponent(Graphics g){
        BufferedImage imgTest = null;
        Graphics2D g2 = (Graphics2D) g;
        String pathTest = System.getProperty("user.dir") + "/app/src/main/java/jp/ac/uryukyu/ie/e235703_e235714_e235726_e235753_e235758/IMG/"+job+".png";

        try {
            imgTest = ImageIO.read(new File(pathTest));
        } catch (Exception e) {
            e.printStackTrace();
            imgTest = null;
        }
        g2.drawImage(imgTest, 0,0, this.width, this.height, this);
    }
}

/**
 * MV
 * 移動処理のための変数等の格納
 */
class MV extends JPanel{
    private Font fm = new Font("ＭＳ ゴシック", Font.BOLD, 40);

    private final int CHARACTERWIDTH = 50;
    private final int CHARACTERHEIGHT = 100;

    private int walk = 0; //キャラクターが何歩あるいたかを記録し、移動可能回数と比較する
    private Map world;
    private int Cuser = 0; //現在操作中のプレイヤー番号
    private ArrayList<User> users; //ユーザーを要素としてもつ配列
    private int Cpoint; //現在操作中のプレイヤーの現在地（マス番号）
    private int turn = 1; //現在のターン

    private int randomNumber; //すごろくが出した目

    MV(Map world){
        this.world = world;
        setOpaque(false);
        setLayout(null);
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int getCpoint() {
        return users.get(Cuser).getSpace().getPoint();
    }

    public void setCpoint(int cpoint) {
        Cpoint = cpoint;
    }

    public int getCx(int cp) {
        int cx;
        int xpoint = cp %  15;
        if(xpoint == 0){
            xpoint = 15;
        }
        cx = 96 * (xpoint - 1) + 20;
        return cx;
    }


    public int getCy(int cp) {
        int cy;
        int ypoint = (int) Math.ceil((double) cp / 15);
        cy = (int) ( 101.5*(ypoint - 1) ) + 20;
        return cy;
    }

    public int getCuser() {
        return Cuser;
    }

    public void setCuser(int cuser) {
        Cuser = cuser;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public int getWalk() {
        return walk;
    }

    public void setWalk(int walk) {
        this.walk = walk;
    }

    @Override
    protected void paintComponent(Graphics g) {
        JButton upButton = new JButton();
        JButton downButton = new JButton();
        JButton leftButton = new JButton();
        JButton rightButton = new JButton();

        JButton walkCharacter = new JButton();
        JButton Shuffle = new JButton();
        
        ActionListener upAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setWalk(getWalk() + 1); //歩数をカウントする

                Space way;
                way = world.getSpaces().get((getCpoint() - 15) - 1); //行き先(現在地の一マス上方)のspaceをとってくる
                getUsers().get(getCuser()).setSpace(way);            //キャラクターの現在地を行き先に上書き

                //ユーザーの再表示
                removeAll();

                for (User u : getUsers()){
                    Test test = new Test("warrior", 50, 100);
                    if(u.getFighter() instanceof Warrior){
                        test = new Test("warrior", 50, 100);
                    }else if(u.getFighter() instanceof Magician){
                        test = new Test("magician",50 , 100);
                    }else if(u.getFighter() instanceof Thief){
                        test = new Test("thief", 50, 100);
                    }
                    test.setBounds(getCx(u.getSpace().getPoint()), getCy(u.getSpace().getPoint()), CHARACTERWIDTH, CHARACTERHEIGHT);
                    add(test);
                }
                
                if(getRandomNumber() - getWalk()== 0){
                    removeAll();
                    setWalk(0);

                    boolean encount = false;
                    FightCharacter fighter1 = new Zombie();
                    FightCharacter fighter2 = new Zombie();

                    for(User user : getUsers()){
                        if((user.getSpace().getPoint() == getUsers().get(getCuser()).getSpace().getPoint()) && user != getUsers().get(getCuser())){
                            encount = true;

                            fighter1 = getUsers().get(getCuser()).getFighter();
                            fighter2 = user.getFighter();
                        }
                    }

                    if(encount){
                        Pvp battlePanel = new Pvp(fighter1, fighter2);
                        
                        JButton back = new JButton("マップに戻る");
                        back.setFont(fm);
                        back.setBounds(660, Main.HEIGHT - 70, 300, 70);
                        add(back);
                        ActionListener backAction = new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(battlePanel.getFinish()){
                                    removeAll();
                                    repaint();
                                }
                            };
                        };
                        back.addActionListener(backAction);

                        battlePanel.setBounds(Main.WIDTH/2 - Pvp.WIDTH/2 , Main.HEIGHT/2 - Pvp.HEIGHT/2 , Pvp.WIDTH , Pvp.HEIGHT);
                        add(battlePanel);
                        repaint();
                    }else if (getUsers().get(getCuser()).getSpace().getEvent().getName().equals("バトル")) {
                        Pvn battlePanel = new Pvn(getUsers().get(getCuser()).getFighter(), new Zombie());
                        
                        JButton back = new JButton("マップに戻る");
                        back.setFont(fm);
                        back.setBounds(660, Main.HEIGHT - 70, 300, 70);
                        add(back);
                        ActionListener backAction = new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(battlePanel.getFinish()){
                                    removeAll();
                                    repaint();
                                }
                            };
                        };
                        back.addActionListener(backAction);

                        battlePanel.setBounds(Main.WIDTH/2 - Pvp.WIDTH/2 , Main.HEIGHT/2 - Pvp.HEIGHT/2 , Pvp.WIDTH , Pvp.HEIGHT);
                        add(battlePanel);
                        repaint();
                    }
                    setCuser(getCuser() + 1);
                }else{
                    add(walkCharacter);
                }

                validate();
                repaint();
            }
        };
        upButton.setFont(fm);
        upButton.setText("上");
        upButton.addActionListener(upAction);

        ActionListener downAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setWalk(getWalk() + 1); //歩数をカウントする

                Space way;
                way = world.getSpaces().get((getCpoint() + 15) - 1); //行き先(現在地の一マス上方)のspaceをとってくる
                getUsers().get(getCuser()).setSpace(way);            //キャラクターの現在地を行き先に上書き

                 //ユーザーの再表示
                removeAll();

                for (User u : getUsers()){
                    Test test = new Test("warrior", 50, 100);
                    if(u.getFighter() instanceof Warrior){
                        test = new Test("warrior", 50, 100);
                    }else if(u.getFighter() instanceof Magician){
                        test = new Test("magician", 50, 100);
                    }else if(u.getFighter() instanceof Thief){
                        test = new Test("thief", 50, 100);
                    }
                    test.setBounds(getCx(u.getSpace().getPoint()), getCy(u.getSpace().getPoint()), CHARACTERWIDTH, CHARACTERHEIGHT);
                    add(test);
                }
                
                if(getRandomNumber() - getWalk()== 0){
                    removeAll();
                    setWalk(0);

                    boolean encount = false;
                    FightCharacter fighter1 = new Zombie();
                    FightCharacter fighter2 = new Zombie();

                    for(User user : getUsers()){
                        if((user.getSpace().getPoint() == getUsers().get(getCuser()).getSpace().getPoint()) && user != getUsers().get(getCuser())){
                            encount = true;

                            fighter1 = getUsers().get(getCuser()).getFighter();
                            fighter2 = user.getFighter();
                        }
                    }

                    if(encount){
                        Pvp battlePanel = new Pvp(fighter1, fighter2);
                        
                        JButton back = new JButton("マップに戻る");
                        back.setFont(fm);
                        back.setBounds(660, Main.HEIGHT - 70, 300, 70);
                        add(back);
                        ActionListener backAction = new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(battlePanel.getFinish()){
                                    removeAll();
                                    repaint();
                                }
                            };
                        };
                        back.addActionListener(backAction);

                        battlePanel.setBounds(Main.WIDTH/2 - Pvp.WIDTH/2 , Main.HEIGHT/2 - Pvp.HEIGHT/2 , Pvp.WIDTH , Pvp.HEIGHT);
                        add(battlePanel);
                        repaint();
                    }else if (getUsers().get(getCuser()).getSpace().getEvent().getName().equals("バトル")) {
                        Pvn battlePanel = new Pvn(getUsers().get(getCuser()).getFighter(), new Zombie());
                        
                        JButton back = new JButton("マップに戻る");
                        back.setFont(fm);
                        back.setBounds(660, Main.HEIGHT - 70, 300, 70);
                        add(back);
                        ActionListener backAction = new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(battlePanel.getFinish()){
                                    removeAll();
                                    repaint();
                                }
                            };
                        };
                        back.addActionListener(backAction);

                        battlePanel.setBounds(Main.WIDTH/2 - Pvp.WIDTH/2 , Main.HEIGHT/2 - Pvp.HEIGHT/2 , Pvp.WIDTH , Pvp.HEIGHT);
                        add(battlePanel);
                        repaint();
                    }
                    setCuser(getCuser() + 1);
                }else{
                    add(walkCharacter);
                }
                
                validate();
                repaint();
            }
        };
        downButton.setFont(fm);
        downButton.setText("下");
        downButton.addActionListener(downAction);

        ActionListener leftAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setWalk(getWalk() + 1); //歩数をカウントする

                Space way;
                way = world.getSpaces().get((getCpoint() - 1) - 1); //行き先(現在地の一マス上方)のspaceをとってくる
                getUsers().get(getCuser()).setSpace(way);            //キャラクターの現在地を行き先に上書き

                //ユーザーの再表示
                removeAll();

                for (User u : getUsers()){
                    Test test = new Test("warrior", 50, 100);
                    if(u.getFighter() instanceof Warrior){
                        test = new Test("warrior", 50, 100);
                    }else if(u.getFighter() instanceof Magician){
                        test = new Test("magician", 50, 100);
                    }else if(u.getFighter() instanceof Thief){
                        test = new Test("thief", 50, 100);
                    }
                    test.setBounds(getCx(u.getSpace().getPoint()), getCy(u.getSpace().getPoint()), CHARACTERWIDTH, CHARACTERHEIGHT);
                    add(test);
                }
                
                if(getRandomNumber() - getWalk()== 0){
                    removeAll();
                    setWalk(0);

                    boolean encount = false;
                    FightCharacter fighter1 = new Zombie();
                    FightCharacter fighter2 = new Zombie();

                    for(User user : getUsers()){
                        if((user.getSpace().getPoint() == getUsers().get(getCuser()).getSpace().getPoint()) && user != getUsers().get(getCuser())){
                            encount = true;

                            fighter1 = getUsers().get(getCuser()).getFighter();
                            fighter2 = user.getFighter();
                        }
                    }

                    if(encount){
                        Pvp battlePanel = new Pvp(fighter1, fighter2);
                        
                        JButton back = new JButton("マップに戻る");
                        back.setFont(fm);
                        back.setBounds(660, Main.HEIGHT - 70, 300, 70);
                        add(back);
                        ActionListener backAction = new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(battlePanel.getFinish()){
                                    removeAll();
                                    repaint();
                                }
                            };
                        };
                        back.addActionListener(backAction);

                        battlePanel.setBounds(Main.WIDTH/2 - Pvp.WIDTH/2 , Main.HEIGHT/2 - Pvp.HEIGHT/2 , Pvp.WIDTH , Pvp.HEIGHT);
                        add(battlePanel);
                        repaint();
                    }else if (getUsers().get(getCuser()).getSpace().getEvent().getName().equals("バトル")) {
                        Pvn battlePanel = new Pvn(getUsers().get(getCuser()).getFighter(), new Zombie());
                        
                        JButton back = new JButton("マップに戻る");
                        back.setFont(fm);
                        back.setBounds(660, Main.HEIGHT - 70, 300, 70);
                        add(back);
                        ActionListener backAction = new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(battlePanel.getFinish()){
                                    removeAll();
                                    repaint();
                                }
                            };
                        };
                        back.addActionListener(backAction);

                        battlePanel.setBounds(Main.WIDTH/2 - Pvp.WIDTH/2 , Main.HEIGHT/2 - Pvp.HEIGHT/2 , Pvp.WIDTH , Pvp.HEIGHT);
                        add(battlePanel);
                        repaint();
                    }
                    setCuser(getCuser() + 1);
                }else{
                    add(walkCharacter);
                }
                
                validate();
                repaint();
            }
        };
        leftButton.setFont(fm);
        leftButton.setText("左");
        leftButton.addActionListener(leftAction);

        ActionListener rightAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setWalk(getWalk() + 1); //歩数をカウントする

                Space way;
                way = world.getSpaces().get((getCpoint() + 1) - 1); //行き先(現在地の一マス上方)のspaceをとってくる
                getUsers().get(getCuser()).setSpace(way);            //キャラクターの現在地を行き先に上書き

                //ユーザーの再表示
                removeAll();

                for (User u : getUsers()){
                    Test test = new Test("warrior", 50, 100);
                    if(u.getFighter() instanceof Warrior){
                        test = new Test("warrior", 50, 100);
                    }else if(u.getFighter() instanceof Magician){
                        test = new Test("magician", 50, 100);
                    }else if(u.getFighter() instanceof Thief){
                        test = new Test("thief", 50, 100);
                    }
                    test.setBounds(getCx(u.getSpace().getPoint()), getCy(u.getSpace().getPoint()), CHARACTERWIDTH, CHARACTERHEIGHT);
                    add(test);
                }
                
                if(getRandomNumber() - getWalk()== 0){
                    removeAll();
                    setWalk(0);

                    boolean encount = false;
                    FightCharacter fighter1 = new Zombie();
                    FightCharacter fighter2 = new Zombie();

                    for(User user : getUsers()){
                        if((user.getSpace().getPoint() == getUsers().get(getCuser()).getSpace().getPoint()) && user != getUsers().get(getCuser())){
                            encount = true;

                            fighter1 = getUsers().get(getCuser()).getFighter();
                            fighter2 = user.getFighter();
                        }
                    }

                    if(encount){
                        Pvp battlePanel = new Pvp(fighter1, fighter2);
                        
                        JButton back = new JButton("マップに戻る");
                        back.setFont(fm);
                        back.setBounds(660, Main.HEIGHT - 70, 300, 70);
                        add(back);
                        ActionListener backAction = new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(battlePanel.getFinish()){
                                    removeAll();
                                    repaint();
                                }
                            };
                        };
                        back.addActionListener(backAction);

                        battlePanel.setBounds(Main.WIDTH/2 - Pvp.WIDTH/2 , Main.HEIGHT/2 - Pvp.HEIGHT/2 , Pvp.WIDTH , Pvp.HEIGHT);
                        add(battlePanel);
                        repaint();
                    }else if (getUsers().get(getCuser()).getSpace().getEvent().getName().equals("バトル")) {
                        Pvn battlePanel = new Pvn(getUsers().get(getCuser()).getFighter(), new Zombie());
                        
                        JButton back = new JButton("マップに戻る");
                        back.setFont(fm);
                        back.setBounds(660, Main.HEIGHT - 70, 300, 70);
                        add(back);
                        ActionListener backAction = new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(battlePanel.getFinish()){
                                    removeAll();
                                    repaint();
                                }
                            };
                        };
                        back.addActionListener(backAction);

                        battlePanel.setBounds(Main.WIDTH/2 - Pvp.WIDTH/2 , Main.HEIGHT/2 - Pvp.HEIGHT/2 , Pvp.WIDTH , Pvp.HEIGHT);
                        add(battlePanel);
                        repaint();
                    }
                    setCuser(getCuser() + 1);
                }else{
                    add(walkCharacter);
                }

                validate();
                repaint();
            }
        };
        rightButton.setFont(fm);
        rightButton.setText("右");
        rightButton.addActionListener(rightAction);


        ActionListener walk = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                Bottom bt = new Bottom();
                bt.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
                bt.setLayout(null);
                add(bt);

                JLabel turn = new JLabel(String.valueOf(getRandomNumber() - getWalk()));
                turn.setFont(fm);
                bt.add(turn);

                for (User u : getUsers()){
                    Test test = new Test("warrior", 50, 100);
                    if(u.getFighter() instanceof Warrior){
                        test = new Test("warrior", 50, 100);
                    }else if(u.getFighter() instanceof Magician){
                        test = new Test("magician",50, 100);
                    }else if(u.getFighter() instanceof Thief){
                        test = new Test("thief", 50, 100);
                    }
                    test.setBounds(getCx(u.getSpace().getPoint()), getCy(u.getSpace().getPoint()), CHARACTERWIDTH, CHARACTERHEIGHT);
                    bt.add(test);
                }

                if (getWalk() < getRandomNumber()){
                    for(int way : getUsers().get(getCuser()).getSpace().getWays()){
                        if((way - getCpoint()) == -15){
                            upButton.setBounds(getCx(getCpoint()), getCy(getCpoint()) - 100, 50, 50);
                            upButton.setFont(fm);
                            upButton.setText("上");
                            bt.add(upButton);

                            turn.setText(String.valueOf(getRandomNumber() - getWalk()));
                            turn.setBounds(getCx(getCpoint()) + 100, getCy(getCpoint()) - 100, 50, 100);
                        }else if((way - getCpoint()) == 15){
                            downButton.setBounds(getCx(getCpoint()), getCy(getCpoint()) + 125, 50, 50);
                            downButton.setFont(fm);
                            downButton.setText("下");
                            bt.add(downButton);

                            turn.setText(String.valueOf(getRandomNumber() - getWalk()));
                            turn.setBounds(getCx(getCpoint()) + 100, getCy(getCpoint()) - 100, 50, 100);
                        }else if((way - getCpoint()) == -1){
                            leftButton.setBounds(getCx(getCpoint()) - 100, getCy(getCpoint()), 50, 50);
                            leftButton.setFont(fm);
                            leftButton.setText("左");
                            bt.add(leftButton);

                            turn.setText(String.valueOf(getRandomNumber() - getWalk()));
                            turn.setBounds(getCx(getCpoint()) + 100, getCy(getCpoint()) - 100, 50, 100);
                        }else if((way - getCpoint()) == 1){
                            rightButton.setBounds(getCx(getCpoint()) + 100, getCy(getCpoint()), 50, 50);
                            rightButton.setFont(fm);
                            rightButton.setText("右");
                            bt.add(rightButton);

                            turn.setText(String.valueOf(getRandomNumber() - getWalk()));
                            turn.setBounds(getCx(getCpoint()) + 100, getCy(getCpoint()) - 100, 50, 100);
                        }
                    }
                    if((getWalk() - getRandomNumber()) == 1){
                        Shuffle.setBounds(0, Main.HEIGHT - 70, 300, 70);
                        Shuffle.setFont(fm);
                        Shuffle.setText("ダイスを振る！");
                    }
                }else{
                    remove(bt);
                    setWalk(0);
                    setCuser(getCuser() + 1);
                }
                validate();
                repaint();
            }
        };
        walkCharacter.setFont(fm);
        walkCharacter.setText("歩く！");
        walkCharacter.addActionListener(walk);

        ActionListener shuffleAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();

                Bottom dicepanel = new Bottom();
                dicepanel.setBounds(Main.WIDTH-220, 20, 200, 100);
                add(dicepanel);

                TurnShow ts = new TurnShow();
                ts.setBounds(Main.WIDTH - 700, Main.HEIGHT - 70, 600, 70);
                add(ts);

                JLabel turnShow = new JLabel();
                turnShow.setFont(fm);
                turnShow.setBounds(0, 0, 600, 70);
                ts.add(turnShow);

                if(getCuser() < getUsers().size()){

                    turnShow.setText(String.valueOf(getTurn()) + "　:　" +String.valueOf(getUsers().get(getCuser()).getPlayerName())+"のターン");

                    Random r = new Random();
                    int randomNumber = r.nextInt(6) + 1;
                    dicepanel.removeAll();

                    if(randomNumber == 1){
                        Dice1 d1 = new Dice1();
                        d1.setBounds(0,0,100,100);
                        dicepanel.add(d1);
                    }else if(randomNumber == 2){
                        Dice2 d2 = new Dice2();
                        d2.setBounds(0,0,100,100);
                        dicepanel.add(d2);
                    }else if(randomNumber == 3){
                        Dice3 d3 = new Dice3();
                        d3.setBounds(0,0,100,100);
                        dicepanel.add(d3);
                    }else if(randomNumber == 4){
                        Dice4 d4 = new Dice4();
                        d4.setBounds(0,0,100,100);
                        dicepanel.add(d4);
                    }else if(randomNumber == 5){
                        Dice5 d5 = new Dice5();
                        d5.setBounds(0,0,100,100);
                        dicepanel.add(d5);
                    }else if(randomNumber == 6){
                        Dice6 d6 = new Dice6();
                        d6.setBounds(0,0,100,100);
                        dicepanel.add(d6);
                    }

                    setRandomNumber(randomNumber);
                    Bottom bottom = new Bottom();
                    bottom.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
                    add(bottom);
                    walkCharacter.setBounds(330, Main.HEIGHT - 70, 300, 70);
                    bottom.add(walkCharacter);
                    
                    validate();
                    repaint();
                }else{
                    if (getTurn() < 5) {
                        setCuser(0);
                        setTurn(getTurn() + 1);

                        turnShow.setText(String.valueOf(getTurn()) + "　:　" +String.valueOf(getUsers().get(getCuser()).getPlayerName())+"　のターン");

                        Random r = new Random();
                        int randomNumber = r.nextInt(6) + 1;
                        dicepanel.removeAll();

                        if(randomNumber == 1){
                            Dice1 d1 = new Dice1();
                            d1.setBounds(0,0,100,100);
                            dicepanel.add(d1);
                        }else if(randomNumber == 2){
                            Dice2 d2 = new Dice2();
                            d2.setBounds(0,0,100,100);
                            dicepanel.add(d2);
                        }else if(randomNumber == 3){
                            Dice3 d3 = new Dice3();
                            d3.setBounds(0,0,100,100);
                            dicepanel.add(d3);
                        }else if(randomNumber == 4){
                            Dice4 d4 = new Dice4();
                            d4.setBounds(0,0,100,100);
                            dicepanel.add(d4);
                        }else if(randomNumber == 5){
                            Dice5 d5 = new Dice5();
                            d5.setBounds(0,0,100,100);
                            dicepanel.add(d5);
                        }else if(randomNumber == 6){
                            Dice6 d6 = new Dice6();
                            d6.setBounds(0,0,100,100);
                            dicepanel.add(d6);
                        }

                        setRandomNumber(randomNumber);
                        Bottom bottom = new Bottom();
                        bottom.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
                        add(bottom);
                        walkCharacter.setBounds(330, Main.HEIGHT - 70, 300, 70);
                        bottom.add(walkCharacter);
                        
                        validate();
                        repaint();
                    }else{
                        System.out.println("ゲームが終了");
                    }
                }
            }
        };
        Shuffle.addActionListener(shuffleAction);

        Shuffle.setBounds(0, Main.HEIGHT - 70, 300, 70);
        Shuffle.setFont(fm);
        Shuffle.setText("ダイスを振る！");
        add(Shuffle);
    }
}


class Bottom extends JPanel{
    Bottom(){
        setOpaque(false);
        setLayout(null);
    }
}
package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;
import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle.*;
import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_sugoroku.*;

import javax.imageio.ImageIO;

class Test extends JPanel{
    Test(){
        setPreferredSize(new Dimension(400,400));
        setOpaque(false);
    }

    public void paintComponent(Graphics g){
        BufferedImage imgTest = null;
        Graphics2D g2 = (Graphics2D) g;
        String pathTest = System.getProperty("user.dir") + "/app/src/main/java/jp/ac/uryukyu/ie/e235703_e235714_e235726_e235753_e235758/IMG/Test.png";

        try {
            imgTest = ImageIO.read(new File(pathTest));
        } catch (Exception e) {
            e.printStackTrace();
            imgTest = null;
        }
        g2.drawImage(imgTest, 0,0, 50,100, this);
    }
}

/**
 * MV
 * 移動処理のための変数等の格納
 */
class MV {
    private Font fm = new Font("ＭＳ ゴシック", Font.BOLD, 40);

    private final int CHARACTERWIDTH = 50;
    private final int CHARACTERHEIGHT = 100;

    private int walk = 0; //キャラクターが何歩あるいたかを記録し、移動可能回数と比較する
    private int limit; //移動可能限界回数、移動できる最大の歩数
    private Map world;
    private int Cuser = 0; //現在操作中のプレイヤー番号
    private ArrayList<User> users; //ユーザーを要素としてもつ配列
    private int Cpoint; //現在操作中のプレイヤーの現在地（マス番号）

    private int randomNumber; //すごろくが出した目

    MV(Map world){
        this.world = world;
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
        cx = 96 * (xpoint - 1) + 20;
        return cx;
    }


    public int getCy(int cp) {
        int cy;
        int ypoint = (int) Math.ceil(cp / 15);
        cy = (int) ( 101.5*ypoint ) + 20;
        return cy;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
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

    /**
     * UButton
     * キャラクターを上方に一マス移動させる
     */
    public class UButton extends JButton {
        @Override
        public void addActionListener(java.awt.event.ActionListener l) {
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setWalk(getWalk() + 1); //歩数をカウントする

                    Space way;
                    way = world.getSpaces().get((getCpoint() - 15) - 1); //行き先(現在地の一マス上方)のspaceをとってくる
                    getUsers().get(getCuser()).setSpace(way);            //キャラクターの現在地を行き先に上書き

                    //ユーザーの再表示
                    removeAll();

                    for (User u : getUsers()){
                        Test test = new Test();
                        test.setBounds(getCx(u.getSpace().getPoint()), getCy(u.getSpace().getPoint()), CHARACTERWIDTH, CHARACTERHEIGHT);
                    }
                    
                    validate();
                    repaint();
                }
            };
        }
    }

    /**
     * DButton
     * キャラクターを上方に一マス移動させる
     */
    public class DButton extends JButton {
        @Override
        public void addActionListener(java.awt.event.ActionListener l) {
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setWalk(getWalk() + 1); //歩数をカウントする

                    Space way;
                    way = world.getSpaces().get((getCpoint() + 15) - 1); //行き先(現在地の一マス上方)のspaceをとってくる
                    getUsers().get(getCuser()).setSpace(way);            //キャラクターの現在地を行き先に上書き

                    //ユーザーの再表示
                    removeAll();

                    for (User u : getUsers()){
                        Test test = new Test();
                        test.setBounds(getCx(u.getSpace().getPoint()), getCy(u.getSpace().getPoint()), CHARACTERWIDTH, CHARACTERHEIGHT);
                    }
                    
                    validate();
                    repaint();
                }
            };
        }
    }

    /**
     * RButton
     * キャラクターを右に一マス移動させる
     */
    public class RButton extends JButton {
        @Override
        public void addActionListener(java.awt.event.ActionListener l) {
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setWalk(getWalk() + 1); //歩数をカウントする

                    Space way;
                    way = world.getSpaces().get((getCpoint() + 1) - 1); //行き先(現在地の一マス上方)のspaceをとってくる
                    getUsers().get(getCuser()).setSpace(way);            //キャラクターの現在地を行き先に上書き

                    //ユーザーの再表示
                    removeAll();

                    for (User u : getUsers()){
                        Test test = new Test();
                        test.setBounds(getCx(u.getSpace().getPoint()), getCy(u.getSpace().getPoint()), CHARACTERWIDTH, CHARACTERHEIGHT);
                    }
                    
                    validate();
                    repaint();
                }
            };
        }
    }

    /**
     * LButton
     * キャラクターを左に一マス移動させる
     */
    public class LButton extends JButton {
        @Override
        public void addActionListener(java.awt.event.ActionListener l) {
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setWalk(getWalk() + 1); //歩数をカウントする

                    Space way;
                    way = world.getSpaces().get((getCpoint() - 1) - 1); //行き先(現在地の一マス上方)のspaceをとってくる
                    getUsers().get(getCuser()).setSpace(way);            //キャラクターの現在地を行き先に上書き

                    //ユーザーの再表示
                    removeAll();

                    for (User u : getUsers()){
                        Test test = new Test();
                        test.setBounds(getCx(u.getSpace().getPoint()), getCy(u.getSpace().getPoint()), CHARACTERWIDTH, CHARACTERHEIGHT);
                    }
                    
                    validate();
                    repaint();
                }
            };
        }
    }

    /**
     * walkCharacter
     * 歩くボタンの実装
     * プレイヤーが選択可能な行き先を提示し、移動するボタン（UButton,DButton,LButton,RButton）を設置
     */
    public class walkCharacter extends JButton{
        @Override
        public void addActionListener(ActionListener l) {
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeAll();
                    Bottom bt = new Bottom();
                    bt.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
                    bt.setLayout(null);
                    add(bt);

                    JLabel turn = new JLabel(String.valueOf(getRandomNumber() - getWalk()));
                    turn.setBounds(getCx(getCpoint()) + 20, getCy(getCpoint()) - 100, 400, 400);
                    bt.add(turn);

                    if (getWalk() < getRandomNumber()){
                        for(int way : getUsers().get(getCuser()).getSpace().getWays()){
                            if((way - getCpoint()) == -15){
                                UButton upButton = new UButton();
                                upButton.setBounds(getCx(getCpoint()) - 150, getCy(getCpoint()) - 100, 400, 400);
                                upButton.setFont(fm);
                                upButton.setText("上");
                                bt.add(upButton);

                                turn.setText(String.valueOf(getRandomNumber() - getWalk()));
                                turn.setBounds(getCx(getCpoint()) + 20, getCy(getCpoint()) - 100, 400, 400);
                            }else if((way - getCpoint()) == 15){
                                DButton downButton = new DButton();
                                downButton.setBounds(getCx(getCpoint()) - 150, getCy(getCpoint()) + 125, 400, 400);
                                downButton.setFont(fm);
                                downButton.setText("下");
                                bt.add(downButton);

                                turn.setText(String.valueOf(getRandomNumber() - getWalk()));
                                turn.setBounds(getCx(getCpoint()) + 20, getCy(getCpoint()) - 100, 400, 400);
                            }else if((way - getCpoint()) == -1){
                                LButton leftbuButton = new LButton();
                                leftbuButton.setBounds(getCx(getCpoint()) - 300, getCy(getCpoint()), 400, 400);
                                leftbuButton.setFont(fm);
                                leftbuButton.setText("左");
                                bt.add(leftbuButton);

                                turn.setText(String.valueOf(getRandomNumber() - getWalk()));
                                turn.setBounds(getCx(getCpoint()) + 20, getCy(getCpoint()) - 100, 400, 400);
                            }else if((way - getCpoint()) == 1){
                                RButton rightButton = new RButton();
                                rightButton.setBounds(getCx(getCpoint()) + 100, getCy(getCpoint()), 400, 400);
                                rightButton.setFont(fm);
                                rightButton.setText("右");
                                bt.add(rightButton);

                                turn.setText(String.valueOf(getRandomNumber() - getWalk()));
                                turn.setBounds(getCx(getCpoint()) + 20, getCy(getCpoint()) - 100, 400, 400);
                            }
                        }
                        if((getWalk() - getRandomNumber()) == 1){
                            Shuffle dicebutton = new Shuffle();
                            dicebutton.setBounds(0, Main.HEIGHT - 70, 300, 70);
                            dicebutton.setFont(fm);
                            dicebutton.setText("ダイスを振る！");
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
        }
    }

    public class Shuffle extends JButton{
        @Override
        public void addActionListener(ActionListener l) {
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeAll();
                    Bottom dicepanel = new Bottom();
                    dicepanel.setBounds(Main.WIDTH-220, 20, 200, 100);
                    add(dicepanel);

                    if(getCuser() < getUsers().size()){
                        Random r = new Random();
                        int randomNumber = r.nextInt(6) + 1;
                        dicepanel.removeAll();

                        if(randomNumber == 1){
                            dicepanel.add(new Dice1());
                        }else if(randomNumber == 2){
                            dicepanel.add(new Dice2());
                        }else if(randomNumber == 3){
                            dicepanel.add(new Dice3());
                        }else if(randomNumber == 4){
                            dicepanel.add(new Dice4());
                        }else if(randomNumber == 5){
                            dicepanel.add(new Dice5());
                        }else if(randomNumber == 6){
                            dicepanel.add(new Dice6());
                        }

                        setRandomNumber(randomNumber);
                        Bottom bottom = new Bottom();
                        walkCharacter wc = new walkCharacter();
                        bottom.add(wc);
                    }
                }
            };
        }
    }
}

class Bottom extends JPanel{
    Bottom(){
        setOpaque(false);
    }
}
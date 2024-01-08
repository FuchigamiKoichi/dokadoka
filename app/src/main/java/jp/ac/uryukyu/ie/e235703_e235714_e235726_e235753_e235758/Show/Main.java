package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;

import java.io.FileInputStream;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import java.util.Random;

import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show.*;
import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle.*;
import jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_sugoroku.*;;


public class Main extends JFrame{
    int user = 1;             //登録中のプレイヤー番号
    static int member = 1;    //登録されたプレイヤー人数
    int cturn = 1;            //現在のターン数
    int cuser = 0;            //現在操作中のプレイヤー番号
    ArrayList<User> users;    //プレイヤーを格納する配列
    int walk = 0;                 //操作中のプレイヤーの何マス移動したか
    

    User usr;
    Space clocate;
    int cpoint;
    int cx;
    int cy;

    static int WIDTH = 1470;  //画面幅
    static int HEIGHT = 940;  //画面高さ
    int startSpace;  //スタート地点のマス番号

    Font fm = new Font("ＭＳ ゴシック", Font.BOLD, 40);
    int TURN = 20;  //ゲームの総ターン数
    Map world = new Map(1);
    ArrayList<Space> spaces = world.getSpaces();

  public static void main(String args[]) throws Exception{
    int WIDTH = Main.WIDTH;
    int HEIGHT = Main.HEIGHT;

    //画面の生成
    Main frame = new Main();
    frame.setTitle("どかどかゲーム");
    GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    device.setFullScreenWindow(frame);  //フルスクリーン設定
    frame.setBounds(0, 0, WIDTH, HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}

  Main() throws Exception{
    for(Space space : spaces){
        if (space.getEvent().getName().equals("スタート")){
            startSpace = space.getPoint();
        }
    }

    //結果画面
    Result result = new Result();

    //すごろく画面
    Sugo map = new Sugo();
    map.setLayout(null);

    Bottom bt = new Bottom();
    bt.setLayout(null);
    bt.setBounds(0, 0, WIDTH, HEIGHT);
    map.add(bt);

    DicePanel dicePanel = new DicePanel();  //すごろくの目の画像を貼るためのパネル
    dicePanel.setBounds(WIDTH - 220,20,200,100);
    map.add(dicePanel);

    TurnShow ts = new TurnShow();           //ターン数と操作中のプレイヤーの名前を表示するパネル
    ts.setBounds(WIDTH - 600, HEIGHT-60, 400, 50);
    map.add(ts);

    JLabel tn = new JLabel();
    tn.setFont(fm);
    ts.add(tn);

    JButton random = new JButton("ダイスを振る！");   //ダイスを振るボタン
    random.setFont(fm);
    random.setBounds(0,HEIGHT-70,300,70);
    ActionListener randomaction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(cuser < users.size()){
                usr = users.get(cuser);
                clocate = usr.getSpace();
                cpoint = clocate.getPoint();
                walk = 0;

                cx = getx(clocate.getPoint());
                cy = gety(clocate.getPoint());

                tn.setText(String.valueOf(cturn) +" : "+ usr.getPlayerName() + "のターン");
                validate();

                Random rm = new Random();
                int randomNumber = rm.nextInt(6) + 1;
                dicePanel.removeAll();

                
                if(randomNumber == 1){
                    dicePanel.add(new Dice1());
                }else if(randomNumber == 2){
                    dicePanel.add(new Dice2());
                }else if(randomNumber == 3){
                    dicePanel.add(new Dice3());
                }else if(randomNumber == 4){
                    dicePanel.add(new Dice4());
                }else if(randomNumber == 5){
                    dicePanel.add(new Dice5());
                }else if(randomNumber == 6){
                    dicePanel.add(new Dice6());
                }

                JButton walkCharacter = new JButton("歩く");
                walkCharacter.setBounds(330, HEIGHT - 70, 300, 70);
                walkCharacter.setFont(fm);
                ActionListener walkAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (walk < randomNumber){
                            usr = users.get(cuser);
                            clocate = usr.getSpace();
                            cpoint = clocate.getPoint();
                            cx = getx(users.get(cuser).getSpace().getPoint());
                            cy = gety(users.get(cuser).getSpace().getPoint());

                            for(int way : spaces.get(cpoint - 1).getWays()){
                                if((way - cpoint) == -15){
                                    Move up = new Move();
                                    JButton upButton = new JButton();
                                    ActionListener upAction = new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            walk++;

                                            users.get(cuser).setSpace(spaces.get(way-1));
                                            bt.removeAll();

                                            for(User user : users){
                                                Test test =  new Test();
                                                test.setBounds(getx(user.getSpace().getPoint()), gety(user.getSpace().getPoint()), 50, 100);
                                                bt.add(test);
                                            }

                                            bt.add(walkCharacter);
                                            validate();
                                            repaint();
                                        };
                                    };
                                    upButton.addActionListener(upAction);

                                    up.setBounds(cx - 150, cy - 100, 400, 400);
                                    bt.add(up);
                                    upButton.setFont(fm);
                                    upButton.setText("上");
                                    up.add(upButton);
                                }else if ((way - cpoint) == -1){
                                    Move left = new Move();

                                    JButton leftButton = new JButton();
                                    ActionListener leftAction =  new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            walk++;

                                            users.get(cuser).setSpace(spaces.get(way-1));
                                            bt.removeAll();

                                            for(User user : users){
                                                Test test =  new Test();
                                                test.setBounds(getx(user.getSpace().getPoint()), gety(user.getSpace().getPoint()), 50, 100);
                                                bt.add(test);
                                            }

                                            bt.add(walkCharacter);
                                            validate();
                                            repaint();
                                        };
                                    };
                                    leftButton.addActionListener(leftAction);

                                    left.setBounds(cx - 500, cy, 400,400);
                                    bt.add(left);
                                    leftButton.setFont(fm);
                                    leftButton.setText("左");
                                    left.add(leftButton);
                                }else if ((way - cpoint == 1)){
                                    Move right = new Move();

                                    JButton rightButton = new JButton();
                                    ActionListener rigAction = new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            walk++;

                                            users.get(cuser).setSpace(spaces.get(way-1));

                                            bt.removeAll();

                                            for(User user : users){
                                                Test test =  new Test();
                                                test.setBounds(getx(user.getSpace().getPoint()), gety(user.getSpace().getPoint()), 50, 100);
                                                bt.add(test);
                                            }

                                            bt.add(walkCharacter);
                                            validate();
                                            repaint();
                                        };
                                    };
                                    rightButton.addActionListener(rigAction);

                                    right.setBounds(cx + 100, cy, 400,400);
                                    bt.add(right);
                                    rightButton.setFont(fm);
                                    rightButton.setText("右");
                                    right.add(rightButton);
                                }else if((way - cpoint) == 15){
                                    Move down = new Move();

                                    JButton downButton = new JButton();
                                    ActionListener downAction = new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            walk++;

                                            users.get(cuser).setSpace(spaces.get(way-1));

                                            bt.removeAll();

                                            for(User user : users){
                                                Test test =  new Test();
                                                test.setBounds(getx(user.getSpace().getPoint()), gety(user.getSpace().getPoint()), 50, 100);
                                                bt.add(test);
                                            }

                                            bt.add(walkCharacter);
                                            validate();
                                            repaint();
                                        };
                                    };
                                    downButton.addActionListener(downAction);

                                    down.setBounds(cx - 150, cy + 125, 400, 400);
                                    bt.add(down);
                                    downButton.setFont(fm);
                                    downButton.setText("下");
                                    down.add(downButton);
                                }
                            }
                        validate();
                        repaint();
                        }else{
                            walk = 0;
                            cuser++;
                            bt.add(random);
                            validate();
                            repaint();
                        }
                    };
                };
                walkCharacter.addActionListener(walkAction);

                bt.add(walkCharacter);
            }else{
                if(cturn <= TURN - 1){
                    cuser = 0;
                    cturn += 1;

                    bt.removeAll();
                    usr = users.get(cuser);
                    clocate = usr.getSpace();
                    cpoint = clocate.getPoint();
                    walk = 0;

                    for(User user : users){
                        Test test =  new Test();
                        test.setBounds(getx(user.getSpace().getPoint()), gety(user.getSpace().getPoint()), 50, 100);
                        bt.add(test);
                    }

                    cx = getx(clocate.getPoint());
                    cy = gety(clocate.getPoint());

                    tn.setText(String.valueOf(cturn) +" : "+ usr.getPlayerName() + "のターン");

                    Random r = new Random();
                    int rN = r.nextInt(6) + 1;
                    dicePanel.removeAll();
                    
                    if(rN == 1){
                        dicePanel.add(new Dice1());
                    }else if(rN == 2){
                        dicePanel.add(new Dice2());
                    }else if(rN == 3){
                        dicePanel.add(new Dice3());
                    }else if(rN == 4){
                        dicePanel.add(new Dice4());
                    }else if(rN == 5){
                        dicePanel.add(new Dice5());
                    }else if(rN == 6){
                        dicePanel.add(new Dice6());
                    }

                    JButton wC = new JButton("歩く");
                    wC.setBounds(330, HEIGHT - 70, 300, 70);
                    wC.setFont(fm);
                    ActionListener wA = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (walk < rN){
                                cuser = 0;
                                for(int way : spaces.get(cpoint - 1).getWays()){
                                    if((way - cpoint) == -15){
                                        Move up = new Move();
                                        JButton upButton = new JButton();
                                        ActionListener upAction = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                walk++;

                                                users.get(cuser).setSpace(spaces.get(way-1));
                                                bt.removeAll();

                                                for(User user : users){
                                                    Test test =  new Test();
                                                    test.setBounds(getx(user.getSpace().getPoint()), gety(user.getSpace().getPoint()), 50, 100);
                                                    bt.add(test);
                                                }
                                                bt.add(wC);

                                                validate();
                                                repaint();
                                            };
                                        };
                                        upButton.addActionListener(upAction);

                                        up.setBounds(cx - 150, cy - 100, 400, 400);
                                        bt.add(up);
                                        upButton.setFont(fm);
                                        upButton.setText("上");
                                        up.add(upButton);
                                    }else if ((way - cpoint) == -1){
                                        Move left = new Move();

                                        JButton leftButton = new JButton();
                                        ActionListener leftAction =  new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                walk++;

                                                users.get(cuser).setSpace(spaces.get(way-1));
                                                bt.removeAll();

                                                for(User user : users){
                                                    Test test =  new Test();
                                                    test.setBounds(getx(user.getSpace().getPoint()), gety(user.getSpace().getPoint()), 50, 100);
                                                    bt.add(test);
                                                }
                                                bt.add(wC);

                                                validate();
                                                repaint();
                                            };
                                        };
                                        leftButton.addActionListener(leftAction);

                                        left.setBounds(cx - 500, cy, 400,400);
                                        bt.add(left);
                                        leftButton.setFont(fm);
                                        leftButton.setText("左");
                                        left.add(leftButton);
                                    }else if ((way - cpoint == 1)){
                                        Move right = new Move();

                                        JButton rightButton = new JButton();
                                        ActionListener rigAction = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                walk++;

                                                users.get(cuser).setSpace(spaces.get(way-1));

                                                bt.removeAll();

                                                for(User user : users){
                                                    Test test =  new Test();
                                                    test.setBounds(getx(user.getSpace().getPoint()), gety(user.getSpace().getPoint()), 50, 100);
                                                    bt.add(test);
                                                }
                                                bt.add(wC);

                                                validate();
                                                repaint();
                                            };
                                        };
                                        rightButton.addActionListener(rigAction);

                                        right.setBounds(cx + 100, cy, 400,400);
                                        bt.add(right);
                                        rightButton.setFont(fm);
                                        rightButton.setText("右");
                                        right.add(rightButton);
                                    }else if((way - cpoint) == 15){
                                        Move down = new Move();

                                        JButton downButton = new JButton();
                                        ActionListener downAction = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                walk++;

                                                users.get(cuser).setSpace(spaces.get(way-1));

                                                bt.removeAll();

                                                for(User user : users){
                                                    Test test =  new Test();
                                                    test.setBounds(getx(user.getSpace().getPoint()), gety(user.getSpace().getPoint()), 50, 100);
                                                    bt.add(test);
                                                }
                                                bt.add(wC);
                                                
                                                validate();
                                                repaint();
                                            };
                                        };
                                        downButton.addActionListener(downAction);

                                        down.setBounds(cx - 150, cy + 125, 400, 400);
                                        bt.add(down);
                                        downButton.setFont(fm);
                                        downButton.setText("下");
                                        down.add(downButton);
                                    }
                                }
                            validate();
                            repaint();
                            }else{
                                cuser += 1;
                                walk = 0;
                                bt.add(random);
                                validate();
                                repaint();
                            }
                        };
                    };
                    wC.addActionListener(wA);

                    bt.add(wC);
                    validate();

                    cuser += 1;
                }else{
                    getContentPane().removeAll();
                    getContentPane().add(result);
                    validate();
                }
            }
        map.remove(random);
        }
    };
    random.addActionListener(randomaction);

    map.add(random);

    //キャラクター登録画面
    RegU setUser = new RegU();
    setUser.setLayout(null);

    UserManager players = new UserManager();

    JLabel character = new JLabel("キャラクター"+String.valueOf(user)+"の名前を教えて！");
    character.setFont(fm);
    character.setForeground(Color.BLUE);
    character.setBounds(WIDTH/2 - 300, 0, 700, 200);
    setUser.add(character);

    JTextField userName = new JTextField();
    userName.setFont(fm);
    userName.setBounds(WIDTH/2 - 400, 300, 800, 50);
    setUser.add(userName);

    JButton regisUserName = new JButton("キャラクター名を登録！！");
    regisUserName.setFont(fm);
    regisUserName.setBounds(WIDTH - 600,HEIGHT-200,500,125);
    ActionListener registUserNameaction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(user < member){
                User player = new User(userName.getText(), 2000, spaces.get(startSpace - 1));
                players.addUser(player);
                user += 1;
                userName.setText("");
                character.setText("キャラクター"+String.valueOf(user)+"の名前を教えて！");
            }else{
                User player = new User(userName.getText(), 2000, spaces.get(startSpace - 1));
                players.addUser(player);
                userName.setText("");
                character.setText("キャラクター"+String.valueOf(user)+"の名前を教えて！");

                users = players.getUsers();
                for(User user : users){
                    Test test =  new Test();
                    test.setBounds(getx(user.getSpace().getPoint()), gety(user.getSpace().getPoint()), 50, 100);
                    bt.add(test);
                }

                getContentPane().removeAll();
                getContentPane().add(map);
                validate();
                repaint();
            }
        }
    };
    regisUserName.addActionListener(registUserNameaction);
    setUser.add(regisUserName);

    //人数設定画面
    RegPN setPlayerNum = new RegPN();
    setPlayerNum.setLayout(null);

    JButton regisUserNum = new JButton("人数を登録！！");  //人数登録ボタン
    regisUserNum.setFont(fm);
    regisUserNum.setBounds(WIDTH - 600,HEIGHT - 200,500,125);
    ActionListener resitUserNumaction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            member = setPlayerNum.member;
            getContentPane().removeAll();
            getContentPane().add(setUser);
            validate();
        }
    };
    regisUserNum.addActionListener(resitUserNumaction);
    setPlayerNum.add(regisUserNum);


    //タイトル画面
    Title title = new Title();
    title.setLayout(null);

    JButton start = new JButton("スタート！");   //スタートボタン
    start.setFont(fm);
    start.setBounds(WIDTH/2 - 250,500,500,125);
    ActionListener startaction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            getContentPane().removeAll();
            getContentPane().add(setPlayerNum);
            validate();
        }
    };
    start.addActionListener(startaction);

    title.add(start);

    Container contentPane = getContentPane();
    contentPane.add(title);
  }

    public int getx(int point) {
        int x;
        int xspace = point % 15;
        x = 96 * (xspace - 1) + 20;
        return x;
    }

    public int gety(int point) {
        int y;
        int yspace = (int) Math.ceil(point / 15);
        y = (int) ( 101.5*yspace ) + 20;
        return y;
    }
}

class DicePanel extends JPanel {
    DicePanel(){
        setPreferredSize(new Dimension(100, 100));
        setOpaque(false);
    }
}

class Move extends JPanel {
    Move(){
        setPreferredSize(new Dimension(400, 400));
        setOpaque(false);
    }
}
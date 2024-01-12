package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;

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
    //Result result = new Result();

    //すごろく画面
    Sugo map = new Sugo();
    map.setLayout(null);

    MV move = new MV(world);
    move.setLayout(null);
    move.setBounds(0,0,Main.WIDTH,Main.HEIGHT);
    map.add(move);

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
                move.setUsers(users);

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

class Move extends JPanel {
    Move(){
        setPreferredSize(new Dimension(400, 400));
        setOpaque(false);
    }
}
package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Main extends JFrame{
    int member = 1;
    int user = 1;
  public static void main(String args[]){
    int WIDTH = 1200;
    int HEIGHT = 800;
    
    Main frame = new Main();
    frame.setTitle("どかどかゲーム");
    frame.setVisible(true);
    frame.setBounds(100, 100, WIDTH, HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  Main(){
    Font fm = new Font("ＭＳ ゴシック", Font.BOLD, 40);

    //すごろく画面
    JPanel map = new JPanel();

    //キャラクター設定画面
    JPanel setUser = new JPanel();
    setUser.setLayout(null);

    JLabel character = new JLabel("キャラクター"+String.valueOf(user)+"の名前を教えて！");
    character.setFont(fm);
    character.setBounds(300, 0, 700, 200);
    setUser.add(character);

    JTextField userName = new JTextField();
    userName.setFont(fm);
    userName.setBounds(300, 300, 600, 50);
    setUser.add(userName);

    JButton regisUserName = new JButton("キャラクター名を登録！！");
    regisUserName.setFont(fm);
    regisUserName.setBounds(350,500,500,125);
    ActionListener registUserNameaction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(user < member){
                user += 1;
                System.out.println(userName.getText());
                userName.setText("");
                character.setText("キャラクター"+String.valueOf(user)+"の名前を教えて！");
            }else{
                System.out.println(userName.getText());
                userName.setText("");
                character.setText("キャラクター"+String.valueOf(user)+"の名前を教えて！");
                
                getContentPane().removeAll();
                getContentPane().add(map);
                validate();
            }
        }
    };
    regisUserName.addActionListener(registUserNameaction);
    setUser.add(regisUserName);


    //人数設定画面

    JPanel setPlayerNum = new JPanel();
    setPlayerNum.setLayout(null);

    JLabel defaultnum = new JLabel(String.valueOf(member)+"人で遊ぶの？");
    defaultnum.setFont(fm);
    defaultnum.setBounds(500, 0, 400, 200);
    setPlayerNum.add(defaultnum);

    JButton up = new JButton("＋１");
    up.setFont(fm);
    up.setBounds(300, 300, 200, 100);
    ActionListener upaction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            member += 1;
            
            defaultnum.setText(String.valueOf(member)+"人で遊ぶの？");
            repaint();
        }
    };
    up.addActionListener(upaction);
    setPlayerNum.add(up);

    JButton down = new JButton("−１");
    down.setFont(fm);
    down.setBounds(800,300,200,100);
    ActionListener downaction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(member - 1 > 0){
                member -= 1;
                defaultnum.setText(String.valueOf(member)+"人で遊ぶの？");
                repaint();
            }
        }
    };
    down.addActionListener(downaction);
    setPlayerNum.add(down);

    JButton regisUserNum = new JButton("人数を登録！！");
    regisUserNum.setFont(fm);
    regisUserNum.setBounds(350,500,500,125);
    ActionListener resitUserNumaction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            getContentPane().removeAll();
            getContentPane().add(setUser);
            validate();
        }
    };
    regisUserNum.addActionListener(resitUserNumaction);
    setPlayerNum.add(regisUserNum);


    //タイトル画面
    JPanel op = new JPanel();
    op.setLayout(null);

    JLabel title = new JLabel("どかどかゲーム");
    title.setFont(fm);
    title.setBounds(450, 0, 400, 200);
    op.add(title);

    JButton start = new JButton("スタート！");
    start.setFont(fm);
    start.setBounds(350,500,500,125);
    ActionListener startaction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            getContentPane().removeAll();
            getContentPane().add(setPlayerNum);
            validate();
        }
    };
    start.addActionListener(startaction);

    op.add(start);

    Container contentPane = getContentPane();
    contentPane.add(op);
  }
}
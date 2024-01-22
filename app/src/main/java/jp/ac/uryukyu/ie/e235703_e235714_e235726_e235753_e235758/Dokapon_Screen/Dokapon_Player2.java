package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Dokapon_Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Dokapon_Player2 extends JFrame{
    State currentState;
    JPanel currentBattlePanel;
    private MenuPanel menuPanel;
    private MonsterEncounterPanel monsterEncounterPanel;
    private BattlePanel battlePanel;
    private AttackPanel attackPanel;
    private DefendPanel defendPanel;
    private DamageShow damageShow;
    private GameOverPanel gameOverPanel;
    private PlayerStatusPanel playerStatusPanel;
    private EnemyStatusPanel enemyStatusPanel;
    
    JLabel FirstTurnLabel;
    JLabel SecondTurnLanel;

    private JProgressBar playerHPBar;
    private JProgressBar enemyHPBar;
    int player_AChoice;
    int player_DChoice;

    double allAttack;//総ダメージ
    private int playerHP; // プレイヤーのHP
    private int enemyHP;  // 敵のHP
    private boolean playerTurn = true;

    int damage = 10;//仮のダメージ

    FightCharacter Player1 = new FightCharacter("プレイヤー1", 200, 2, 2, 3, 30, 0, "健康");
    FightCharacter Player2 = new FightCharacter("プレイヤー２",50,4,2,8,7,20,"通常");
    FightCharacter[] fighters = {Player1,Player2};

    //プレイヤーの先行後攻を決める
    int randomValue = new Random().nextInt(2);
    String 先行の人 = fighters[randomValue].getName();
    String 後攻の人 = fighters[Seconder()].getName();

    //モンスターのコマンドをランダムで選ばせる
    int randomSelect = new Random().nextInt(1,4);

    public Dokapon_Player2(){

        setTitle("どかVS プレイヤー用");
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuPanel = new MenuPanel(this);
        monsterEncounterPanel = new MonsterEncounterPanel(this);
        //battlePanel = new BattlePanel(this);
        //attackPanel = new AttackPanel(this);
        defendPanel = new DefendPanel(this);
        playerStatusPanel = new PlayerStatusPanel(this);
        enemyStatusPanel = new EnemyStatusPanel(this);
        gameOverPanel = new GameOverPanel(this,fighters[Seconder()]);
        
        battlePanel.add(playerStatusPanel);
        battlePanel.add(enemyStatusPanel);
        
        currentState = State.MENU;
        switchState(currentState);
        setLocationRelativeTo(null);
    }

    //遷移するパネル
    private enum State{
        MENU,MONSTER_ENCOUNTER,BATTLE,GAME_OVER
    }

    //パネルを遷移させるメソッド
    private void switchState(State newState){
        getContentPane().removeAll();
        currentState = newState;

        switch (currentState) {
            case MENU:
                getContentPane().add(menuPanel);
                break;
            case MONSTER_ENCOUNTER:
                getContentPane().add(monsterEncounterPanel);
                break;
            case BATTLE:
                getContentPane().add(battlePanel);
                break;
            case GAME_OVER:
                getContentPane().add(gameOverPanel);
                break;
            default:
                break;
        }
        revalidate();
        repaint();
    }

    //特にバトルに関するパネルを遷移させるメソッド
    private void switchBattlePanel(JPanel oldPanel,JPanel newPanel){//削除するパネルと新たに追加するパネルを引数にもつ
        currentBattlePanel = newPanel;
        // AttackPanel を除外する
            battlePanel.remove(oldPanel);

        // DefendPanel を BattlePanel に追加し、表示する
        battlePanel.add(newPanel);
        newPanel.setVisible(true);

        // AttackPanel を非表示にする（必要に応じて再利用する場合はコメントアウト）
        oldPanel.setVisible(false);

        // BattlePanel を再描画
        battlePanel.revalidate();
        battlePanel.repaint();

    }
    //ランダムで選択された以外の数字を返す
    public int Seconder(){
        int result;
        if(randomValue == 0){
            result = 1;
        }else{
            result = 0;
        }
        return result;
    }

    public FightCharacter updateFirstTurn(){//ここで先行プレイヤーを入れ替え
        if(fighters[randomValue] == Player1){//先行がプレイヤー１のとき,エネミー１を先行に
            fighters[randomValue] = Player2;
            
        }else{//先行がエネミー１の場合,プレイヤー１を先行に
            fighters[randomValue] = Player1;
        }
        return fighters[randomValue];
    }

    public FightCharacter updateSecondTurn(){//ここで後攻プレイヤーを入れ替え
        if(fighters[Seconder()] == Player2){
            fighters[Seconder()] = Player1;
            
        }else{
            fighters[Seconder()] = Player2;
        }
        return fighters[Seconder()];
    }

    //ダメージの計算式(未完成)
    private double damageFormula(FightCharacter firstPlayer,FightCharacter secondPlayer){
        AttackComand AC = new AttackComand();
        MagicalComand MC = new MagicalComand();
        SpecialComand SC = new SpecialComand();

        if(player_AChoice == 1){
            allAttack = AC.Attack_method(firstPlayer, secondPlayer, player_DChoice);
            
        }else if(player_AChoice == 2){
            allAttack = MC.Attack_method(firstPlayer,secondPlayer,player_DChoice);
            allAttack = 30;
        }else if(player_AChoice == 3){
            allAttack = SC.Attack_method(firstPlayer,secondPlayer,player_DChoice);
            allAttack = 10;
        }else if(player_AChoice == 4){
            firstPlayer.AT *= 1.5;
            allAttack = 0;
        }
        return (int)allAttack;
    }


    
    public boolean getPlayerTurn(){
        return playerTurn;
    }


    //本来はマップ画面
    private static class MenuPanel extends JPanel{
        public MenuPanel(Dokapon_Player2 doka){
            JButton exploreButton = new JButton("バトルへ");
            exploreButton.addActionListener(e -> doka.switchState(State.MONSTER_ENCOUNTER));
            add(exploreButton);
        }
    }

    //エネミーと遭遇する画面(80%で遭遇するようにしたい)
    private static class MonsterEncounterPanel extends JPanel{
        public MonsterEncounterPanel(Dokapon_Player2 doka){
            setLayout(new GridLayout(3,1));
            JLabel encount = new JLabel(doka.fighters[doka.Seconder()].getName() + "と遭遇した!");
            add(encount);
            JLabel proclaim = new JLabel(doka.fighters[doka.randomValue].getName() + " VS " + doka.fighters[doka.Seconder()].getName());
            add(proclaim);
            
            encount.setHorizontalAlignment(JLabel.CENTER);
            proclaim.setHorizontalAlignment(JLabel.CENTER);

            JButton continueButton = new JButton("OK");
            continueButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(doka.monsterEncounterPanel,doka.先行の人 + "のターン");
                    System.out.println(doka.先行の人);
                    if(doka.fighters[0].getName() == doka.先行の人){
                        doka.playerTurn = true;
                        System.out.println(doka.playerTurn);
                    }else{
                        doka.playerTurn = false;
                        System.out.println(doka.playerTurn);

                    }
                    doka.switchState(State.BATTLE);
                }
            });
            add(continueButton);
            doka.attackPanel = new AttackPanel(doka);
            doka.battlePanel = new BattlePanel(doka);
            doka.battlePanel.add(doka.attackPanel);
            

        }
    }

    //攻撃パネル,防御パネル,ダメージパネルが以下のバトルパネルに貼られる--------------------------------------
    private static class BattlePanel extends JPanel{
        Dokapon_Player2 doka;
        
        public BattlePanel(Dokapon_Player2 doka){
            this.doka = doka;
            

            // 初期HPを設定
            doka.playerHP = 100;
            doka.enemyHP = 100;

            // Player HP Bar
            doka.playerHPBar = new JProgressBar(0, (int)doka.fighters[doka.randomValue].getHP());
            doka.playerHPBar.setStringPainted(true);
            doka.playerHPBar.setValue((int)doka.fighters[doka.randomValue].getHP());   // 現在の値も初期HPに設定
            add(new JLabel(doka.fighters[doka.randomValue].getName()+" HP"));
            add(doka.playerHPBar);

            // Enemy HP Bar
            doka.enemyHPBar = new JProgressBar(0, (int)doka.fighters[doka.Seconder()].getHP());
            doka.enemyHPBar.setStringPainted(true);
            doka.enemyHPBar.setValue((int)doka.fighters[doka.Seconder()].getHP());   // 現在の値も初期HPに設定
            add(new JLabel(doka.fighters[doka.Seconder()].getName() + " HP"));
            add(doka.enemyHPBar);
        }
    }
    //攻撃コマンドパネル
    //攻撃コマンドパネル
    private static class AttackPanel extends JPanel{
        Dokapon_Player2 doka;
        public AttackPanel(Dokapon_Player2 doka){

            this.doka = doka;
            doka.FirstTurnLabel = new JLabel(doka.先行の人 +"はコマンドを選択してください");
            add(doka.FirstTurnLabel);
            System.out.println(doka.playerTurn);
            
            JButton attack = new JButton("こうげき");
    

            JButton magic = new JButton("まほう");
            JButton special = new JButton("ひっさつ");
            JButton buff = new JButton("バフ");
            
            attack.addActionListener(new AttackCommandListener(doka,1));
            magic.addActionListener(new AttackCommandListener(doka,2));
            special.addActionListener(new AttackCommandListener(doka,3));
            buff.addActionListener(new AttackCommandListener(doka,4));
            
            add(attack);
            add(magic);
            add(special);
            add(buff);
            
            validate();
            repaint();
        }
    }

    //防御コマンドパネル
    private static class DefendPanel extends JPanel{
        public DefendPanel(Dokapon_Player2 doka){
            // setLayout(null);

            doka.SecondTurnLanel = new JLabel(doka.後攻の人 + "はコマンドを選択してください");
            doka.SecondTurnLanel.setBounds(400, 400, 600, 600);
            add(doka.SecondTurnLanel);

            JButton defense = new JButton("ぼうぎょ");
            defense.setBounds(300, 200, 300, 100);

            JButton magicDefend = new JButton("まほーぼうぎょ");
            JButton counter = new JButton("カウンター");
            JButton surrender = new JButton("降参");

            defense.addActionListener(new DefendCommandListener(doka,1));
            magicDefend.addActionListener(new DefendCommandListener(doka,2));
            counter.addActionListener(new DefendCommandListener(doka,3));
            surrender.addActionListener(e -> doka.switchState(State.GAME_OVER));
            
            add(defense);
            add(magicDefend);
            add(counter);
            add(surrender);
        }
    }

    //攻撃ボタンの機能を管理
    private static class AttackCommandListener implements ActionListener{
        int command1;
        Dokapon_Player2 doka;
        public AttackCommandListener(Dokapon_Player2 doka,int command1){
            this.command1 = command1;
            this.doka = doka;
            
        }
        @Override
        public void actionPerformed(ActionEvent e){
            doka.player_AChoice = command1;
            doka.switchBattlePanel(doka.attackPanel, doka.defendPanel);
        }
    }

    //防御ボタンの機能を管理
    private static class DefendCommandListener implements ActionListener{
        int command2;
        Dokapon_Player2 doka;
        public DefendCommandListener(Dokapon_Player2 doka,int command2){
            this.command2 = command2;
            this.doka = doka;
        }
        @Override
        public void actionPerformed(ActionEvent e){
            doka.player_DChoice = command2;
            doka.damageShow = new DamageShow(doka);
            doka.switchBattlePanel(doka.defendPanel, doka.damageShow);
            
        }
    }

    //ダメージ表示画面
    private static class DamageShow extends JPanel{
        Dokapon_Player2 doka;
        JLabel DamageTell;
        public DamageShow(Dokapon_Player2 doka){
            
            this.doka = doka;
            if(doka.player_DChoice == 3){
                this.DamageTell = new JLabel(doka.後攻の人 + "は" + doka.先行の人 + "に" + doka.damageFormula(doka.fighters[doka.Seconder()], doka.fighters[doka.randomValue]) + "ダメージ与えた");
                add(this.DamageTell);
            }else{
                this.DamageTell = new JLabel(doka.先行の人 + "は" + doka.後攻の人 + "に" + doka.damageFormula(doka.fighters[doka.randomValue], doka.fighters[doka.Seconder()]) + "ダメージを与えた");
                add(this.DamageTell);
            }

            JButton NextTurnButton = new JButton("OK");
            NextTurnButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    //先行後攻を入れ替え
                    doka.先行の人 = doka.updateFirstTurn().getName();
                    doka.後攻の人 = doka.updateSecondTurn().getName();
                    doka.FirstTurnLabel.setText(doka.先行の人 + "はコマンド選択してください!!!!!");
                    doka.SecondTurnLanel.setText(doka.後攻の人 + "はコマンドを選択してください!!!!!");
                    System.out.println(doka.先行の人);
                    doka.switchBattlePanel(doka.damageShow, doka.attackPanel);
                }
            });
            add(NextTurnButton);

            // Update HP bars..
            if(doka.先行の人 == "プレイヤー1"){
                doka.enemyHP = (int)Math.max(doka.enemyHP - doka.damageFormula(doka.fighters[doka.randomValue],doka.fighters[doka.Seconder()]), 0);
                System.out.println("プレイヤーダメージ" + doka.damageFormula(doka.fighters[doka.randomValue],doka.fighters[doka.Seconder()]));
                doka.enemyHPBar.setValue(doka.enemyHP);
            }else{
                doka.playerHP = (int)Math.max(doka.playerHP - doka.damageFormula(doka.fighters[doka.randomValue],doka.fighters[doka.Seconder()]), 0);
                System.out.println("エネミーダメージ" + doka.damageFormula(doka.fighters[doka.randomValue],doka.fighters[doka.Seconder()]));
                doka.playerHPBar.setValue(doka.playerHP);
            }

        }
    }

    private static class PlayerStatusPanel extends JPanel{
        public PlayerStatusPanel(Dokapon_Player2 doka){
            setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
            JLabel PlayerName = new JLabel(doka.fighters[0].getName() + "(Lv " + doka.fighters[0].getLevel() + ")");
            JLabel PlayerAT = new JLabel("AT "+ doka.fighters[0].AT);
            JLabel PlayerDF = new JLabel("DF"+ doka.fighters[0].DF);
            JLabel PlayerMG = new JLabel("MG"+ doka.fighters[0].MP);
            JLabel PlayerSP = new JLabel("SP"+ doka.fighters[0].getSP());

            add(PlayerName);
            add(PlayerAT);
            add(PlayerDF);
            add(PlayerMG);
            add(PlayerSP);
        }
    }
    private static class EnemyStatusPanel extends JPanel{
        public EnemyStatusPanel(Dokapon_Player2 doka){
            setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
            JLabel EnemyName = new JLabel(doka.fighters[1].getName() + "(Lv " + doka.fighters[1].getLevel() + ")");
            JLabel EnemyAT = new JLabel("AT "+ doka.fighters[1].AT);
            JLabel EnemyDF = new JLabel("DF "+ doka.fighters[1].DF);
            JLabel EnemyMG = new JLabel("MG" + doka.fighters[1].MP);
            JLabel EnemySP = new JLabel("SP "+ doka.fighters[1].getSP());

            add(EnemyName);
            add(EnemyAT);
            add(EnemyDF);
            add(EnemyMG);
            add(EnemySP);
        }
    }

    private static class GameOverPanel extends JPanel {
        public GameOverPanel(Dokapon_Player2 doka,FightCharacter losePlayer) {
            add(new JLabel("Game Over - " + losePlayer.getName() + "の負け"));
            JButton backButton = new JButton("メニューに戻る");
            backButton.addActionListener(e -> doka.switchState(State.MENU));
            add(backButton);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Dokapon_Player2().setVisible(true));
    }
}


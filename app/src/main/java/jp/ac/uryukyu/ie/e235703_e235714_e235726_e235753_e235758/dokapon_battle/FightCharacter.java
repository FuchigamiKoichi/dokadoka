package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
import java.util.ArrayList;
public class FightCharacter extends Character{;
    final int defaultHP = 100;
    double HP;
    int gainHP;
    int SP;
    int DF;
    int AT;
    int MP;
    String health;
    private int EXP;
    final int defaultLevel = 1;
    private final int EXPERIENCE_TO_NEXTLEVEL = 100;
    private int level = 1;
    ArrayList <Weapon> weapons = new ArrayList<>();
    DefendWeapon defendWeapon;
    AttackWeapon attackWeapon;
    
    

    public FightCharacter(String name,double HP ,int SP,int DF,int AT,int MP,int money,String health){
        super(name,money);
        this.HP = HP;
        this.MP = MP;
        this.SP = SP;
        this.DF = DF;
        this.AT = AT;
        this.health = health;
    }

    public int getAttack(){ //武器を所持しているときとそうでないときで分岐している
        if(attackWeapon != null){
            this.AT += attackWeapon.AT + defendWeapon.AT;
            return this.AT;
        }
        return this.AT;
    }

    public int getDefance(){
        if(defendWeapon != null){
            this.DF += attackWeapon.DF + defendWeapon.DF;
            return this.DF;
        }
        return this.DF;
    }

    public int getMG(){
        return this.MP;
    }

    public int getSP(){
        return this.SP;
    }
    
    public double getEXP(){
        return this.EXP;
    }

    public void addEXP(double obtainedEXP){
        this.EXP += obtainedEXP;
    }

    public int getLevel(){
        return this.level;
    }

    public void setLevel(int newLevel){
        this.level = newLevel;
    }

    public String getHealth(){
        return this.health;
    }

    public void setHealth(String health){
        this.health = health;
    }

    public double getHP(){
        return this.HP;
    }
    public void setHP(double HP){
        this.HP = HP;
    }

    public void takenDamage(double damage){
        this.HP -= damage;
    }
    
    


    @Override
    //キャラ情報を表示するためのメソッド
    public void displayInfo(){
        System.out.println("name: " + this.getName());
        System.out.println("health: " + this.health);
        System.out.println("money: " + this.getMoney());
        System.out.println("Level: " + this.level);
    }

    //レベルアップについてのメソッド
    public void LevelUp(){
        System.out.println(this.getName() + ": レベル" + this.level + "→" + "レベル" + (level + 1) + "!!!");
        this.level ++;
        int gainHP = 10;
        this.HP = defaultHP + gainHP;//仮実装
        this.EXP -= EXPERIENCE_TO_NEXTLEVEL;
    }

    //経験値を入手するメソッド
    public void gainEXP(double obtainedEXP){
        this.EXP += obtainedEXP;
        System.out.println("獲得経験値(" + this.getName() + ") :" + obtainedEXP + "EXP");

        while(this.EXP >= EXPERIENCE_TO_NEXTLEVEL){
            LevelUp();
        }
    }

    public void die(){
        dead = true;
        System.out.println(this.getName() + "はやられた!");
    }

    public void revival(){
        if(this.dead){
            this.HP = defaultHP;
            this.dead = false;
            System.out.println(this.getName() + "は生き返った!!");
        }
    }
    
    public void getAttackWeapon(AttackWeapon attackWeapon){
        this.attackWeapon = attackWeapon;
        System.out.println(attackWeapon.getName() + "を手に入れた!!");
        weapons.add(attackWeapon);
        System.out.println("{" + attackWeapon.getName() + "} 攻撃力: " + attackWeapon.AT);
        System.out.println("{" + attackWeapon.getName() + "}防御力: " + attackWeapon.DF);
        System.out.println("機能: " + attackWeapon.effect);


    }

    public void getDefenseWeapon(DefendWeapon defendWeapon){
        this.defendWeapon = defendWeapon;
        System.out.println(defendWeapon.getName() + "を手に入れた!!");
        weapons.add(defendWeapon);
        System.out.println("{" + defendWeapon.getName() + "}攻撃力: " + defendWeapon.AT);
        System.out.println("{" + defendWeapon.getName() + "}防御力: " + defendWeapon.DF);
        System.out.println("機能: " + defendWeapon.effect);
    }

    public void displayWeapon(){
        System.out.println("所持している武器の一覧: ");
        for(Weapon weapon : weapons){
            System.out.println(weapon.getName());
        }
    }
}

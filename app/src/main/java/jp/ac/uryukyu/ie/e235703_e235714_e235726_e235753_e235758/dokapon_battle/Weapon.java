package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
import java.util.ArrayList;

class Weapon {
    String weaponName;
    int AT;
    int DF;
    int MG;
    int SP;
    int HP;
    String effect;
    FightCharacter special;//得意武器
    

    public Weapon(String name,int AT,int DF,int MG,int SP,int HP,String effect){
        this.weaponName = name;
        this.AT = AT;
        this.DF = DF;
        this.MG = MG;
        this.SP = SP;
        this.HP = HP;
        this.effect = effect;
    }
    public String getName(){
        return this.weaponName;
    }
}

class WeaponManager{
    ArrayList<Weapon>weapons;
    

    public WeaponManager(){
        this.weapons = new ArrayList<>();
    }

    public void addWeapon(Weapon weapon){
        weapons.add(weapon);
    }

}
class AttackWeapon extends Weapon{
    AttackWeapon(String name,int AT,int DF,int MG,int SP,int HP,String effect){
        super(name, AT, DF, MG, SP, HP,effect);
    }
}
class DefendWeapon extends Weapon{
    DefendWeapon(String Name,int AT,int DF,int MG,int SP,int HP,String effect){
        super(Name, AT, DF,MG,SP,HP,effect);
    }
    public static void main(String[] args) {
        WeaponManager weaponManager = new WeaponManager();
        FightCharacter FC = new FightCharacter("プレイヤー１", 0, 0, 0, 0, 0, 0, "健康");
        //武器の追加
        Weapon sword = new Weapon("ロングソード",10, 0,0,0,0,"眠り(確率1/8)");
        Weapon shield = new Weapon("青銅の盾",0, 15,0,0,0,"毒耐性");
        weaponManager.weapons.add(sword);
        weaponManager.weapons.add(shield);
    }
}
    

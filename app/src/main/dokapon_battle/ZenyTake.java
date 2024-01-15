package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;
//"ゼニテイク"はお金を奪う事ができる魔法
//ダメージも与えるかは未定
public class ZenyTake implements Action{
    //技名の表示
    @Override
    public String getName(){
        return "ゼニテイク";
    }
    //お金を奪うコマンド
    @Override
    public void execute(FightCharacter executer,FightCharacter target){
        System.out.println("ゼニテイク発動!!!");
        //stolenの意味は"盗まれた"
        //所持金の４分の１を盗めるようにしたい
        double stolenMoney = target.getMoney() * 0.25;
        target.setMoney(target.getMoney() - (int)stolenMoney);
        System.out.println(executer.getName() + "に" +  + (int)stolenMoney + "円奪われた");
        System.out.println(target.getName() + "の所持金は" + target.getMoney() + "円です");

    }
    public static void main(String[] args) {
        Warrior warrior1 = new Warrior("戦士", 0, 0, 0, 0, 0, 1000,"健康");
        Enemy enemy = new Enemy("ローグ", 0, 0,0, 0, 0, 200,"通常");
        ZenyTake zenyTake = new ZenyTake();
        zenyTake.execute(enemy,warrior1);
        
    }
    
}
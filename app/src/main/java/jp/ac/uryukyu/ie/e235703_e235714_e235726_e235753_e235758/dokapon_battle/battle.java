package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

//健太のコードとドッキングさせる
public class battle {
    public static void main(String[] args) {
        var master = new TurnDecision();
        FightCharacter p1 = new FightCharacter("勇者1",15,5,2,44,2,"健康");
        FightCharacter p2 = new FightCharacter("勇者2",50,12,8,20,4,"健康");

        ComandSelect comandSelect = new ComandSelect();

        int comand1 = comandSelect.A_comand_Select();
        計算分別 計算分別 = new 計算分別();



        master.determineTurn(p2);//p2は相手
        //相手が先行の場合
        if(master.advance == 0){
            System.out.println(p2.getName() + "のターン");
            double allAttack = 計算分別.Calculation(comand1,p2,p1);

        }else{ //自分が先行の場合
            System.out.println(p1.getName() + "のターン");
            double allAttack = 計算分別.Calculation(comand1,p1,p2);

        }

        double allAttack = 計算分別.Calculation(comand1,p2,p1);
        System.out.println(p2.getName()+"は"+p1.getName()+"に"+allAttack+"ダメージ！！！");





    }
}

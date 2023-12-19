package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Calculation;

public class Main {
    public static void main(String[] args) {
        Character仮 p1 = new Character仮("勇者1",15,5,2,2,2);
        Character仮 p2 = new Character仮("勇者2",50,12,8,1,4);

        ComandSelect comandSelect = new ComandSelect();

        int comand1 = comandSelect.A_comand_Select();

        計算分別 計算分別 = new 計算分別();
        double allAttack = 計算分別.Calculation(comand1,p2,p1);


        System.out.println(p2.getName()+"は"+p1.getName()+"に"+allAttack+"ダメージ！！！");
    } 
}

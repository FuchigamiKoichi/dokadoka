package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_battle;

import java.util.ArrayList;

public class Occupation extends FightCharacter{
    ArrayList <FightCharacter> jobNames = new ArrayList<>();

    Occupation(String name,int HP ,int SP,int DF,int AT,int MP,String health){
        super(name, HP, SP, DF, AT, MP,health);
    }
}

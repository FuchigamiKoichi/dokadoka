package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.dokapon_sugoroku;

import java.util.ArrayList;

public class Space {
    int point;
    ArrayList<Integer> ways;
    Event event;

    public Space(int point, Event event){
        this.point = point;
        this.ways = new ArrayList<>();
        this.event = event;
    }

    public void addWays(int way){
        ways.add(way);
    };

    public ArrayList<Integer> getWays() {
        return ways;
    }
    
    public int getPoint() {
        return point;
    }

    public Event getEvent() {
        return event;
    }
}
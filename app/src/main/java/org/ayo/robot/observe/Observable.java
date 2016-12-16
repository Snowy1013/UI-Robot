package org.ayo.robot.observe;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/17.
 */

public class Observable {
    private ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void notifyDataChanged(Object source, Object data){
        for(Observer observer: observers){
            observer.update(this, source, data);
        }
    }
}

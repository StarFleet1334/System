package com.solvd.app.patterns.behavioral.observer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {

    private Map<String, List<Purchaser>> map = new HashMap<>();

    private List<Purchaser> list = new ArrayList<>();

    public Manager() {}

    public void subscribe(Purchaser purchaser) {
        attachObserver(purchaser);
        for (int i = 0; i < purchaser.getNewsPapers().size(); i++) {
            List<Purchaser> purchasers = map.get(purchaser.getNewsPapers().get(i));
            if (purchasers != null) {
                purchasers.add(purchaser);
                map.put(purchaser.getNewsPapers().get(i),purchasers);
            } else {
                System.out.println("This Type of Magazine is not yet published");
            }
        }
    }

    public void unsubscribe(Purchaser purchaser,String name) {
        List<Purchaser> purchasers = map.get(name);
        if (purchasers != null) {
            purchasers.remove(purchaser);
        } else {
            System.out.println("This Type of Magazine is not yet published");
        }
    }

    public void publish(String name){
        map.put(name,new ArrayList<>());
        notifyPurchasers(name);
    }

    private void attachObserver(Purchaser purchaser) {
        list.add(purchaser);
    }

    private void notifyPurchasers(String newNewsPaper) {
        for (Purchaser x : list) {
            x.getNotification(newNewsPaper);
        }
    }

    public List<Purchaser> getList() {
        return list;
    }

    public Map<String, List<Purchaser>> getMap() {
        return map;
    }
}

package com.solvd.app.tasks;

import java.util.*;

public class CollectionTask<T> {
    private List<T> lst1;
    private List<T> lst2;
    private List<T> lst3;
    private List<T> lst4;
    private Queue<T> queue;


    public CollectionTask() {
        this.lst1 = new ArrayList<>();
        this.lst2 = new LinkedList<>();
        this.lst3 = new Stack<>();
        this.lst4 = new Vector<>();
        this.queue = new ArrayDeque<>();
    }

    public List<T> getLst1() {
        return lst1;
    }

    public void setLst1(List<T> lst1) {
        this.lst1 = lst1;
    }

    public List<T> getLst2() {
        return lst2;
    }

    public void setLst2(List<T> lst2) {
        this.lst2 = lst2;
    }

    public List<T> getLst3() {
        return lst3;
    }

    public void setLst3(List<T> lst3) {
        this.lst3 = lst3;
    }

    public List<T> getLst4() {
        return lst4;
    }

    public void setLst4(List<T> lst4) {
        this.lst4 = lst4;
    }

    public Queue<T> getQueue() {
        return queue;
    }

    public void setQueue(Queue<T> queue) {
        this.queue = queue;
    }
}

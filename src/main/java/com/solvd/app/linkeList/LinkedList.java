package com.solvd.app.linkeList;

public class LinkedList<T> {

       private static class Node<U> {
           U data;
           Node<U> next;

           Node(U data) {
               this.data = data;
               this.next = null;
           }
       }

       Node<T> head;

     public void push(T data) {
         Node<T> newNode = new Node<>(data);
         if (this.head == null) {
             this.head = newNode;
         } else {
             Node<T> last = this.head;
             while (last.next != null) {
                 last = last.next;
             }
             last.next = newNode;
         }
    }

    public void output(LinkedList<T> list) {
         Node<T> current = list.head;
         while (current != null) {
             System.out.println(current.data + " ");
             current = current.next;
         }
    }

}

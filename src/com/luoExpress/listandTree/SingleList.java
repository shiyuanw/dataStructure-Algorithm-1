package com.luoExpress.listandTree;

import java.util.Stack;

/**
 * 自定义链表设计
 *
 * @author Dal
 *
 */
public class SingleList {
    Node head = null; // 头节点
    /**
     * 链表中的节点，data代表节点的值，next是指向下一个节点的引用
     *
     * @author Dal
     *
     */
    class Node {
        Node next = null;// 节点的引用，指向下一个节点
        int data;// 节点的对象，即内容

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 向链表中插入数据
     *
     * @param d
     */
    public void addNode(int d) {
        Node newNode = new Node(d);// 实例化一个节点
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    public void insertNode(int d,int index) {
        //if(index<length()){
    //}
        Node newNode = new Node(d);
        int i=0;
        Node tmp=new Node(0);
        while(i<index-2){
            i++;
            tmp=head.next;
        }
        //newNode.next = curent.next;
        //current.next = newNode;
        Node tmp2=tmp.next;
        newNode.next=tmp2;
        tmp.next=newNode;
    }

    /**
     *
     * @param index:删除第index个节点
     * @return
     */
    public boolean deleteNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }
        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 1;
        Node preNode = head;
        Node curNode = preNode.next;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;
    }

    public boolean search(int value){
        Node cur=head;
        while(cur!=null){
            if(cur.data==value){return true;}
            cur=cur.next;
        }
        return false;
    }

    public Node reverse(SingleList s){
        Stack<Node>stack=new Stack<>();
        Node cur=s.head;
        while(cur.next!=null){
            stack.push(cur.next);
            cur=cur.next;
        }
        cur=s.head;
        while(!stack.isEmpty()&&cur.next!=null){
            cur.next=stack.pop();
            cur=cur.next;
        }
        return s.head;
    }

    /**
     *
     * @return 返回节点长度
     */
    public int length() {
        int length = 0;
        Node tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    /**
     * 在不知道头指针的情况下删除指定节点
     *
     * @param n
     * @return
     */
    public boolean deleteNode11(Node n) {
        if (n == null || n.next == null)
            return false;
        int tmp = n.data;
        n.data = n.next.data;
        n.next.data = tmp;
        n.next = n.next.next;
        System.out.println("删除成功！");
        return true;
    }

    public void printList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
    /**
     * 链表反转
     *
     * @param head
     * @return
     */
    public Node ReverseIteratively(Node head) {
        Node pReversedHead = head;
        Node pNode = head;
        Node pPrev = null;
        while (pNode != null) {
            Node pNext = pNode.next;
            if (pNext == null) {
                pReversedHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        this.head = pReversedHead;
        return this.head;
    }

    /**
     * 查找单链表的中间节点
     *采用快慢指针的方式查找单链表的中间节点，
     *快指针一次走两步，慢指针一次走一步，当快指针走完时，慢指针刚好到达中间节点。
     * @param head
     * @return
     */
    public Node SearchMid(Node head) {
        Node p = this.head, q = this.head;
        while (p != null && p.next != null && p.next.next != null) {
            p = p.next.next;
            q = q.next;
        }
        System.out.println("Mid:" + q.data);
        return q;
    }

    /**
     * 查找倒数 第k个元素
     *采用两个指针P1,P2，P1先前移K步，
     *然后P1、P2同时移动，当p1移动到尾部时，P2所指位置的元素即倒数第k个元素 。
     * @param head
     * @param k
     * @return
     */
    public Node findElem(Node head, int k) {
        if (k < 1 || k > this.length()) {
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < k; i++)// 前移k步
            p1 = p1.next;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    /**
     * 排序
     *
     * @return
     */
    public Node orderList() {
        Node nextNode = null;
        int tmp = 0;
        Node curNode = head;
        while (curNode.next != null) {
            nextNode = curNode.next;
            while (nextNode != null) {
                if (curNode.data > nextNode.data) {
                    tmp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = tmp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }

    /**
     * 删除重复节点
     */
    public void deleteDuplecate(Node head) {
        Node p = head;
        while (p != null) {
            Node q = p;
            while (q.next != null) {
                if (p.data == q.next.data) {
                    q.next = q.next.next;
                } else
                    q = q.next;
            }
            p = p.next;
        }

    }

    /**
     * 从尾到头输出单链表，采用递归方式实现
     *
     * @param pListHead
     */
    public void printListReversely(Node pListHead) {
        if (pListHead != null) {
            printListReversely(pListHead.next);
            System.out.println("printListReversely:" + pListHead.data);
        }
    }






    public static void main(String[] args) {
        SingleList list = new SingleList();
        list.addNode(5);
        list.addNode(3);
        list.addNode(1);
        list.addNode(2);
        list.addNode(55);
        list.addNode(36);
        System.out.println("linkLength:" + list.length());
        System.out.println("head.data:" + list.head.data);
        list.printList();
        list.deleteNode(4);
        System.out.println("After deleteNode(4):");
        list.printList();
    }

}

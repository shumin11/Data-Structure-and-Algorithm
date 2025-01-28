

import java.util.*;

public class website {
    class Node{
        String name;
        int count;
        Node next;
        Node prev;
        public Node(String name) {
            this.name = name;
        }
    }
    public HashMap<String, Integer> map;
    public HashMap<String, Node> nodeMap;
    public Node head;
    public Node tail;

    public website() {
        map = new HashMap<>();
        nodeMap = new HashMap<>();
        head = new Node("");
        tail = new Node("");
        head.next = tail;
        tail.prev = head;
    }
    
    private void record(String name) {
        map.put(name, map.getOrDefault(name, 0) + 1);
        if (map.get(name) == 1) {
            Node node = new Node(name);
            nodeMap.put(name, node);
            add(node);
        }
        if (map.get(name) > 1 && nodeMap.containsKey(name)) {
            remove(nodeMap.get(name));
            nodeMap.remove(name);
        }     
    }

    private String search() {
        return getFirst().name;
    }

    private void add(Node node) {
        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        node.next = tail;
        tail.prev = node;
    }
    
    private void remove(Node node) {
        Node front = node.prev;
        Node back = node.next;
        front.next = back;
        back.prev = front;

    }

    private Node getFirst() {
        return head.next;
    }

    public static void main(String[] args) {
        website sol = new website();
        sol.record("google");
        sol.record("facebook");
        sol.record("google");
        System.out.println(sol.search());
        sol.record("youtube");
        System.out.println(sol.search());
    }
}
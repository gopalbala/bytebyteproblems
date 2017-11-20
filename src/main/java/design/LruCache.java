package design;

import java.util.HashMap;

/**
 * Created by gbalasubramanian on 20/11/17.
 */
public class LruCache {
    static int capacity = 10;
    static HashMap<Integer, DllNode> map = new HashMap<>();
    static DllNode head = null;
    static DllNode end = null;

    public int get(int key) {
        if (map.containsKey(key)) {
            DllNode n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }

    public void remove(DllNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            end = node.prev;
        }
    }

    void setHead(DllNode node) {
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (end == null) {
            end = head;
        }
    }

    void set(int key, int value) {
        if (map.containsKey(key)) {
            DllNode old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            DllNode node = new DllNode(key, value);
            if (map.size() > capacity) {
                remove(end);
                setHead(node);
            } else {
                setHead(node);
            }
            map.put(key, node);
        }
    }
}

class DllNode {
    int key;
    int value;
    DllNode prev;
    DllNode next;

    public DllNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
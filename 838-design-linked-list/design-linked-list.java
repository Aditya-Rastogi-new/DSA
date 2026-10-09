class MyLinkedList {
    class Node {
        int val;
        Node next, prev;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head, tail;
    private int size;
    public MyLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int idx) {
        if(idx <0 || idx >= size) return -1;
        Node temp = head;
        for(int i = 0; i<=idx; i++){
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) return;
        Node pred = head;
        for(int i = 0; i<index; i++){
            pred = pred.next;
        }
        Node succ = pred.next;
        Node newNode = new Node(val);
        newNode.prev = pred;
        newNode.next = succ;
        pred.next = newNode;
        succ.prev = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        Node pred = head;
        for(int i = 0; i<index; i++){
            pred = pred.next;
        }
        
        Node succ = pred.next.next;
        pred.next = succ;
        succ.prev = pred;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
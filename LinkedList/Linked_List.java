// package LinkedList;

class Linked_List {
    public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print(){
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+ "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx , int data){
        if(idx == 0){
            addFirst(data);
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        while (i < idx-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int itrSearch(int key){
        Node temp = head;
        int i =0;

        while (temp != null) {
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key){
        return helper(head, key);
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void removeFromEnd(int n){
        int sz =0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if(n == sz){
            head = head.next; // removeFirst
            return;
        }
        Node prev = head;
        int i =0;
        int idx = sz - n;

        while (i < idx-1) {
            prev =prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    //Slow-fast technique for Checking a linkedlist is palindrom or not
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;            
        }
        return slow;
    }
    public boolean checkpalindrom(){
        if(head == null || head.next == null){
            return true;
        }
        // Step1 - find the mid
        Node midNode = findMid(head);
        //Step2 - reverse the 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next ;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //Step3 - check the left and right half
        Node left = head;
        Node right = prev; // right half head

        while (right != null) {
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Linked_List ll = new Linked_List();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(2);
        // ll.add(2, 9);
        ll.addLast(1);
        ll.print();
        // System.out.println("size of LL : "+ll.size);
        // System.out.println(ll.recSearch(3));
        // ll.reverse();
        // ll.removeFromEnd(3);
        // ll.print();
        System.out.println(ll.checkpalindrom());       
    }
}
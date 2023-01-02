public class CircularSinglyLinkedListImplementation {
    Node head = null;
    Node tail = null;

    public void addAtBeginning(int data) {
        Node newHeadNode = new Node();
        newHeadNode.data = data;
        if (head == null) {
            head = newHeadNode;
            tail = newHeadNode;
            newHeadNode.next = newHeadNode;
        } else {
            newHeadNode.next = head;
            head = newHeadNode;
            tail.next = head;
        }
    }

    public void addAtPosition(int position, int data) {
        --position;
        int pos = 0;
        if (position == 0) {
            addAtBeginning(data);
        } else if (length() >= position) {
            int len = length();
            Node temp = head;
            Node newNode = new Node();
            newNode.data = data;
            while (pos < position - 1) {
                temp = temp.next;
                ++pos;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            if (position == len) {
                tail = newNode;
            }
        } else
            System.out.println("Entered position is greater than the size of the linked list");
    }

    public void append(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.next = head;
        tail = newNode;
    }

    public void display() {
        Node temp = head.next;
        if (temp == head) {
            System.out.print(temp.data);
        } else {
            System.out.print(head.data + " ");
            while (temp != head) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
        System.out.println();
    }

    public int length() {
        Node temp = head;
        if (temp == null) {
            return 0;
        } else if (temp.next == head) {
            return 1;
        } else {
            int len = 1;
            temp = temp.next;
            while (temp != head) {
                ++len;
                temp = temp.next;
            }
            return len;
        }
    }

    public void deleteByPosition(int position) {
        if (length() < position) {
            System.out.println("Invalid position entered");
        } else if (position == 1) {
            tail.next = head.next;
            head = head.next;
        } else {
            int pos = 0;
            Node temp = head;
            Node temp2;
            int len = length();
            --position;
            while (pos < position - 1) {
                ++pos;
                temp = temp.next;
            }
            temp2 = temp.next;
            temp.next = temp2.next;
            if (position == len - 1) {
                tail = temp;
            }
        }
    }

    public void reverse() {
        Node nextNode = null;
        Node prevNode = tail;
        if (head != null) {
            if (head.next != head) {
                Node temp = head;
                tail = head;
                while (head.next != temp) {
                    nextNode = head.next;
                    head.next = prevNode;
                    prevNode = head;
                    head = nextNode;
                }
                head.next = prevNode;
            }
        }
    }
}
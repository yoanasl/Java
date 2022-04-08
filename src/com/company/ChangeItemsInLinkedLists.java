package com.company;

class Node
{
   public int value;
    Node next;
    Node(int data)
    {
        value = data;
        next = null;
    }
    public void setValue(int newValue)
    {
        if(0 <= newValue && newValue<= 100)
        this.value = newValue;
    }

}

class LinkedList
{
    public Node head = null;
    public Node tail = null;

    void addAtTheBeginning(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }


    public void addAtEnd(int data)
    {

        Node newNode = new Node(data);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
            // both will point to new node
        }
        else
        {
            tail.next = newNode; //=> will point to new node
            tail = newNode; // => new node will be new tail
        }
    }

    void printList() throws Exception {
        if (head == null)
        {
            throw new Exception("List is empty");
        }
        Node node = head;
        while (node != null)
        {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println("");
    }

    int count()
    {
        int count = 0;  //=> will find length of linked list
        Node node = head;
        if (head == null)
        {
            System.out.println("List is empty");
        }
        else
        {
            while (node != null) {
                count++;
                node= node.next;
            }
        }
        return count;
    }

    void swapNode(int k) throws Exception {
        int count = count();

        if (count < k && k >100000 && k<1)
        {
            throw new Exception("K is not vali");
        }


        Node fromBeginningK = head;
        Node previousbeg = null;
       // finding k node from beginning
        for (int i = 1; i < k; i++) {
            previousbeg = fromBeginningK; // previous node pointing to kth node
            fromBeginningK = fromBeginningK.next; // node for swap = kth node
        }

        Node fromEndK = head;
        Node previousend = null;
       // kth node from end is (n-k+1) from beginning , because head is first node
        for (int i = 1; i < count - k + 1; i++) {
            previousend = fromEndK;
            fromEndK = fromEndK.next;
        }


        if (previousbeg != null) {
            previousbeg.next = fromEndK;//previous node from the begin will pointing kth node from end
        }
        if (previousend != null) {
            previousend.next = fromBeginningK;//previous node from the end will pointing kth node from beginning
        }

        // if we want to swap first and last  node:
        if (k == 1)
        {
            head = fromEndK; // we set last node to be head (first from the list)
        }

        if (k == count) {
            head = fromBeginningK;  // we set first node to be last from the list
        }
        //
        //Swap next pointers of node from begin and end
        Node temp = fromBeginningK.next; // find
        fromBeginningK.next = fromEndK.next; //
        fromEndK.next = temp;
    }


    public static void main(String[] args) throws Exception {
        LinkedList llist = new LinkedList();
        int[] arr = {7,9,6,6,7,8,3,0,9,5};

        for (int i = 0; i < arr.length; i++)
            llist.addAtEnd(arr[i]);

        System.out.print("Original list: ");
        llist.printList();


        int k = 5;
            llist.swapNode(k);
            System.out.print("Modified list: ");
            llist.printList();


    }

}



package com.company;

public class Main {

    public static void main(String[] args) {
        // LINKED LIST TEST
        LinkedList ll = new LinkedList();
        for (int i = 0; i < 25; i++) {
            // Add node storing signal to list
            Node<Integer> node = new Node<>(i);
            ll.append(node);
        }

//        ll.remove(24);
//        ll.remove(22);
//        ll.remove(0);

//        for (int i = 25; i >= 0; i--) {
//            ll.remove(i);
//        }

        Node currentNode = ll.head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }




        // SIGNAL TEST
//        int[] data = {100, 102, 103, 104, 106, 109, 110, 112, 118, 115, 116, 117, 118, 120, 122, 123};
//        Signal input = new Signal(data);
//
//        Pipeline p = new Pipeline();
//        p.addStep(new MaxOperation());
//        input = p.evaluate(input);
//        input.print();
    }
}

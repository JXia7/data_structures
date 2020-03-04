package com.company;

public class Pipeline {
    private LinkedList steps;

    public Pipeline() {
        steps = new LinkedList();
    }

    public void addStep(Operation op) {
        Node node =  new Node<Operation>(op);
        steps.append(node);
    }

    public Signal evaluate(Signal input) {
        Node step = steps.head;
        while (step != null) {
            Operation op = (Operation) step.data;
            input = op.evaluate(input);

            step = step.next;
        }

        return input;
    }

}

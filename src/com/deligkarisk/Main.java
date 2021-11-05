package com.deligkarisk;

public class Main {

    public static void main(String[] args) {


        LinkedList myOtherLinkedList = new LinkedList();
        myOtherLinkedList.addStringToList("My own savior");
        myOtherLinkedList.addStringToList("Consequences");
        myOtherLinkedList.addStringToList("Watching over me");
        myOtherLinkedList.addStringToList("Lost children");


        System.out.println("Size of the list is: " + myOtherLinkedList.size());

        System.out.println("Print contents");
        myOtherLinkedList.printListContents();
        System.out.println("\n");

        System.out.println("Print contents in reverse");
        myOtherLinkedList.printListContentsReverse();
        System.out.println("\n");

        // Show that the current cursor does not change if we print the contents of the list.
        // We only want the current cursor position to change if we call the next() or previous() methods.

        myOtherLinkedList.next();
        System.out.println("Current object is: " + myOtherLinkedList.getCursorPosition());
        myOtherLinkedList.printListContents();
        System.out.println("Current object is: " + myOtherLinkedList.getCursorPosition());
        System.out.println("\n");

        System.out.println("Current object is: " + myOtherLinkedList.getCursorPosition());
        System.out.println("The object at position 1 is " + myOtherLinkedList.getAtIndex(2));
        System.out.println("Current object is: " + myOtherLinkedList.getCursorPosition());
        System.out.println("\n");

        // Iterate through elements
        System.out.println("Iterating through elements...");
        myOtherLinkedList.setCursorPosition(myOtherLinkedList.getAtIndex(0));
        System.out.println(myOtherLinkedList.getCursorPosition());
        while (myOtherLinkedList.hasNext()) {
            myOtherLinkedList.next();
            System.out.println(myOtherLinkedList.getCursorPosition());
        }
        System.out.println("\n");

        System.out.println("Trying to access the next element should produce a warning, and also keep the cursor at " +
                "the last position.");
        System.out.println(myOtherLinkedList.next());
        System.out.println("Current object is: " + myOtherLinkedList.getCursorPosition());
        System.out.println("\n");



        // Iterate through elements in the reverse order
        System.out.println("Iterating through elements in the reverse...");
        myOtherLinkedList.setCursorPosition(myOtherLinkedList.getAtIndex(myOtherLinkedList.size()-1));
        System.out.println(myOtherLinkedList.getCursorPosition());
        while (myOtherLinkedList.hasPrevious()) {
            myOtherLinkedList.previous();
            System.out.println(myOtherLinkedList.getCursorPosition());
        }
        System.out.println("\n");

        System.out.println("Trying to access the previous element should produce a warning, and also keep the cursor " +
                "at the last position.");
        System.out.println(myOtherLinkedList.previous());
        System.out.println("Current object is: " + myOtherLinkedList.getCursorPosition());
        System.out.println("\n");


        // Removing element
        System.out.println("Removing random element");
        System.out.println("Before removal, size of the list is: " + myOtherLinkedList.size());
        myOtherLinkedList.removeAtIndex(2);
        System.out.println("After removal, size of the list is: " + myOtherLinkedList.size());
        myOtherLinkedList.printListContents();















    }
}

package com.deligkarisk;

public class LinkedList {

    private LinkedListStringItem cursorPosition;
    private LinkedListStringItem headerItem;
    private LinkedListStringItem lastItem;


    public void addStringToList(String stringValue) {
        if (headerItem == null) {
            headerItem = new LinkedListStringItem(stringValue);
            lastItem = headerItem;
            cursorPosition = lastItem;
            return;
        }
        LinkedListStringItem itemToAdd = new LinkedListStringItem(stringValue);
        lastItem.nextItem = itemToAdd;
        itemToAdd.previousItem = lastItem;
        lastItem = itemToAdd;
    }


    public Boolean next() {

        if (headerItem == null) {
            System.out.println("List is empty.");
            return false;
        }

        if (!hasNext()) {
            System.out.println("Already at the end of the list.");
            return false;
        }

        cursorPosition = cursorPosition.getNextItem();
        return true;
    }


    public Boolean previous() {

        if (headerItem == null) {
            System.out.println("List is empty.");
            return false;
        }

        if (!hasPrevious()) {
            System.out.println("Already at the beginning of the list.");
            return false;
        }

        cursorPosition = cursorPosition.getPreviousItem();
        return true;
    }


    public Boolean hasNext() {
        return cursorPosition.hasNext();
    }


    public Boolean hasPrevious() {
        return cursorPosition.hasPrevious();
    }


    public void removeAtIndex(int index) {
        LinkedListStringItem elementToRemove = getAtIndex(index);
        removeFromList(elementToRemove);
    }

    private void removeFromList(LinkedListStringItem itemToRemove) {

        System.out.println("Removing item with value: " + itemToRemove.getValue());

        if (itemToRemove == lastItem) {
            lastItem = itemToRemove.getPreviousItem();
            lastItem.setNextItem(null);
        }

        if (itemToRemove == headerItem) {
            headerItem = itemToRemove.getNextItem();
        }

        itemToRemove.getPreviousItem().setNextItem(itemToRemove.getNextItem());
        itemToRemove.getNextItem().setPreviousItem(itemToRemove.getPreviousItem());

    }


    public void printListContents() {
        LinkedListStringItem currentItem = headerItem;
        System.out.println(currentItem);
        while (currentItem.hasNext()) {
            currentItem = currentItem.getNextItem();
            System.out.println(currentItem);
        }
    }


    public void printListContentsReverse() {
        LinkedListStringItem currentItem = lastItem;
        System.out.println(currentItem);
        while (currentItem.hasPrevious()) {
            currentItem = currentItem.getPreviousItem();
            System.out.println(currentItem);
        }
    }


    public LinkedListStringItem getAtIndex(int index) {
        LinkedListStringItem currentItem = headerItem;

        if (index == 0) {
            return currentItem;
        }

        for (int i = 0; i < index; i++) {
            currentItem = currentItem.getNextItem();
        }

        return currentItem;
    }


    public int size() {

        if (headerItem == null) {
            return 0;
        }

        LinkedListStringItem currentItem = headerItem;
        int size = 1;

        while(currentItem.hasNext()) {
            size = size + 1;
            currentItem = currentItem.getNextItem();
        }
        return size;
    }



    public LinkedListStringItem getCursorPosition() {
        return cursorPosition;
    }

    public void setCursorPosition(LinkedListStringItem newCurrentObject) {
        this.cursorPosition = newCurrentObject;
    }

    private class LinkedListStringItem {
        private String value;
        private LinkedListStringItem nextItem;
        private LinkedListStringItem previousItem;

        public String getValue() {
            return value;
        }


        public LinkedListStringItem getNextItem() {
            return nextItem;
        }

        public void setNextItem(LinkedListStringItem nextItem) {
            this.nextItem = nextItem;
        }

        public LinkedListStringItem getPreviousItem() {
            return previousItem;
        }

        public void setPreviousItem(LinkedListStringItem previousItem) {
            this.previousItem = previousItem;
        }

        public LinkedListStringItem(String value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return value;
        }

        public Boolean hasNext() {
            return nextItem != null;
        }


        public Boolean hasPrevious() {
            return previousItem != null;
        }
    }
}

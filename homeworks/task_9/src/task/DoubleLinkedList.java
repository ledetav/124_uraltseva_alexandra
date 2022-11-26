package task;

public class DoubleLinkedList<T extends Comparable<T>> {

    // fields
    // --------------------------------------------------

    private DoubleLinkedListItem<T> firstElement;
    private DoubleLinkedListItem<T> lastElement;
    private int listSize;

    // constructor
    // --------------------------------------------------

    public DoubleLinkedList() {
        firstElement = lastElement = null;
        listSize = 0;
    }

    // methods
    // --------------------------------------------------

    public DoubleLinkedListItem<T> findFirstItem(T value) {
        if (listSize == 0)
            return null;
        var element = firstElement;
        while (element != null && !element.getData().equals(value))
            element = element.getNext();
        return element;
    }

    public DoubleLinkedListItem<T> findLastItem(T value) {
        if (listSize == 0)
            return null;
        var element = lastElement;
        while (element != null && !element.getData().equals(value))
            element = element.getPrev();
        return element;
    }

    public void insertAfter(DoubleLinkedListItem<T> listItem, T data) {
        if (listSize == 0) {
            firstElement = lastElement = new DoubleLinkedListItem<>(data);
            ++listSize;
            return;
        }

        var item = new DoubleLinkedListItem<>(data);

        if (listItem == null) {
            item.setNext(firstElement);
            firstElement.setPrev(item);
            firstElement = item;
        } else if (listItem == lastElement) {
            lastElement.setNext(item);
            item.setPrev(lastElement);
            lastElement = item;
        } else {
            item.setPrev(listItem);
            item.setNext(listItem.getNext());
            listItem.getNext().setPrev(item);
            listItem.setNext(item);
        }

        listSize++;
    }

    public void insertBefore(DoubleLinkedListItem<T> listItem, T data) {
        if (listSize == 0) {
            firstElement = lastElement = new DoubleLinkedListItem<>(data);
            listSize++;
            return;
        }

        var item = new DoubleLinkedListItem<>(data);

        if (listItem == null) {
            lastElement.setNext(item);
            item.setPrev(lastElement);
            lastElement = item;
        } else if (listItem == firstElement) {
            item.setNext(firstElement);
            firstElement.setPrev(item);
            firstElement = item;
        } else {
            item.setNext(listItem);
            item.setPrev(listItem.getPrev());
            listItem.getPrev().setNext(item);
            listItem.setPrev(item);
        }

        listSize++;
    }

    public void remove(DoubleLinkedListItem<T> item) {
        if (listSize == 1) {
            firstElement = lastElement = null;
        } else if (item == firstElement) {
            item.getNext().setPrev(null);
            firstElement = item.getNext();
        } else if (item == lastElement) {
            item.getPrev().setNext(null);
            lastElement = item.getPrev();
        } else {
            item.getNext().setPrev(item.getPrev());
            item.getPrev().setNext(item.getNext());
        }

        listSize--;
    }

    public int getSize() {
        return listSize;
    }

    public DoubleLinkedListItem<T> getFirst() {
        return firstElement;
    }

    public DoubleLinkedListItem<T> getLast() {
        return lastElement;
    }
}

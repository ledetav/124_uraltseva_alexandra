package task;

public class DoubleLinkedListItem<T extends Comparable<T>> {

    //fields
    //--------------------------------------------------

    private DoubleLinkedListItem<T> beginning;
    private DoubleLinkedListItem<T> end;
    private T data;

    //constructor
    //--------------------------------------------------

    public DoubleLinkedListItem(T data) {
        beginning = end = null;
        this.data = data;
    }

    //methods
    //--------------------------------------------------

    public DoubleLinkedListItem<T> getNext() {
        return end;
    }

    public DoubleLinkedListItem<T> getPrev() {
        return beginning;
    }

    public T getData() {
        return data;
    }

    public void setNext(DoubleLinkedListItem<T> value) {
        end = value;
    }

    public void setPrev(DoubleLinkedListItem<T> value) {
        beginning = value;
    }
    
    public void setData(T value) {
        data = value;
    }
}

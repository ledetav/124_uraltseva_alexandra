package task;

public class DoubleLinkedListSorter {
    public static <T extends Comparable<T>> void sort(DoubleLinkedList<T> list) {

        if(list.getSize() == 0)
            return;
        
        int elementSorted = 0;

        while (elementSorted != list.getSize() - 1) {
            var element = list.getFirst();

            for(int i = 0; i < list.getSize() - elementSorted - 1; i++) {
                if(element.getData().compareTo(element.getNext().getData()) >= 0) {
                    var data = element.getData();
                    element.setData(element.getNext().getData());
                    element.getNext().setData(data);
                }

                element = element.getNext();
            }

            elementSorted++;
        }
    }
}

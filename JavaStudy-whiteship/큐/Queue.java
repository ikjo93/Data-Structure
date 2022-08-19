package whiteship.queue;

public interface Queue {

    void add(int data);

    int remove();

    int peek();

    boolean isEmpty();

    int size();

    void clear();
}

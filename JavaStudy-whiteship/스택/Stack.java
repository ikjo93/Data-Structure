package whiteship.stack;

public interface Stack {

    void push(int data);

    int pop();

    int peek();

    int get(int index);

    int size();

    void clear();
}

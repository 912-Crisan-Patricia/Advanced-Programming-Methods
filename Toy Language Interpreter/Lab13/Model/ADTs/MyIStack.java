package Model.ADTs;

import Model.MyException;

public interface MyIStack<T> extends Clearable {

    T pop();
    T peek() throws MyException;

    void push(T v);

    int size();

    boolean isEmpty();


}

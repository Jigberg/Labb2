package Graphical;
import java.util.ArrayDeque;
import java.util.*;

public interface Observer {

   /* Deque<String> stack = new ArrayDeque<>();

    default void push(String instructionMessage){
        stack.push(instructionMessage);
    }

    default String pop(){
        return stack.pop();
    }*/

    void recieveMessage(String message, int amount);

}

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rectangle {

    // make private and add modifiers
    private int topLeftX;
    private int topLeftY;
    private int topRightX;
    private int topRightY;

    private char letter;


    // !!!!! Intentionally do not implement @Equals
    // we want finding the rectangle in the list and comparison by reference, not by value
    // to allow two rectangles have the same letter

    // Alternatively - add some unique identifier to each rectangle

}

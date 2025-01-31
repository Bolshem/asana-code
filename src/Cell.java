import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

@Getter
public class Cell {

    // make private and add modifiers
    private final LinkedList<Rectangle> rectangles;

    public Cell() {
        rectangles = new LinkedList<>();
    }
}

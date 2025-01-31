import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.PriorityQueue;

@Getter
public class Cell {

    // make private and add modifiers
    private final PriorityQueue<Rectangle> rectangles;

    public Cell() {
        rectangles = new PriorityQueue<>((a,b) -> b.getLayer() - a.getLayer());
    }
}

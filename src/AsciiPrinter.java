
public class AsciiPrinter {

    private Cell[][] field;

    public AsciiPrinter() {
        reset();
    }

    public void draw(char letter, int x1, int y1, int x2, int y2) {
        var rect = new Rectangle(x1,y1, x2, y2, letter);

        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                field[x][y].getRectangles().addFirst(rect);
            }
        }
    }

    public void bringToFront(int selectX, int selectY) {

        // check if there is a rectangle at this point
        if (this.field[selectX][selectY].getRectangles().isEmpty()) {
            return;
        }

        // get the top most rectangle
        var rect = this.field[selectX][selectY].getRectangles().getFirst();

        // go over its original coordinates and bring it to the top of the list
        for (int x = rect.getTopLeftX(); x <= rect.getTopRightX(); x++) {
            for (int y = rect.getTopLeftY(); y <= rect.getTopRightY(); y++) {

                // ignore cells where this rectangle was erased
                if (!this.field[x][y].getRectangles().contains(rect)) {
                    return;
                }
                this.field[x][y].getRectangles().remove(rect);
                this.field[x][y].getRectangles().addFirst(rect);
            }
        }
    }

    public void erase(int x1, int y1, int x2, int y2) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                this.field[x][y].getRectangles().clear();
            }
        }
    }

    public void print() {
        for (int y = 0; y < field[0].length; y++) {
            for (int x = 0; x < field.length; x++) {
                if (field[x][y].getRectangles().isEmpty()) {
                    System.out.print("."); // Empty cell
                } else {
                    // Print the first rectangle's letter (assuming a list of rectangles)
                    // the top rectangle is azlways at the beginning of the list
                    System.out.print(field[x][y].getRectangles().getFirst().getLetter());
                }
            }
            System.out.println();
        }
        System.out.println("------------------");
    }

    public void dragAndDrop(int selectX, int selectY, int releaseX, int releaseY) {
        var rect = this.field[selectX][selectY].getRectangles().getFirst();

        // shift values
        var difX = releaseX - selectX;
        var difY = releaseY - selectY;

        // go over original rectangles coordinates & dimensions
        for (int x = rect.getTopLeftX(); x <= rect.getTopRightX(); x++) {
            for (int y = rect.getTopLeftY(); y <= rect.getTopRightY(); y++) {
                // some areas ,ay be deleted
                // do not shift rectangle if it was erased from this cell
                if (this.field[x][y].getRectangles().contains(rect)) {
                    this.field[x][y].getRectangles().remove(rect);
                    this.field[x + difX][y + difY].getRectangles().addLast(rect);
                }
            }
        }
    }

    public void reset() {
        this.field = new Cell[10][6]; // 5x5 grid
        // Optionally, you can initialize each Cell in the array if needed
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new Cell(); // Initializing each cell
            }
        }
    }
}

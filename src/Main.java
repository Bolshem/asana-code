//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    // Assumption for the project - input is always correct.
    // Otherwise need to check input and boundaries

    public static void main(String[] args) {
        var printer = new AsciiPrinter();

        printer.draw('L', 1,1,2,2);

        printer.draw('A', 2,2,5,5);
        printer.bringToFront(1,1);

        printer.print();
        printer.erase(2,2,3,3);

        printer.print();
        printer.dragAndDrop(1,1,0,0);
        printer.print();
    }


    private static void runSingleCommand(String s, AsciiPrinter printer) {
        var args= s.trim().replaceAll("\\s+", " ").split(" ");

        switch (args[0]) {
            case "DRAW_RECTANGLE":
                printer.draw(args[1].charAt(0), // fill character
                        Integer.parseInt(args[2]), // left_x
                        Integer.parseInt(args[3]), // top_y
                        Integer.parseInt(args[4]), // right_x
                        Integer.parseInt(args[5])); // bottom_y
                break;

            case "ERASE_AREA":
                printer.erase(
                        Integer.parseInt(args[1]),
                        Integer.parseInt(args[2]),
                        Integer.parseInt(args[3]),
                        Integer.parseInt(args[4]));
                break;

            case "DRAG_AND_DROP":
                printer.dragAndDrop(
                        Integer.parseInt(args[1]),
                        Integer.parseInt(args[2]),
                        Integer.parseInt(args[3]),
                        Integer.parseInt(args[4]));
                break;

            case "BRING_TO_FRONT":
                printer.bringToFront(
                        Integer.parseInt(args[1]),
                        Integer.parseInt(args[2]));
                break;

            case "PRINT_CANVAS":
                printer.print();
                break;

            default:
                System.out.println("Unknown command: " + args[0]);
                break;
        }
    }
}
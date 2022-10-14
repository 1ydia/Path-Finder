import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Object> toSearch = List.of(
                "[0]",
                List.of(
                        "[1, 0]",
                        List.of(
                                "[1, 1, 0]"
                        )
                ),
                "[2]",
                List.of(
                        "[3, 0]",
                        List.of(
                                "[3, 1, 0]"
                        )
                )
        );
        String s = "";
        do {
            System.out.print(">> ");
            Scanner in = new Scanner(System.in);
            s = in.nextLine();
            try {
                System.out.println(Maze.findIn(s, toSearch));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!s.equals("exit"));
    }
}

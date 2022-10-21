import java.util.Stack;
import java.util.List;

public class Maze {
    final static char C = ' ', X = 'x', S = 's', E = 'e', V = '.';
    private static final char[][] mazeBase = {
            {X, X, X, X, X, X, X, X, X, X, X, X, X, X, X},
            {X, C, C, C, C, C, C, X, C, C, C, C, C, C, X},
            {X, X, X, C, X, X, X, X, X, X, X, C, X, C, X},
            {X, C, X, C, C, C, C, C, C, C, C, C, X, C, X},
            {X, C, X, C, X, X, C, C, X, X, X, C, X, C, X},
            {X, C, C, C, X, C, C, C, C, C, X, C, X, C, X},
            {X, C, X, X, X, X, X, C, X, C, X, C, X, C, X},
            {X, C, C, C, C, S, C, C, X, C, C, X, E, C, X},
            {X, X, X, X, X, X, X, X, X, X, X, X, X, X, X}
    };

    static Stack<Stack<Integer>> search() throws Exception {
        char[][] mazeCopy = mazeBase.clone();
        List<Object> mazeList = LydiLists.toLists(mazeCopy);
        Stack<Stack<Stack<Integer>>> worklist = new Stack<Stack<Stack<Integer>>>();
        worklist.add((Stack<Stack<Integer>>) List.of((Stack<Integer>) LydiLists.findIn(mazeList, S)));
        List<Character> valids = List.of(C, E);
        List<List<Integer>> directions = List.of(
                List.of(0, -1), // North
                List.of(1, 0), // East
                List.of(0, 1), // South
                List.of(-1, 0) // West
        );
        while (true) {
            Object last = worklist.clone();
            for (Stack<Stack<Integer>> history : worklist) {
                List<Integer> coord = history.peek();
                if (mazeCopy[coord.get(1)][coord.get(0)] == E) {
                    System.out.println("Queue: Escape Successful");
                    return history;
                }
                else mazeCopy[coord.get(1)][coord.get(0)] = V;
                for (List<Integer> direction : directions) {
                    Stack<Stack<Integer>> newV = (Stack<Stack<Integer>>) history.clone();
                    newV.add((Stack<Integer>) LydiLists.addListVectors(coord, direction));
                    if(valids.contains(LydiLists.atCoordInList(newV.peek(), mazeList))) worklist.add(newV);
                }
            }
            if (last.equals(worklist)) throw new Exception("Maze solver got stuck.");
        }
    }

    static void printArr(char[][] arr) {
        for (char[] line : arr) {
            System.out.println(new String(line));
        }
    }
}
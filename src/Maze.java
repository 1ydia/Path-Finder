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

    static void search() throws Exception {
        List<Object> mazeList = LydiLists.toLists(mazeBase);
        Stack<List<Integer>> worklist = new Stack<List<Integer>>();
        worklist.add(LydiLists.findIn(mazeList, S));
        while (true) {
            for (List<Integer> coord : worklist) {
                Object north = mazeList.get(coord.get(0)).get(coord.get())
            }
        }
    }
}
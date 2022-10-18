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
        List<Object> mazeLists = LydiLists.toLists(mazeBase);
        Stack<List<Integer>> worklist = (Stack<List<Integer>>) LydiLists.findIn(
                LydiLists.toLists()
        );
    }
}
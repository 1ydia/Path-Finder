import java.sql.Array;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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

    // find 'toFind' in 'dim' dimensional arraylist 'map'
    // do not accept a T where T.instanceOf(List)
    static List<Integer> findIn(Object toFind, List<Object> toSearch) throws Exception {
        return findIn(toFind, toSearch, new ArrayList<Integer>());
    }

    private static List<Integer> findIn(Object toFind, List<Object> toSearch, List<Integer> index) throws Exception {
        for (int i = 0; i < toSearch.size(); i++) {
            Object obj = toSearch.get(i);
            if (obj.equals(toFind)) { index.add(i); return index; }
            if (obj instanceof List) {
                index.add(i);
                return findIn(toFind, (List<Object>) obj, index);
            }
        }
        throw new Exception("No element matching " + toFind + " was found.");
    }

    /*
    static void search() {
        char[][] mazeCopy = mazeBase.clone();
        Stack<Int2D> worklist = new Stack<Int2D>();
        Int2D coord = new Int2D(0, 0);
        for (coord.y = 0; coord.y < mazeCopy.length; coord.y++) {
            for (coord.x = 0; coord.x < mazeCopy[0].length; coord.x++) {
                if (mazeCopy[coord.y][coord.x] == S) {

                }
            }
        }
    }
    */
}
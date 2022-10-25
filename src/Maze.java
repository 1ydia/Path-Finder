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
        char[][] maze = mazeBase.clone();

        Stack<Stack<Integer>> path = new Stack<Stack<Integer>>();

        Stack<Integer> start = new Stack<Integer>();
        start.addAll(LydiLists.findIn(LydiLists.toLists(maze), S));
        path.push(start);

        while (path.size() > 0) {
            Stack<Integer> coord = path.pop();
            int x = coord.get(0);
            int y = coord.get(1);
            if (maze[y][x] == E) {
                System.out.println("Found the end!");
                System.out.println("Path:");
                for (Stack<Integer> c : path) {
                    System.out.printf("(%d, %d)%n", c.get(1), c.get(0));
                }
                System.out.println(coord);
                return path;
            }
            if (maze[y][x] == C || maze[y][x] == S) {
                maze[y][x] = V;
                path.push(coord);
                Character North = maze[y - 1][x];
                Character South = maze[y + 1][x];
                Character East = maze[y][x + 1];
                Character West = maze[y][x - 1];
                Stack<Integer> newCoord = new Stack<Integer>();
                newCoord.addAll(coord);
                if (North == C || North == E) newCoord.set(1, y - 1);
                else if (South == C || South == E) newCoord.set(1, y + 1);
                else if (East == C || East == E) newCoord.set(0, x + 1);
                else if (West == C || West == E) newCoord.set(0, x - 1);
                else continue;
                path.push(newCoord);
            }
        }
        throw new Exception("No path found!");
    }

    static void printArr(char[][] arr) {
        for (char[] line : arr) {
            System.out.println(new String(line));
        }
    }
}
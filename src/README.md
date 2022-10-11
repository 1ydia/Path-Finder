# Path Finder
In this project you will be writing code to solve mazes. To do so, you will be required to use a Stack and a Queue. Allow me to elaborate.

Your code will be given some maze represented as a 2D array of characters. On the code end, they will appear as follows:
```java
final static char C = ' ', X = 'x', S = 's', E = 'e', V = '.';
private static char[][] mazeBase = {
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
```
When displayed to the console, they will appear as follows:
```
X X X X X X X X X X X X X X X
X             X             X
X X X   X X X X X X X   X   X
X   X                   X   X
X   X   X X     X X X   X   X
X       X           X   X   X
X   X X X X X   X   X   X   X
X         s     X     X e   X
X X X X X X X X X X X X X X X
```
where ‘s’ represents the starting point, and ‘e’ the escape point. Starting at ‘s’ your program will hunt through all valid tiles without crossing itself until it either runs out of valid tiles or finds ‘e’.
The way it will avoid crossing itself is by marking tiles as V (‘.’) to know it has already been there. In the end, your program will print out either “Escape Successful” followed by the final marked maze array in the case of a success, or just the final marked maze in the event of a failure.
```
Queue: Escape Successful
X X X X X X X X X X X X X X X
X . . . . . . X . . . . . . X
X X X . X X X X X X X . X . X
X . X . . . . . . . . . X . X
X . X . X X . . X X X . X . X
X . . . X . . . . . X . X . X
X . X X X X X . X . X . X . X
X . . . . s . . X . . X e . X
X X X X X X X X X X X X X X X
```
You may have noticed in the screencap above it specifically says “Queue: Escape Successful”. This is due to the fact that this task can be solved using either a Stack or a Queue. I will be asking you to do both in this project.

Both processes follow the same basic algorithm, and simply replace each other in it. The idea is as follows:

- Make a copy of the maze array to use
- Create worklist Stack/Queue to represent tiles that need to be searched
  - Add the starting location to the worklist
- As long as the the worklist is not empty:
  - Take an entry out of the worklist
    - If it is the end location, print out “Escape successful” and terminate
  - Mark the tile as explored (set value to V)
  - Add valid adjacent tiles to the worklist
- Restore starting point’s value as S (it will have been overridden with V)
- Print the marked up maze

I will supply you with a framework which contains methods to print and copy the baseMaze array, as well as the main method. Your job will be to write the solveQ and solveS methods which solve the maze with a Queue and Stack respectively. Once you have written one, you have effectively written the other.

Good luck!
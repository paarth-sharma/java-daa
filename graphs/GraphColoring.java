public class GraphColoring {

    static int V = 4; // number of vertices

    static boolean graphColor(boolean graph[][], int m,int ind, int color[]){
        if (ind == V){
            
            if(isSafe(graph, color)){
                printSol(color);
                return true;
            }
            
            return false;
        }
        // Assign each color from 1 to m
        for (int j = 1; j <= m; j++) {
            color[ind] = j;
 
            // Recursion of the remaining vertices
            if (graphColor(graph, m, ind + 1, color))
                return true;

            color[ind] = 0;
        }
        return false;
    }

    static void printSol(int color[]){
        System.out.println("The soln exists, following are the assigned colors: ");
        for(int i=0; i<V; i++)
            System.out.print(" "+ color[i]);
        System.out.println();
    }

    static boolean isSafe(boolean graph[][], int color[]){
         // check for every edge
        for (int i = 0; i < V; i++)
            for (int j = i + 1; j < V; j++)
            // if the node before OR on below it are the same color
                if (graph[i][j] && color[j] == color[i])
                    return false;
        return true;
    }
    public static void main(String[] args) {
        boolean graph[][] = {
            { false, true, true, true },
            { true, false, true, false },
            { true, true, false, true },
            { true, false, true, false },
        };

        // no of colors
        int m =3;

        int[] color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;
 
        // Function call
        if (!graphColor(graph, m, 0, color))
            System.out.println("Solution does not exist");
    }
}

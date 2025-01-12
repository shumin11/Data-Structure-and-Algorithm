import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class possibleBipartition {
    // from back to front!
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, ArrayList<Integer>> neighbors = new HashMap<>();
        for (int[] dislike : dislikes) {
            if (!neighbors.containsKey(dislike[0])) {
                neighbors.put(dislike[0], new ArrayList<>());
            }
            neighbors.get(dislike[0]).add(dislike[1]);
            if (!neighbors.containsKey(dislike[1])) {
                neighbors.put(dislike[1], new ArrayList<>());
            }
            neighbors.get(dislike[1]).add(dislike[0]);
        }
        int[] visited = new int[n + 1]; // visited 
        for (int i = 0; i <= n; i++) {
            if (visited[i] == 0) {
                if (!bfs(neighbors, n, i, visited)) {
                    return false;
                }
            }  

        }
        return true;
    }

    public boolean bfs(HashMap<Integer, ArrayList<Integer>> neighbors, int n, int i, int[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);        
        visited[i] = 1;
        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            if (!neighbors.containsKey(curr)) continue;
            ArrayList<Integer> lists = neighbors.get(curr);
            for (Integer nei : lists) {
                if (visited[nei] == visited[curr]) {
                    return false;
                }
                if (visited[nei] == 0) {
                    queue.add(nei);
                    visited[nei] = -visited[curr]; 
                }
            }                
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] dislikes = {
            {1, 2},
            {1, 3},
            {2, 4}
        };
        possibleBipartition sol = new possibleBipartition();
        System.out.println(sol.possibleBipartition(n, dislikes)); // true       
    }
}
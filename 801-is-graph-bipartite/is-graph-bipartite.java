class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colour = new int[n]; // also acts as visited array
        Arrays.fill(colour, -1);

        for (int i = 0; i < n; i++) {
            if (colour[i] == -1) {
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i, 1));   // start with color 1
                colour[i] = 1;

                while (!q.isEmpty()) {
                    Pair p = q.poll();
                    int node = p.first;
                    int col = p.second;

                    for (int nei : graph[node]) {
                        if (colour[nei] == -1) {
                            int newColour = (col == 1) ? 2 : 1;
                            colour[nei] = newColour;
                            q.add(new Pair(nei, newColour));
                        }
                        else if(colour[nei] == col) return false;
                    }
                }
            }
        }
        return true;
    }

    class Pair {
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}
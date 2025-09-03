class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int res = 0;
        //ascending order based on the first element (index 0), and if equal, sort in descending order based on the second element (index 1).
        Arrays.sort(points, (a, b) -> 
            a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0])
        );
        for(int i = 0; i < n; i++){
            //A
            int x1 = points[i][0];
            int y1 = points[i][1];

            int maxY = Integer.MIN_VALUE;
            for(int j = i + 1 ; j < n; j++){
                //B
                int x2 = points[j][0];
                int y2 = points[j][1];

                if(y2 > y1) continue; //B above A

                if(y2 > maxY){
                    res++;
                    maxY = y2;
                }
            }
        }
        return res;
    }
}
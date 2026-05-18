import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n <= 1) return 0;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        boolean[] vis = new boolean[n];

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        vis[0] = true;

        int count = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            while(size > 0) {
                int index = q.poll();

                if(index == n - 1) return count;

                int left = index - 1;
                if(left >= 0 && !vis[left]) {
                    q.offer(left);
                    vis[left] = true;
                }

                int right = index + 1;
                if(right < n && !vis[right]) {
                    q.offer(right);
                    vis[right] = true;
                }

                for(int ind : map.get(arr[index])) {
                    if(!vis[ind]) {
                        q.offer(ind);
                        vis[ind] = true;
                    }
                }
                map.get(arr[index]).clear();
                size--;
            }
            count++;
        }
        return -1;
    }
}
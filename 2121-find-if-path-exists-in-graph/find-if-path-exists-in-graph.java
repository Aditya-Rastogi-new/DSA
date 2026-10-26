class Solution {
    public boolean validPath(int n, int[][] edge, int start, int end) {
        if(start == end) return true;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        for(int i = 0; i<edge.length; i++){
            int a = edge[i][0], b = edge[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] vis= new boolean[n]; // false
        vis[start] = true;
        bfs(start,end,adj,vis);
        return vis[end];
    }

    private void bfs(int start,int end, List<List<Integer>> adj, boolean[] vis) {
        int n = vis.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(q.size() > 0){
            int front = q.remove();
            for(int ele : adj.get(front)){
                if(!vis[ele]){
                    vis[ele] = true;
                    q.add(ele);
                    if(ele == end) return;
                }
            }
        }
    }
}
class Solution {
    class Pair{
        int dst;
        int cnt;
        Boolean color;
        public Pair(int dst, int cnt, Boolean color){
            this.dst = dst;
            this.cnt = cnt;
            this.color = color;
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<Integer>[] adjRed = new ArrayList[n];
        ArrayList<Integer>[] adjBlue = new ArrayList[n];

        for(int i=0;i<n;i++){
            adjRed[i] = new ArrayList<>();
            adjBlue[i] = new ArrayList<>();
        }

        for(int[] edge:redEdges){
            adjRed[edge[0]].add(edge[1]);
        }
        for(int[] edge:blueEdges){
            adjBlue[edge[0]].add(edge[1]);
        }

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Integer.compare(a.cnt, b.cnt));
        int[] ansRed = new int[n];
        int[] ansBlue = new int[n];
        Arrays.fill(ansRed,Integer.MAX_VALUE);
        Arrays.fill(ansBlue,Integer.MAX_VALUE);
        ansRed[0] = 0;
        ansBlue[0] = 0;
        q.add(new Pair(0, 0, null));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int src = p.dst;
            int curCnt = p.cnt;
            Boolean curColor = p.color;

            if(curColor == null || curColor){
                for(int nxt: adjRed[src]){
                    if(curCnt+1 < ansRed[nxt]){
                        ansRed[nxt] = curCnt+1;
                        q.add(new Pair(nxt, curCnt+1, false));
                    }
                }
            }

            if(curColor == null || !curColor){
                for(int nxt: adjBlue[src]){
                    if(curCnt+1 < ansBlue[nxt]){
                        ansBlue[nxt] = curCnt+1;
                        q.add(new Pair(nxt, curCnt+1, true));
                    }
                }
            }
        }
        
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = Math.min(ansRed[i], ansBlue[i]);
            if(ans[i] == Integer.MAX_VALUE) ans[i] = -1;
        }

        return ans;
    }
}
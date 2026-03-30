class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int count=0;
        boolean[] vis=new boolean[n];//false
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(i,vis,isConnected);
                count++;
            }
        }
        return count;
     }
     private void bfs(int i,boolean[] vis,int [][] isConnected){
        int n=isConnected.length;
        vis[i]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        while(q.size()>0){
            int front=q.remove();
            for(int j=0;j<n;j++){
            if(isConnected[front][j]==1 && !vis[j]){
                q.add(j);
                vis[j]=true;
            }
            }
        }
     }
}
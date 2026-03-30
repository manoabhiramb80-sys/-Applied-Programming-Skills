class Solution {
    boolean[] v;
    public boolean canVisitAllRooms(List<List<Integer>> r) {
        int n=r.size();
        v=new boolean[n];
        solve(r, n, 0);
        for(int i=0;i<n;i++){
            if(!v[i]) return false;
        }
        return true;
    }
    void solve(List<List<Integer>> r, int n, int ind){
        if(ind>=n) return;
        if(v[ind]) return;
        v[ind]=true;
        for(int i=0;i<r.get(ind).size();i++){
            solve(r, n, r.get(ind).get(i));
        }
    }
}
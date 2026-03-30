class Solution {
    static int size[];//stores the size of the group whose leader is ith node
    static int parent[];//stores the group leader of the group to which ith node belongs
    int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);//path compression
    }

    void union(int a,int b){
        int grpa=find(a);
        int grpb=find(b);
        if(size[grpa]>=size[grpb]){
            parent[grpb]=grpa;
            size[grpa]+=size[grpb];
        }
        else{
            parent[grpa]=grpb;
            size[grpb]+=size[grpa];
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        size=new int[n];
        parent=new int[n];
        for(int i=0;i<n;i++){
            size[i]=1;
            parent[i]=i;
        }

        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String s=accounts.get(i).get(j);
                if(map.containsKey(s)){
                    union(map.get(s),i);
                }
                else map.put(s,i);
            }
        }

        List<List<String>> preAns=new ArrayList<>();
        for(int i=0;i<n;i++){
            preAns.add(new ArrayList<>());
        }
        for(String s:map.keySet()){
            int ind=map.get(s);//it stores the index(list) to which the string belongs so that we can add it to its parent
            preAns.get(find(ind)).add(s);//stores in the ultimate parent list/ in the group leader list
        }

        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(preAns.get(i).size()>0){
                Collections.sort(preAns.get(i));//sorting the list
                List<String> temp=new ArrayList<>();
                temp.add(accounts.get(i).get(0));
                for(int j=0;j<preAns.get(i).size();j++){
                    temp.add(preAns.get(i).get(j));
                }
                ans.add(temp);
            }
            
        }

        return ans;
    }
}
class MyHashSet {
    int[][] arr;

    public MyHashSet() {
        arr = new int[10][10000];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(arr[i], -999);
        }
    }

    public void add(int key) {
        int hash = key % 10;
        int firstDeleted = -1;

        for (int i = 0; i < 10000; i++) {
            if (arr[hash][i] == key) return;
            if (arr[hash][i] == -11 && firstDeleted == -1)
                firstDeleted = i;
            if (arr[hash][i] == -999) {
                if (firstDeleted != -1)
                    arr[hash][firstDeleted] = key;
                else
                    arr[hash][i] = key;
                return;
            }
        }
    }

    public void remove(int key) {
        int hash = key % 10;
        for (int i = 0; i < 10000; i++) {
            if (arr[hash][i] == -999) return;
            if (arr[hash][i] == key) {
                arr[hash][i] = -11;
                return;
            }
        }
    }

    public boolean contains(int key) {
        int hash = key % 10;
        for (int i = 0; i < 10000; i++) {
            if (arr[hash][i] == -999) return false;
            if (arr[hash][i] == key) return true;
        }
        return false;
    }
}



/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
 

/*
class MyHashSet {

    private boolean[] hashSetArray;

    public MyHashSet() {
        this.hashSetArray = new boolean[1_000_001];
    }
    
    public void add(int key) {
        hashSetArray[key] = true;
    }
    
    public void remove(int key) {
        hashSetArray[key] = false;
    }
    
    public boolean contains(int key) {
        return hashSetArray[key];
    }
}*/
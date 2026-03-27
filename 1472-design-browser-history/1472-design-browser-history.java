class BrowserHistory {

    ArrayList<String> arr;
    int curr;
    int MAX;

    public BrowserHistory(String homepage) {
        arr = new ArrayList<>();
        arr.add(homepage);
        curr = 0;
        MAX = arr.size();
    }
    
    public void visit(String url) {
        curr += 1;
        arr.add(curr, url);
        MAX = curr + 1;
    }
    
    public String back(int steps) {
        if (curr - steps >= 0) {
            curr -= steps;
            return arr.get(curr);
        }
        curr = 0;
        return arr.get(curr);
    }
    
    public String forward(int steps) {
        if (curr + steps < MAX) {
            curr += steps;
            return arr.get(curr);
        }
        curr = MAX - 1;
        return arr.get(curr);
    }
}
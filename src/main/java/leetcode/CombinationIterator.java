package leetcode;

class CombinationIterator {
    
    LinkedList<String> combination;

    public CombinationIterator(String characters, int combinationLength) {
        combination = new LinkedList();
        //combi vs perm is the starting point. where comb has start
        dfs(characters, combinationLength, 0, new boolean[characters.length()], new StringBuilder());
    }
    
    void dfs(String word, int combinationLength, int start, boolean[] visited, StringBuilder builder) {
        if(combinationLength == 0) {
            //base case
            combination.add(builder.toString());
        } else {
            for(int i = start; i < word.length(); i++) {
                if(visited[i]) continue;
                visited[i] = true;
                builder.append(word.charAt(i));
                dfs(word, combinationLength - 1, i +1, visited, builder);
                visited[i] = false;
                builder.setLength(builder.length() -1);
            }
        }
    }
    
    public String next() {
        return combination.removeFirst();
    }
    
    public boolean hasNext() {
        return combination.size() > 0;
    }
}

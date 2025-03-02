

import java.util.*;
//1079. Letter Tile Possibilities

class Solution {
    public void solve(String curr, String s, HashSet<String> st, boolean[] vis){
        if(curr.length() > 0) st.add(curr);

        for(int i = 0; i < s.length(); i++){
            if(vis[i] == true) continue;

            //take 
            curr = curr+s.charAt(i);
            vis[i] = true;

            solve(curr, s, st, vis);

            //backtrack
            curr = curr.substring(0, curr.length()-1);
            vis[i] = false;
        }
    }
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        boolean[] vis = new boolean[n+1];
        HashSet<String> st = new HashSet<>();

        solve("", tiles, st, vis);
        return st.size();
    }
}



import java.util.*;

//1718. Construct the Lexicographically Largest Valid Sequence

class Solution {
    public boolean solve(int idx, int n, int[] result, boolean[] vis){
        if(idx >= result.length) return true;
            
        if(result[idx] != -1){
            return solve(idx+1, n, result, vis);
        }

        for(int num = n; num >= 1; num--){
            if(vis[num]) continue;

            result[idx] = num;
            vis[num] = true;

            if(num == 1){
                if(solve(idx+1, n, result, vis)){
                    return true;
                }
            }
            else{
                int j = idx+result[idx];

                if(j < result.length && result[j] == -1){
                    result[j] = num;
                    if(solve(idx+1, n, result, vis)){
                        return true;
                    }

                    //backtrack
                    result[j] = -1;
                }
            }

            //backtrack
            result[idx] = -1;
            vis[num] = false;
        }

        return false;
    }
    public int[] constructDistancedSequence(int n) {
        int size = n*2-1;
        boolean[] vis = new boolean[n+1];;
        int[] result = new int[size];
        Arrays.fill(result, -1);

        solve(0, n, result, vis);
        return result;
    }
}
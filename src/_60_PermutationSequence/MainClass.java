package _60_PermutationSequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i = 1; i <= n; ++i){
            nums[i - 1] = i;
        }
        int[] factorial = new int[n];
        factorial[0] = 1;
        for(int i = 2; i <= n; ++i){
            factorial[i - 1] = factorial[i - 2] * i;
        }
        int pos = 0;
        while(k > 1){
            if(k == factorial[n - 1]){
                StringBuilder sb = new StringBuilder();
                for(int num : nums){
                    sb.append(num);
                }
                return sb.reverse().toString();
            }
            if(k > factorial[n - pos - 2]){
                int cnt = k / factorial[n - pos - 2];

                if(k % factorial[n - pos - 2] == 0){
                    cnt--;
                }
                int tmp = nums[pos + cnt];
                k = k - cnt * factorial[n - pos - 2];
                for(int i = pos + cnt; i > pos; --i){
                    nums[i] = nums[i - 1];
                }
                nums[pos] = tmp;
            }
            pos++;
        }
        StringBuilder sb = new StringBuilder();
        for(int num : nums){
            sb.append(num);
        }
        return sb.toString();
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            String ret = new Solution().getPermutation(n, k);

            String out = (ret);

            System.out.print(out);
        }
    }
}
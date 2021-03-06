package com.ob.algorithm.dynamic;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: oubin
 * @Date: 2020/8/25 08:40
 * @Description: 最长子串和子串长度
 */
public class MaxSubStringLength {

    public static void main(String[] args) {

        String str = "123456789agcdegadewrtrazgbwrcaseagedegd";
        System.out.println(maxLengthString(str));

    }

    public static int maxLengthString(String str) {

        int i = 0;
        int j = 0;
        int max = 0;
        int tempi = i;
        int tempj = j;
        Set<Character> set = new HashSet<>();
        while (j < str.length()) {
            if (!set.contains(str.charAt(j))) {
                set.add(str.charAt(j));
                max = Math.max(max, set.size());
                if (max == set.size()) {
                    tempi = i;
                    tempj = j;
                }
                j++;
            } else {

                set.remove(str.charAt(i++));
            }
        }
        System.out.println(tempi + "  " + tempj + "  " + str.substring(tempi, tempj + 1));
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}

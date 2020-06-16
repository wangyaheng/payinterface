package leetcode3;

import com.lefu.commons.utils.lang.JsonUtils;

import java.util.Arrays;

/**
 *
 给出一个区间的集合，请合并所有重叠的区间。

 示例 1:

 输入: [[1,3],[2,6],[8,10],[15,18]]
 输出: [[1,6],[8,10],[15,18]]
 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class Q55 {

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge(ints);

        System.out.println(JsonUtils.toJsonString(merge));

    }

    public static int[][] merge(int[][] intervals) {
        if(intervals.length==0) return new int[0][0];
        // 对集合进行排序
        int resultIndex = 0;
        int[][] result = new int[intervals.length][intervals[0].length];
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        System.out.println(JsonUtils.toJsonString(intervals));
        int s = intervals[0][0];
        int l = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 是否需要合并
            if(intervals[i][0]<=l){
                // 需要合并
                l = Math.max(intervals[i][1],l);

            }else{
                // 不需要合并
                result[resultIndex][0] = s;
                result[resultIndex++][1] = l;
                s = intervals[i][0];
                l = intervals[i][1];

            }

        }
        result[resultIndex][0] = s;
        result[resultIndex][1] = l;
        int[][] ints = Arrays.copyOfRange(result, 0, resultIndex+1);
        return ints;
    }
}

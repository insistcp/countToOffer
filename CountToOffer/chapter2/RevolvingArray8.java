package CountToOffer;/*
* ------------------------------------------------------------------
* Copyright © 2017 Hangzhou DtDream Technology Co.,Lt d. All rights reserved.
* ------------------------------------------------------------------
*       Product: 题目描述：给定一个已经排好序的数组（递增排序）的旋转数组，让你查找这个数组中最小的元素。
*   Module Name: 解题思路：利用二分查找算法，排序数组的旋转数组有这样一种特性：数组被分为两部分，两部分都是已经排好序的；
*   并且我们可以知道，后半部分的小于前半部分；所我们可以设置两个点位于数组的两端，不断拿中间的值和两个端点值进行比较，
*   如果大于最左边，表明middle还是在左边数，此时我们可以将做端点移动到middle位置，如果小于最右边表明还是在最右边。
*   此时我们可以将右端点移动到middle位置。如此循环直到，left和right下标相邻。
*   特殊情况：
*   1：旋转数据就是排序数组本身。
*   2：旋转数组中有重复元素例如{1,0,1,1,1}这种情况，当middle元素和left以及right都相等时。我们需要采用顺序遍历的方式来确定最小元素。
*  Date Created: 2018-02-07
*   Description:
* ------------------------------------------------------------------
* Modification History
* DATE            Name           Description
* ------------------------------------------------------------------
* 2018-02-07     chenpeng sx-9325     ::tada
* ------------------------------------------------------------------
*/

public class RevolvingArray8 {
    public int getRevolvingMin(int[] data){
        if(data==null||data.length==0){
            return 0;
        }
        int left = 0;
        int right = data.length-1;
        int minIndex = 0;
        while(left<=right){
            int middle  = (left+right)/2;
            if(right-left==1){
                minIndex=right;
                break;
            }
            if(data[left]<data[right]){
                minIndex = left;
                break;
            }
            if(data[left]<data[middle]){
                left = middle;
            }
            if(data[middle]<data[right]){
                right = middle;
            }
            if(data[middle]==data[left] && data[middle]==data[right]){
                minIndex = left;
                for(int i=left+1;i<right;i++){
                    if(data[minIndex]>data[i]){
                        minIndex = i;
                    }
                }
                break;
            }
        }
        return data[minIndex];
    }

    public static void main(String[] args) {
        RevolvingArray8 ra = new RevolvingArray8();
        int[] test = {1,0,1,1,1};
        int res = ra.getRevolvingMin(test);
        System.out.println(res);
    }
}

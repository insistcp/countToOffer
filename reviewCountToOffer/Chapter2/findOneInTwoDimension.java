package reviewCountToOffer.Chapter2;

/**
 * Created by cp on 2018/3/26.
 */
public class findOneInTwoDimension {
    public boolean findnumber(int[][] arr,int target){
        if(arr == null){
            return false;
        }
        int len = arr.length;
        int height = arr[0].length;
        int i = len-1,j = 0;
        while(i>=0 && j<height){
            if(arr[i][j]<target){
                j++;
            }else if(arr[i][j]>target){
                i--;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] test = {{1,2,3,4},{5,6,7,8},{11,12,13,14},{21,22,23,24}};
        findOneInTwoDimension font  = new findOneInTwoDimension();
        boolean res = font.findnumber(test,4);
        System.out.println(res);
    }
}

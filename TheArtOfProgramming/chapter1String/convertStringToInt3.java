package TheArtOfProgramming.chapter1String;

/**
 * program:
 * description: 讲字符串转化为int，注意边界值的判断
 * author: chenpeng
 * create: 2018/4/7:下午12:38
 **/
public class convertStringToInt3 {
    public int convertToInt(String str){
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        if(str == null){
            return MIN;
        }
        int res = 0;
        str = str.trim();
        int i = 0,len = str.length();
        boolean flag = true;
        if(str.charAt(i)=='-'){
            flag = false;
            i++;
        }else if(str.charAt(i)=='+'){
            i++;
        }
        while(i<len){
            char tmp = str.charAt(i);
            if(tmp<'0' || tmp>'9'){
                return MIN;
            }
            int y = tmp-'0';
            // 边界值的判断，当目前的值大于MAX／10时或者前n-1个数字相等并且当前位大于MAX的最后一位时，表示这个数的值已经大于MAX
            if(flag && (res > MAX / 10 || (res == MAX / 10 && y > MAX % 10))){
                res = MAX;
                break;
            }else if(!flag && (res > -MIN / 10 || (res == -MIN / 10 && y > -MIN % 10))){
                res = -MIN;
                break;
            }
            //res = res*10;
            res  = res*10 +y;
            i++;
        }
        System.out.println(MIN);
        System.out.println(MAX);
        return flag?res:-res;
    }

    public static void main(String[] args) {
        convertStringToInt3 csti = new convertStringToInt3();
        int res = csti.convertToInt("+12343333335");
        System.out.println(res);
    }
}

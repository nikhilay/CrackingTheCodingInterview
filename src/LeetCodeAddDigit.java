/**
 * Created by Nikhil on 9/22/16.
 */
public class LeetCodeAddDigit {
    public static void main(String[] args){
        LeetCodeAddDigit ob = new LeetCodeAddDigit();
        System.out.println(ob.addDigits(456));
    }
    public int addDigits(int num) {
        int result = 0;

        while(num!=0){
            result = result + num%10;
            num = num/10;
        }

        if(result>9){
            LeetCodeAddDigit obt = new LeetCodeAddDigit();

            return obt.addDigits(result);
        }else{
            return result;
        }

    }
}

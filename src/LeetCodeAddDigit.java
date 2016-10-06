import java.security.Timestamp;
import java.util.Calendar;

/**
 * Created by Nikhil on 9/22/16.
 */
public class LeetCodeAddDigit {
    public static void main(String[] args){
        LeetCodeAddDigit ob = new LeetCodeAddDigit();
        System.out.println(ob.addDigits(323));
        System.out.println(ob.efficientAddDigits(323));
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

    //betterSolution
    public int efficientAddDigits(int input){
        if(input % 9 ==0){
            return 9;
        }else{
            return input % 9;
        }
    }
}

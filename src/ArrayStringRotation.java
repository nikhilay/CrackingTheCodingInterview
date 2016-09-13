/**
 * Created by Nikhil on 9/13/16.
 */
public class ArrayStringRotation {

    public boolean isStringRotation(String s1, String s2){
       if(s1.length()!=s2.length()&& s1.length()>0 &&s2.length()>0){
           return false;
       }

       String s1s1 =  s1+s1;
        return isSubString(s1s1,s2);
    }

    public boolean isSubString(String s1, String s2){
        return true;
    }
}

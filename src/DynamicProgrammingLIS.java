import java.util.LinkedList;

/**
 * Created by Nikhil on 10/11/16.
 */
public class DynamicProgrammingLIS {

    public static void main(String[] args){
        int[] input = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        new DynamicProgrammingLIS().longestIncreasingSubsequence(input);

    }

    public void longestIncreasingSubsequence(int[] inputSequence){
        int n = inputSequence.length;
        int[] lis = new int[n];
        for(int i:lis){
            lis[i]=1;
        }
        LinkedList<Integer> result = new LinkedList<>();
        for(int i =1;i<inputSequence.length;i++){
            LinkedList<Integer> temp = new LinkedList<>();
            for(int j =0;j<i;j++){
                if(inputSequence[i]>inputSequence[j] && lis[i]<lis[j]+1){
                    temp.add(inputSequence[j] );
                    lis[i] = lis[j]+1;
                    if(j==(i-1)){
                        temp.add(inputSequence[i]);
                    }
                }
                if(lis[i]>lis[i-1]){
                    result = temp;
                }
            }
        }
        int max = 0;
        for(int i:lis){
          max = Math.max(max, i);
        }
        System.out.println("Longest increasing subsequence is "+ max);

        while(!result.isEmpty()){
            System.out.print(result.poll()+" ");
        }
    }
}

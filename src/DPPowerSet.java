import java.util.ArrayList;

/**
 * Created by Nikhil on 10/12/16.
 */
public class DPPowerSet {

    public ArrayList<ArrayList<Integer>> givePowerSet(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if (set.size() == index) {
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<Integer>());
        } else {
            allSubsets = givePowerSet(set, index + 1);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allSubsets) {
                int item = set.get(index);
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }
}

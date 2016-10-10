import static com.sun.tools.javac.jvm.ByteCodes.ret;

/**
 * Created by Nikhil on 10/9/16.
 */

public class SortingRanksFromStream {
    RankNode root = null;

    class RankNode

    {

        public int leftSize;
        public RankNode left;
        public RankNode right;
        public int data;

        public RankNode(int data) {
            this.data = data;
        }

        void track(int data) {
            if (root == null) {
                root = new RankNode(data);
            } else {
                root.insert(data);
            }
        }

        private void insert(int data) {
            if (data <= root.data) {
                if (left == null) {
                    left = new RankNode(data);
                } else {
                    left.insert(data);
                }
                leftSize++;
            } else {
                if (right == null) {
                    right = new RankNode(data);
                } else {
                    right.insert(data);
                }
            }
        }

        public int getRankOfNumber(int data) {
            return root.getRank(data);
        }

        private int getRank(int data) {
            if (root.data == data) {
                return leftSize;
            } else if (data < root.data) {
                if (left == null) return -1;
                else return left.getRank(data);
            } else {
                int rightRank = right == null ? -1 : right.getRank(data);
                if (rightRank == -1) return -1;
                else return leftSize + 1 + rightRank;
            }

        }
    }

}

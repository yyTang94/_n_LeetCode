import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Temp {

    public List<List<Integer>> fun1(int[] nums) {
        // pre check
        if (nums == null) {
            return new ArrayList<>();
        }

        // (i, j, k)
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (left == i + 1 || nums[left] != nums[left - 1]) {
                    if (nums[i] + nums[left] + nums[right] == 0) {
                        List<Integer> triple = new ArrayList<>();
                        triple.add(nums[i]);
                        triple.add(nums[left]);
                        triple.add(nums[right]);

                        result.add(triple);
                    }
                }
            }
        }

        return result;
    }

    public void fun2(int[][] matrix) {
        // pre check
        if (matrix == null) {
            return;
        }

        // zeroInFirstRow, zeroInFirstCol
        boolean zeroInFirstRow = false;
        boolean zeroInFirstCol = false;

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                zeroInFirstRow = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                zeroInFirstCol = true;
                break;
            }
        }

        // find zero in main matrix
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // set zero in main matrix
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // set zero in first
        if (zeroInFirstRow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (zeroInFirstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    public List<List<String>> fun3(String[] strs) {
        // pre check
        if (strs == null) {
            return new ArrayList<>();
        }

        //
        Map<String, List<String>> m = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedS = new String(c);

            if (m.containsKey(sortedS)) {
                m.get(sortedS).add(s);
            } else {
                m.put(sortedS, new ArrayList<>());
                m.get(sortedS).add(s);
            }
        }

        //
        List<List<String>> result = (List<List<String>>) m.values();

        return result;
    }

    public int fun4(String s) {
        // pre check
        if (s == null) {
            return 0;
        }

        //
        Set<Character> unique = new HashSet<>();
        int pioneer = 0;

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!unique.contains(s.charAt(pioneer))) {
                unique.add(s.charAt(pioneer));
                pioneer++;
            } else {
                int length = pioneer - i;
                if (length > maxLength) {
                    maxLength = length;
                }

                unique.remove(s.charAt(i));
            }
        }

        return maxLength;
    }

    public String fun5(String s) {
        return "";
    }

    public boolean fun6(int[] nums) {
        // pre check
        if (nums == null) {
            return false;
        }

        // status: left, left-mid, left-mid-pioneer
        int left = 0;
        int mid = 0;
        int pioneer = 0;

        String status = "start";

        for (int n : nums) {
            if (status.equals("start")) {
                left = n;
            } else if (status.equals("left")) {
                if (n < left) {
                    left = n;
                } else if (n > left) {
                    mid = n;
                    status = "left-mid";
                }
            } else if (status.equals("left-mid")) {
                if (n > mid) {
                    status = "success";
                    break;
                } else if (left < n && n < mid) {
                    mid = n;
                } else if (n < left) {
                    pioneer = n;
                    status = "left-mid-pioneer";
                }
            } else if (status.equals("left-mid-pioneer")) {
                if (n > mid) {
                    status = "success";
                    break;
                } else if (pioneer < n && n < mid) {
                    left = pioneer;
                    mid = n;
                    status = "left-mid";
                } else if (n < pioneer) {
                    pioneer = n;
                }
            }
        }

        return status.equals("success") ? true : false;

    }

    public static void main(String[] args) {
        return;
    }

}

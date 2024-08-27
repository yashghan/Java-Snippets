
import java.util.*;

public class Main {
    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLine();
        }

        Map<String, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(a[i], k -> new ArrayList<>()).add(i);
        }

        while (q-- > 0) {
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;
            sc.nextLine(); // Consume the newline character

            Set<Character> st = new HashSet<>();
            for (char c : a[i].toCharArray()) {
                st.add(c);
            }
            for (char c : a[j].toCharArray()) {
                st.add(c);
            }

            if (st.size() < 4) {
                System.out.println(Math.abs(i - j));
                continue;
            }

            if (i > j) {
                int temp = i;
                i = j;
                j = temp;
            }

            int l = -1, r = n;

            for (Map.Entry<String, List<Integer>> entry : mp.entrySet()) {
                String str = entry.getKey();
                List<Integer> v = entry.getValue();

                if (str.equals(a[i]) || str.equals(a[j])) {
                    continue;
                }

                int idx = Collections.binarySearch(v, i);
                if (idx < 0) {
                    idx = -idx - 1;
                }
                if (idx > 0) {
                    l = Math.max(l, v.get(idx - 1));
                }
                if (idx < v.size()) {
                    r = Math.min(r, v.get(idx));
                }
            }

            if (l == -1 && r == n) {
                System.out.println(-1);
            } else if (l == -1) {
                System.out.println(Math.abs(r - i) + Math.abs(j - r));
            } else if (r == n) {
                System.out.println(Math.abs(i - l) + Math.abs(j - l));
            } else {
                int ans = Math.min(Math.abs(i - l) + Math.abs(j - l), Math.abs(r - i) + Math.abs(j - r));
                System.out.println(ans);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }
}

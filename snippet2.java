import java.util.*;



public class D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();
        int var = 0;
        Set<Integer> st = new HashSet<>();
        for(int i = 0; i < n; i++){
            int len = scn.nextInt();
            for(int j = 0; j < len; j++){
                st.add(scn.nextInt());
            }
            int j = 0;
            int flag = 0;
            while(true){
                if(!st.contains(j)){
                    if(flag == 0){
                        flag = 1;
                    }
                    else{
                        var = Math.max(var, j);
                        break;
                    }
                }
                j++;
            }
            st.clear();
        }
        int ans = 0;
        if(var >= m){
            ans = (m + 1) * var;
            System.out.println(ans);
        }
        else{
            ans = (var + 1) * var + (m * (m + 1)) / 2 - (var * (var + 1)) / 2;
            System.out.println(ans);
        }
    }
}

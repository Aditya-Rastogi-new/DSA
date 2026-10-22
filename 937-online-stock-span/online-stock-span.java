
import java.util.Stack;

class StockSpanner {
    Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int k = 1;

        while (!st.isEmpty() && st.peek()[0] <= price) {
            k += st.pop()[1];
        }

        st.push(new int[]{price, k});

        return k;
    }
}

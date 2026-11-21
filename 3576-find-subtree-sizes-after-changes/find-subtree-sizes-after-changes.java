
class Solution {
    int[] ans;
    int[] last = new int[26];
    ArrayList<Integer>[] tree;
    int[] parent;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        ans = new int[n];
        tree = new ArrayList[n];
        this.parent = parent;

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        Arrays.fill(last, -1);

        dfs(0, s);

        return ans;
    }

    void dfs(int node, String s) {
        int ch = s.charAt(node) - 'a';
        int old = last[ch];

        ans[node] = 1;
        last[ch] = node;

        for (int child : tree[node]) {
            dfs(child, s);
        }

        int newParent;

        if (old != -1) {
            newParent = old;
        } else {
            newParent = parent[node];
        }

        if (newParent != -1) {
            ans[newParent] += ans[node];
        }

        last[ch] = old;
    }
}

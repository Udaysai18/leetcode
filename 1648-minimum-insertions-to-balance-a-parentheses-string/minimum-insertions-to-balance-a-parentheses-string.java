class Solution {
    public int minInsertions(String s) {
        int insertions = 0, open = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else { // c == ')'
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++; // consume the pair
                    if (open > 0) {
                        open--;
                    } else {
                        insertions++; // need an extra '('
                    }
                } else {
                    // single ')'
                    if (open > 0) {
                        open--;
                        insertions++; // need one more ')'
                    } else {
                        insertions += 2; // need '(' + ')'
                    }
                }
            }
        }
        
        return insertions + 2 * open;
    }
}

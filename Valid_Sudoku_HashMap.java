class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<String, HashSet<Character>> grids = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && board[i][j] != ',') {
                    if (!rows.containsKey(i)) {
                        rows.put(i, new HashSet<Character>());
                    }
                    if (!cols.containsKey(j)) {
                        cols.put(j, new HashSet<Character>());
                    }
                    int row = i/3;
                    int col = j/3;
                    StringBuilder sb = new StringBuilder();
                    sb.append("#");
                    sb.append(row);
                    sb.append("#");
                    sb.append(col);
                    String key = sb.toString();
                    if (!grids.containsKey(key)) {
                        grids.put(key, new HashSet<Character>());
                    }
                    if (rows.get(i).contains(board[i][j])) {
                        return false;
                    }
                    if (cols.get(j).contains(board[i][j])) {
                        return false;
                    }
                    if (grids.get(key).contains(board[i][j])) {
                        return false;
                    }
                    rows.get(i).add(board[i][j]);
                    cols.get(j).add(board[i][j]);
                    grids.get(key).add(board[i][j]);
                }
            }
        }
        return true;
    }
}
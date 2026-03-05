import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int size;
    private boolean[][] isOpen;
    private WeightedQuickUnionUF ufPercolation;
    private WeightedQuickUnionUF ufFullness;
    private final int topVirtual;
    private final int bottomVirtual;
    private int openCount;

    public Percolation(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        this.size = size;
        isOpen = new boolean[size][size];
        ufPercolation = new WeightedQuickUnionUF(size * size + 2);
        ufFullness = new WeightedQuickUnionUF(size * size + 1);
        topVirtual = size * size;
        bottomVirtual = size * size + 1;
    }

    private int toIndex(int row, int col) {
        return row * size + col;
    }

    private void validate(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void open(int row, int col) {
        validate(row, col);
        if (isOpen[row][col]) {
            return;
        }
        isOpen[row][col] = true;
        openCount += 1;
        int i = toIndex(row, col);
        if (row == 0) {
            ufPercolation.union(i, topVirtual);
            ufFullness.union(i, topVirtual);
        }
        if (row == size - 1) {
            ufPercolation.union(i, bottomVirtual);
        }
        int[][] neighbors = {{row - 1, col}, {row + 1, col}, {row, col - 1}, {row, col + 1}};
        for (int[] neighbor : neighbors) {
            int r = neighbor[0];
            int c = neighbor[1];
            if (r >= 0 && r < size && c >= 0 && c < size && isOpen[r][c]) {
                ufPercolation.union(i, toIndex(r, c));
                ufFullness.union(i, toIndex(r, c));
            }
        }
    }

    public boolean isOpen(int row, int col) {
        validate(row, col);
        return isOpen[row][col];
    }

    public boolean isFull(int row, int col) {
        validate(row, col);
        int i = toIndex(row, col);
        return isOpen[row][col] && ufFullness.connected(i, topVirtual);
    }

    public int numberOfOpenSites() {
        return openCount;
    }

    public boolean percolates() {
        return ufPercolation.connected(topVirtual, bottomVirtual);
    }

}

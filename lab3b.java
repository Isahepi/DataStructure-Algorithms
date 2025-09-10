// lab3b.java
// Fall 2025
// Isabella Herrera Pilonieta
// Demonstrates recursive algorithm to "flood fill"
// an ASCII graphic

class lab3b {
    public static void main(String[] args) {

        // grid represents a graphic image
        char grid[][] = {
            { 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g' },
            { 'g', 'g', ' ', 'g', 'g', ' ', ' ', ' ', 'g' },
            { 'g', 'g', ' ', ' ', ' ', ' ', 'g', ' ', 'g' },
            { 'g', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'g' },
            { 'g', ' ', ' ', ' ', ' ', 'g', ' ', ' ', 'g' },
            { 'g', ' ', ' ', ' ', ' ', 'g', ' ', ' ', 'g' },
            { 'g', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'g' },
            { 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g' }
        };

        System.out.println("Original\n");
        display(grid);

        // Fill spaces with r
        floodFillTarget(grid, 5, 3, ' ', 'r');
        System.out.println("After flood fill with r\n");
        display(grid);

        // Fill border with i
        floodFillTarget(grid, 0, 0, 'g', 'i');
        System.out.println("After flood filling border with i\n");
        display(grid);
    } // main

    public static void floodFillTarget(char[][] temp, int row, int col, char fillcolor, char bordercolor) {
        //Check if the current row/col is out of bounds
        if (row < 0 || row >= temp.length || col < 0 || col >= temp[row].length) {
            return;
        }

        // Stop if this cell is NOT the fillcolor character
        if (temp[row][col] != fillcolor) {
            return;
        }

        //Replace the current cell with the fill color
        temp[row][col] = bordercolor;

        //Recursve calls in all 4 directions
        floodFillTarget(temp, row, col - 1, fillcolor, bordercolor); // left
        floodFillTarget(temp, row, col + 1, fillcolor, bordercolor); // right
        floodFillTarget(temp, row - 1, col, fillcolor, bordercolor); // up
        floodFillTarget(temp, row + 1, col, fillcolor, bordercolor); // down
    } // floodFillTarget

    // display array
    public static void display(char[][] temp) {
        for (int r = 0; r < temp.length; r++) {
            for (int c = 0; c < temp[r].length; c++) {
                System.out.print(temp[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    } // display
} // class

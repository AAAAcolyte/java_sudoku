public class Grid {
    private Square[][] myGrid = new Square[9][9];
    public Grid(int[][] _grid){
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++){
                if(_grid[i][j] == 0)
                    myGrid[i][j] = new Square();
                else
                    myGrid[i][j] = new Square(_grid[i][j]);
            }
    }
    public void printGrid(){
        for(int i = 0; i < myGrid.length; i++) {
            for (int j = 0; j < myGrid[0].length; j++) {
                myGrid[i][j].printValue();
                System.out.print(", ");
            }
            System.out.println();
        }
    }
    public boolean hasFreeSpace(){
        for(int i = 0; i < myGrid.length; i++) {
            for (int j = 0; j < myGrid[0].length; j++) {
                if (myGrid[i][j].isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isGoodMove(int row,int col) {
        return myGrid[row][col].hasUniquePMark();
    }
    public void makeMove(int row,int col){
        myGrid[row][col].setFieldValue(myGrid[row][col].uniquePMark());
    }
    public void removePMarks(int row,int col){
        // Row
        for(int i = 0; i < 9; i++){
            if(myGrid[row][i].isEmpty() == false){
                myGrid[row][col].removePMarkIfThere(myGrid[row][i].getFieldValue());
            }
        }
        // Col
        for(int i = 0; i < 9; i++){
            if (myGrid[i][col].isEmpty() == false) {
                myGrid[row][col].removePMarkIfThere(myGrid[i][col].getFieldValue());
            }
        }
        // 3*3 Square
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(myGrid[startRow+i][startCol+j].isEmpty() == false)
                myGrid[row][col].removePMarkIfThere(myGrid[startRow+i][startCol+j].getFieldValue());
            }
        }
    }
    public void compute(){
        while(hasFreeSpace()){
            for(int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (myGrid[i][j].isEmpty()) {
                        removePMarks(i, j);
                        if(isGoodMove(i,j))
                            makeMove(i,j);
                    }
                }
            }
            printGrid();
            System.out.println();
        }

    }
}

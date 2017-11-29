public class Square {
    private int fieldValue; // 0 == Empty Range : 1 - 9
    private int[] pMarks = {1,2,3,4,5,6,7,8,9};
    private int nPMark; // Number of pencil marks
    public Square(int n){
        this.fieldValue = n;
    }
    public Square(){
        this.fieldValue = 0;
    }
    public int getFieldValue(){
        return fieldValue;
    }
    public boolean isEmpty(){
        if(fieldValue == 0)
            return true;
        else
            return false;
    }
    public boolean hasUniquePMark(){
        int counter = 0;
        for(int i = 0; i < pMarks.length; i++){
            if(pMarks[i] == 0)
                counter ++;
        }
        if(counter == 8) {
            return true;
        }
        else
            return false;
    }
    public int uniquePMark(){
        assert hasUniquePMark() : "PMark is not unique";
        for(int i = 0; i < pMarks.length; i++)
            if(pMarks[i] != 0)
                return pMarks[i];
        return 0;
    }
    public void removePMarkIfThere(int n){
        for(int i = 0; i < pMarks.length; i++){
            if(pMarks[i] == n) {
                pMarks[i] = 0;
                break;
            }
        }
    }
    public void setFieldValue(int n){
        fieldValue = n;
    }
    public void printValue() {
        System.out.print(fieldValue);
    }
}

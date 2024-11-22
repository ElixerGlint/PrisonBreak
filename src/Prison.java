import java.util.Arrays;

public class Prison {
    private int[] boxes;

    public Prison(int boxnum) {
        boxes = new int[boxnum];
        for (int i = 0; i < boxnum; i++) {
            boxes[i] = i;
        }
        this.shuffle();
    }

    public boolean followSmartPath(int start, boolean show) { //VERY WRONG
        String output = "";
        for(int i = 0; i < boxes.length; i++) { //the rate will be determined here VERY WRONG
            output += boxes[i];
            if(start == boxes[i]) {

                return true;
            }
        }
        return false;
    }

    
    @Override
    public String toString() {
        String output = "";
        for(int i = 0; i < boxes.length; i++) {
            if(i%10 == 0) {
                output+="\n";
            }
            if(i < 10) { //box #
                output+= "[0" + i + ", " + boxes[i] + "] ";
            }
            else{ //box #
                output+= "[" + i + ", " + boxes[i] + "] ";
            }
        }
        return output;

    }


    public void shuffle() {
        int tempnum = 0;
        int tempindex = 0;
        int tempnum2 = 0;
        int tempindex2 = 0;

        for(int i = 0 ; i< boxes.length; i++) { //dont use i here

            tempindex = (int) (Math.random()*boxes.length);
            tempnum = boxes[tempindex];

            tempindex2 = (int) (Math.random()*boxes.length);
            tempnum2 = boxes[tempindex2];
            
            boxes[tempindex] = tempnum2;
            boxes[tempindex2] = tempnum;
        }
    }
    public void reset() {
        for(int i = 0; i < boxes.length; i++) {
            boxes[i] = i;
        }
    }

    public int[] getBoxes() {
        return boxes;
    }

    public void setBoxes(int[] boxes) {
        this.boxes = boxes;
    }
}

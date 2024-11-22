import java.util.Arrays;

public class Prison {
    private int[] boxes;

    public Prison(int boxnum) {
        boxes = new int[boxnum];
        for (int i = 0; i < boxnum; i++) {
            boxes[i] = (int) (Math.random() * boxnum);
        }
    }

    @Override
    public String toString() {
        String output = "";
        for(int i = 0; i < boxes.length; i++) {
            if(i%10 == 0) {
                output+="\n";
            }
            if(i < 10) { //box #
                output+= "[0" + i + ", " + boxes[i] + "]";
            }
            else{ //box #
                output+= "[" + i + ", " + boxes[i] + "]";
            }
        }
        return output;

    }
}

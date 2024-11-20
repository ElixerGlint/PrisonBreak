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

            if(i < 10) {
                output+= "[0" + i + "]";
            }
            else{
                output+= "[" + i + "]";
            }
            if(i%10 == 0 && i > 0) {
                output+="\n";
                for(int j = i-10; j < i; j++) {
                    output+= "[" + boxes[j] + "]";
                }
                output += "\n";
            }
        }
        return output;

    }
}

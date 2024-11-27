
public class Prison {

    private int[] boxes; //2 prisoners

    public Prison(int boxnum) {
        boxes = new int[boxnum];
        for (int i = 0; i < boxnum; i++) {
            boxes[i] = i;
        }
        this.shuffle();
    }

    public double simulate(int trials, boolean whichPath) {
        int wins = 0;
        if (whichPath) {
            for (int j = 0; j < 1000000; j++) {
                for (int i = 0; i < trials; i++) {
                    if(swimulatesmart(i) == true) {
                        wins++;
                    }
                }
            }
        }
        else {
            for (int j = 0; j < 1000000; j++) {
                for (int i = 0; i < trials; i++) {
                    if(simulaterandom(i) == true) {
                        wins++;
                    }
                }
            }
        }
        

        return wins / trials; //REPLACE -100!
    }

    public boolean swimulatesmart(int startnum) {
        boolean output;
        output = followSmartPath(startnum, false);

        return output;
    }

    public boolean simulaterandom(int startnum) {
        boolean output;
        output = followRandomPath(startnum, false);

        return output;
    }

    public boolean followSmartPath(int start, boolean show) { //ask questions
        int tempnum = start;
        for (int i = 0; i < boxes.length / 2; i++) { //the possible error point
            if (show) {
                System.out.print(tempnum + " -> ");
            }
            tempnum = boxes[tempnum];
            if (boxes[tempnum] == boxes[start]) {
                if (show) {
                    System.out.print(start + " -> ");
                }
                return true;
            }
        }
        System.out.println();
        return false;
    }

    public boolean followRandomPath(int start, boolean show) { //cant repeat boxes you have looked through
        int tempboxes[] = boxes.clone();

        othershuffle(tempboxes);

        for (int i = 0; i < boxes.length / 2; i++) {
            System.out.print(tempboxes[i] + " -> ");
            if (tempboxes[i] == start) {
                return true;
            }

        }

        return false;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < boxes.length; i++) {
            if (i % 10 == 0) {
                output += "\n";
            }
            if (i < 10) { //box #
                output += "[0" + i + ", " + boxes[i] + "] ";
            } else { //box #
                output += "[" + i + ", " + boxes[i] + "] ";
            }
        }
        return output;

    }

    public static void othershuffle(int[] arr) {
        //shuffles arrays
        int tempnum = 0;
        int tempindex = 0;
        int tempnum2 = 0;
        int tempindex2 = 0;

        for (int i = 0; i < arr.length; i++) {

            tempindex = (int) (Math.random() * arr.length);
            tempnum = arr[tempindex];

            tempindex2 = (int) (Math.random() * arr.length);
            tempnum2 = arr[tempindex2];

            arr[tempindex] = tempnum2;
            arr[tempindex2] = tempnum;
        }
    }

    public void shuffle() {
        int tempnum = 0;
        int tempindex = 0;
        int tempnum2 = 0;
        int tempindex2 = 0;

        for (int i = 0; i < boxes.length; i++) { //dont use i here

            tempindex = (int) (Math.random() * boxes.length);
            tempnum = boxes[tempindex];

            tempindex2 = (int) (Math.random() * boxes.length);
            tempnum2 = boxes[tempindex2];

            boxes[tempindex] = tempnum2;
            boxes[tempindex2] = tempnum;
        }
    }

    public void reset() {
        for (int i = 0; i < boxes.length; i++) {
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

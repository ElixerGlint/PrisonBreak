
public class Prison {

    private int[] boxes; //array for the box # (index) and the # they contain (value)

    public Prison(int boxnum) { //constuctor
        boxes = new int[boxnum];
        for (int i = 0; i < boxnum; i++) {
            boxes[i] = i;
        }
        this.shuffle(); //shuffels so that the box #s are in a random orientation
    }


    public double simulate(int trials, boolean whichPath) { //simulate function, returns the double %
        if (whichPath) { //smart trial
            int actualwins = 0;
            int wins = 0;

            if(boxes.length == 1) {
                return 100;
            }

            for (int j = 0; j < trials; j++) { //for each trial, it runs through x prison experiement
                for (int i = 0; i < boxes.length; i++) { //below it runs through the prison experiement
                    if (followSmartPath(i, false)) { //if prisoner i makes it through, wins gets +
                        wins++;
                    }
                }
                if (wins == boxes.length) { //if all the prisoners make it out, a prison escape win is counted
                    actualwins++; //this could be done considerably faster by checking if the prisoner ever fails to leave, then just failing the tiral
                }
                shuffle();
                wins = 0;
            }
            double tempactual = (double)actualwins; //the amount of prison eascapes/ trials shows the sucess rate
            double temptrails = (double)trials;
            return tempactual/temptrails*100;
        } else { //random trial
            int actualwins = 0; //prety much the same code as above, except with random
            int wins = 0;

            if(boxes.length == 1) {
                return 100;
            }

            for (int j = 0; j < trials; j++) {
                for (int i = 0; i < boxes.length; i++) {
                    if (followRandomPath(i, false)) {
                        wins++;
                    }
                }
                if (wins == boxes.length) {
                    actualwins++;
                }
                shuffle();
                wins = 0;
            }
            double tempactual = (double)actualwins;
            double temptrails = (double)trials;
            return tempactual/temptrails*100;
        }
    }

    public boolean followSmartPath(int start, boolean show) { //follows the smart path
        int tempnum = start;
        for (int i = 0; i < boxes.length / 2; i++) { //the prisoners get 1/2 of the attempts
            if (show) {
                System.out.print(tempnum + " -> "); //printing
            }
            tempnum = boxes[tempnum]; //the box they are headed to is the number inside of the previous box
            if (boxes[tempnum] == boxes[start]) { //if the persons number matches their prison number, they are out! returns true
                if (show) {
                    System.out.print(start + " -> "); //printing
                }
                return true;
            }
        }
        if (show) {
            System.out.println();
        }
        return false; //returns false otherwise because the prisoner did not find their number in the allocated time
    }

    public boolean followRandomPath(int start, boolean show) { //cant repeat boxes you have looked through
        int tempboxes[] = boxes.clone(); //makes a clone of the boxes and shuffles it

        othershuffle(tempboxes);

        for (int i = 0; i < boxes.length / 2; i++) { //goes in a straight line, becuase its shuffeled it means they are going through a random 50%
            if (show) {
                System.out.print(tempboxes[i] + " -> ");
            }
            if (tempboxes[i] == start) { //if they find their number its true
                return true;
            }

        }

        return false; //otherwise false
    }

    @Override //tostring
    public String toString() {
        String output = "";
        for (int i = 0; i < boxes.length; i++) { //prints out the boxes in nice rows
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

    public static void othershuffle(int[] arr) { //the other shuffle that you can do with a specific array entered
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

    public void shuffle() { //shuffle just for boxes
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

    public void reset() { //reset the boxes to be in order
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = i;
        }
    }

    public int[] getBoxes() { //returns boxes
        return boxes;
    }

    public void setBoxes(int[] boxes) { //sets boxes
        this.boxes = boxes;
    }
}

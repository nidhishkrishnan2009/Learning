import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        int index=0;
          String result = null;
        while(!StdIn.isEmpty()){
            String input=StdIn.readString();
           boolean champion=StdRandom.bernoulli(1/(index+1.0));
           if(champion){
               result=input;
           }
           else {
               break;
           }
           index++;
        }

        StdOut.println("\n"+result);
    }
}

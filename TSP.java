import java.util.*;
import java.util.stream.*;

public class TSP{
  static Random rand = new Random();

  static int amount = 4;
  static Double[][] lengths = new Double[amount][amount];
  static int[] bestPath = new int[amount - 1];
  static double bestLength;

  public static void main(String args[]){
    int[] combs = IntStream.rangeClosed(2, amount)
    .boxed().collect(Collectors.toList()).stream().mapToInt(i->i).toArray();
    int n = combs.length;

    
    int[][] coords = new int[amount][2];
    for (int i = 0; i < amount; i ++){
      coords[i][0] = rand.nextInt(100);
      coords[i][1] = rand.nextInt(100);
    }

    for (int i = 0; i < amount; i ++ ) {

      for (int j = 0; j < amount; j ++) {
        double sidea = Math.pow(   coords[j][0]   -   coords[i][0] , 2);
        double sideb = Math.pow(   coords[j][1]   -   coords[i][1] , 2);
        lengths[i][j] = Math.sqrt(sidea + sideb);
        }
    }
    for (int i = 0; i < amount;i++ ) {
      for (int j = i+1 ; j< amount; j++) {
        System.out.format("%s %2d %s %2d %s","(" , (i+1) , "," , (j+1) , ")");
        System.out.format("%7.2f %s", lengths[i][j], " | ");
      }
      System.out.println();
    }
    // String[] comb = {"a", "b", "c"};

    bestLength = calcLength(combs);
    permute(combs, 0, n-1); //Create the permutations
    
    /* Here there be graphics */

    StdDraw.setXscale(-5, 105);
		StdDraw.setYscale(-5, 105);
    StdDraw.setPenRadius(0.05/10);
    StdDraw.setPenColor(StdDraw.RED);
    int[] prev = coords[0];
    System.out.format("%f.2 \n",bestLength);
    for (int i : bestPath){
      StdDraw.line(prev[0],prev[1],coords[i-1][0],coords[i-1][1]);
      prev = coords[i-1];
    }
    StdDraw.setPenRadius(0.3/10);
    
    StdDraw.setPenColor(StdDraw.BLACK);
    int count = 1;
    for (int[] i : coords) {
      StdDraw.point(i[0], i[1]);
      StdDraw.text(i[0],i[1]+4,String.valueOf(count));
      count++;
    }
    StdDraw.setPenColor(StdDraw.BLUE);
    StdDraw.point(coords[0][0], coords[0][1]);

    printArray(bestPath);


    
  }

  static void permute(int[] input, int l, int r) {

    if (l == r){
      if (calcLength(input) <= bestLength) {
        bestLength = calcLength(input);
        bestPath = input.clone();
      }

    }
    else
    {
        for (int i = l; i <= r; i++)
        {
          input = swap(input,l,i);
            permute(input, l+1, r);
            input = swap(input,l,i);
        }
    }
  }
  static int[] swap(int[] a, int i, int j) {
      int temp = a[i] ;
      a[i] = a[j];
      a[j] = temp;
      return a;
  }
  static void printArray(int[] arg){
    for (int i = 0; i < arg.length; i++ ) {
      System.out.print(arg[i] + " ");
    }
    System.out.println();
  }

  static double calcLength(int[] arg){
    double len = 0;
    int prev = 0;
      for (int i = 0; i < arg.length; i++){
        len += lengths[prev][arg[i]-1];
        prev = arg[i]-1;
      }

    return len;
  }

}

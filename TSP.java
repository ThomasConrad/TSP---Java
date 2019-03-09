import  java.util.ArrayList;
import java.util.*;
import java.util.stream.*;

public class TSP{
  static Random rand = new Random();

  static int amount = 13;
  static ArrayList<Double> pathLength = new ArrayList<Double>();
  static ArrayList<int[]> paths = new ArrayList<int[]>();
  static Double[][] lengths = new Double[amount][amount];

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
        System.out.print("(" + (i+1) + "," + (j+1) + ")");
        System.out.format("%8.2f %s", lengths[i][j], " | ");
      }
      System.out.println();
    }
    Double totaldist = 0.0;
    for (int i = 1; i < amount; i++){
      totaldist += lengths[0][i];
    }
    // String[] comb = {"a", "b", "c"};


    permute(combs, 0, n-1);
    
    /* Here there be graphics */

    StdDraw.setXscale(-5, 105);
		StdDraw.setYscale(-5, 105);
    StdDraw.setPenRadius(0.05/10);
    StdDraw.setPenColor(StdDraw.RED);
    int[] prev = coords[0];
    int[] best = paths.get(pathLength.indexOf(Collections.min(pathLength)));
    System.out.println(Collections.min(pathLength));
    for (int i : best){
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

    printArray(best);


    
  }

  static void permute(int[] input, int l, int r) {

    if (l == r){
      pathLength.add(calcLength(input));
      paths.add(input.clone());
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

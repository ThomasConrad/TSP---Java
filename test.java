import  java.util.ArrayList;
import java.util.Random;

public class test{
  static Random rand = new Random();

  static int amount = 5;

  public static void main(String args[]){
    int[] str = {1,2,3};
    int n = str.length;
    permute(str, 0, n-1);

    Double[][] lengths = new Double[amount][amount];
    int[][] coords = new int[amount][2];
    for (int i = 0; i < amount; i ++){
      coords[i][0] = rand.nextInt(100);
      coords[i][1] = rand.nextInt(100);
    }

    for (int i = 0; i < amount; i ++ ) {

      for (int j = i+1; j < amount; j++) {
        lengths[i][j] = (Math.sqrt(Math.pow(   coords[j][0]   -   coords[i][0] , 2) +
        Math.pow(  coords[j][1]  -  coords[i][0]   ,2)));
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
    String[][] combs = new String[2][2];
    for (int i = 0 ; i < 6; i++) {

    }



    System.out.println(String.valueOf(totaldist));
  }

  static void permute(int[] str, int l, int r) {
    int[] temp = new int[]

    if (l == r)
        printArray(str);
    else
    {
        for (int i = l; i <= r; i++)
        {
            str = swap(str,l,i);
            permute(str, l+1, r);
            str = swap(str,l,i);
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

}

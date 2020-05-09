public class Testground{
  public static void main(String[] args) {
    int x, y, n;
    x = 0;
    for (int i = 1; i <= 2; i++) {
      for (int j = 1; j <= i; j++) {
        x += i + j;
      }
    }
    System.out.println(x + y);
  }
}
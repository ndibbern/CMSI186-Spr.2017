import java.lang.Math;
public class PiEstimatorIgnore {

      public static void main(String[] args) {

          if (args.length == 1) {
              try {
                  int nThrows = Integer.parseInt(args[0]);
                  int nSuccess = 0;
                  double x, y;

                  if (nThrows > 0 ) {
                      //System.out.println("start");
                      for ( int k = 1 ; k <= nThrows ; k+=50) {

                          nSuccess = 0;

                          for (int i = 0; i < k ; i++) {
                              x = Math.random();
                              y = Math.random();

                              if ( x * x + y * y <= 1 ) {
                                  nSuccess++;
                                  // System.out.println(x + " " + y + " in");
                              } else {
                                  // System.out.println(x + " " + y + " out");
                              }
                          }
                      // System.out.println("end");
                      System.out.println(4 * (double) nSuccess / (double) k + ", " + k);
                      // System.out.println(4 * (double) nSuccess / (double) k + "," + k);
                      }

                  } else {
                      System.out.println("Please input a positive integer.");
                  }
              } catch (NumberFormatException nfe) {
                  System.out.println("Please input a positive integer.");
              }
          } else {
              System.out.println("Please input only one positive integer.");
          }
      }
   }

public class Playground {

private static boolean isEvenArray(String[] anyArray){
  return anyArray.length % 2==0;
}
    public static void main(String[] args){

      if (isEvenArray(args)){
        System.out.println("Even!");
      }
      else{
        System.out.pringln("Odd!");
      }
}
}

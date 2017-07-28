public class ChangeMaker{

    public static int getQuarters(int cents) {
        return (int) cents/25;
    }
    public static int getDimes(int cents) {
        return (int) cents/10;
    }

    public static int getNickels(int cents) {
        return (int) cents/5;
    }

    public static int getPennies(int cents) {
        return cents;
    }

    public static int[] getCoins(int cents) {
        int[] coins = new int[4];
        coins[0] = getQuarters(cents);
        int newCents = cents - coins[0] * 25;
        coins[1] = getDimes(newCents);
        newCents -= coins[1] * 10;
        coins[2] = getNickels(newCents);
        newCents -= coins[2] * 5;
        coins[3] = getPennies(newCents);
        return coins;
    }

    public static int getTotalCents(int[] coins) {
    return coins[0] * 25 + coins[1] * 10 + coins[2] * 5 + coins[3];
    }

    public static int[] joinCoins(int[] initialCoins, int[] additionalCoins) {
        int[] newCoins = new int[4];
        for(int i = 0; i < newCoins.length; i++) {
            newCoins[i] = initialCoins[i] + additionalCoins[i];
        }
        return newCoins;
    }

    public static void main(String[] args) {
        if(args.length == 0) System.out.println("Usage: java ChangeMaker <amount in cents | four coin counts | eight coin counts>");
        else if(args.length == 1) {
            try {
                int cents = Integer.parseInt(args[0]);
                if(cents >= 0){
                    int[] coins = getCoins(cents);
                    String[] label = new String[] {"Quarters: ", "Dimes: ", "Nickels: ", "Pennies: "};
                    for(int i = 0; i < coins.length; i++ ){
                        System.out.println(label[i] + coins[i]);
                    }
                }else System.out.println("Negative amounts are not permitted.");
                }catch (NumberFormatException ignore) {
                     System.out.println("Supplied values must be integers.");
                 }
        }else if(args.length == 4) {
            try {
                int quarters = Integer.parseInt(args[0]);
                int dimes = Integer.parseInt(args[1]);
                int nickels = Integer.parseInt(args[2]);
                int pennies = Integer.parseInt(args[3]);

               if (quarters >= 0 && dimes >= 0 && nickels >= 0 && pennies >= 0) {
                   int[] coins = new int[] {quarters, dimes, nickels, pennies};
                   System.out.println(getTotalCents(coins) + " cents");
               }else  System.out.println("Negative amounts are not permitted.");
               }catch (NumberFormatException ignore) {
                   System.out.println("Supplied values must be integers.");
               }


        }else if(args.length == 8) {
            try {
                int quarters0 = Integer.parseInt(args[0]);
                int dimes0 = Integer.parseInt(args[1]);
                int nickels0 = Integer.parseInt(args[2]);
                int pennies0 = Integer.parseInt(args[3]);

                int quarters1 = Integer.parseInt(args[4]);
                int dimes1 = Integer.parseInt(args[5]);
                int nickels1 = Integer.parseInt(args[6]);
                int pennies1 = Integer.parseInt(args[7]);

               if (quarters0 >= 0 && dimes0 >= 0 && nickels0 >= 0 && pennies0 >= 0
                    && quarters1 >= 0 && dimes1 >= 0 && nickels1 >= 0 && pennies1 >= 0) {
                   int[] coins1 = new int[] {quarters0, dimes0, nickels0, pennies0};
                   int[] coins2 = new int[] {quarters1, dimes1, nickels1, pennies1};
                   int[] newCoins = joinCoins(coins1, coins2);
                   String[] label = new String[] {"Quarters: ", "Dimes: ", "Nickels: ", "Pennies: "};
                   for(int i = 0; i < newCoins.length; i++ ){
                       System.out.println(label[i] + newCoins[i]);
                   }
                   System.out.println(" ");
                   System.out.println(getTotalCents(newCoins) + " cents");
               }else  System.out.println("Negative amounts are not permitted.");
               }catch (NumberFormatException ignore) {
                   System.out.println("Supplied values must be integers.");
               }
        }else System.out.println("One or more of the supplied dates is not valid");
    }
}

public class BagOfCoins {

    public static int DEFAULT_COIN_COUNT = 1000;
    public static String UNEVEN_PARTITION_MESSAGE = "Partition count must evenly divide the total number of bag throws.";

    private Coin[] bag;
    private long[] totalFlip;

    public BagOfCoins(int coinCount, double bias) {
        this.bag = new Coin[coinCount];
        for (int i = 0; i < coinCount; i++) {
            this.bag[i] = new Coin(bias);
        }
    }
    public BagOfCoins(int coinCount) {
        this(coinCount, Coin.FAIR_BIAS);
    }

    public BagOfCoins(double bias) {
        this(DEFAULT_COIN_COUNT, bias);
    }

    public BagOfCoins() {
        this(DEFAULT_COIN_COUNT, Coin.FAIR_BIAS);
    }

    public int getCoinCount() {
        return bag.length;
    }

    public Coin getCoin(int index) {
        return bag[index];
    }

    public void throwCoins() {
        for (Coin c: bag) {
            c.flip();
        }
        return;
    }

    public void resetCoins() {
        for (Coin c: bag) {
            c.reset();
        }
        return;
    }

    public long[] getFlipTotals() {
        long[] totalHeadsAndTails = new long[2];
        for (Coin c: bag) {
            totalHeadsAndTails[0] += c.getHeadCount();
            totalHeadsAndTails[1] += c.getTailCount();
        }
        return  totalHeadsAndTails;
    }

    public int[] getFlipHistogram(int partitionCount) {

           int totalThrows = (int) (getFlipTotals()[0] + getFlipTotals()[1])/getCoinCount();
           if(totalThrows % partitionCount != 0){
               throw new IllegalArgumentException(UNEVEN_PARTITION_MESSAGE);
           }
           int partitionSize = totalThrows/partitionCount;
           int[] histogram = new int[partitionCount];

           for (Coin c: bag) {
               if (c.getHeadCount() != totalThrows) {
                   int slot = (int) c.getHeadCount()/partitionSize;
                   histogram[slot]++;
               }
               else{
                   histogram[histogram.length - 1]++;
               }
           }
           return histogram;
       }
   }

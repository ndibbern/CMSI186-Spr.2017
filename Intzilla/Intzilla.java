public class Intzilla {

    //CLASS LEVEL VARIABLES -----------------------------

    public static final int DEFAULT_VALUE = 0;
    public static final Intzilla ZERO = new Intzilla("0");
    public static final Intzilla ONE = new Intzilla("1");
    public static final Intzilla TEN = new Intzilla("10");

    private int[] values;
    private int value;
    private byte sign;

    // CONSTRUCTORS --------------------------------------
    public Intzilla() {
        this.values = new int[] {DEFAULT_VALUE};
    }

    public Intzilla(String s) {
        //take out the white space and check if first char is  -
        String trimedS = s.trim();
        if (trimedS.charAt(0) == '-') {
            this.sign = -1;
        } else {
            this.sign = 1;
        }
        //take out anything that is not a number and all not significant 0's
        String numberedS = trimedS.replaceAll("\\D+", "");
        if (numberedS.length() == 0) {
            //this means the provided argument did not contain numbers
            throw new IllegalArgumentException();
        }
        while (numberedS.charAt(0) == '0' && numberedS.length() > 1) {
            numberedS = numberedS.substring(1);
        }

        if (numberedS.charAt(0) == '0') {
            this.sign = 0;
        }
        //fill array with values
        String finalS = numberedS.replaceAll("\\D+", "");
        int valLen = finalS.length();
        this.values = new int[valLen];

        for (int i = 0; i < valLen; i++) {
            this.values[(valLen - 1) - i] = Character.getNumericValue(finalS.charAt(i));
        }
    }

    //PUBLIC METHODS, MAIN ARITHMETIC-------------------------------------

    public boolean equals(Object n) {
        /*
        Returns whether or not the given object is a large integer whose value
        is equal to the receiver.
        */
        if (this == n) {
            return true;
        }
        if (n == null) {
            return false;
        }
        if (getClass() != n.getClass()) {
            return false;
        }
        Intzilla other = (Intzilla)n;
        return this.toString().equals(other.toString());
    }

    public boolean isGreaterThan(Intzilla n) {
        /*
        Returns whether or not the receiver is greater than the given large integer.
        */
        return this.compareTo(n) == 1;
    }

    public boolean isLessThan(Intzilla n) {
        /*
        Returns whether or not the receiver is less than the given large integer.
        */
        return this.compareTo(n) == -1;
    }

    public Intzilla minus(Intzilla subtrahend) {
        /*
        Subtracts the given large integer from the receiver (the minuend), and
        returns a new large integer representing the difference.
        */

        //Default cases
        if (subtrahend.equals(ZERO)) {
            return this;
        } else if (this.equals(ZERO)) {
            return subtrahend.opposite();
        } else if (this.equals(subtrahend)) {
            return ZERO;
        }

        int thisSign = (int) this.getSign();
        int subtrahendSign = (int) subtrahend.getSign();

        //check to see if it is an plusition
        if (subtrahendSign == -1 || thisSign == -1) {
            //this might be an addition
            if (subtrahendSign == -1 && thisSign == 1) {
                //t - (-v) == t + v
                //the opposite of subtrahend should be added
                return this.plus(subtrahend.opposite());
            } else if (subtrahendSign == 1 && thisSign == -1) {
                // (-t) - v = -(t + v)
                // the opposite of this should be aded to subtrahend and the opposite returned
                return subtrahend.plus(this.opposite()).opposite();
            } else {
                //(-t) - (-v) == (-t) + v == v - t
                //we simply reverse the order
                return subtrahend.opposite().minus(this.opposite());
            }
        }
        //at this point we only have to handle positive values

        if (subtrahend.isGreaterThan(this)) {
            //subtrahend is greater than this
            //they are both positive
            //4 - 5 == -( 5 - 4 )
            return (subtrahend.minus(this)).opposite();
        }

        int largestLength = Math.max(this.length(), subtrahend.length());
        int[] tempValues = new int[largestLength + 1];
        String tempIntzillaName = "";

        for (int i = 0; i < largestLength; i++) {
            if (i < Math.min(this.length(), subtrahend.length())) {
                tempValues[i] = this.getValues()[i] - subtrahend.getValues()[i];
            } else {
                tempValues[i] = this.length() == largestLength ? this.getValues()[i] : -subtrahend.getValues()[i];
            }
        }

        normalizeValues(tempValues);
        for (int v : tempValues) {
            tempIntzillaName = String.valueOf(v) + tempIntzillaName;
        }
        return new Intzilla(tempIntzillaName);
    }

    public Intzilla plus(Intzilla addend) {
        /*
        Adds the given large integer to the receiver (another addend), and
        returns a new large integer representing the sum.
        */
        if (addend.equals(ZERO)) {
            return this;
        } else if (this.equals(ZERO)) {
            return addend;
        } else if (this.equals(addend.opposite())) {
            return ZERO;
        }
        addend.opposite();

        int thisSign = (int) this.getSign();
        int addendSign = (int) addend.getSign();

        //check to see if it is a substraction
        if (addendSign == -1 || thisSign == -1) {
            //this is a substraction
            if (addendSign == -1 && thisSign == 1) {
                //val is negative
                return this.minus(addend.opposite());
            } else if (addendSign == 1 && thisSign == -1) {
                // this is negative
                return addend.minus(this.opposite());
            } else {
                //both are negative
                //we return the opposite of the additin of their opposite
                //-1 + -1 == -(1 + 1)
                return this.opposite().plus(addend.opposite()).opposite();
            }
        }

        int largestLength = Math.max(this.length(), addend.length());
        int[] tempValues = new int[largestLength + 1];
        String tempIntzillaName = "";

        for (int i = 0; i < largestLength; i++) {
            if (i < Math.min(this.length(), addend.length())) {
                tempValues[i] = this.getValues()[i] + addend.getValues()[i];
            } else {
                tempValues[i] = this.length() == largestLength ? this.getValues()[i] : addend.getValues()[i];
            }
        }

        normalizeValues(tempValues);
        for (int v: tempValues) {
            tempIntzillaName = String.valueOf(v) + tempIntzillaName;
        }
        return new Intzilla(tempIntzillaName);
    }

    public Intzilla times(Intzilla factor) {
        /*
        Multiplies the given large integer from the receiver (another factor),
        and returns a new large integer representing the product.
        */

        //Default cases
        if (factor.equals(ZERO)) {
            return ZERO;
        } else if (this.equals(ZERO)) {
            return ZERO;
        } else if (this.equals(ONE)) {
            return factor;
        } else if (factor.equals(ONE)) {
            return this;
        }

        //we take care of the sign first
        if (this.getSign() == -1 || factor.getSign() == -1) {
            if (this.getSign() == 1 && factor.getSign() == -1) {
                //It is better if this is negative and not val
                return this.opposite().times(factor.opposite());
            } else if (this.getSign() == -1 && factor.getSign() == -1) {
                return this.opposite().times(factor.opposite());
            }
        }

        Intzilla result = ZERO;
        Intzilla thisCopy = new Intzilla(this.toString());
        //Russian peasant algorithm
        while (!factor.equals(ZERO)) {
            if (factor.getValues()[0] % 2 != 0) {
                result = result.plus(thisCopy);
                factor = factor.minus(ONE);
            }
            thisCopy = thisCopy.twice();
            factor = factor.halve();
        }
        return result;
    }

    public Intzilla div(Intzilla divisor) {
        /*
        Integer-divides the receiver (the dividend) by the given large integer,
        and returns a new large integer representing the [integer] quotient.
        */

        //Default cases
        if (divisor.equals(ZERO)) {
            throw new IllegalArgumentException("division by 0");
        } else if (divisor.equals(ONE)) {
            return this;
        } else if (this.equals(divisor)) {
            return ONE;
        } else if (this.equals(divisor.opposite())) {
            return ONE.opposite();
        } else if (this.absoluteValue().compareTo(divisor.absoluteValue()) == -1) {
            /*
            if the numerator is numerically grater than the numerator we know
            the divisio gives 0
            */
            return ZERO;
        }

        //we take care of the sign
        if (this.getSign() == -1 || divisor.getSign() == -1) {
            if (this.getSign() == 1 && divisor.getSign() == -1) {
                //To simplify the code only this can be negative
                return this.opposite().div(divisor.opposite());
            } else if (this.getSign() == -1 && divisor.getSign() == -1) {
                return this.opposite().div(divisor.opposite());
            }
        }

        //we perfom the division
        int exp = this.length() - divisor.length();
        Intzilla result = ZERO;
        Intzilla thisCopy = new Intzilla(this.toString());
        boolean isNegative = thisCopy.getSign() == -1;
        if (isNegative) {
            /*
            we switch the sign at the end because before we made sure
            divisor cant be negative
            */
            thisCopy.setSign((byte) 1);
        }

        //division algorithm so we don't have to keep adding to get to the result
        while (exp >= 0) {
            Intzilla fact = ONE;
            while (thisCopy.isGreaterThan(divisor.times(fact.exponent(exp)))) {
                //while ( fact *(divisor*(10^exp)) < this )
                fact = fact.plus(ONE);
            }
            /*
            //we exit the loop which means: either we exeded this and we need
            to use the previous fact and try with smaller exp or we just hit divisor
            */

            if (thisCopy.isLessThan(divisor.times(fact.exponent(exp)))) {
                fact = fact.minus(ONE);
                result = result.plus(fact.exponent(exp));
                thisCopy = thisCopy.minus(divisor.times(fact.exponent(exp)));
                exp--;
            } else {
                result = result.plus(fact.exponent(exp));
                return (!isNegative) ? result : result.opposite();
            }
        }
        return (!isNegative) ? result : result.opposite();
    }

    public Intzilla mod(Intzilla divisor) {
        /*
        Returns the remainder that results from the division of the receiver by
        the given large integer (i.e., the modulo or mod operation).
        */

        //10/3 = 3 => remainder = 1 = 10 - (10/3)3
        //-10/3 = -3 => remainder = -1 = -10 - (-10/3)3
        return this.minus(this.div(divisor).times(divisor));
    }

    //OTHER PUBLIC METHODS --------------------------------------------------------

    public int compareTo(Intzilla val) {
        // returns -1/0/1 as this Intzilla is numerically less than/equal to/greater than val
        if (this.equals(val)) {
            return 0;
        }

        if (this.getSign() < val.getSign()) {
            return -1;
        } else if (this.getSign() > val.getSign()) {
            return 1;
        }

        if (this.sign == 1) {
            //this means they are both positive
            if (this.length() > val.length()) {
                return 1;
            } else if (this.length() < val.length()) {
                return -1;
            }

            for (int i = this.length() - 1; i >= 0; i--) {
                if (this.values[i] > val.getValues()[i]) {
                    return 1;
                } else if (this.values[i] < val.getValues()[i]) {
                    return -1;
                }
                //if they are the same we continue with an order of magnitude less
            }
        } else if (this.sign == -1) {
            //this means they are both negative
            return -this.opposite().compareTo(val.opposite());
        }
        return 0;
    }

    public Intzilla opposite() {
        //returns an Intzilla with the opsite value without altering this
        Intzilla val = new Intzilla(this.toString());
        val.switchSign();
        return val;
    }

    public Intzilla halve() {
        //default values
        if (this.equals(ZERO)) {
            return ZERO;
        } else if (this.equals(TEN)) {
            return new Intzilla("5");
        }
        if (this.getValues()[0] % 2 == 0) {
            Intzilla result = new Intzilla(Integer.toString(this.getValues()[0] / 2));
            Intzilla tempInt = new Intzilla("0");

            for (int i = 1; i < this.length(); i++) {
                if (this.getValues()[i] % 2 == 0) {
                    tempInt = new Intzilla(Integer.toString(this.getValues()[i] / 2));
                    tempInt = tempInt.exponent(i);
                } else {
                    tempInt = new Intzilla(Integer.toString((this.getValues()[i] * 10) / 2));
                    tempInt = tempInt.exponent(i - 1);
                }
                result = result.plus(tempInt);
            }
            return (this.getSign() == 1) ? result : result.opposite();
        } else {
            throw new IllegalArgumentException("Can not halve odd numbers");
        }
    }

    public Intzilla twice() {
        Intzilla thisCopy = new Intzilla(this.toString());
        thisCopy = thisCopy.plus(thisCopy);
        return thisCopy;
    }

    public Intzilla exponent(int exp) {
        //returns this*10^exp
        if (exp == 0) {
            //a * 10^0 = a
            return this;
        } else {
            String result = this.toString();
            for (int i = 1; i <= exp; i++) {
                result += "0";
            }
            return new Intzilla(result);
        }
    }

    public void switchSign() {
        //switches the sign but does not return a new Intzilla
        this.sign = (byte) -this.sign;
    }

    public void setSign(byte sign) {
        if ((sign == 1 || sign == -1) && (this.sign != 0)) {
            this.sign = sign;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String toString() {
        // returns the decimal string represention of this Intzilla
        String intzillaName = "";

        for (int val: values) {
            intzillaName = val + intzillaName;
        }
        switch (sign) {
            case 1: intzillaName = "+" + intzillaName;
            break;
            case 0: intzillaName = "" + intzillaName;
            break;
            case -1: intzillaName = "-" + intzillaName;
            break;
            default : intzillaName = "" + intzillaName;
            break;
        }
        return intzillaName;
    }

    //GETTERS AND SETTERS -------------------------------

    public byte getSign() {
        return this.sign;
    }

    public int[] getValues() {
        return this.values;
    }

    public int length() {
        return this.values.length;
    }

    //STATIC CLASS METHODS ------------------------------

    public static Intzilla valueOf(long val) {
        // "static factory" for constructing Intzillas out of longs
        Intzilla intzilla = new Intzilla(Long.toString(val));
        return intzilla;
    }

    //PRIVATE METHODS -------------------------------

    public Intzilla absoluteValue() {
        return (this.getSign() == 1) ? this : this.opposite();
    }

    private void normalizeValues(int[] val) {
        for (int i = 0; i < val.length; i++) {
            if (val[i] >= 10) {
                val[i] = val[i] % 10;
                val[i + 1]++;
            } else if (val[i] < 0) {
                val[i] = 10 + val[i];
                val[i + 1]--;
            }
        }
    }
}

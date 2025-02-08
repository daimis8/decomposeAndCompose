public class CharNumber {
    //initializing char and int one for the letter the other one for occurencies
    private char c;
    private int numberOfOccurencies;

    //Assigning c and numberOfOccurencies
    CharNumber(char c, int numberOfOccurencies) {
        this.c = c;
        this.numberOfOccurencies = numberOfOccurencies;
    }

    //toString() method to output string and not adress of a class
    @Override
    public String toString() {
        return ""+c+numberOfOccurencies;
    }
    
}

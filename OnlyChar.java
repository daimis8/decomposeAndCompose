public class OnlyChar {
    private char c;

    //Assigning c
    OnlyChar(char c) {
        this.c = c;
    }

    //toString() method to output string and not adress of a class
    @Override
    public String toString() {
        return ""+c;
    }
}

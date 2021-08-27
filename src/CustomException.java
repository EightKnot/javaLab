public class CustomException extends Exception {

    private final int someInt;
    private final String someStr;

    public CustomException(int i, String str) {
        //super(str);
        this.someInt = i;
        this.someStr = str;
    }

    @Override
    public String getMessage() {
        return "CustomException block:\n" + this.getSomeInt() + " " + this.getSomeStr();
    }

    public int getSomeInt() {
        return someInt;
    }

    public String getSomeStr() {
        return someStr;
    }
}

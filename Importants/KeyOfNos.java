public class KeyOfNos {

    private static String isFourDigits(int n) {
        String num = String.format("%04d", n);
        return num;
    }

    private static char getMinDigit(char digit1, char digit2, char digit3) {
        return (char) Math.min(Math.min(digit1, digit2), digit3);
    }

    public static int generateKey(int num1, int num2, int num3) {
        String n1 = isFourDigits(num1);
        String n2 = isFourDigits(num2);
        String n3 = isFourDigits(num3);

        String key = "";

        for (int i = 0; i < 4; i++) {
            char minDigit = getMinDigit(n1.charAt(i), n2.charAt(i), n3.charAt(i));
            key += minDigit;
        }

        return Integer.parseInt(key);
    }

    public static void main(String[] args) {
        int num1 = 987, num2 = 879, num3 = 798;
        System.out.println(generateKey(num1, num2, num3));

        int num1Test = 1, num2Test = 10, num3Test = 1000;
        System.out.println(generateKey(num1Test, num2Test, num3Test));
    }
}

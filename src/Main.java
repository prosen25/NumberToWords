//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        numberToWords(0);
        numberToWords(123);
        numberToWords(1010);
        numberToWords(1000);
        numberToWords(-12);
    }

    public static void numberToWords(int number) {

        if (number < 0) {
            System.out.println("Invalid Value");
        } else {
            StringBuilder word = new StringBuilder();
            int reverseNumber = reverse(number);

            int digitCount = getDigitCount(number);
            int reverseDigitCount = getDigitCount(reverseNumber);

            do {

                int digit = reverseNumber % 10;
                word.append(" ").append(switch (digit) {
                    case 0 -> "Zero";
                    case 1 -> "One";
                    case 2 -> "Two";
                    case 3 -> "Three";
                    case 4 -> "Four";
                    case 5 -> "Five";
                    case 6 -> "Six";
                    case 7 -> "Seven";
                    case 8 -> "Eight";
                    case 9 -> "Nine";
                    default -> "Invalid Value";
                });

                reverseNumber /= 10;
            } while (reverseNumber != 0);

            if (digitCount > reverseDigitCount) {
                for (int i = 0; i < (digitCount - reverseDigitCount); i++) {
                    word.append(" ").append("Zero");
                }
            }

            System.out.println(word.toString().trim());
        }
    }

    public static int reverse(int number) {

        int reverseNumber = 0;
        while(number != 0) {

            reverseNumber *= 10;
            reverseNumber += number % 10;
            number /= 10;
        }

        return reverseNumber;
    }

    public static int getDigitCount(int number) {

        if (number < 0) {
            return -1;
        }

        int counter = 0;
        do {
            counter++;
            number /= 10;
        } while (number != 0);

        return counter;
    }
}
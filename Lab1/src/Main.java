

public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //System.out.print("Enter the string of numbers: ");
        //String input = scanner.nextLine();

        int sum = 0;
        int elements = args.length;

        if(args.length ==0)
            System.out.println("The string is empty");

        for(int i=0;i< args.length ;i++)
        {
            int value = Integer.parseInt(args[i]);
            sum += value;

        }
        double average = (double) sum/elements;
        System.out.println(sum);
        System.out.println("The average of the string is " + average);
    }
}
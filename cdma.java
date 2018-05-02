import java.util.*;

class cdma {

  static int[] getCode(String code, int n) {
    int chipCode[] = new int[n];
    for (int i=0; i<n; i++) {
      if (code.charAt(i) == '0')
        chipCode[i] = -1;
      else chipCode[i] = 1;
    }
    return chipCode;
  }

  static int[] getSM(int chipCode[], int data, int n) {
    int SM[] = new int[n];
    if (data == 0)
      data = -1;
    else data = 1;
    for (int i=0; i<n; i++)
      SM[i] = chipCode[i] * data;
    return SM;
  }

  static int getSum(int mixedSM[], int chipCode[], int n) {
    int sum = 0;
    for (int i=0; i<n; i++)
      sum = sum + mixedSM[i] * chipCode[i];
    return sum;
  }

  public static void main(String[] args) {
    String code1, code2;
    int n, data1, data2;
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter single bit data sent by user 1: ");
    data1 = sc.nextInt();
    System.out.println("Enter single bit data sent by user 2: ");
    data2 = sc.nextInt();

    System.out.println("Enter number of bits in chip code: ");
    n = sc.nextInt();

    System.out.println("Enter user 1's "+n+"-bit chip code: ");
    code1 = sc.next();
    System.out.println("Enter user 2's "+n+"-bit chip code: ");
    code2 = sc.next();

    int chipCode1[] = getCode(code1, n);
    int chipCode2[] = getCode(code2, n);
    System.out.println("User 1's chip code: " + Arrays.toString(chipCode1));
    System.out.println("User 2's chip code: " + Arrays.toString(chipCode2));

    int SM1[] = getSM(chipCode1, data1, n);
    int SM2[] = getSM(chipCode2, data2, n);
    System.out.println("Spread message sent by user 1: " + Arrays.toString(SM1));
    System.out.println("Spread message sent by user 2: " + Arrays.toString(SM2));

    int mixedSM[] = new int[n];
    for (int i=0; i<n; i++)
      mixedSM[i] = SM1[i] + SM2[i];
    System.out.println("On receiver side \nMixed spread message received by receiver: " + Arrays.toString(mixedSM));

    int sum1 = getSum(mixedSM, chipCode1, n);
    int sum2 = getSum(mixedSM, chipCode2, n);
    System.out.println("Sum for user 1: " + sum1);
    System.out.println("Sum for user 2: " + sum2);

    System.out.println("Regenerated data sent by user 1: " + (sum1/n == -1? 0:1));
    System.out.println("Regenerated data sent by user 2: " + (sum2/n == -1? 0:1));
  }

}

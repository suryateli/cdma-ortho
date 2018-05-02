import java.util.*;

class ortho {

  static int[] getCode(String code, int n) {
    int[] chipCode = new int[n];
    for (int i=0; i<n; i++) {
      if (code.charAt(i) == '0')
        chipCode[i]=-1;
      else chipCode[i]=1;
    }
    return chipCode;
  }

  static boolean checkOrtho(int chipCode1[], int chipCode2[], int n) {
    int sum = 0;
    for (int i=0; i<n; i++) {
      sum += chipCode1[i]*chipCode2[i];
    }
    return sum==0? true:false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    String code1, code2;

    System.out.println("Enter no. of bits in chip code: ");
    n = sc.nextInt();
    System.out.println("Enter user 1's "+n+"-bit code: ");
    code1 = sc.next();
    System.out.println("Enter user 2's "+n+"-bit code: ");
    code2 = sc.next();

    int chipCode1[] = getCode(code1, n);
    int chipCode2[] = getCode(code2, n);
    System.out.println("User 1's chip code: " + Arrays.toString(chipCode1));
    System.out.println("User 2's chip code: " + Arrays.toString(chipCode2));

    if (checkOrtho(chipCode1, chipCode2, n)) {
      System.out.println("Codes are orthogonal");
    }
    else {
      System.out.println("Codes are not orthogonal");
    }
  }
}

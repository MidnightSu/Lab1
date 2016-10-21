package lab.lab;

import java.util.Scanner;

public class OurProject {
  /**
   * javadoc for main.
   * 
   */
  public static void main(final String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = null;
    str = scanner.next();
    char[] myList = str.toCharArray();
    int tag = judge(myList);
    if (tag == 0) {
      System.out.println(myList);
      Scanner order = new Scanner(System.in);
      String str1 = null;
      str1 = order.nextLine();
      char[] myList1 = str1.toCharArray();
      int tag1 = judgeO(myList1, myList);
      if (tag1 == 0) {
        if (myList1[1] == 's') {
          simplify(myList, myList1);
        } else if (myList1[1] == 'd') {
          derivative(myList, myList1);
        }
      } else {
        System.out.println("Error,no variable");
      }
      order.close();
    } else {
      System.out.println("Error,no variable");
    }
    scanner.close();
  }

  /**
   * judge javavdoc.
   * 
   */
  public static int judge(final char[] myList) {
    int judgetag = 0;
    char temp = myList[0];
    if ((temp <= '9' && temp >= '0') || (temp <= 'z' && temp >= 'a')
        || (temp <= 'Z' && temp >= 'A')) {
      for (int i = 0; i < myList.length; i++) {
        char tem = myList[i];
        if ((tem <= '9' && tem >= '0') || (tem <= 'z' && tem >= 'a') || (tem <= 'Z' && tem >= 'A')
            || tem == '+' || tem == '*') {
          if (i == myList.length - 1) {
            break;
          }
          char te = myList[i + 1];
          if (tem <= '9' && tem >= '0') {
            if ((te <= 'z' && te >= 'a') || (te <= 'Z' && te >= 'A')) {
              judgetag += 1;
              break;
            }
          } else if ((tem <= 'z' && tem >= 'a') || (tem <= 'Z' && tem >= 'A')) {
            if ((te <= '9' && te >= '0') || (te <= 'z' && te >= 'a') || (te <= 'Z' && te >= 'A')) {
              judgetag += 1;
              break;
            }
          }
        } else {
          judgetag += 1;
          break;
        }
      }
    } else {
      judgetag += 1;
    }
    return judgetag;
  }

  /**
   * javadoc for judgeO.
   * 
   */
  public static int judgeO(final char[] ch, final char[] myList) {
    char[] chr = new char[ch.length + 1];
    for (int r = 0; r < ch.length; r++) {
      for (int o = 0; o < ch.length; o++) {
        chr[o] = ch[o];
      }
      chr[chr.length - 1] = ' ';
    }
    int judgenum = 0;
    if (ch[0] == '!') {
      if (ch[1] == 's') {
        char[] test = new char[8];
        char[] test1 = { 's', 'i', 'm', 'p', 'l', 'i', 'f', 'y' };
        for (int i = 0; i < 8; i++) {
          test[i] = ch[i + 1];
        }

        if (!java.util.Arrays.equals(test, test1)) {
          judgenum += 1;
        } else {
          if (ch.length != 9) {
            for (int i = 9; i < ch.length; i++) {
              char tem = ch[i];
              if ((tem <= '9' && tem >= '0') || (tem <= 'z' && tem >= 'a')
                  || (tem <= 'Z' && tem >= 'A') || tem == ' ' || tem == '=') {
                if (tem == '=') {

                  char temp = ch[i - 1];
                  int te = 0;
                  for (int j = 0; j < myList.length; j++) {
                    if (myList[j] == temp) {
                      te += 1;
                    }
                  }
                  if (te == 0) {
                    judgenum += 1;
                  }
                  do {
                    if (chr[i + 1] > '9' || chr[i + 1] < '0') {
                      judgenum += 1;
                    } else {
                      i += 1;
                    }
                  } while (chr[i + 1] != ' ');
                }
              } else {
                judgenum += 1;
              }
            }
          }
        }
      } else if (ch[1] == 'd') {
        if (ch[2] == '/') {
          if (ch[3] == 'd') {
            char ba = ch[4];
            int ca = 0;
            for (int j = 0; j < myList.length; j++) {
              if (myList[j] == ba) {
                ca += 1;
              }
            }
            if (ca == 0) {
              judgenum += 1;
            }
          } else {
            judgenum += 1;
          }
        } else {
          judgenum += 1;
        }
      } else {
        judgenum += 1;
      }
    } else {
      judgenum += 1;
    }
    return judgenum;
  }

  /**
   * javadoc for simplify.
   */
  public static void simplify(final char[] myList, final char[] myList1) {
    for (int i = 8; i < myList1.length; i++) {
      if (myList1[i] == '=') {
        for (int j = 0; j < myList.length; j++) {
          if (myList[j] == myList1[i - 1]) {
            myList[j] = myList1[i + 1];
          }
        }
      }
    }
    System.out.println(myList);
  }

  /**
   * javadoc for derivative.
   * 
   */
  public static void derivative(final char[] myList, final char[] myList1) {
    int ab = 0;
    char[] myList2 = new char[myList.length + 1];
    // for (int i = 0; i < myList.length; i++) {
    for (int j = 0; j < myList.length; j++) {
      myList2[j] = myList[j];
    }
    myList2[myList2.length - 1] = '+';
    // }
    for (int k = 0; k < myList.length + 1; k++) {
      if (myList2[k] == '+') {
        int sum = 0;
        for (int i = ab; i < k; i++) {
          if (myList2[i] == myList1[4]) {
            sum += 1;
          }
        }
        for (int l = ab; l < k; l++) {
          if (myList2[l] == myList1[4]) {
            String ms = String.valueOf(sum);
            myList[l] = ms.charAt(0);
            break;
          }
        }
        ab = k;
      }
    }
    System.out.println(myList);
  }
}
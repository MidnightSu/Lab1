package lab.lab;

import java.util.Scanner;

/**
 * 类描述.
 * 
 * @author Meng Kuang
 *
 */
public class OurProject {
  /**
   * javadoc for main. 主函数
   */
  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);
    String str = null;
    str = scanner.next();
    final char[] myList = str.toCharArray();
    final int tag = judge(myList);
    if (tag == 0) {
      System.out.println(myList);
      final Scanner order = new Scanner(System.in);
      String str1 = null;
      str1 = order.nextLine();
      final char bjd = 'd';
      final char[] myList1 = str1.toCharArray();
      final int tag1 = judgeO(myList1, myList);
      if (tag1 == 0) {
        final char sss = 's';
        if (myList1[1] == sss) {
          simplify(myList, myList1);
        } else if (myList1[1] == bjd) {
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
   * judge javavdoc. 判断
   */
  public static int judge(final char[] myList) {
    int judgetag = 0;
    final char temp = myList[0];
    if (temp <= '9' && temp >= '0' || temp <= 'z' && temp >= 'a' || temp <= 'Z' && temp >= 'A') {
      for (int i = 0; i < myList.length; i++) {
        final char tem = myList[i];
        if (tem <= '9' && tem >= '0' || tem <= 'z' && tem >= 'a' || tem <= 'Z' && tem >= 'A'
            || tem == '+' || tem == '*') {
          if (i == myList.length - 1) {
            break;
          }
          final char temn = myList[i + 1];
          if (tem <= '9' && tem >= '0') {
            if (temn <= 'z' && temn >= 'a' || temn <= 'Z' && temn >= 'A') {
              judgetag += 1;
              break;
            }
          } else if (tem <= 'z' && tem >= 'a' || tem <= 'Z' && tem >= 'A') {
            if (temn <= '9' && temn >= '0' || temn <= 'z' && temn >= 'a'
                || temn <= 'Z' && temn >= 'A') {
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
   * javadoc for judgeO. 有一个判断
   */
  public static int judgeO(final char[] chrr, final char[] myList) {
    char[] chr = new char[chrr.length + 1];
    final char gth = '!';
    // for (int r = 0; r < chrr.length; r++) {
    System.arraycopy(chrr, 0, chr, 0, chrr.length);
    chr[chr.length - 1] = ' ';
    // }
    int judgenum = 0;
    final char bjd = 'd';
    if (chrr[0] == gth) {
      final char sss = 's';
      if (chrr[1] == sss) {
        final char[] test = new char[8];
        final char[] test1 = { 's', 'i', 'm', 'p', 'l', 'i', 'f', 'y' };
        //for (int i = 0; i < 8; i++) {
        //  test[i] = chrr[i + 1];
        //}
        System.arraycopy(chrr,1,test,0,8);
        final int bjj = 9;
        if (!java.util.Arrays.equals(test, test1)) {
          judgenum += 1;
        } else {
          final char dyh = '=';
          if (chrr.length != bjj) {
            for (int i = 9; i < chrr.length; i++) {
              final char tem = chrr[i];
              if (tem <= '9' && tem >= '0' || tem <= 'z' && tem >= 'a' || tem <= 'Z' && tem >= 'A'
                  || tem == ' ' || tem == '=') {
                if (tem == dyh) {

                  final char temp = chrr[i - 1];
                  int ted = 0;
                  for (int j = 0; j < myList.length; j++) {
                    if (myList[j] == temp) {
                      ted += 1;
                    }
                  }
                  if (ted == 0) {
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
      } else if (chrr[1] == bjd) {
        final char bjx = '/';
        if (chrr[2] == bjx) {
          if (chrr[3] == bjd) {
            final char bac = chrr[4];
            int cab = 0;
            for (int j = 0; j < myList.length; j++) {
              if (myList[j] == bac) {
                cab += 1;
              }
            }
            if (cab == 0) {
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
   * javadoc for simplify. 化简
   */
  public static void simplify(final char[] myList, final char[] myList1) {
    final char dyh = '=';
    for (int i = 8; i < myList1.length; i++) {
      if (myList1[i] == dyh) {
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
   * javadoc for derivative. 求导
   */
  public static void derivative(final char[] myList, final char[] myList1) {
    int abc = 0;
    char[] myList2 = new char[myList.length + 1];
    // for (int i = 0; i < myList.length; i++) {
    //for (int j = 0; j < myList.length; j++) {
    //  myList2[j] = myList[j];
    //}
    System.arraycopy(myList,0,myList2,0,myList.length);
    myList2[myList2.length - 1] = '+';
    // }
    final char jhh = '+';
    for (int k = 0; k < myList.length + 1; k++) {
      if (myList2[k] == jhh) {
        int sum = 0;
        for (int i = abc; i < k; i++) {
          if (myList2[i] == myList1[4]) {
            sum += 1;
          }
        }
        for (int l = abc; l < k; l++) {
          if (myList2[l] == myList1[4]) {
            final String msb = String.valueOf(sum);
            myList[l] = msb.charAt(0);
            break;
          }
        }
        abc = k;
      }
    }
    System.out.println(myList);
  }
}
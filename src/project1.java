import java.util.Scanner;

public class project1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = null;
		str = scanner.next();
		char myList[] = str.toCharArray();
		int tag = judge(myList);
		if (tag == 0) {
			System.out.println(myList);
			Scanner order = new Scanner(System.in);
			String str1 = null;
			str1 = order.nextLine();
			char myList1[] = str1.toCharArray();
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

	public static int judge(char myList[]) {
		int judgetag = 0;
		char l = myList[0];
		if ((l <= '9' && l >= '0') || (l <= 'z' && l >= 'a') || (l <= 'Z' && l >= 'A')) {
			for (int i = 0; i < myList.length; i++) {
				char k = myList[i];
				if ((k <= '9' && k >= '0') || (k <= 'z' && k >= 'a') || (k <= 'Z' && k >= 'A') || k == '+'
						|| k == '*') {
					if (i == myList.length - 1)
						break;
					char j = myList[i + 1];
					if (k <= '9' && k >= '0') {
						if ((j <= 'z' && j >= 'a') || (j <= 'Z' && j >= 'A')) {
							judgetag += 1;
							break;
						}
					} else if ((k <= 'z' && k >= 'a') || (k <= 'Z' && k >= 'A')) {
						if ((j <= '9' && j >= '0') || (j <= 'z' && j >= 'a') || (j <= 'Z' && j >= 'A')) {
							judgetag += 1;
							break;
						}
					}
				} else {
					judgetag += 1;
					break;
				}
			}
		} else
			judgetag += 1;

		return judgetag;
	}

	public static int judgeO(char a[], char myList[]) {
		char[] d = new char[a.length + 1];
		for (int r = 0; r < a.length; r++) {
			for (int o = 0; o < a.length; o++) {
				d[o] = a[o];
			}
			d[d.length - 1] = ' ';
		}
		int judgenum = 0;
		if (a[0] == '!') {
			if (a[1] == 's') {
				char[] test = new char[8];
				char[] test1 = { 's', 'i', 'm', 'p', 'l', 'i', 'f', 'y' };
				for (int i = 0; i < 8; i++)
					test[i] = a[i + 1];

				if (!java.util.Arrays.equals(test, test1)) {
					judgenum += 1;
				} else {
					if (a.length != 9) {
						for (int i = 9; i < a.length; i++) {
							char k = a[i];
							if ((k <= '9' && k >= '0') || (k <= 'z' && k >= 'a') || (k <= 'Z' && k >= 'A') || k == ' '
									|| k == '=') {
								if (k == '=') {

									char b = a[i - 1];
									int c = 0;
									for (int j = 0; j < myList.length; j++) {
										if (myList[j] == b) {
											c += 1;
										}
									}
									if (c == 0) {
										judgenum += 1;
									}

									do {
										if (d[i + 1] > '9' || d[i + 1] < '0') {
											judgenum += 1;
										} else
											i += 1;
									} while (d[i + 1] != ' ');
								}
							} else {
								judgenum += 1;
							}

						}
					}
				}
			} else if (a[1] == 'd') {
				if (a[2] == '/') {
					if (a[3] == 'd') {
						char b = a[4];
						int c = 0;
						for (int j = 0; j < myList.length; j++) {
							if (myList[j] == b) {
								c += 1;
							}
						}
						if (c == 0) {
							judgenum += 1;
						}
					} else
						judgenum += 1;
				} else
					judgenum += 1;
			} else
				judgenum += 1;
		} else
			judgenum += 1;
		return judgenum;

	}

	public static void simplify(char myList[], char myList1[]) {
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

	public static void derivative(char myList[], char myList1[]) {
		int a = 0;
		char[] myList2 = new char[myList.length + 1];
		for (int i = 0; i < myList.length; i++) {
			for (int j = 0; j < myList.length; j++) {
				myList2[j] = myList[j];
			}
			myList2[myList2.length - 1] = '+';
		}
		for (int k = 0; k < myList.length + 1; k++) {
			if (myList2[k] == '+') {
				int sum = 0;
				for (int i = a; i < k; i++) {
					if (myList2[i] == myList1[4]) {
						sum += 1;
					}
				}
				for (int l = a; l < k; l++) {
					if (myList2[l] == myList1[4]) {
						String m = String.valueOf(sum);
						myList[l] = m.charAt(0);
						break;
					}
				}
				a = k;
			}
		}
		System.out.println(myList);
	}

}
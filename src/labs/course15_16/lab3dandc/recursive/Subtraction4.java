package labs.course15_16.lab3dandc.recursive;

/* Class that models T(n)=T(n-1)+O(n)
 * The time complexity is quadratic O(3^n/2)
 * a=3; b=2; k=1 
 * and the waste of stack is O(n)
 * In this case => the stack overflows 
 */
public class Subtraction4 {
	public static long rec4(int n) {
		long cont = 0;
		if (n <= 0)
			cont++;
		else {
			for (int i = 0; i < n; i++)
				cont++; // O(n)
			rec4(n - 2);
			rec4(n - 2);
			rec4(n - 2);
		}
		return cont;
	}

	public static void main(String arg[]) {
		long t1, t2, cont = 0;
		for (int n = 1; n <= 100000; n *= 2) {
			t1 = System.currentTimeMillis();

			cont = rec4(n);

			t2 = System.currentTimeMillis();

			System.out.println("n=" + n + "**TIME=" + (t2 - t1) + "**cont="
					+ cont);
		} // for
	} // main
} // class
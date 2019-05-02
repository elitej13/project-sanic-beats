package com.sanicbeats;

public class ComplexUtil {


	// makes the lows high and the highs low
	public static ComplexNumber[] reverse(ComplexNumber[] a) {
		ComplexNumber[] b = new ComplexNumber[a.length];
		for (int i = 0; i < b.length; i++) {
			ComplexNumber max = Theromax().divide(new ComplexNumber(2, 0));
			ComplexNumber t = a[i].subtract(max);
			b[i] = max.subtract(t);

		}
		return b;

	}
	

	// returns / compresses the array and gets the average of the array baised on
	// the number given
	public static ComplexNumber[] average(ComplexNumber[] b, int n) {
		ComplexNumber[] a = new ComplexNumber[b.length];
		ComplexNumber average = new ComplexNumber(0,0);
		int diff;
		for(int i = 0;i<b.length;i++) {
			if(i%n==0) {
			average = new ComplexNumber(0,0);
			diff=0;
			for(int j =0;j<n;j++) {
				if(j+i<a.length) {
					average = average.add(b[j+i]);
				}
				else {
					diff++;
				}
			}
			average =average.divide(new ComplexNumber(n-diff,0));
			}
			a[i]=new ComplexNumber(average);
		}
		
//		
//		
//		
//		double d = Math.ceil((double) (a.length) / n);
//		ComplexNumber[] b = new ComplexNumber[(int) d];
//		int j = 0;
//		for (int i = 0; i < a.length; i += n) {
//			ComplexNumber q = new ComplexNumber(0,0);
//			ComplexNumber t = new ComplexNumber(0,0);
//			for (int w = 0; w < n; w++) {
//				if ((w + i) < a.length) {
//					q.add(new ComplexNumber(1,0));
//					t.add(a[i + w]);
//				}
//				else {break;}
//			}
//			// always divides by the number given by n
//			b[j] = t.divide(q);
//			j++;
//		}

		return a;

	}

	// returns / compresses the array and gets the average of the array for every 2
	// spots
	public static ComplexNumber[] average2(ComplexNumber [] a) {
			ComplexNumber [] b = new ComplexNumber[(int)Math.ceil(a.length/2)];
			int j = 0;
			for (int i = 0; i < a.length; i+=2) {
				ComplexNumber t = new ComplexNumber (0,0);
				t = a[i].add(t);
				t= a[i+1].add(t);
				b[j] = t.divide(new ComplexNumber(2,0));
				j++;
			}
			return b;
			
		}
		
		//sets each spot of the array to a random values baised on the max value in the main array
		public static ComplexNumber[] random (ComplexNumber [] a) {
			ComplexNumber max = max(a);
			ComplexNumber [] b = new ComplexNumber [a.length];
			for (int i = 0; i < b.length; i++) {
				b[i] = (new ComplexNumber(Math.random(),0)).multiply(max);
				}
			return b;
			
		}
		
		// gets the max value in the given array
		public static ComplexNumber max (ComplexNumber[] a) {
			ComplexNumber t = new ComplexNumber(Double.MIN_VALUE,Double.MIN_VALUE);
			for (int i = 0; i < a.length; i++) {
				if (a[i].isGreaterThan(t)) {
					t = a[i];
				}
			}
			return t;

		}

	// may be used later
	public static ComplexNumber Theromax() {
		return new ComplexNumber(Byte.MAX_VALUE, 0);
	}

	// returns a random movie quote
	public static void movie() {
		int a = (int) Math.random() * 8;
		if (a == 0) {
			System.out.println("'They may take our lives, but they'll never take our freedom!' - Braveheart");
		} else if (a == 1) {
			System.out.println(
					"'When you realize you want to spend the rest of your life with somebody, you want the rest of your life to start as soon as possible.' - When Harry Met Sally");
		} else if (a == 2) {
			System.out.println(
					"'If you let my daughter go now, that'll be the end of it. I will not look for you, I will not pursue you. But if you don't, I will look for you, I will find you, and I will kill you.' - Taken");
		} else if (a == 3) {
			System.out.println("Roads? Where we're going we don't need roads.' -Back to the Future");
		} else if (a == 4) {
			System.out.println(
					"'Hello. My name is Inigo Montoya. You killed my father. Prepare to die.' The Princess Bride");
		} else if (a == 5) {
			System.out.println(
					"' Mawage. Mawage is wot bwings us togeder today. Mawage, that bwessed awangment, that dweam wifin a dweam...' - The Princess Bride");
		} else if (a == 6) {
			System.out.println(
					"'It is not our abilities that show what we truly are� it is our choices.' � Harry Potter and the Chamber of Secrets");
		} else if (a == 7) {
			System.out.println(
					"'My momma always said, 'Life is like a box of chocolates, you never know what you�re gonna get.'' � Forrest Gump");
		} else if (a == 8) {
			System.out.println(
					"'How many times do I have to teach you: just because something works doesn�t mean it can�t be improved.' � Black Panther");
		}
	}
}

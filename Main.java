package com.company;
import java.util.Scanner;
public class Main {

	public static char[] selectionSort(char[][] myArray, String key) {
		char[] sort = new char[key.length()];
		for (int i = 0; i < sort.length; i++)
			sort[i] = key.charAt(i);
		for (int i = 0; i < sort.length; i++) {
			int min = sort[i];
			int min_i = i;
			for (int j = i + 1; j < sort.length; j++) {
				if (sort[j] < min) {
					min = sort[j];
					min_i = j;
				}
			}
			if (i != min_i) {
				char tmp = sort[i];
				sort[i] = sort[min_i];
				sort[min_i] = tmp;
			}
		}
		return (sort);
	}

	public static void deshifr() {
		Scanner in = new Scanner(System.in);
		System.out.print("Введите строку:");
		String stroka = in.nextLine();
		System.out.print("Введите ключ:");
		String key = in.nextLine();
		int height = stroka.length() / key.length();
		if (stroka.length() % key.length() > 0)
			++height;
		char[][] myArray = new char[(height + 2)][key.length()];
		for (int i = 0; i < key.length(); i++)
			myArray[0][i] = key.charAt(i);
		char[] sort = selectionSort(myArray, key);
		for (char i = 0; i < sort.length; i++)
			for (char j = 0; j < sort.length; j++) {
				if (myArray[0][j] == sort[i]) {
					myArray[1][j] = i;
					break;
				}
			}
		int s = 0;
		for (int l = 0; l < sort.length; l++)
			for (int i = 0; i < sort.length; i++) {
				if (myArray[1][i] == l) {
					for (int j = 2; j < (height + 2); j++) {
						myArray[j][i] = stroka.charAt(s);
						s++;
						if (s == stroka.length())
							break;
					}
				}
			}
		for(int i=2;i<(height+2);i++)
			for(int j=0;j<sort.length;j++){
				System.out.print(myArray[i][j]);
			}


	}

	public static void shifrovka() {
		Scanner in = new Scanner(System.in);
		System.out.print("Введите строку:");
		String stroka = in.nextLine();
		System.out.print("Введите размер ключа:");
		int key = in.nextInt();
		int Array[][] = new int[key*2][key*2];
		int k = 0;
        for (int i=0; i<key; i++){
        	for (int j=0; j<key; j++){
        		Array[i][j] = k;
			}
		}
        k = 0;
        for (int i = key; i<(key*2); i++){
        	for (int j = key; j<(key*2); j++){

			}
		}




		int height = stroka.length() / key.length();
		if (stroka.length() % key.length() > 0)
			++height;
		char[][] myArray = new char[(height + 2)][key.length()];
		for (int i = 0; i < key.length(); i++)
			myArray[0][i] = key.charAt(i);
		int s = 0;
		for (int i = 2; i < (height + 2); i++) {
			for (int j = 0; j < key.length(); j++) {
				myArray[i][j] = stroka.charAt(s);
				s++;
				if (s == stroka.length())
					break;
			}
		}
		char[] sort = selectionSort(myArray, key);
		for (char i = 0; i < sort.length; i++)
			for (char j = 0; j < sort.length; j++) {
				if (myArray[0][j] == sort[i]) {
					myArray[1][j] = i;
					break;
				}
			}
		for (int i = 0; i < sort.length; i++)
			for (int l = 0; l < sort.length; l++) {
				if (myArray[1][l] == i) {
					for (int j = 2; j < (height + 2); j++)
						System.out.print(myArray[j][l]);
					break;
				}
			}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Выберите действие:");
		System.out.println("1.Шифрование");
		System.out.println("2.Дешифрование");
		int choice = 0;
		while (choice != 1 && choice != 2) {
			choice = in.nextInt();
		}
		if (choice == 1)
			shifrovka();
		else
			deshifr();
	}
}

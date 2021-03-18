package com.company;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
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

    public static void deshifr_stolbec() {
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
        for (int i = 2; i < (height + 2); i++)
            for (int j = 0; j < sort.length; j++) {
                if (myArray[i][j] != 0)
                    System.out.print(myArray[i][j]);
            }
        System.out.println();

    }

    public static void shifrovka_stolbec() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку:");
        String stroka = in.nextLine();
        System.out.print("Введите ключ:");
        String key = in.nextLine();
        int height = stroka.length() / key.length();
        if (stroka.length() % key.length() > 0)
            ++height;
        char[][] myArray = new char[(height + 2)][key.length()];
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < key.length(); j++) {
                myArray[i][j] = ' ';
            }
        }
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
        System.out.println();
    }

    public static void deshifr_reshet() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку:");
        String stroka = in.nextLine();
        System.out.print("Введите размер ключа:");
        int key = in.nextInt();
        System.out.println("Введите ключ:");
        int keyschema[][] = new int[key * 2][key * 2];
        for (int i = 0; i < key * 2; i++) {
            for (int j = 0; j < key * 2; j++) {
                keyschema[i][j] = in.nextInt();
            }
        }
        char Array[][] = new char[key * 2][key * 2];
        int c = 0;
        for (int i = 0; i < key * 2; i++) {
            for (int j = 0; j < key * 2; j++) {
                Array[i][j] = stroka.charAt(c);
                c++;
            }
        }

        c = 0;
        boolean nechet = true;
        int keyschema2[][] = new int[key * 2][key * 2];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < key * 2; j++) {
                for (int l = 0; l < key * 2; l++) {
                    if ((keyschema[j][l] == 1 && nechet) || (keyschema2[j][l] == 1 && !nechet)) {
                        if (Array[j][l] != '@')
                            System.out.print(Array[j][l]);
                    }
                }
            }
            if (nechet) {
                for (int z = 0; z < key * 2; z++) {
                    for (int x = 0; x < key * 2; x++) {
                        keyschema2[z][x] = keyschema[key * 2 - x - 1][z];
                    }
                }
                nechet = false;
            } else {
                for (int z = 0; z < key * 2; z++) {
                    for (int x = 0; x < key * 2; x++) {
                        keyschema[z][x] = keyschema2[key * 2 - x - 1][z];
                    }
                }
                nechet = true;
            }
        }
        System.out.println();

    }

    public static void shifrovka_reshet() {
        final Random random = new Random();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку:");
        String stroka = in.nextLine();
        System.out.print("Введите размер ключа:");
        int key = in.nextInt();
        char Array[][] = new char[key * 2][key * 2];
        int k = 1;
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < key; j++) {
                Array[i][j] = (char) (k++);
            }
        }
        k = 1;
        for (int i = key * 2 - 1; i > key - 1; i--) {
            for (int j = 0; j < key; j++) {
                Array[j][i] = (char) (k++);
            }
        }
        k = 1;
        for (int j = 0; j < key; j++) {
            for (int i = key * 2 - 1; i > key - 1; i--) {
                Array[i][j] = (char) (k++);
            }
        }
        k = 1;
        for (int i = key * 2 - 1; i > key - 1; i--) {
            for (int j = key * 2 - 1; j > key - 1; j--) {
                Array[i][j] = (char) (k++);
            }
        }

        int schet;
        int mas[][] = new int[2][4];
        int keyschema[][] = new int[key * 2][key * 2];
        for (int i = 1; i < (key * key) + 1; i++) {
            schet = 0;
            for (int j = 0; j < key * 2; j++) {
                for (int l = 0; l < key * 2; l++) {
                    if (Array[j][l] == i) {
                        mas[0][schet] = j;
                        mas[1][schet] = l;
                        schet++;
                    }
                }
            }
            schet = random.nextInt(4);
            keyschema[mas[0][schet]][mas[1][schet]] = 1;
        }
        System.out.println("KEY:");
        for (int i = 0; i < key * 2; i++) {
            for (int j = 0; j < key * 2; j++) {
                System.out.print(keyschema[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int j = 0; j < key * 2; j++) {
            for (int l = 0; l < key * 2; l++) {
                Array[j][l] = 0;
            }
        }
        int c = 0;
        boolean nechet = true;
        int keyschema2[][] = new int[key * 2][key * 2];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < key * 2; j++) {
                for (int l = 0; l < key * 2; l++) {
                    if ((keyschema[j][l] == 1 && nechet) || (keyschema2[j][l] == 1 && !nechet)) {
                        if (c < stroka.length())
                            Array[j][l] = stroka.charAt(c++);

                        else Array[j][l] = '@';
                    }
                }
            }
            if (nechet) {
                for (int z = 0; z < key * 2; z++) {
                    for (int x = 0; x < key * 2; x++) {
                        keyschema2[z][x] = keyschema[key * 2 - x - 1][z];
                    }
                }
                nechet = false;
            } else {
                for (int z = 0; z < key * 2; z++) {
                    for (int x = 0; x < key * 2; x++) {
                        keyschema[z][x] = keyschema2[key * 2 - x - 1][z];
                    }
                }
                nechet = true;
            }
        }
        System.out.println();
        for (int i = 0; i < key * 2; i++) {
            for (int j = 0; j < key * 2; j++) {
                System.out.print(Array[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("Shifr:");
        for (int i = 0; i < key * 2; i++) {
            for (int j = 0; j < key * 2; j++) {
                System.out.print(Array[i][j]);
            }
        }
        System.out.println();
    }

    public static void shifrovka_isgorod() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку:");
        String stroka = in.nextLine();
        System.out.print("Введите ключ:");
        int key = in.nextInt();
        char[][] myArray = new char[key][stroka.length()];
        int cikl = stroka.length() / (key + key - 2);
        int c = 0;
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < stroka.length(); j++) {
                myArray[i][j] = ' ';
            }
        }
        for (int i = 0; i < cikl; i++) {
            for (int j = 0; j < key; j++) {
                myArray[j][c] = stroka.charAt(c++);
            }
            for (int l = key - 2; l > 0; l--) {
                myArray[l][c] = stroka.charAt(c++);
            }

        }
        if (stroka.length() > c) {
            for (int j = 0; j < key; j++) {
                myArray[j][c] = stroka.charAt(c++);
                if (c == stroka.length())
                    break;
            }

        }

        if (stroka.length() > c) {
            for (int l = key - 2; l > 0; l--) {
                myArray[l][c] = stroka.charAt(c++);
                if (c == stroka.length())
                    break;
            }

        }


        for (int i = 0; i < key; i++) {
            for (int j = 0; j < stroka.length(); j++) {
                System.out.print(myArray[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < key; i++) {
            for (int j = 0; j < stroka.length(); j++) {
                if (myArray[i][j] != ' ')
                    System.out.print(myArray[i][j]);
            }
        }
        System.out.println();
    }


    public static void deshifr_isgorod(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку:");
        String stroka = in.nextLine();
        System.out.print("Введите ключ:");
        int key = in.nextInt();
        char[][] myArray = new char[key][stroka.length()];
        String res = new String("");
        int period = 2*(key-1);

        int[] mas = new int[stroka.length()];
        for(int i=0;i<stroka.length();i++){
            int ost = i%period;
            int row = key-1-Math.abs(key-1-ost);
            mas[i]=row;
        }
        Arrays.sort(mas);

        int down = 0;
        int i =0;
        while (res.length() !=stroka.length()){
            for (int l=0;l<stroka.length();l++){
                if (i==mas[l]){
                    res+=stroka.charAt(l);
                    mas[l]=-1;
                    break;
                }
            }
            if (i==key-1){
                down = 1;
            }
            if (i==0){
                down = 0;
            }
            if (down == 0){
                i++;
            }
            else {
                i--;
            }
        }
        System.out.println(res);


    }


    public static void deshifr_vishener(char [][] myArray) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку:");
        String stroka = in.nextLine();
        System.out.print("Введите ключ:");
        String key = in.nextLine();
        stroka=stroka.toUpperCase();
        key = key.toUpperCase();
        int height = stroka.length() / key.length();
        if (stroka.length() % key.length() > 0)
            ++height;
        String keyword = "";
        for(char i = 0; i<height;i++)
            for (int j = 0; j<key.length();j++)
                keyword+=(key.charAt(j));
        for (int i = 0;i<stroka.length();i++){
            for(int j=1;j<27;j++) {
                if (stroka.charAt(i) < 90 && stroka.charAt(i) > 41) {
                    if (myArray[keyword.charAt(i) - 64][j] == stroka.charAt(i)){
                        System.out.print(myArray[0][j]);
                    }
                }
                else{
                    System.out.print(stroka.charAt(i));
                    break;
                }
            }
        }
        System.out.println();

    }

    public static void shifrovka_vishener(char [][] myArray) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку:");
        String stroka = in.nextLine();
        System.out.print("Введите ключ:");
        String key = in.nextLine();
        stroka=stroka.toUpperCase();
        key = key.toUpperCase();
        int height = stroka.length() / key.length();
        if (stroka.length() % key.length() > 0)
            ++height;
        String keyword = "";
        int progress = 0;
        for(char i = 0; i<height;i++)
            for (int j = 0; j<key.length();j++)
                keyword+=(key.charAt(j));
        for(int i=0;i<stroka.length();i++){
            if(stroka.charAt(i)>41 && stroka.charAt(i)<90)
                System.out.print(myArray[keyword.charAt(i)-64][stroka.charAt(i)-64]);
            else
                System.out.print(stroka.charAt(i));
        }
        System.out.println();
    }

    public static char [][] Createtable(char [][] table){
        char c=65;
        for(int i=1;i<27;i++){
            table[0][i] = c;
            table[i][0] = c;
            c++;
        }
        for (char i=1;i<27;i++){
            c = (char) (64+i);
            for (int j=1;j<27;j++){
                table[i][j] = c;
                c++;
                if (c>90) c = (char)(c-26);
            }
        }
        return(table);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = 0, choice2 = 0;
        while (choice != 5) {
            System.out.println("Выберите метод шифрования:");
            System.out.println("1.Столбцевой");
            System.out.println("2.Решеткой");
            System.out.println("3.Изгородь");
            System.out.println("4.Виженера");
            System.out.println("5.Закончить программу");
            choice = 0;
            choice2 = 0;
            while (choice > 5 || choice < 1) {
                choice = in.nextInt();
            }
            switch (choice) {
                case 1:
                    System.out.println("1.Шифрование");
                    System.out.println("2.Дешифровка");
                    System.out.println("3.Выйти");
                    while (choice2 > 3 || choice2 < 1) {
                        choice2 = in.nextInt();
                    }
                    if (choice2 == 1)
                        shifrovka_stolbec();
                    else
                        deshifr_stolbec();
                    break;
                case 2:
                    System.out.println("1.Шифрование");
                    System.out.println("2.Дешифровка");
                    System.out.println("3.Выйти");
                    while (choice2 > 3 || choice2 < 1) {
                        choice2 = in.nextInt();
                    }
                    if (choice2 == 1)
                        shifrovka_reshet();
                    else
                        deshifr_reshet();
                    break;
                case 3:
                    System.out.println("1.Шифрование");
                    System.out.println("2.Дешифровка");
                    System.out.println("3.Выйти");
                    while (choice2 > 3 || choice2 < 1) {
                        choice2 = in.nextInt();
                    }
                    if (choice2 == 1)
                        shifrovka_isgorod();
                    else
                        deshifr_isgorod();
                    break;
                case 4:
                    System.out.println("1.Шифрование");
                    System.out.println("2.Дешифровка");
                    System.out.println("3.Выйти");
                    while (choice2 > 3 || choice2 < 1) {
                        choice2 = in.nextInt();
                    }
                    char [][] table = new char [27][27];
                    table = Createtable(table);
                    if (choice2 == 1)
                        shifrovka_vishener(table);
                    if (choice2 ==2)
                        deshifr_vishener(table);
                    break;
                case 5:
                    break;
            }


        }
    }
}

package 信息安全.置换密码;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static String key = null;
    private static String message = null;
    private static char[] Messages = null;
    private static char[] Keys = null;
    private static char[] KeysInOrder = null;

    /**
     * 菜单函数
     */
    public static void Menu() {
        System.out.println("\nMenu");
        System.out.println("1.明文加密\n" + "2.密文解密\n" + "3.退出\n");
        System.out.print("请选择菜单功能：");
    }


    /**
     * 置换 加解密算法
     *
     * @param choice
     */
    public static void enCode(int choice) {
        int base = 0;
        int group;//矩阵行数（组数）
        if (choice == 1)
            System.out.print("请输入明文：");
        else
            System.out.print("请输入密文：");
        Scanner in1 = new Scanner(System.in);
        message = in1.nextLine();
        System.out.print("请输入密钥：");
        Scanner in2 = new Scanner(System.in);
        key = in2.nextLine();
        KeysInOrder = key.toCharArray();
        Arrays.sort(KeysInOrder);
        Keys = key.toCharArray();
        for (int i = 0; i < Keys.length; i++) {//将输入的密钥转化为数字序号
            for (int j = 0; j < KeysInOrder.length; j++) {
                if (Keys[i] == KeysInOrder[j]) {
                    Keys[i] = (char) (j + '0');
                    break;
                }
            }
        }

        message = message.replaceAll("\\s*", "");//清除message中的空格
        message = message.toLowerCase();//转换为小写字母
        group = (int) (Math.ceil(message.length() / (double) key.length()));//group为组数
        Messages = message.toCharArray();//将输入的信息转为字符数组保存

        if (choice == 1)
            for (int i = 0; i < group; i++) {
                for (int j = 0; j < Keys.length; j++) {
                    if (base + Integer.parseInt(String.valueOf(Keys[j])) < Messages.length)
                        System.out.print(Messages[base + Integer.parseInt(String.valueOf(Keys[j]))]);
                    else
                        System.out.print("#");
                }
                base += key.length();
            }
        if (choice == 2) {
            for (int i = 0; i < group; i++) {
                for (int j = 0; j < Keys.length; j++) {
                    for (int k = 0; k < Keys.length; k++) {
                        if (Integer.parseInt(String.valueOf(Keys[k])) == j && Messages[k + base] != '#') {
                            System.out.print(Messages[k + base]);
                            break;
                        }
                    }
                }
                base += key.length();
            }
        }
    }

    public static void main(String[] args) {
        int choice = -1;
        int flag = 0;
        while (flag == 0) {
            Menu();
            Scanner in2 = new Scanner(System.in);
            choice = in2.nextInt();
            switch (choice) {
                case 1:
                    enCode(choice);
                    break;
                case 2:
                    enCode(choice);
                    break;
                case 3:
                    flag++;
                    break;
                default:
                    break;
            }
        }
    }
}
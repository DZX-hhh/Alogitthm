package 信息安全.替代密码;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    private static int ASCII;
    private static char[] Messages = null;
    private static int i = 0;
    private static int key = 0;


    public static void Menu() {
        System.out.println("\nMenu");
        System.out.println("\n1.明文加密" + "\n2.密文解密" + "\n3.退出");
        System.out.print("请选择菜单功能：");
    }

    public static void enCode(int choice) {
        boolean flag = false;
        do {
            flag = false;
            if (choice == 1)
                System.out.print("请输入明文：");
            else
                System.out.print("请输入密文：");
            Scanner in1 = new Scanner(System.in);
            String message = in1.nextLine();
            System.out.print("请输入密钥：");
            Scanner in2 = new Scanner(System.in);
            message = message.replaceAll("\\s*", "");
            try {
                key = in2.nextInt();
            } catch (Exception e) {
                flag = true;
                System.out.println("密钥必须为数字！请重新输入...");
            }
            if (flag != true) {
                Messages = message.toCharArray();
                for (i = 0; i < Messages.length; i++) {
                    ASCII = Integer.valueOf(Messages[i]);
                    if (ASCII < 65 || (ASCII > 90 && ASCII < 97) || ASCII > 122) {
                        flag = true;
                        System.out.println("请输入英文！请再次尝试...");
                        break;
                    } else
                        switch (choice) {
                            case 1:
                                encode();
                                break;
                            case 2:
                                decode();
                                break;
                            default:
                                System.out.println("出错！");
                                break;
                        }
                }
            }
        } while (flag);
        System.out.print("密文为：");
        for (int i = 0; i < Messages.length; i++)
            System.out.print(Messages[i]);
    }

    public static void encode() {
        if (ASCII >= 97 && ASCII <= 122)//小写字母
            Messages[i] = (char) ((ASCII + key - 97) % 26 + 97);
        else //大写字母
            Messages[i] = (char) ((ASCII + key - 65) % 26 + 65);
    }

    public static void decode() {
        if (ASCII >= 97 && ASCII <= 122)//小写字母
            Messages[i] = (char) ((ASCII - 97 + 26 - key) % 26 + 97);
        else //大写字母
            Messages[i] = (char) ((ASCII - 65 + 26 - key) % 26 + 65);
    }

    public static void main(String[] args) throws IOException {
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
                    System.out.println("出错！");
                    break;
            }
        }
    }
}

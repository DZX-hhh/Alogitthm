package 信息安全;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class cc {
	static String key=null;
	static String message=null;
	static char[] messageArray=null;
	static char[] keyArray=null;
	public static void main(String[] args) {
		int choice=-1;
		int flag=0;
		while(flag==0) {
			menu();
			Scanner in2=new Scanner(System.in);
			choice=in2.nextInt();
			switch (choice) {
				case 1:
					code(choice);
					break;
				case 2:
					code(choice);
					break;
				case 3:
					flag++;
					break;
				default:
					System.out.println("出错！");
					break;
			}
		}
		System.out.println("谢谢您的使用！");
	}
	public static void menu() {
		System.out.println();
		System.out.println();
		System.out.println("***********PermutationCipher**********");
		System.out.println("    "+"1.明文加密"+"      "+"2.密文解密"+"        "+"3.退出");
		System.out.println("**************************************");	
		System.out.print("请选择菜单功能：");
	}
	public static void code(int choice){
		int base=0;//矩阵每行元素的下标
		int group;//矩阵行数（组数）
		if(choice==1)
			System.out.print("请输入密文：");
		else
			System.out.print("请输入明文：");
		Scanner in1=new Scanner(System.in);
		message=in1.nextLine();
		System.out.print("请输入**：");
		Scanner in2=new Scanner(System.in);
		key=in1.nextLine();
		keyArray=key.toCharArray();
		message=message.replaceAll("\\s*", "");//清除message中的空格
		message=message.toLowerCase();//转换为小写字母
		group=(int)(Math.ceil(message.length()/(double)key.length()));//group为组数
		messageArray=message.toCharArray();//将输入的信息转为字符数组保存
		for(int i=0;i<group;i++) {//给明文分组，每组排完序后直接输出
			Map<String, String>map=sortMap(base);
			String[] valueArray = new String[key.length()*group];
		    map.values().toArray(valueArray);
			for(int j=0;j<key.length();j++) {
				if(valueArray[j]=="0")//如果是后补的“0”，则跳过输出
					continue;
				System.out.print(valueArray[j]);
			}
			base+=key.length();
		}
	}
	private static Map<String, String> sortMap(int base) {//加解密的排序通过此函数完成
    	Map<String,String> group = new TreeMap<String,String>();
    	//利用TreeMap会自动根据键的大小排序这个特性，最终得到的group一定是根据键由小到大的顺序排好序的，非常方便
    	String tag="";
    	for(int i=0;i<key.length();i++) {//设置每组键值对
    		if(base+i<message.length()) {//判断是否完成明文的扫描
    			tag=String.valueOf(keyArray[i]);
    			group.put(tag,String.valueOf(messageArray[base+i]));
    		}
    		else//messageArray扫描完成，则给该组剩余值补“0”，确保每组都有key.lenth()个
    			group.put(Integer.toString(126+i),"0");//126是为了确保后面补的“0”一定比前面的内容靠后，即大于ASCII码最大值就好
        }
    	return group;
	}
}

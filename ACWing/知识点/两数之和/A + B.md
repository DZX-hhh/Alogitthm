1. A + B

- [  题目](https://www.acwing.com/problem/content/description/1/)
- [  提交记录](https://www.acwing.com/problem/content/submission/1/)
- [  讨论](https://www.acwing.com/problem/content/discussion/index/1/1/)
- [  题解](https://www.acwing.com/problem/content/solution/1/1/)
- [  视频讲解](https://www.acwing.com/problem/content/video/1/)

输入两个整数，求这两个整数的和是多少。

#### 输入格式

输入两个整数A,BA,B，用空格隔开

#### 输出格式

输出一个整数，表示这两个数的和

#### 数据范围

0≤A,B≤1080≤A,B≤108

#### 样例输入：

```
3 4
```

#### 样例输出：

```
7
```

##### ACWing Start

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        System.out.println(A + B);
    }
}
```
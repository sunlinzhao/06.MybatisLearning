package com.slz.one;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/24
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入总格子数 w 和画笔数 n
        int w = scanner.nextInt();
        int n = scanner.nextInt();
        int[] a = new int[n];

        // 输入每个画笔可以涂的格子数
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // 计算总涂色格子数和最小空格子数
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        int minSpace = sum + n - 1; // n-1 是每个画笔之间至少的空白格数

        // 如果涂色总格子数超过 w，则没有办法实现
        if (minSpace > w) {
            System.out.println(0);
            return;
        }

        // 计算从左到右和从右到左的最小涂色位置
        int[] left = new int[w];
        int[] right = new int[w];
        Arrays.fill(left, 0);
        Arrays.fill(right, 0);

        // 从左到右涂色
        int start = 0;
        for (int i = 0; i < n; i++) {
            for (int j = start; j < start + a[i]; j++) {
                left[j] = 1;
            }
            start += a[i] + 1;
        }

        // 从右到左涂色
        start = w - 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = start; j > start - a[i]; j--) {
                right[j] = 1;
            }
            start -= a[i] + 1;
        }

        // 找出所有涂色格子
        List<Integer> fixedColorGrids = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            if (left[i] == 1 && right[i] == 1) {
                fixedColorGrids.add(i + 1); // 格子编号从 1 开始
            }
        }

        // 输出固定涂色的格子
        System.out.println(fixedColorGrids.size());
        for (int pos : fixedColorGrids) {
            System.out.print(pos + " ");
        }
    }
}


package com.hcldailytask;

public class MonthlyUsageAnalyser {
    static final int LOW_USAGE_LIMIT = 100;
    static final int MEDIUM_USAGE_LIMIT = 200;
    static final char GRADE_A = 'A';
    static final char GRADE_B = 'B';
    static final char GRADE_C = 'C';

    public static void main(String[] args) {
        int[] usage = {
                120, 180, 95, 210,
                150, 175, 220, 130,
                90, 160, 195, 250
        };

        int totalUsage = 0;
        int maxUsage = usage[0];
        int minUsage = usage[0];

        for (int monthlyUsage : usage) {
            totalUsage += monthlyUsage;

            if (monthlyUsage > maxUsage) {
                maxUsage = monthlyUsage;
            }

            if (monthlyUsage < minUsage) {
                minUsage = monthlyUsage;
            }
        }

        double averageUsage = (double) totalUsage / usage.length;

        System.out.println("===== Monthly Usage Analysis =====");
        System.out.println("Total Usage   : " + totalUsage);
        System.out.println("Average Usage : " + averageUsage);
        System.out.println("Maximum Usage : " + maxUsage);
        System.out.println("Minimum Usage : " + minUsage);

        char grade = averageUsage <= LOW_USAGE_LIMIT
                ? GRADE_A
                : averageUsage <= MEDIUM_USAGE_LIMIT
                ? GRADE_B
                : GRADE_C;

        System.out.println("Usage Grade   : " + grade);

        int largeNumber = Integer.MAX_VALUE;

        System.out.println("\n===== Integer Overflow =====");
        System.out.println("Maximum int value : " + largeNumber);

        int overflowResult = largeNumber + 1;

        System.out.println("After adding 1   : " + overflowResult);

        long safeNumber = (long) Integer.MAX_VALUE;

        long safeResult = safeNumber + 1;

        System.out.println("\n===== Using long =====");
        System.out.println("Maximum int value : " + safeNumber);
        System.out.println("After adding 1   : " + safeResult);

        int[][] houseUsage = {
                {120, 180, 95, 210, 150, 175, 220, 130, 90, 160, 195, 250},
                {100, 140, 110, 190, 130, 160, 200, 120, 80, 150, 170, 220},
                {200, 220, 180, 250, 210, 230, 270, 190, 160, 210, 240, 280}
        };

        System.out.println("\n===== 3 Houses Usage =====");

        for (int house = 0; house < houseUsage.length; house++) {
            System.out.print("House " + (house + 1) + ": ");

            for (int month = 0; month < houseUsage[house].length; month++) {
                System.out.print(houseUsage[house][month] + " ");

            }

            System.out.println();
        }
    }
}
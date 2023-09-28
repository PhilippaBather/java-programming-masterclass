package org.batherphilippa.controlflow;

public class PaintJobChallenge {

    public static void main(String[] args) {
        System.out.println(getBucketCount(-3.4, 2.1, 1.5, 2)); // -1
        System.out.println(getBucketCount(3.4, 2.1, 1.5, 2)); // 3
        System.out.println(getBucketCount(2.75, 3.25, 2.5, 1)); // 3
        System.out.println(getBucketCount(1.4,2.1,-1.5,2)); // -1


        System.out.println("-------- First Overloaded Method ---------");
        System.out.println(getBucketCount(-3.4, 2.1, 1.5)); // -1
        System.out.println(getBucketCount(3.4, 2.1, 1.5)); // 5
        System.out.println(getBucketCount(7.25, 4.3, 2.35)); // 14

        System.out.println("-------- Second Overloaded Method ---------");
        System.out.println(getBucketCount(3.4, 1.5)); // 3
        System.out.println(getBucketCount(6.26, 2.2)); // 3
        System.out.println(getBucketCount(3.26, 0.75)); // 5
        System.out.println(getBucketCount(2.25,0.0)); // -1
    }

    private static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets){
        if ((width <= 0) || (height <= 0) || (areaPerBucket <= 0) || (extraBuckets < 0)){
            return -1;
        }

        double wallArea = (width * height);
        return (int) Math.ceil((wallArea / areaPerBucket)) - extraBuckets;
    }

    private static int getBucketCount(double width, double height, double areaPerBucket) {
        return getBucketCount(width, height, areaPerBucket, 0);
    }

    private static int getBucketCount(double area, double areaPerBucket) {
        if ((area <= 0) || (areaPerBucket <= 0)){
            return -1;
        }

        return (int) Math.ceil(area / areaPerBucket);
    }
}

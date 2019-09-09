public class TestThread {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[]arr = new float[SIZE];


    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start!");
        withoutThreading();
        withThreading();
    }



    static void withoutThreading() {
        long a = System.currentTimeMillis();
        calculateAll(arr);
        System.out.println("Метод 1 выполнялся: " + (+ System.currentTimeMillis() - a) + "ms");
    }

    static void withThreading() {

        long a = System.currentTimeMillis();

        float[]arr1 = new float[HALF];
        float[]arr2 = new float[HALF];
        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        System.arraycopy(arr, arr1.length, arr2, 0, arr2.length );

        MyThread myThread = new MyThread(arr1);
        MyThread myThread1 = new MyThread(arr2);

        myThread.start();
        myThread1.start();

        try {
            myThread.join();
            myThread1.join();
        } catch (InterruptedException e) {
            System.out.println("Прерван main поток");
        }

        System.out.println("Метод 2 выполнялся: " + (+ System.currentTimeMillis() - a) + "ms");
    }


    static float[]calculateAll(float[]arr) {
        fillInArray(arr);
        calculateFormula(arr);
        return arr;
    }

    static float[] fillInArray(float[]array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
        return array;
    }

    static float[] calculateFormula(float[] array){
        for (float i : array) {
            array[(int) i] = (float)(array[(int) i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return array;
    }

    public static class MyThread extends Thread {

        float[]threadArray;

        public MyThread(float[]threadArray) {
            this.threadArray = threadArray;
        }

        public void run() {
            calculateAll(threadArray);
        }
    }
}

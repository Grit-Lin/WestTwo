package Problem2;


import java.util.concurrent.locks.Lock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {2,4,6,8,10};
        arrayALT(arr1,arr2);

        System.out.println(legalEmail("505499947@qq.com"));
    }


    public static void arrayALT(int[] arr1,int[] arr2){
        Thread1 thread1 = new Thread1(arr1);
        Thread1 thread2 = new Thread1(arr2);

        new Thread(thread1).start();
        new Thread(thread2).start();
    }

    public static boolean legalEmail(String email){
        String check = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        return matcher.matches();
    }


}

class Thread1 implements Runnable{
    int[] arr;

    public Thread1(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
            for (int i = 0;i < arr.length;i++){
                synchronized (Problem2.class){
                    System.out.print(arr[i]+" ");
                    Problem2.class.notify();
                    try {
                        Problem2.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
}

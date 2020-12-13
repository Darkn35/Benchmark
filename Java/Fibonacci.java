import java.math.BigInteger;
import java.lang.management.ManagementFactory;

public class Fibonacci {

    static void printFibonacciNumbers(int n) // function to print the n fibonacci numbers
    {
        long startTime = System.currentTimeMillis(); // start the timer

        int  f1 = 0, f2 = 1;
        int i;
        BigInteger Bigf1 = BigInteger.valueOf(f1);
        BigInteger Bigf2 = BigInteger.valueOf(f2);

        if (n < 1)
            return;
        System.out.print(Bigf1 + "\n");
        for (i = 1; i < n; i++) 
        {
            System.out.print(Bigf2 + "\n");
            BigInteger sum;
            sum = Bigf1.add(Bigf2);
            Bigf1 = Bigf2;
            Bigf2 = sum;
        }
        
        // get the current memory usage

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is : " + memory + " bytes");

        // end the timer

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Elapsed Time : " + elapsedTime + " ms");

        // get the current cpu usage

        com.sun.management.OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(com.sun.management.OperatingSystemMXBean.class);
        System.out.println("System Load Average : " + osBean.getProcessCpuLoad() * 100);
    }
    
    public static void main(String[] args)
    {
        printFibonacciNumbers(10001); // call the function to print the first 10000 fibonacci numbers
    }
}
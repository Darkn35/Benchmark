import java.lang.management.ManagementFactory;

public class PrimeNumber {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // start the timer

        int ct = 0, n = 0, i = 1, j = 1;
        while (n < 10000) {
            j = 1;
            ct = 0;
            while (j <= i) {
                if (i % j == 0)
                    ct++;
                j++;
            }
            if (ct == 2) {
                System.out.printf("%d \n", i);
                n++;
            }
            i++;
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
}
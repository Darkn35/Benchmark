import java.lang.management.ManagementFactory;

public class HelloWorld {
    
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis(); // start the timer

        for (int i = 1; i <= 10000; i++) { // for loop to print "Hello World!" 10000 times
            System.out.println("Hello World!");
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
        System.out.println(osBean.getProcessCpuLoad() * 100);
        System.out.println("System Load Average : " + osBean.getProcessCpuLoad() * 100);
        
    }
}
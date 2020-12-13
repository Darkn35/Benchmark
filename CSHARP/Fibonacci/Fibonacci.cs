using System;
using System.Numerics;
using System.Diagnostics;
using System.Threading;

    class Program
    {
        static void printFibonacciNumbers(int n) // function to print n fibonacci numbers
        {
            Program CPUChecker = new Program();
            var watch = System.Diagnostics.Stopwatch.StartNew(); // start the timer
            
            int f1 = 0, f2 = 1, i;
            BigInteger Bigf1 = f1;
            BigInteger Bigf2 = f2;
            if (n < 1)
                return;
            Console.Write(Bigf1 + "\n");
            for (i = 1; i < n; i++) {
                Console.Write(Bigf2 + "\n");
                BigInteger sum = Bigf1 + Bigf2;
                Bigf1 = Bigf2;
                Bigf2 = sum;
            }
            // get the current memory usage
            Process currentProcess = Process.GetCurrentProcess();
            long usedMemory = currentProcess.PrivateMemorySize64;
            Console.WriteLine("Memory: " + usedMemory);
            // call the function to get the current cpu usage
            CPUChecker.CPUChecker();
            
            watch.Stop(); // end the timer
            var elapsedMs = watch.ElapsedMilliseconds;
            Console.WriteLine("Time : " + elapsedMs + "ms");
        }
 
    public static void Main() 
    { 
         printFibonacciNumbers(10001); // call the function to print the first 10000 fibonacci numbers
    }

    private PerformanceCounter theCPUCounter = new PerformanceCounter("Processor", "% Processor Time", "_Total");
    public void CPUChecker()
    {
        var cpuUsage = new PerformanceCounter("Processor", "% Processor Time", "_Total");
        Thread.Sleep(1000);
        var firstCall = cpuUsage.NextValue();

        for (int i = 0; i < 5; i++) // get the current cpu usage five times in the span of five seconds
        {
            Thread.Sleep(1000);
            Console.WriteLine(cpuUsage.NextValue() + "%");
        }
    }
}
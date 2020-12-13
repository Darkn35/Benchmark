using System;
using System.Diagnostics;
using System.Threading;

namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            Program CPUChecker = new Program();
            var watch = System.Diagnostics.Stopwatch.StartNew(); // start the timer

            for (int i = 1; i <= 10000; i++) // for loop to print "Hello World!" 10000 times
            {
                Console.WriteLine("Hello World!");
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
}
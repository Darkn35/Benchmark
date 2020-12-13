import os
import psutil
import time

def printFibonacciNumbers(n):
    
    # start the timer

    start_time = time.time()

    f1 = 0
    f2 = 1
    if (n < 1):
        return
    print(f1, end="\n")

    # for loop to print the n fibonacci numbers

    for x in range(1, n):
        print(f2, end="\n")
        next = f1 + f2
        f1 = f2
        f2 = next
     # get and print the runtime

    print("--- %s seconds ---" % (time.time() - start_time))
    
    # get and print the current cpu usage

    print("CPU : %s" % psutil.cpu_percent())
    
    # get the current memory usage

    process = psutil.Process(os.getpid())
    
    # print the current memory usage

    print("Memory : %s bytes" % process.memory_info().rss)

if __name__ == '__main__':

    # call the function to print the first 10000 fibonacci numbers

    printFibonacciNumbers(10001)

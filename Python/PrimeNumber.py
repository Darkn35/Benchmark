import psutil
import time
import os

def my_func():

    # start the timer

    start_time = time.time()

    i=1
    x = 10000
    counter = 0

    # while loop to print the first 10000 prime numbers

    while True:
        c=0;
        for j in range (1, (i+1), 1):
            a = i%j
            if (a==0):
                c = c+1
        if (c==2):
            print (i)
            counter = counter + 1
            if counter >= x:
                break
        i=i+1

     # get and print the runtime

    print("--- %s seconds ---" % (time.time() - start_time))
    
    # get and print the current cpu usage

    print("CPU : %s" % psutil.cpu_percent())
    
    # get the current memory usage

    process = psutil.Process(os.getpid())
    
    # print the current memory usage

    print("Memory : %s bytes" % process.memory_info().rss)

if __name__ == '__main__':
    my_func()
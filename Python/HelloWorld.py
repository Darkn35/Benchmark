import os
import psutil
import time


def my_func(): 

  # start the timer

  start_time = time.time()

  # for loop to print 10000 "Hello World!"

  for line in range(10000):
    print("Hello World!")

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
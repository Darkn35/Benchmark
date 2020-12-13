<?php

$time_start = microtime(true); // start the timer

// Code to print the first 10000 prime numbers

set_time_limit(500); // set the time limit in order for the script to run properly

$ct=0;  
$n=0;  
$i=1;  
$j=1;

while($n<10000)  
{  
    $j=1;  
    $ct=0;  
    while($j<=$i)  
    {  
        if($i%$j==0)  
        $ct++;  
        $j++;   
        }  
        if($ct == 2)  
        {  
        echo $i;  
        echo "<br>";  
        $n++;  
    }  
    $i++;  
}

// Measurement

$memory_size = memory_get_usage(); // get the current memory usage

$memory_unit = array('Bytes','KB','MB','GB','TB','PB');

echo 'Used Memory : '.round($memory_size/pow(1024,($x=floor(log($memory_size,1024)))),2).' '.$memory_unit[$x]."<br>";

function win_sys_current_cpu_usage() { // get the current cpu usage
    $cmd = 'typeperf  -sc 1  "\Processor(_Total)\% Processor Time"';
    exec($cmd, $lines, $retval);
    if($retval == 0) {
      $values = str_getcsv($lines[2]);
      return floatval($values[1]);
    } else {
      return false;
    }
  }

echo 'Used CPU : ',win_sys_current_cpu_usage(),' %<br>';

$time_end = microtime(true); // end the timer
$execution_time = ($time_end - $time_start);
echo '<b>Total Execution Time:</b> '.$execution_time.' Seconds';
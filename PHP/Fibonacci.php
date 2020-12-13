<?php

$time_start = microtime(true); // start the timer

// fucntion to print the n fibonacci numbers

function printFibonacciNumbers($n)
{
    $f1 = 0;
    $f2 = 1; 
    $i;
 
    if ($n < 1)
        return;
    echo($f1);
    echo("<br>");
    for ($i = 1; $i < $n; $i++)
    {
        echo($f2);
        echo("<br>");
        $next = $f1 + $f2;
        $f1 = $f2;
        $f2 = $next;
    }
}

    printFibonacciNumbers(10001); // call the function to print the first 10000 fibonacci numbers

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
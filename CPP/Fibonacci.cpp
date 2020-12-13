#include <bits/stdc++.h> 
#include <sys/time.h>
#include <pdhmsg.h>
#include <iostream>
#include "windows.h"
#include "tchar.h"
#include "pdh.h"
#include "psapi.h"

using namespace std;

static PDH_HQUERY cpuQuery;
static PDH_HCOUNTER cpuTotal;

void printFibonacciNumbers(int n) // function to print n fibonacci numbers
{
    unsigned long f1 = 0, f2 = 1, i;

    if (n < 1)
        return;
    cout << f1 << "\n";
    for (i = 1; i < n; i++) {
        cout << f2 << "\n";
        unsigned long sum = f1 + f2;
        f1 = f2;
        f2 = sum;
    }
}
 
void init(){
    PdhOpenQuery(NULL, NULL, &cpuQuery);
    // You can also use L"\\Processor(*)\\% Processor Time" and get individual CPU values with PdhGetFormattedCounterArray()
    PdhAddEnglishCounter(cpuQuery, "\\Processor(_Total)\\% Processor Time", NULL, &cpuTotal);
    PdhCollectQueryData(cpuQuery);
}

double getCurrentValue(){
	PDH_FMT_COUNTERVALUE counterVal;

    PdhCollectQueryData(cpuQuery);
    PdhGetFormattedCounterValue(cpuTotal, PDH_FMT_DOUBLE, NULL, &counterVal);
    return counterVal.doubleValue;
} 
 
int main()
{
	init();
    struct timespec start, end; //start the timer

    clock_gettime(CLOCK_MONOTONIC, &start); 
  
    ios_base::sync_with_stdio(false); 

    printFibonacciNumbers(10001); // call the function to print the first 10000 fibonacci numbers

    clock_gettime(CLOCK_MONOTONIC, &end); // end the timer
  
    double time_taken; 
    time_taken = (end.tv_sec - start.tv_sec) * 1e9; 
    time_taken = (time_taken + (end.tv_nsec - start.tv_nsec)) * 1e-9; 
  
    cout << "Time taken by program is : " << fixed 
         << time_taken << setprecision(9); 
    cout << " sec" << endl; 

    PROCESS_MEMORY_COUNTERS_EX pmc;
	GetProcessMemoryInfo(GetCurrentProcess(), (PROCESS_MEMORY_COUNTERS*)&pmc, sizeof(pmc));
	SIZE_T virtualMemUsedByMe = pmc.PrivateUsage;

	cout << virtualMemUsedByMe << " bytes" << endl;
	
	getCurrentValue();
	
	for (int i = 0; i < 5; i++)
	{
		Sleep(1000);
		cout << getCurrentValue() << " %" << endl;
	}
	
	system("pause");
	
    return 0;
}

/*
Television Sets
==Problem Description
Dr. Vishnu is opening a new world class hospital in a small town designed to be the first preference of the patients in the city. Hospital has N rooms of two types - with TV and without TV, with daily rates of R1 and R2 respectively. 

However, from his experience Dr. Vishnu knows that the number of patients is not constant throughout the year, instead it follows a pattern. The number of patients on any given day of the year is given by the following formula – 

(6-M)^2 + |D-15| where

M is the number of month (1 for jan, 2 for feb ...12 for dec) and

D is the date (1,2...31).

All patients prefer without TV rooms as they are cheaper, but will opt for with TV rooms only if without TV rooms are not available. Hospital has a revenue target for the first year of operation. Given this target and the values of N, R1 and R2 you need to identify the number of TVs the hospital should buy so that it meets the revenue target. Assume the Hospital opens on 1st Jan and year is a non-leap year. 

Constraints
Hospital opens on 1st Jan in an ordinary year

5 <= Number of rooms <= 100

500 <= Room Rates <= 5000

0 <= Target revenue < 90000000

Input
First line provides an integer N that denotes the number of rooms in the hospital

Second line provides two space-delimited integers that denote the rates of rooms with TV (R1) and without TV (R2) respectively

Third line provides the revenue target

Output
Minimum number of TVs the hospital needs to buy to meet its revenue target. If it cannot achieve its target, print the total number of rooms in the hospital.

Timeout
1


==Examples:
=Example 1:

Input

20

1500 1000  //w/, w/o TV

7000000

Output

14 

Explanation

Using the formula, number of patients on 1st Jan will be 39, on 2nd Jan will be 38 and so on. Considering there are only twenty rooms and rates of both type of rooms are 1500 and 1000 respectively, we will need 14 TV sets to get revenue of 7119500. With 13 TV sets Total revenue will be less than 7000000

=Example 2

Input

10

1000 1500

10000000

Output

10

Explanation

In the above example, the target will not be achieved, even by equipping all the rooms with TV. Hence, the answer is 10 i.e. total number of rooms in the hospital.
*/

public class MockVita2 {
    public static void main(String[] args) {
    // 	String[] myArgs = args[0].split(" ");  // change to \n
        int numRooms = Integer.parseInt(args[0]); System.out.println("numRooms: "+numRooms);
        int tvPrice = Integer.parseInt(args[1]); System.out.println("tvPrice: "+tvPrice);
        int notvPrice = Integer.parseInt(args[2]); System.out.println("notvPrice: "+notvPrice);
        int revTarget = Integer.parseInt(args[3]); System.out.println("revTarget: "+revTarget);

        //loop to find daily visits
        int[] visits = new int[365];
        int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31}; //based on j'th index
        int i = 0; //i = index of visits[]
        for(int j = 1; j < 13; j++) { //j = month
        	for(int k = 1; k <= days[j]; k++) { //k = day
        		visits[i] = (6-j)*(6-j) + Math.abs(k-15);
        		// System.out.println(visits[i]);
        		i++;
        	}
        	// System.out.println("End of month: "+j);
        	// break; //DEBUG
        }

        int totalRev = 0;
        //vv loop to incr. & decr. number of TV & non-TV rooms
        for(int numTVs = 0; numTVs <= numRooms; numTVs++) {
        	//vv loop to go through each day of that^ n-TV & m-noTV year 
        	for(i = 0; i < 365; i++) {  //i = day
        		// //vv assign each person of that^ day
        		//REDO THIS BLOCK! 
        		//USE FOR() LOOPS, TAKE INTO ACCOUNT LIMITED ROOMS & PATIENTS
        		int patients = visits[i];  //how many patients that day
        		int roomsAvailable = numRooms;
        		int nonTVAvailable = roomsAvailable - numTVs;
        		int tvAvailable = roomsAvailable - nonTVAvailable;
        		while(nonTVAvailable > 0 && patients > 0) {
        			nonTVAvailable--; 
        			patients--;
        			totalRev += notvPrice;
        		}
        		while(tvAvailable > 0 && patients > 0) {
        			tvAvailable--; 
        			patients--;
        			totalRev += tvPrice;
        		}

        		//INCORRECT CODE
        		// //vv assign each person of that^ day
        		// int patients = visits[i];  //how many people that day
        		// int numNoTV = numRooms - numTVs; //number of no-TV rooms
        		
        		// //fill noTV rooms first, calculate $
        		// int inNoTV = patients - numNoTV; //num. of patients assigned to no-TV rooms
        		// patients -= inNoTV; //patients left over
        		// totalRev += inNoTV*notvPrice;
        		
        		// //now fill TV rooms (M: if needed), calculate $
        		// if(patients != 0){
	        	// 	int inTV = patients - numTVs; //M: = instead of -
    	    	// 	patients -= inTV; //patients left over
        		// 	totalRev += inTV*tvPrice;
        		// }
        	}
        	//now check how much $ was made
        	if(totalRev >= revTarget) {
        		//if target was met, then print revenue
        		System.out.println(totalRev);
        		System.out.println(numTVs); //DEBUG
        		return;
        	}
        	//reset revenue counter
        	totalRev = 0;
        } //Sublime Text automatically put this after an indented comment! Wow!
        //if target could not be reached, print # of rooms
        System.out.println(numRooms);
    }
}


/*
18 = 2*2 + abs(-14)
17
16
15
14
13
12
11
10
9
8
7
6
5
4 = 2*2 + abs(0)
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20 = 2*2 + 16
End of month: 8
*/
















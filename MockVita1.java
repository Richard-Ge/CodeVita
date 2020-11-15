/*
 * You are given a string P that denotes the new order of letters in the English dictionary. 
 * You need to print the smallest lexicographic string made from the given string S.
 * ex:
>>Input

0: 2

1: polikujmnhytgbvfredcxswqaz

2: abcd

3: qwryupcsfoghjkldezxvbintma

4: ativedoc

>>Output

bdca

codevita

To run in Terminal: 
javac MockVita.java
java MockVita 1 polikujmnhytgbvfredcxswqaz abcd
 * */
public class MockVita {
    public static void main(String[] args) {
    // 	String[] myArgs = args[0].split(" ");  // change to \n
        String[] myArgs = args;
		int numTestCases = Integer.parseInt(myArgs[0]); 
// 		System.out.println("Test Cases: "+numTestCases);
		String[] alphabets = new String[numTestCases];
		String[] words = new String[numTestCases];
		//get alphabets and words, stored in order
		for(int i = 0; i < numTestCases; i++) {
		  //  System.out.println("i: "+i);
		  //  System.out.println("length of myArgs: "+myArgs.length);
		  //  System.out.println(myArgs[(2*i)+1]);
			alphabets[i] = myArgs[2*i+1];
		}
		for(int i = 0; i < numTestCases; i++) {
			words[i] = myArgs[2*i+2];
// 			System.out.println(myArgs[2*i+2]);
		}
		//create words with the new alphabets
// 		System.out.print((int)'a');  // = 97
        String[] results = new String[words.length];
		for(int i = 0; i < numTestCases; i++) {
		    char[] alphaArr = alphabets[i].toCharArray();
		    char[] wordArr = words[i].toCharArray();
		    for(int j = 0; j < alphaArr.length; j++) {
		        for(int k = 0; k < wordArr.length; k++) {
		            if(wordArr[k] == alphaArr[j]) {
		                results[i] += alphaArr[j];
		            }
		        }
		    }
		  //  System.out.println(results[i]);
	       // //for each word-alphabet pair
	       // //create an array of the word's letters
	       // int[] letters = new int[words[i].length()];
	       // for(int j = 0; j < words[i].length(); j++) {
	       //     //for each word, store its letters
	       //     char[] curWord = words[i].toCharArray();
	       //     letters[j] = (int)(curWord[j]);
	       // }
	       // //now letters[] has the letters of each word
	       // //we need to search the alphabet in order, and 
	       // //find which letters come up first  //WRONG!!!
	       // for(int k = 0; k < 26; k++) {
	       //     //for each letter of the new alphabet
	       //     for(int h = 0; h < letters.length; h++) {
	       //         //search each letter of our word
	       //         if(letters[h] == )
	       //     }
	       // }
		}
		//print out results
		for(int i = 0; i < numTestCases; i++) {
		    System.out.println(results[i].substring(4, results[i].length()));
		}  //why does it print out null at the beginning?
	}
}







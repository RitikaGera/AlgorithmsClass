// Given a string, write a function that returns toggle case of a string using the bitwise operators in place.
/* Approach : 
In ASCII codes character ‘A’ is integer 65 = (0100 0001)2, while character ‘a’ is integer 97 = (0110 0001)2.
The difference between the ASCII values of ‘a’ and ‘A’ is 32.
So we can easily change the case of the letters either from Upper to lower or lower to upper by adding or subtracting the difference from the letters.
Input : "GeekSfOrgEEKs" that is change case of every character
Output : "gEEKsFoRGeekS"                  

Input : "StRinG"
Output : "sTrINg"
*/

/** Pseudocode:
 * Public class Decrypter {
 *  String userMessage;
 *  Public String decrypt(String cypherText){
 *     For (I = 0; I < 2; i++){ <Reverse the string first>
 *          char Temp = userMessage[i] 
 *          userMessage[i] = userMessage[i+2] 
 *          userMessage[i+2] = Temp 
 *      For (i =  0; i < 4; i++) {
 *          (Convert to int(cypherText[i]) - 7) mod 10
 *          Cast to string, store into userMessage[i]
 *     return userMessage;
 *  }
 * }
 */
package app;

public class Decrypter {
    private int userText[] = {-9,-9,-9,-9};
    
    public int[] decrypt(String cypherText){
        int i, userInt, temp;
        if (cypherText.length() != 4){
            return userText;
        }
        // Check if each character is a digit
        for (i = 0; i < 4; i++){
            if (Character.isDigit(cypherText.charAt(i)) == false){
                return userText;
            }
        }
        // Parse the string to convert it to integers
        userInt = Integer.parseInt(cypherText);

        for (i = 4; i >= 1; i--){  
            userText[i-1] = userInt % 10; //Use mod to access the last digit of number;
            userInt /= 10;                 // Use division to move up a digit to get that digit mod 10

        }

        for (i = 0; i < 2; i++){   
            temp = userText[i];
            userText[i] = userText[i+2];
            userText[i+2] = temp;
        }

        for (i = 0; i < 4; i++){
            userText[i] = (userText[i] + 3) % 10; // + 3 because we want positive mod (-7 + 10);
        }
        return userText;
    }
}
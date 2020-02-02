/** Psudocode: Tips: Use stringName.charAt(int k) instead of stringName[int k]
 *             Tip2: Use stringName.lenght() instead of strlen(stringName), if necc;
 * Public class Encrypter {
 *  String cyphertext;
 *  Public String encrypt(String userString){
 *      For (I = 0; I < 4 ; i++){
 *      (Convert to int(userString[i])) + 7 mod 10
 *      Cast to string, store into cypherText[i]
}
 * Ex. 8901
 *      For (I = 0; i < 2; i++){
 *      char Temp = cypherText[i] = 8 = 9
 *      cypherText[i] = cypherText[i+2] => 0901 => 0101
 *      cypherText[i+2] = Temp => 0981 => 0109
 *  return cyphertext;
 *  }
 * }
*/
package app;

public class Encrypter {
    private int cypherText[] = {-9,-9,-9,-9};
    
    public int[] encrypt(String userString){
        int i, cypherInt, temp;
        if (userString.length() != 4){
            return cypherText;
        }
        // Check if each character is a digit
        for (i = 0; i < 4; i++){
            if (Character.isDigit(userString.charAt(i)) == false){
                return cypherText;
            }
        }
        // Parse the string to convert it to integers
        cypherInt = Integer.parseInt(userString);
        for (i = 4; i >= 1; i--){  
            cypherText[i-1] = cypherInt % 10; //Use mod to access the last digit of number;
            cypherInt /= 10;                 // Use division to move up a digit to get that digit mod 10
        }
        for (i = 0; i < 4; i++){
            cypherText[i] = (cypherText[i] + 7) % 10;
        }
        for (i = 0; i < 2; i++){
            temp = cypherText[i];
            cypherText[i] = cypherText[i+2];
            cypherText[i+2] = temp;
        }
        return cypherText;
    }
}
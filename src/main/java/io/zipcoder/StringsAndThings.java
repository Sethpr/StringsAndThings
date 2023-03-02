package io.zipcoder;


import java.util.regex.Pattern;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        String[] arr = input.split(" ");
        int count = 0;
        for(String s: arr){
            if(s.toLowerCase().charAt(s.length()-1) == 'y' || s.toLowerCase().charAt(s.length()-1) == 'z')
                count++;
        }
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        return base.replace(remove , "");
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        Pattern regNot = Pattern.compile("not");
        Pattern regIs = Pattern.compile("is");

        return regNot.matcher(input).results().count() == regIs.matcher(input).results().count();
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        //if(!input.contains("g"))
        //    return true;
        String[] arr = input.split("");
        //System.out.println(arr.length);
        if(arr.length == 1) {
            //System.out.println("false on arr.length");
            return false;
        }
        if(arr[arr.length-1].compareTo("g")== 0 && arr[arr.length-1].compareTo("g") != 0){
            //System.out.println("false on last");
            return false;
        }
        if(arr[0].compareTo("g")== 0 && arr[0].compareTo("g") != 0){
            //System.out.println("false on first");
            return false;
        }
        for(int i = 1; i < input.length()-1; i++){
            if(arr[i].compareTo("g") == 0 && (arr[i+1].compareTo("g") != 0 && arr[i-1].compareTo("g") != 0)) {
                //System.out.println("false on loop " + i);
                return false;
            }
        }


        return true;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int count = 0;
        String[] arr = input.split("");
        for(int i = 0; i < arr.length - 3; i++){
            if(arr[i].compareTo(arr[i+1])==0 && arr[i].compareTo(arr[i+2])==0)
                count++;
        }
        return count;
    }
}

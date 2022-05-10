import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
import javax.swing.JFileChooser;

/**
 * @author anonymous
 * @version 1.0
 * SpellChecker class reads two files as a dictionary and user input to check.
 * 5 methods are used to suggest candidate words in case the user input words are not in dictionary
 */

public class SpellChecker {
	
	public static void main (String[] args) throws FileNotFoundException {
		HashSet<String> dictSet = new HashSet<String>();
		
		//scan words from dictionary
	    Scanner dict = new Scanner(new File("C:\\Users\\01043028\\private\\UoP\\CS1103\\Week5\\words.txt")); //change file path to your environment
	    dict.useDelimiter("[^a-zA-Z]+");
	    while (dict.hasNext()) {
	        String tk = dict.next(); // a token is simply a word
	        if (dictSet.contains(tk)){ // check whether the word is duplicated or not
	        	continue;
	        } else {
	        dictSet.add(tk.toLowerCase()); // change each word to lower case and add them to hash set
	        }
	    }
	    if (dictSet.size() != 72875) { // check the number of the word in the list
	    	System.out.println("The number of words in the list is not appropriate. Check the file.");
			System.exit(0);
	    	}
	    //scan words from the file selected by user
	    Scanner filein = new Scanner(getInputFileNameFromUser());
	    filein.useDelimiter("[^a-zA-Z]+");
	    while (filein.hasNext()) {
	        String tk = filein.next().toLowerCase(); // a token is simply a word
	        if (dictSet.contains(tk)) {
	        	continue; //if the word is in dictionary, it means there is no spelling mistake
	        }else {
			    //check spelling of the word given and show suggestions based on the input
	        	String suggestion;
	        	if (corrections(tk, dictSet).isEmpty()){
	        		suggestion = "(no suggetions)";
	        		System.out.println(tk + ": " + suggestion);
	        	}else {
	        		suggestion = corrections(tk, dictSet).toString();
	        		System.out.println(tk + ": " + suggestion);
	        	}
	        }
	    }
	}
 
	/**
     * Lets the user select an input file using a standard file
     * selection dialog box.  If the user cancels the dialog
     * without selecting a file, the return value is null.
     */
    static File getInputFileNameFromUser() {
       JFileChooser fileDialog = new JFileChooser();
       fileDialog.setDialogTitle("Select File for Input");
       int option = fileDialog.showOpenDialog(null);
       if (option != JFileChooser.APPROVE_OPTION)
          return null;
       else
          return fileDialog.getSelectedFile();
    }
    
    //corrections methods that implement 5 methods to check the suggestions for non-existing words from dictionary
    static TreeSet<String> corrections(String badWord, HashSet<String> dictionary) {
		TreeSet<String> suggestionSet = new TreeSet<String>();
		for (String suggest : deleteOneLetter(badWord, dictionary)) {
			suggestionSet.add(suggest);
		}
		for (String suggest : changeLetters(badWord, dictionary)) {
			suggestionSet.add(suggest);
		}
		for (String suggest : insertLetters(badWord, dictionary)) {
			suggestionSet.add(suggest);
		}
		for (String suggest : swapNeighbors(badWord, dictionary)) {
			suggestionSet.add(suggest);
		}
		for (String suggest : insertSpace(badWord, dictionary)) {
			suggestionSet.add(suggest);
		}
    	return suggestionSet;
    }
    
    //5 methods to check the patterns of misspelled words
    static TreeSet<String> deleteOneLetter(String badWord, HashSet<String> dictionary) {
		TreeSet<String> tempSet = new TreeSet<String>();
    	String modifiedString;
    	for (int i = 0; i < badWord.length(); i++) {
    		 modifiedString = badWord.substring(0,i) + badWord.substring(i+1); //get string with a deletion of all letters
    		 if (dictionary.contains(modifiedString)){ //check whether dictionary holds the modified string or not
    			 tempSet.add(modifiedString);
    		 }
    	 }
    	return tempSet;
    }
    static TreeSet<String> changeLetters(String badWord, HashSet<String> dictionary) {
		TreeSet<String> tempSet = new TreeSet<String>();
    	String modifiedString;
    	for (int i = 0; i < badWord.length(); i++) {
    		for (char ch = 'a'; ch <= 'z'; ch++) {
	    		modifiedString = badWord.substring(0,i) + ch + badWord.substring(i+1); //place wild card with each position
	    		//System.out.println(modifiedString);
	    		if (dictionary.contains(modifiedString)){ //check whether dictionary holds the modified string or not
	    			tempSet.add(modifiedString);
	    		}
	    	}
    	}
    	return tempSet;
    }
  	
    static TreeSet<String> insertLetters(String badWord, HashSet<String> dictionary) {
		TreeSet<String> tempSet = new TreeSet<String>();
    	String modifiedString;
    	for (int i = 0; i <= badWord.length(); i++) {
    		for (char ch = 'a'; ch <= 'z'; ch++) {
    			modifiedString = badWord.substring(0,i) + ch + badWord.substring(i); //place a to z with each position
    			if (dictionary.contains(modifiedString)){ //check whether dictionary holds the modified string or not
    				tempSet.add(modifiedString);
    			}
    		}
    	}
    	return tempSet;
    }

  	static TreeSet<String> swapNeighbors(String badWord, HashSet<String> dictionary) {
        ArrayList<String> tempArrayForBadWord = new ArrayList<String>(Arrays.asList(badWord.split(""))); //Need an ArrayList to swap neighboring characters
        TreeSet<String> tempSet = new TreeSet<String>();
    	String modifiedString;
    	for (int i = 0; i < badWord.length()-1; i++) {
            Collections.swap(tempArrayForBadWord, i, i+1);
            modifiedString = String.join("", tempArrayForBadWord);
			if (dictionary.contains(modifiedString)){ //check whether dictionary holds the modified string or not
    			tempSet.add(modifiedString);
    		}
    	}
    	return tempSet;
  	}
  		
   	static TreeSet<String> insertSpace(String badWord, HashSet<String> dictionary) {
		TreeSet<String> tempSet = new TreeSet<String>();
    	String modifiedString;
    	for (int i = 0; i < badWord.length(); i++) {
    		modifiedString = badWord.substring(0,i) + " " + badWord.substring(i); //place blank space with each position
    		if (dictionary.contains(modifiedString.substring(0,i)) && dictionary.contains(modifiedString.substring(i+1))){ //check whether dictionary holds the both of split strings or not
    			tempSet.add(modifiedString);
    		}    		
    	}
    	return tempSet;
   	}    
}

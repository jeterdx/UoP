import java.util.ArrayList;
import java.util.Random;
/**
 * @author anonymous
 * @version 1.0
 *
 */
public class SimpleRandomSentences {
	/**
	 * Class SimpleRandomSentences generates one sentence composed of random words 
	 * from constant array lists of strings following a grammar rule of English.
	 */
	final static Random random = new Random();
	//Prepare the lists of words for each part of speech
	static ArrayList<String> conjunction = new ArrayList<String>(){
		{
			add("and");	
			add("or");
			add("but");
			add("because");
		}
	};	
	static ArrayList<String> proper_noun = new ArrayList<String>(){
		{
			add("Fred");	
			add("Jane");
			add("Richard Nixon");
			add("Miss America");
		}
	};
	static ArrayList<String> common_noun = new ArrayList<String>(){
		{
			add("man");	
			add("woman");
			add("fish");
			add("elephant");
			add("unicorn");
		}
	};
	static ArrayList<String> determiner = new ArrayList<String>(){
		{
			add("a");	
			add("the");
			add("every");
			add("some");
		}
	};
	static ArrayList<String> adjective = new ArrayList<String>(){
		{
			add("big");	
			add("tiny");
			add("pretty");
			add("bold");
		}
	};
	static ArrayList<String> intransitive_verb = new ArrayList<String>(){
		{
			add("runs");	
			add("jumps");
			add("talks");
			add("sleeps");
		}
	};
	static ArrayList<String> transitive_verb = new ArrayList<String>(){
		{
			add("loves");	
			add("hates");
			add("sees");
			add("knows");
			add("looks for");
			add("finds");
		}
	};
	//Main method calls sentence method and it calls another method which calls another one recursively.
	public static void main (String[] args) {
		System.out.println(sentence());
	}
	public static String sentence() {
		return simple_sentence().substring(1)+".";
	}
	public static String simple_sentence() {
		return noun_phrase() + " " +verb_phrase();
	}
	public static String noun_phrase() {
		if (random.nextBoolean()) {
			//Get a each word from each list depending on the result of random method.
			return " " + proper_noun.get(random.nextInt(proper_noun.size()-1));
		}else {
			String adjectives = "";
			while (random.nextBoolean()) {
				adjectives += " " + adjective.get(random.nextInt(adjective.size()-1)); 
			}
			if (random.nextBoolean()) {
				return " " + determiner.get(random.nextInt(determiner.size()-1)) + adjectives + " " + common_noun.get(random.nextInt(common_noun.size()-1));
			}else {
				return " " + determiner.get(random.nextInt(determiner.size()-1)) + adjectives + " " + common_noun.get(random.nextInt(common_noun.size()-1))+ " who " + verb_phrase();
			}			
		}
	}
	public static String verb_phrase() {
		if (random.nextInt(4)==0) {
			return intransitive_verb.get(random.nextInt(intransitive_verb.size()-1));
		}else if (random.nextInt(4)==1){
			return transitive_verb.get(random.nextInt(transitive_verb.size()-1)) + noun_phrase();			
		}else if (random.nextInt(4)==2){
			return "is " + adjective.get(random.nextInt(adjective.size()-1));
		}else{
			return "believes that" + simple_sentence();
		}
	}
}

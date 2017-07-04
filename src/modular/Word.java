package modular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {
	String word;
	int length;
	int vowelLength;
	int consonantsLength;
	static int place;
	String symbol;
	public Word(String str) {
		 word = str;
		word=str.trim();
		length=new StringBuffer(word).reverse().toString().replaceFirst("[-+.^:,;]","").length();
		vowelLength=getvowelLength();
		consonantsLength=getconsonantsLength();
	    //checkSymbol=word.substring(word.length()-1);
		if(length<word.length())
	    symbol = word.substring(word.length()-1);
	    //System.out.println(symbol);
     }
	private int getconsonantsLength() {
		
		return length-vowelLength;
	}
	private int getvowelLength() {
		int vowels=0;
		for(int i=0;i<word.length();i++)
		{
			char ch=word.charAt(i);
			if(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' ||   
				      ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U')
				          vowels ++;
		}
		
		return vowels;
	}
	public void display() {
	System.out.println(word.replaceAll("[-+.^:,;]","")+"\t\t\t\t\t\t\t\t\t\t"+length+"\t\t\t\t\t\t"+vowelLength+"\t\t\t\t\t\t"+consonantsLength);
	}
	public String getWord() {
		return word.replaceAll("[-+.^:,;]","");
	}
	public String getActualWord() {
		return word;
	}
	public String getSymbol() {
		//System.out.println(symbol);
		return symbol;
	}
	public void find(String findWord) {
		 Pattern pattern = Pattern.compile(findWord.toLowerCase());
		    Matcher match = pattern.matcher(word.toLowerCase());

		    while (match.find()) {
		         System.out.println("Start Index :"+ match.start() +"  End Index :"+ (match.end()-1));
		    }
	}
	
}

package modular;

import java.util.ArrayList;
import java.util.Iterator;

public class Sentence {
	 int wordCount;
	 ArrayList<Word> list;
	public Sentence(String str) {
		list=new ArrayList<Word>();
		String[] word = str.split(" ");
	      for(String s:word){
				list.add(new Word(s));
			}
	      wordCount=list.size();
	}
public int getWordCount()
{
	return wordCount;
}
public void metaData(){
	System.out.println("Word count:"+wordCount);
}
public void display() {
	System.out.println("Word Count:"+wordCount);
	System.out.println("WORD\t\t\t\t\t\t\t\t\tLENGTH\t\t\t\t\t\tVOWEL\t\t\t\t\t\tCONSONANTS");
	Iterator<Word> iterator = list.iterator();
	while(iterator.hasNext()){
		Word nextWord = iterator.next();
		nextWord.display();
	}
	
}

public String print(int j) {
	Word word=list.get(j);
	return word.getWord();
}
public void insert(int j,String word) {
	list.add(j,new Word(word));
	wordCount=list.size();
}
public String printSentence() {
	Iterator<Word> iterator = list.iterator();
	StringBuilder sentence=new StringBuilder();
	while(iterator.hasNext()){
		Word nextWord = iterator.next();
		sentence.append(nextWord.getActualWord());
		sentence.append(" ");
	}
	return sentence.toString().trim();
}
public void delete(int i) {
	 
     list.remove(i);
     wordCount=list.size();
}
private void appendSymbol(int i, String appendWord) {
	 Word wordObj=list.get(i);
	 String word=wordObj.getActualWord();
	 //System.out.println(wordObj.getActualWord());
	 replace(i,word+appendWord);
	}
void replace(int i, String word) {
    list.remove(i);
	insert(i,word);
}
public void find(String words) {
	String word[]=words.split(" ");
	StringBuilder findString=new StringBuilder();
	for(int i=0;i<(list.size()-word.length+1);i++)
	{
		findString.setLength(0);
		for(int j=i;j<(word.length+i);j++)
			findString.append(list.get(j).getActualWord().toLowerCase()+" ");
		if(findString.toString().trim().contains(words)){
		    for(int k=i,c=0;k<(word.length+i);k++,c++){
		    	System.out.println("Word:"+(k+1));
		    	list.get(k).find(word[c]);
		    }
		}
	}
		}
	
}


package modular;

import java.util.ArrayList;
import java.util.Iterator;

public class Paragraphs {
       ArrayList<Sentence> list;
	   int sentenceCount;
	   int newLineCount;
	   int tabSpaceCount=0;
	   int totwordCount;
	     int blankCount;
	public Paragraphs(String str, int count){
		newLineCount=count;
		for(int i=0;i<str.length();i++)
		   {
			if((str.charAt(i))=='\t')
				tabSpaceCount++;
			else if((str.charAt(i))==' ')
				blankCount++;
			   else 
			{if((((int)(str.charAt(i))>64)&&((int)(str.charAt(i))<91))||(((int)(str.charAt(i))>96)&&((int)(str.charAt(i))<123)))
				break;
		    }
			}
		list = new ArrayList<Sentence>();
		String[] sentences = str.split("[.|!|?]");
		for(String s:sentences){
			s=s.replaceFirst("^\\s*", "");
			if(s.length()>1)
			list.add(new Sentence(s));
		}
		sentenceCount=list.size();
	}
	
	public void metaData(){
		sentenceCount=1;
		totwordCount=0;
		Iterator<Sentence> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println("Sentence:"+sentenceCount);
			Sentence nextSentence = iterator.next();
			nextSentence.metaData();
			totwordCount += nextSentence.getWordCount();
			sentenceCount++;
		}
		System.out.println("Total Word count in para:"+totwordCount+"\nSentenceCount:"+(sentenceCount-1));
	}

	public void display() {
		Iterator<Sentence> iterator = list.iterator();
		while(iterator.hasNext()){
			Sentence next = iterator.next();
			next.display();
		}
	}

	public String print(int i, int j) {
		Sentence sentence=list.get(i);
		return sentence.print(j);
	}

	public void insert(int i, int j,String word) {
		Sentence sentence=list.get(i);
		sentence.insert(j,word);
	}

	public String printSentence(int i) {
		Sentence sentence=list.get(i);
		return sentence.printSentence();
	}

	public String printParagraph() {
		Iterator<Sentence> iterator = list.iterator();
		StringBuilder paragraph=new StringBuilder();
		while(iterator.hasNext()){
			Sentence nextSentence = iterator.next();
			paragraph.append(nextSentence.printSentence());
			paragraph.append(". ");
		}
		
		return paragraph.toString();
	}

	public void deleteWord(int i, int j) {
		Sentence sentence=list.get(i);
		sentence.delete(j);
				}

	public void replace(int i, int j, String word) {
		Sentence sentence=list.get(j);
		sentence.replace(i,word);
	
	}
	public int getTotWordCount() {
		return totwordCount;
	}

	public String getTabSpaceCount() {
		StringBuilder tabSpace=new StringBuilder();
		for(int i=0;i<tabSpaceCount;i++)
		 tabSpace.append("\t");
		for(int i=0;i<blankCount;i++)
			 tabSpace.append(" ");
		return tabSpace.toString();
	}

	public String getNewLine() {
		StringBuilder newLine=new StringBuilder();
		for(int i=0;i<newLineCount+1;i++)
		 newLine.append("\n");
		return newLine.toString();
		}

	public void find(String words) {
		Iterator<Sentence> iterator = list.iterator();
		while(iterator.hasNext()){
			Sentence nextSentence = iterator.next();
			if(nextSentence.printSentence().toLowerCase().contains(words))
			{
				System.out.println("Sentence:"+(list.indexOf(nextSentence)+1));
				nextSentence.find(words);
			}
		}
}
}

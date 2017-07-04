package modular;

import java.util.ArrayList;
import java.util.Iterator;

public class TotalFile {
	ArrayList<Paragraphs> list;
	   int paragraphCount;
	public TotalFile(String str){
		list = new ArrayList<Paragraphs>();
		int count=0;
		String[] paragraphs = str.split("\n");
		for(String s:paragraphs)
		{    s.trim();
			if(s.matches(".*[a-zA-Z]+.*"))
		    {
			list.add(new Paragraphs(s,count));
			count=0;
		    }
		    else
		    	count++;
		}
		paragraphCount=list.size();
	}
	public void metaData() {
		int totwordCount=0,paraCount=1;
		Iterator<Paragraphs> iterator = list.iterator();
		while(iterator.hasNext()){
			Paragraphs nextParagraph = iterator.next();
			System.out.println("PARAGRAPH:"+paraCount);
			paraCount++;
			nextParagraph.metaData();
			totwordCount += nextParagraph.getTotWordCount();
		}
		System.out.println("Total Word Count in File:"+totwordCount+"\nParagraph Count:"+paragraphCount);
		
	}
	public void display() {
		int count=1;
		Iterator<Paragraphs> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println("PARAGRAPH:"+count);
			Paragraphs next = iterator.next();
			next.display();
			count++;
		}
	}
	public String print(int i, int j, int k) {
		Paragraphs paragraph=list.get(i-1);
		return paragraph.print(j-1, k-1);
	}
	public String printSentence(int i, int j) {
		Paragraphs paragraph=list.get(i-1);
		return paragraph.printSentence(j-1);
	}
	public String printParagraph(int i) {
		Paragraphs paragraph=list.get(i-1);
		return paragraph.printParagraph();
	}
	public String printFile() 
	   {
		Iterator<Paragraphs> iterator = list.iterator();
		StringBuilder file=new StringBuilder();
		while(iterator.hasNext()){
			Paragraphs nextParagraph = iterator.next();
			file.append(nextParagraph.getNewLine());
			file.append(nextParagraph.getTabSpaceCount());
			file.append(nextParagraph.printParagraph());
		}
		
		return file.toString();

	}
	public void insert(int i, int j, int k, String word) {
		Paragraphs paragraph=list.get(i-1);
		paragraph.insert(j-1,k-1,word);
        }
	public void deleteWord(int i, int j, int k) {
		Paragraphs paragraph=list.get(i-1);
		paragraph.deleteWord(j-1,k-1);
	}
	public void replace(int i, int j, int k, String word) {
		Paragraphs paragraph=list.get(i-1);
		paragraph.replace(j-1,k-1,word);
	
	}
	public void find(String words) {
		Iterator<Paragraphs> iterator = list.iterator();
		while(iterator.hasNext()){
			Paragraphs paragraph = iterator.next();
			if(paragraph.printParagraph().toLowerCase().contains(words))
			{
				 System.out.println("Paragraph:"+(list.indexOf(paragraph)+1));	
			     paragraph.find(words);
		    }
		}
	}
	public String wordWrap() {
		Iterator<Paragraphs> iterator = list.iterator();
		StringBuilder file=new StringBuilder();
		int count=0;
		while(iterator.hasNext()){
			Paragraphs nextParagraph = iterator.next();
			file.append(nextParagraph.getNewLine());
			file.append(nextParagraph.getTabSpaceCount());
			String str=nextParagraph.printParagraph();
			String split[]=str.split(" ");
			count=(nextParagraph.tabSpaceCount*8)+nextParagraph.blankCount; // '*8' since tab space=8 blank space
			 for(int i=0;i<split.length;i++)
			    { 
			    	if((count+split[i].length()+1)<=130){
			    		count+=split[i].length()+1;   //'+1' to include blank space count in between words
			    		file.append(split[i]+" ");
			    	}
			    	else
			    	{  
			    		count=0;
			    		count=count+split[i].length()+1;
			    		file.append("\n"+split[i]+" ");
			    	}
		}
		
	}
		return file.toString();
	}
}

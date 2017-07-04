package modular;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Editor {
	public static void main(String args[]) throws IOException
	{   
		Editor object=new Editor();
		String file = object.getFile();
		System.out.println(file);
		TotalFile obj=new TotalFile(file);
		obj.metaData();
    	int choice;
    	do
		{
		System.out.println("Enter the operation to be perfomed\n1.Insert\n2.Find\n3.Delete\n4.Replace\n5.PrintWord\n6.PrintParagraph\n7.PrintSentence\n8.Save\n9.PrintFile\n10.WordWrap\n11.MetaData");
		Scanner in=new Scanner(System.in);
		int paragraph;
  	    int sentence;
        int position;
        String word;
	    int options=in.nextInt();
	    switch(options)
	      {
	       case 1:
	    	   System.out.println("Enter the paragraph, sentence, position and word to be inserted");
	    	   paragraph=in.nextInt();
	    	   sentence=in.nextInt();
	           position=in.nextInt();
	           word=in.nextLine();
	           obj.insert(paragraph,sentence,position,word);
	           obj.metaData();
	           break;
	       case 2:
		    	  System.out.println("Enter the word to be searched:");
		       	  in.nextLine();
		    	  word=in.nextLine();
		    	  obj.find(word);
		    	  break;
	      case 3: 
	    	  System.out.println("Enter the paragraph, sentence and position of word to be deleted");
	    	  paragraph=in.nextInt();
	    	  sentence=in.nextInt();
	          position=in.nextInt();
	          obj.deleteWord(paragraph,sentence,position);
	          break;
	      case 4:
	    	  System.out.println("Enter the paragraph, sentence, position and new word to be replaced");
	    	  paragraph=in.nextInt();
	    	  sentence=in.nextInt();
	          position=in.nextInt();
	          word=in.nextLine();
	          obj.replace(paragraph,sentence,position,word);
	          break;
	      case 5:
	    	  System.out.println("Enter the paragraph,sentence and position of word to be displayed:");
	    	  paragraph=in.nextInt();
	    	  sentence=in.nextInt();
	          position=in.nextInt();
	          System.out.println(obj.print(paragraph,sentence,position));
	          break;
	      case 6:
	    	  System.out.println("Enter the paragraph number to display:");
	    	  paragraph=in.nextInt();
	    	  System.out.println(obj.printParagraph(paragraph));
	    	  break;
	      case 7:
	    	  System.out.println("Enter the paragraph and sentence number to display:");
	    	  paragraph=in.nextInt();
	    	  sentence=in.nextInt();
	    	  System.out.println(obj.printSentence(paragraph,sentence));
	    	  break;
	      case 8:
	    	  try (PrintStream out = new PrintStream(new FileOutputStream("sample.txt"))){
	    		   new FileWriter("sample.txt").close();
	    	   out.print(obj.printFile().replaceAll("\\s+$", "").replaceFirst("\n", ""));
	    	   }
	    	   break;
	      case 9:
	    	  System.out.println(obj.printFile());
	    	  break;
	      case 10:
	    	  System.out.println(obj.wordWrap());
	    	  break;
	      case 11:
	    	  obj.metaData();
	    	  break;
	      }
	    System.out.println("Enter 12 to continue");
	    choice=in.nextInt();
		}while(choice==12);

	}

	private String getFile() {
		StringBuilder sb=new StringBuilder();
	    BufferedReader buf;
	    try
	    {
	    	InputStream is=new FileInputStream("sample.txt");
	    	buf=new BufferedReader(new InputStreamReader(is));
	    	String line=buf.readLine();
	    	while(line !=null)
	    	{
	    		sb.append(line).append("\n");
	    		line=buf.readLine();
	    	}
	    }
	catch(Exception e)
	    {
		System.out.println("File not found");
	    }
		return sb.toString();
	}

}

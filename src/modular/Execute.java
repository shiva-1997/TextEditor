package modular;

public class Execute {
	
	public static void main(String args[])
	{  
		String para="He didn’t say any more, but we’ve always been unusually \n\t\tcommunicative in a reserved way, and I understood that he meant a great deal more than that. In consequence, I’m inclined to reserve all judgments, a habit that has opened up many curious natures to me and also made me the victim of not a few veteran bores. The abnormal mind is quick to detect and attach itself to this quality when it appears in a normal person, and so it came about that in college I was unjustly accused of being a politician, because I was privy to the secret griefs of wild, unknown men. Most of the confidences were unsought — frequently I have feigned sleep, preoccupation, or a hostile levity when I realized by some unmistakable sign that an intimate revelation was quivering on the horizon; for the intimate revelations of young men, or at least the terms in which they express them, are usually plagiaristic and marred by obvious suppressions. Reserving judgments is a matter of infinite hope. I am still a little afraid of missing something if I forget that, as my father snobbishly suggested, and I snobbishly repeat, a sense of the fundamental decencies is parcelled out unequally at birth.";
		TotalFile obj=new TotalFile(para);
		obj.metaData();
		//obj.display();
		//System.out.println(obj.print(1,1,4));
		//System.out.println(obj.printSentence(1,1));
		//System.out.println(obj.printParagraph(2));
		//System.out.println(para+"\n\n\n");
		System.out.println(obj.printFile());
		//obj.insert(1,1,1,"siva");
		//System.out.println(obj.print(1,1,1));
		//System.out.println(obj.printParagraph(1));
		//obj.deleteWord(1,1,4);
		//obj.replace(1,1,1,"siva");
		//obj.metaData();
		  //obj.find("more, but");
		//System.out.println(obj.printParagraph(1));
		System.out.println(obj.wordWrap());
	}
    }



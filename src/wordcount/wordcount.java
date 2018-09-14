package wordcount;
import java.io.*;
import java.io.File;


public class wordcount {
	
		public static int wordscount = 1;

		public static int charscount = 0;

		public static int linescount = 1;

		public static int whitetline = 0;
		
		public static int commentline =0;
		
		public static void main(String args[])throws java.io.IOException {
			//TODO AUTO-generated method stub
			if( args[0].equals("-s"))
			{
			//要遍历的路径
			File file = new File("C:\\Users\\lsy\\Desktop\\测试");	//获取其file对象
			File[] a = file.listFiles();	//遍历path下的文件和目录，放在File数组中
			for(File f:a){		
				//遍历File[]数组
			if(!f.isDirectory())
				//若非目录(即文件)，则打印
			System.out.println(f);
		}
		}
			else {
				
			FileInputStream a;
			
			try {

			if (args.length == 0) {    // 检查是否读入

			a = new FileInputStream("C:\\Users\\lsy\\Desktop\\lsy.txt");

			wc(a);
		}
			else // 判断行
			{ 
			int i=1;
			do {
			a = new FileInputStream(args[i]);
			wc(a);
			i++;
			}while(i<args.length);

	     }
			}
			catch(IOException e)
			{
			return;
			} 
			if( args[0].equals("-c"))
			  {
				System.out.println("字符数"+charscount);
			}
			if( args[0].equals("-w"))
			   {
			System.out.println("单词数"+wordscount);
		}
			if( args[0].equals("-l"))
			   {
			System.out.println("总行数"+linescount);
		}
			if( args[0].equals("-a") ){
			System.out.println("注释行"+commentline);
			
		}
			
			}	
				
		} 

		public static void wc(InputStream f) throws java.io.IOException{
			int flag=0;
		int c = 0;

		boolean lastNotWhite = false;

		String whiteSpace = " \t\n\r";

		while ((c = f.read()) != -1) {

		charscount++;

		if (c == '\n') {

		linescount++;
		}
		if (c=='/'&& flag==0)  {
			flag=1;
		}
		
		if (c=='/'&& flag==1)  {
			flag=0;
		commentline++;	
		}
		
		

		if (whiteSpace.indexOf(c) != -1) {
			

		if (lastNotWhite) {

		wordscount++;

		}

		lastNotWhite = false;

		} else
		{

		lastNotWhite = true;

		}

		}
		
		}
	}



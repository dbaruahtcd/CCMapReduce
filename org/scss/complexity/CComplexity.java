package org.scss.complexity;

import java.io.File;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;


public class CComplexity {
	
	public static int getComplexity(String fileLoc) throws IOException
	{
		int defaultComplexity = 1;
		int complexity = 0;
		String[] keywords = {"if", "for", "do", "while", "switch", "case", "default", "continue", "break", "&&", "||", "?", "else", "return"};
		String words = "";
		String line = null;

		
		try{
			Path pt = new Path(fileLoc);
			FileSystem fs = FileSystem.get(new Configuration());
			BufferedReader br = new BufferedReader(new InputStreamReader(fs.open(pt)));
			
			line = br.readLine();
			
			while(line!= null)
			{
				StringTokenizer st = new StringTokenizer(line);
				while(st.hasMoreTokens())
				{
					words = st.nextToken();
					for(int i = 0; i < keywords.length; i++)
					{
						if(keywords[i].equals(words))
						{
							
							System.out.println(keywords[i]);
							complexity++;
						}
					}
				}
			 line = br.readLine();	
			}
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		/*finally
		{
			br.close();
		}*/
		return complexity > 0 ? complexity : defaultComplexity;
		
	}

}

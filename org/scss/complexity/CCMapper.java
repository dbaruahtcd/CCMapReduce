package org.scss.complexity;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
//import org.apache.hadoop.mapreduce.lib.input.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;


public class CCMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	private static IntWritable complexityCount = null;
	private Text result = new Text();
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		//File f = ;
		//org.apache.hadoop.fs.Path filePath = ((FileSplit)context.getInputSplit()).getPath();
		
		
		//Path filePath = ((FileSplit) context.getInputSplit()).getPath();
		//String filePathString = ((FileSplit) context.getInputSplit()).getPath().toString();
		
		//InputSplit inputSplit= (InputSplit)context.getInputSplit(); 
		
		/*Path filePath = ((FileSplit) inputSplit).getPath(); 
		String filePathString = ((FileSplit) context.getInputSplit()).getPath().toString();*/
		
		//correct
		Path filePath = ((FileSplit) context.getInputSplit()).getPath();
		String filePathString = ((FileSplit) context.getInputSplit()).getPath().toString();
		
		complexityCount = new IntWritable(CComplexity.getComplexity(filePathString));
		/*InputSplit inName = (InputSplit)context.getInputSplit();
		String name = inName.*/
		
		//String fileName = ((FileSplit) context.getInputSplit()).getPath().getName();
		
		result.set(filePathString);
		context.write(result, complexityCount);
		
		
		
	}
	

}


	
/*public class WordCountMapper extends
		Mapper<LongWritable, Text, Text, IntWritable> {

	private Text word = new Text();
	private final static IntWritable ONE = new IntWritable(1);

	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String[] str = value.toString().split(" ");

		for (String s : str) {
			word.set(s);
			context.write(word, ONE);

		}
	}
} */

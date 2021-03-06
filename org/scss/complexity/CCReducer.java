package org.scss.complexity;

import java.io.IOException;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;

public class CCReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	private IntWritable output = new IntWritable();
	
	public void reduce(Text key, Iterable<IntWritable> value, Context context ) throws IOException, InterruptedException
	{
		int count = 0;
		for(IntWritable i : value)
		{
			count = i.get();
		}
		output.set(count);
		context.write(key, output);
	}
	
}	


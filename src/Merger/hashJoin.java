package Merger;

import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;


import relation.record;

public class hashJoin {

	Map<String,String> bucket1LeftRel = new HashMap<String,String>();
	Map<String,String> bucket2LeftRel = new HashMap<String,String>();
	Map<String,String> bucket3LeftRel = new HashMap<String,String>();
	Map<String,String> bucket1RightRel = new HashMap<String,String>();
	Map<String,String> bucket2RightRel = new HashMap<String,String>();
	Map<String,String> bucket3RightRel = new HashMap<String,String>();
	Map<String,String> tempBucket1 = new HashMap<String,String>();
	Map<String,String> tempBucket2 = new HashMap<String,String>();
	
	Map<String, String> output = new HashMap<String, String>();
	
	int totalBlocks;
	int rowsInEachBlock = 4;
	

	public void hashFn1LeftRel(Map<String,String> relation) {
		tempBucket1.putAll(relation);
				
		for(Entry<String,String> leftMap : relation.entrySet()) {
			int hashValue = calculateHash1(leftMap.getKey().toString());
		
			
			if(hashValue == 0)
				bucket1LeftRel.put(leftMap.getKey(), leftMap.getValue());
			
			if(hashValue == 1)
				bucket2LeftRel.put(leftMap.getKey(), leftMap.getValue());
			
			if(hashValue == 2)
				bucket3LeftRel.put(leftMap.getKey(), leftMap.getValue());
          
			
		}
		totalBlocks = tempBucket1.size()/rowsInEachBlock ; 
		   
	    System.out.println("\nBringing" +totalBlocks +" blocks of relation 1 to memory");
	    System.out.println("Using First Hash Function to create partitions");		    
	    
	    	for(int i=0;i<totalBlocks;i++)
	    	{
	    		System.out.println("Partition of block" +i +" is completed");
	    		System.out.println("Output block is full, writing to disk");
	    	}
		
		System.out.println("\nBucket 1 ---"+bucket1LeftRel);
		System.out.println("Bucket 2 ---"+bucket2LeftRel);
		System.out.println("Bucket 3 ---"+bucket3LeftRel);
	}
		public void hashFn1RightRel(Map<String,String> relation2) {
			tempBucket2.putAll(relation2);
			
			for(Entry<String,String> leftMap : relation2.entrySet()) {
				int hashValue = calculateHash1(leftMap.getKey().toString());
			
				
				if(hashValue == 0)
					bucket1RightRel.put(leftMap.getKey(), leftMap.getValue());
				
				if(hashValue == 1)
					bucket2RightRel.put(leftMap.getKey(), leftMap.getValue());
				
				if(hashValue == 2)
					bucket3RightRel.put(leftMap.getKey(), leftMap.getValue());
	          
				
			}
			
			totalBlocks = tempBucket2.size()/rowsInEachBlock ; 
			   
		    System.out.println("\nBringing" +totalBlocks +" blocks of relation 2 to memory");
		    System.out.println("Using First Hash Function to create partitions");
		    		    
		    
		    	for(int i=0;i<totalBlocks;i++)
		    	{
		    		System.out.println("Partition of block" +i +" is completed");
		    		System.out.println("Output block is full, writing to disk");
		    	}
			
		System.out.println("\nBucket 1 ---"+bucket1RightRel);
		System.out.println("Bucket 2 ---"+bucket2RightRel);
		System.out.println("Bucket 3 ---"+bucket3RightRel);
	}
		public Map<String, String> hashFn2() {
			Map<String,String> bucket1 = new HashMap<String,String>();
			Map<String,String> bucket2 = new HashMap<String,String>();
			Map<String,String> bucket3 = new HashMap<String,String>();
			Map<String,String> bucket4 = new HashMap<String,String>();
			Map<String,String> bucket5 = new HashMap<String,String>();
			Map<String,String> hashBucket = new HashMap<String,String>();
			
			System.out.println("\nBringing 2 partitions of relation 1 to memory \nUsing second hash Function to partition");	    		    					
			for(Entry<String,String> temp : tempBucket1.entrySet()) {
				int hashValue2 = calculateHash2(temp.getKey().toString());
				
				if(hashValue2 == 0)
					bucket1.put(temp.getKey(), temp.getValue());
				
				if(hashValue2 == 1)
					bucket2.put(temp.getKey(), temp.getValue());
				
				if(hashValue2 == 2)
					bucket3.put(temp.getKey(), temp.getValue());
				
				if(hashValue2 == 3)
					bucket4.put(temp.getKey(), temp.getValue());
				
				if(hashValue2 == 4)
					bucket5.put(temp.getKey(), temp.getValue());
			}
			System.out.println("\nBucket 1 ---"+bucket1);
			System.out.println("Bucket 2 ---"+bucket2);
			System.out.println("Output block is full, writing this to disk");
			System.out.println("Bucket 3 ---"+bucket3);
			System.out.println("Bucket 4 ---"+bucket4);
			System.out.println("Output block is full, writing this to disk");
			System.out.println("Bucket 5 ---"+bucket5);
			for(Entry<String,String> temp : tempBucket2.entrySet()) {
				
				int hashValue2 = calculateHash2(temp.getKey().toString());
					
								    		    					
					String result = "";
					
					{
						for (Map.Entry<String,String> entry1 : tempBucket1.entrySet()) {
							String key1 = entry1.getKey();
							String value1 = entry1.getValue();
							
							 							 
							for (Map.Entry<String,String> entry2 : tempBucket2.entrySet()) {
							  
								String key2 = entry2.getKey();
								String value2 = entry2.getValue();
															  
								  if(key1.equals(key2))
								   result = new StringBuilder().append(value1).append("  ").append(value2).toString();
							  							
							}
							String string = result;
							String row[] = string.split(" ",2);
							String key = row[0];
							String value = row[1];
							output.put(key, value);
												
					}
												
											
					}
							
				
			}
			totalBlocks = output.size()/rowsInEachBlock ; 
			   
			
		
			return output;
			}
			
				
	private int calculateHash1(String key)
	{
	
		return Math.floorMod(Integer.valueOf(key).intValue(), 3);
				
	}
	
	private int calculateHash2(String key2)
	{
		
		return Math.floorMod(Integer.valueOf(key2).intValue(), 5);
				
	}

}
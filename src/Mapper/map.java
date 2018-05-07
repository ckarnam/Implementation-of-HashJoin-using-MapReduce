package Mapper;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;



public class map {
	int totalBlocks;
	int rowsInEachBlock = 4;
	
	public  Map<String,String> shuffleAndMap1(String relation1) throws IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader br1;
			 
		br1 = new BufferedReader(new InputStreamReader(new FileInputStream(relation1)));
		
		 
		 String line1;
		 line1 = br1.readLine();
		 
		 Map<String,String> dataRow1 = new HashMap<String,String>();
		 Map<String,String> emp_records = new HashMap<String,String>();
		 
		    
		    while ((line1 = br1.readLine()) != null) {
		    	
		       	        
				String colValue1 = String.valueOf(line1);
				String string = colValue1;
				String[] parts  = string.split(" ");
				
				dataRow1.put( parts[0], colValue1);
			

		    }
		    emp_records.putAll(dataRow1);
		    
		    totalBlocks = emp_records.size()/rowsInEachBlock ; 
		   
		    System.out.println("Bringing " +totalBlocks +" blocks of relation 1 to memory");
		    		    
		    
		    	for(int i=0;i<totalBlocks;i++)
		    	{
		    		System.out.println("Mapper 1 is full, writing to disk");
		    		System.out.println("Output block is full, writing to disk");
		    	}
		    	
		    
		   
		    br1.close();
		 
		    return emp_records;
		
	}

	public Map<String,String> shuffleAndMap2(String relation2) throws IOException {
		// TODO Auto-generated method stub
		
		 BufferedReader br2;
		 Map<String,String> project_records = new HashMap<String,String>();
		 Map<String,String> dataRow2 = new HashMap<String,String>();
		
		 try {
		br2 = new BufferedReader(new InputStreamReader(new FileInputStream(relation2)));
		String line2;
		line2 = br2.readLine();
		 
	    
	    while ((line2 = br2.readLine()) != null) {
	    	
	       	        
			String colValue2 = String.valueOf(line2);
			String string = colValue2;
			String[] parts = string.split(" ");
			
			dataRow2.put( parts[0], colValue2);
			 
			project_records.putAll(dataRow2);
			 
	    }
	    totalBlocks = project_records.size()/rowsInEachBlock ; 
	    
	    System.out.println("\nBringing " +totalBlocks +" blocks of relation 2 to memory");
	    
	      	for(int i=0;i<totalBlocks;i++)
	    	{
	    		System.out.println("Mapper 2 is full, writing to disk");
	    		System.out.println("Output block is full, writing to disk");
	    	}
	    
	   
	    br2.close();
	   
	   
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return project_records;
	}
	
	}






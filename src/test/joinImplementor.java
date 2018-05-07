package test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;

import Mapper.map;
import Merger.hashJoin;
import Merger.join;
import relation.record;

public class joinImplementor {
	
	 Map<String,String> build = new HashMap<String,String>(); 
	 Map<String,String> probe = new HashMap<String,String>(); 

	 public Map<String,String> leftMap = new HashMap<String,String>();
	 public Map<String,String> rightMap = new HashMap<String,String>();
			
	String file1 = "C:/Users/Charitha/eclipse-workspace/Emp_Details.txt";
	String file2 = "C:/Users/Charitha/eclipse-workspace/Project_Details.txt";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		joinImplementor joinObj = new joinImplementor();
		joinObj.execute();
		
		}  
		
		private void execute() throws IOException {
		// TODO Auto-generated method stub
		map mapper1 = new map();
		map mapper2 = new map();
		
		//Call mapper 1 to generate key-value pairs
		leftMap = mapper1.shuffleAndMap1(file1);
		
		//Call mapper 2 to generate key-value pairs
		rightMap = mapper2.shuffleAndMap2(file2);
				
		System.out.println("\n---Left Relation key-value pairs--- ");
		for(Entry<String,String> temp : leftMap.entrySet())
		{
			
			System.out.println(temp.getKey()+" = "+temp.getValue());
		}
		
		
		System.out.println("\n---Right Relation key-value pairs--- ");
		for(Entry<String,String> temp : rightMap.entrySet())
		{
			
			System.out.println(temp.getKey()+" = "+temp.getValue());
		}
				
		//Assign build and probe based on size of relation
		join(leftMap,rightMap);
		
				
		//Apply hash function 1 - mod 3 on both left and right relations
		hashJoin joinObj = new hashJoin();
		joinObj.hashFn1LeftRel(build);
		joinObj.hashFn1RightRel(probe);
		
		//Apply hash function 2 - mod 5 and join
		Map<String, String> output = joinObj.hashFn2();
		
		System.out.println("\n---Final Joined Result--- ");
		System.out.println("\nProject_id Project_name Emp_id Emp_name Salary Location");
		for(Entry<String,String> temp : output.entrySet())
		{
			
			System.out.println(temp.getValue());
		}
			
		//System.out.println("---Final Joined Result--- "+"\n"+output);
		
	}

	private Map<String,String> join(Map<String,String> leftMap, Map<String,String> rightMap) {
		// TODO Auto-generated method stub
		
		
		int lm = leftMap.size();
		int rm = rightMap.size();
		
		if(lm<=rm) {
			build = leftMap;
			probe = rightMap;
			
		}
		else
			build = rightMap;
			probe = leftMap;
		
		return null;
	}

	
}

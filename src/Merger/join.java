package Merger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import relation.record;

public class join {

	
	
	public Map<Integer, record> joinSize(Map<Integer, record> leftMap, Map<Integer, record> rightMap) {
		// TODO Auto-generated method stub
		
		Map<Integer, record> build = new HashMap<Integer, record>(); 
		
		int lm = leftMap.size();
		int rm = rightMap.size();
		
		if(lm<=rm) 
			build = leftMap;
		else
			build = rightMap;
				
		
		
		return build;
		
	
	}		
}

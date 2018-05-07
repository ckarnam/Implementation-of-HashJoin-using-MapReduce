package Reducer;

import java.util.HashMap;
import java.util.Map;
import relation.record;


public class reduce {
	
		private Map<Integer, record> result = new HashMap<Integer, record>();

		public Map<Integer, record> getRecord() {
			return result;
		}

		public void setResultDataRowMap(Map<Integer, record> resultDataRowMap) {
			this.result = result;
		}
	}



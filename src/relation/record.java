package relation;
import java.util.*;
	
public class record {
		

			private Map<String,String> row = new HashMap<String,String>();

			@Override
			public String toString() {
				return row.toString();
			}

			public Map<String,String> getRow() {
				return row;
			}

			public void setRow(Map<String,String> row) {
				this.row = row;
			}

			
		

	}



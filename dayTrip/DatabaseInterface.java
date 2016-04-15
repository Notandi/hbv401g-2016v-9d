package dayTrip;

import java.util.ArrayList;
import java.sql.*;

public class DatabaseInterface {
	
	public DataBlock select(Query query)
	{
		int type = query.getType();
		DataBlock res = new DataBlock(type);
		
		/*switch(type){
		case 1:	ArrayList<Attraction> mockresultAttraction =  MockData.MockAttraction(query);
				res.setAttractions(mockresultAttraction);
				break;
		case 2: ArrayList<Trip> mockresultTrip = MockData.MockTrip(query);
				res.setTrips(mockresultTrip);
				break;
		}
		return res;*/
		DataBlock datablock = new DataBlock(2);
		return datablock;
	}
	
	public int insert(Pair[] query)
	{		
		//if()
		return 1;
	}
	
	public int delete(Pair[] query)
	{
		return 1;
	}

}

package lab_1;

import java.awt.List;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

public class MultyLevelParking<T> {
		
	WarBase<ITransport, IGuns> base= new WarBase<ITransport ,IGuns>(20, 663, 440);
	
	ArrayList parkingStages = new ArrayList()  ; 
	
	private static int countPlaces = 20;
	
	public void MultiLevelParking(int countStages, int pictureWidth, int pictureHeight)
	 {
		for (int i = 0; i < countStages; ++i)
		 {
			
		 parkingStages.add(new WarBase<ITransport,IGuns>(countPlaces, pictureWidth,pictureHeight));
		 
		 }
	 }
	// indecsator
	public  int index_Re(int index) {
		
		if (index > -1 && index < parkingStages.size())
		 {
			return index;
		 }
		return -1;
	}		
}

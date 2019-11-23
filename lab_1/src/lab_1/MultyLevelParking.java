package lab_1;

import java.awt.Container;
import java.awt.List;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

public class MultyLevelParking {
				
	ArrayList<WarBase<ITransport, IGuns>> parkingStages = new ArrayList<WarBase<ITransport, IGuns>>()  ; 
	
	private static int countPlaces = 20;
	
	public MultyLevelParking(int countStages, int pictureWidth, int pictureHeight)
	 {
		for (int i = 0; i < countStages; ++i)
		 {
			
		 parkingStages.add(new WarBase<ITransport,IGuns>(countPlaces, pictureWidth,pictureHeight));
		 
		 }
	 }
	// indecsator
	public  int select_index(int index) {
		
		if (index > -1 && index < parkingStages.size())
		 {
			return index;
		 }
		return -1;
	}
		
}

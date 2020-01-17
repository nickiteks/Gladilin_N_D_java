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
	public  <T> ITransport chose_element(int index_level,int index_parking) {	
		if (index_level > -1 && index_level < parkingStages.size()) {
			ITransport transport = parkingStages.get(index_level)._places.get(index_parking);
			return transport;
		}
		return null;
	}		
}

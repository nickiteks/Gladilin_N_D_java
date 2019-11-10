package lab_1;

import java.awt.List;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

public class MultyLevelParking<T> {
	
	 ArrayList<T> parkingStages = new ArrayList<T>();
	
	private static int countPlaces = 20;
	
	
	
	public void MultiLevelParking(int countStages, int pictureWidth, int pictureHeight)
	 {
	 parkingStages = (ArrayList<T>) new ArrayList<WarBase<ITransport,IGuns>>();
	 	for (int i = 0; i < countStages; ++i)
	 	{
		 
		 parkingStages.add((T) new WarBase<ITransport,IGuns>(countPlaces, pictureWidth,
			 pictureHeight));
	 	}
	 }
	/*
	public  Object getLevel( int ind) {
		if(ind>-1 && ind < parkingStages.size()) {
			
			return parkingStages[ind];
			
		}
		return null;
	}
	*/
	
}

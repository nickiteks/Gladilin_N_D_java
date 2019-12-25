package lab_1;

import java.awt.Container;
import java.awt.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	public  <T> ITransport chose_element(int index_level,int index_parking) {
				
		return parkingStages.get(index_level)._places.get(index_parking);
		
	}
	public boolean  Save(String filename) throws IOException {
		FileWriter fw = new FileWriter(filename);
		WriteToFile("CountLeveles:" + parkingStages.size() + "\n", fw);
		for (WarBase<ITransport, IGuns> level : parkingStages) {
			WriteToFile("Level" + "\n", fw);
			for (int i = 0; i < countPlaces; i++) {
				ITransport transport = level.getTransport(i);
				if (transport != null) {
					if (transport.getClass().getName() == "lab_1.WarCar" ) {
						WriteToFile(i + ":WarCar:", fw);
					}
					if (transport.getClass().getName() == "lab_1.tank") {
						WriteToFile(i + ":tank:", fw);
					}
					WriteToFile(transport.ToString() + "\n", fw);
				}
			}
		}
		fw.flush();	
		
		return true;
	}
	private void WriteToFile(String text, FileWriter fw) {
		try {
			fw.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean Load(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		String bufferTextFromFile = "";
		int counter = -1;

		int c;
		while ((char) (c = fr.read()) != '\n') {
			bufferTextFromFile += (char) c;
		}

		if (bufferTextFromFile.contains("CountLeveles")) {
			int count = Integer.parseInt(bufferTextFromFile.split(":")[1]);
			if (parkingStages != null) {
				parkingStages.clear();
			}
			parkingStages = new ArrayList<WarBase<ITransport, IGuns>>(count);
			bufferTextFromFile = "";
		} else {
			return false;
		}

		while ((c = fr.read()) != -1) {
			if ((char) c == '\n') {
				ITransport transport = null;

				if (bufferTextFromFile.equals("Level")) {
					counter++;
					parkingStages.add(new WarBase<ITransport, IGuns>(countPlaces, 663, 440));
					bufferTextFromFile = "";
					continue;
				}

				if (bufferTextFromFile.split(":").length > 1) {
					if (bufferTextFromFile.split(":")[1].equals("WarCar")) {
						transport = new WarCar(bufferTextFromFile.split(":")[2]);
					} else if (bufferTextFromFile.split(":")[1].equals("tank")) {
						transport = new tank(bufferTextFromFile.split(":")[2]);
					}
					parkingStages.get(counter).add(transport);
					parkingStages.get(counter).setTransport(Integer.parseInt(bufferTextFromFile.split(":")[0]),
							transport);
				}

				bufferTextFromFile = "";
			} else {
				bufferTextFromFile += (char) c;
			}
		}
		return true;
	}
	
	public boolean SaveLevel(String filename, int lvl) throws IOException {
		try {
			if (lvl > parkingStages.size() && lvl < 0) {
				return false;
			}
			FileWriter fw = new FileWriter(filename);
			WriteToFile("Level:" + lvl + "\n", fw);
			WarBase<ITransport, IGuns> level = parkingStages.get(lvl);
			for (int i = 0; i < countPlaces; i++) {
				ITransport transport = level.getTransport(i);
				if (transport != null) {
					if (transport.getClass().getName() == "lab_1.WarCar") {
						WriteToFile(i + ":WarCar:", fw);
					}
					if (transport.getClass().getName() == "lab_1.tank") {
						WriteToFile(i + ":tank:", fw);
					}
					WriteToFile(transport.ToString() + "\n", fw);
				}
			}
			fw.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean LoadLevel(String filename) throws IOException {
		try {
			FileReader fr = new FileReader(filename);
			String bufferTextFromFile = "";
			int lvl = 0;

			int c;
			while ((char) (c = fr.read()) != '\n') {
				bufferTextFromFile += (char) c;
			}

			if (bufferTextFromFile.contains("Level")) {
				lvl = Integer.parseInt(bufferTextFromFile.split(":")[1]);
				bufferTextFromFile = "";
			} else {
				return false;
			}

			if (parkingStages.size() < lvl) {
				return false;
			}

			parkingStages.set(lvl, new WarBase<ITransport, IGuns>(countPlaces, 663, 440));

			while ((c = fr.read()) != -1) {
				if ((char) c == '\n') {
					ITransport transport = null;

					if (bufferTextFromFile == null) {
						continue;
					}

					if (bufferTextFromFile.split(":").length > 2) {
						if (bufferTextFromFile.split(":")[1].equals("WarCar")) {
							transport = new WarCar(bufferTextFromFile.split(":")[2]);
						} else if (bufferTextFromFile.split(":")[1].equals("tank")) {
							transport = new tank(bufferTextFromFile.split(":")[2]);
						}
						parkingStages.get(lvl).add(transport);
						parkingStages.get(lvl).setTransport(Integer.parseInt(bufferTextFromFile.split(":")[0]),
								transport);
					}

					bufferTextFromFile = "";
				} else {
					bufferTextFromFile += (char) c;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true; 
	}
	
	
	
		
}

package car_track;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class zapravka {
	public static final int speedFill = 1;
	//int time =0;
	private int getTime(List<Car> list) {
		int time1 = 0;
		double valueAllFill = 0;
		for (Car car1 : list) {
			valueAllFill = valueAllFill + car1.getFreeSpase();
		}
		time1 = (int) valueAllFill / speedFill;
		
		return time1;
	}
	
	public int fillCars(List<Car> list) {
		List<Car> StationCar1 = new ArrayList();
		List<Car> StationCar2 = new ArrayList();
		for (Car car : list) {
			int time1 = getTime(StationCar1);
			int time2 = getTime(StationCar2);
			if (time1 < time2) {
				StationCar1.add(car);
			} else {
				StationCar2.add(car);
			}			
		}		
		try {
			saveFile(StationCar1,StationCar2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Math.max(getTime(StationCar1), getTime(StationCar2));
	}
	
	public void saveFile(List<Car> list1, List<Car> list2) throws IOException {
		FileWriter writer=new FileWriter("D:\\file3.txt",  false);
		writer.write("Station1:");
		writer.write('\r');
		writer.write('\n');
		int i=1;
		for(Car car:list1) {
			writer.write(String.valueOf(i));
			writer.write(") ");
			writer.write(car.toString());
			i=i+1;
			writer.write('\r');
			writer.write('\n');
		}
		
		writer.write("Station2:");
		writer.write('\r');
		writer.write('\n');
		int j=1;
		for(Car car:list2) {
			writer.write(String.valueOf(j));
			writer.write(") ");
			writer.write(car.toString());
			j=j+1;
			writer.write('\r');
			writer.write('\n');
		}
		
		
		
		
		
		writer.flush();
		writer.close();
	}
	
	
	

}

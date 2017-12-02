package car_track;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*Нужно рассчитать сколько километров проедет машина за время t,
 *  машина едет равномерно.
Входные параметры: кол-во литров в баке (литров), расход топлива в секунду
 и пройденное растояние за секунду. Пользователь указывает время t в секундах,
  на выходе получаем кол-во метров пройденное машиной.

К примеру, машину заправили на 10 литров, также у нее расход 0.1 литр в секунду и за каждую секунду машина проходит 10 метров. Я хочу узнать, сколько метров пройдет машина за 10 секунд пути, в итоге должен получить 100 метров. (вроде правильно посчитал)
//условие понятно*/
public class car_1 {

	public static void probeg(int x, double y, int z) {
		System.out.println(x / y * z);
	}

	public static void main(String[] args) throws IOException {
		// probeg(10,0.1,10);
		/*
		 * Car car1 = new Car(0,0.1,10);
		 * System.out.println("Машина готова"+car1.toString());
		 * 
		 * System.out.println("За 10 секунд мы проехали(метров): "+car1.way(20));
		 * System.out.println("До заправки бензина"+car1.toString()); car1.addValume(2);
		 * System.out.println("После заправки бензина"+car1.toString());
		 * System.out.println("В машине осталось топлива:"+car1.toString());
		 */

		/*
		 * ArrayList <Car> list = new ArrayList(); list.add(new Car(1,1,1));
		 * list.add(new Car(2,2,2)); list.add(new Car(3,3,3)); list.add(new Car(4,4,4));
		 * list.add(new Car(5,5,5)); list.add(new Car(6,6,6));
		 * 
		 * zapravka station= new zapravka(); int x=station.fillCars(list);
		 * System.out.println(x);
		 */

		ArrayList<Car> alist = new ArrayList();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D://file2.txt")));
		while (true) {
			String s = reader.readLine();

			if (s == null) {
				break;
			}
			char[] arr1 = new char[18];
			char[] arr2 = new char[3];
			char[] arr3 = new char[3];
			char[] arr4 = new char[3];
			arr1 = s.toCharArray();

			for (int j = 0; j < 3; j++) {
				arr2[j] = arr1[j + 7];
			}

			for (int j = 0; j < 3; j++) {
				arr3[j] = arr1[j + 11];
			}

			for (int j = 0; j < 3; j++) {
				arr4[j] = arr1[j + 15];
			}

			System.out.println(s);
/*
			for (int i = 0; i < arr2.length; i++) {
				System.out.print(arr2[i]);
			}
			for (int i = 0; i < arr3.length; i++) {
				System.out.print(arr3[i]);
			}
			for (int i = 0; i < arr4.length; i++) {
				System.out.print(arr4[i]);
			}*/
			Car car1=new Car(Double.valueOf(new String(arr2)), Double.valueOf(new String(arr3)), Double.valueOf(new String(arr4)));
			alist.add(car1);
		}
		for(Car car: alist) {
			System.out.println(car.toString());
			
		}
		
		zapravka station= new zapravka();
		int x=station.fillCars(alist);
		System.out.println(x);
	}
}

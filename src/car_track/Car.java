package car_track;

public class Car {
	
	public static final double MAX_VALUME_TRANK = 40;
	// Обьем бака в литрах
	private double valumeTrank;

	// Расход топлива за 1 секунду
	private double consumation;

	// Скорость за 1 секунду
	private double speed;

	public Car(double valuemTrank, double consumation, double speed) {
		super();
		this.valumeTrank = valuemTrank;
		this.consumation = consumation;
		this.speed = speed;
	}

	public double way(int countSecond) {
		int maxTime = getMaxTime();
		if (countSecond > maxTime) {
			valumeTrank = 0;
			return maxTime * speed;

		} else {
			valumeTrank = valumeTrank - consumation * countSecond;
			return speed * countSecond;
		}
	}
	
	public double addValume(double valume) {
		double diff = (MAX_VALUME_TRANK-valumeTrank);
		if(diff < valume) {
			valumeTrank = MAX_VALUME_TRANK;
			return diff;
		}else {
			valumeTrank = valumeTrank + valume;
			return valume;
		}
	}

	public int getMaxTime() {
		return (int) (valumeTrank / consumation);
	}
	
	public double getFreeSpase() {
		return MAX_VALUME_TRANK-valumeTrank;
	}
	
	

	@Override
	public String toString() {
		return "Car [valumeTrank=" + valumeTrank + ", consumation=" + consumation + ", speed=" + speed + "] " + hashCode();
	}

}

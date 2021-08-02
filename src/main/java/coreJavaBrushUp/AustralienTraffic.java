package coreJavaBrushUp;

public class AustralienTraffic implements CentralTraffic, ContinentalTraffic {

	public static void main(String[] args) {

		CentralTraffic a = new AustralienTraffic();
		a.greenGo();
		a.redStop();
		a.FlashingYellow();
		AustralienTraffic at = new AustralienTraffic();

		at.TrainSignal();

		ContinentalTraffic ct = new AustralienTraffic();
		ct.TrainSignal();

	}

	@Override
	public void greenGo() {
		System.out.println("Under greenGo");
	}

	@Override
	public void redStop() {
		System.out.println("Under redStop");
	}

	@Override
	public void FlashingYellow() {
		System.out.println("Under FlashingYellow");
	}

	@Override
	public void TrainSignal() {

		System.out.println("Under Train Signal");

	}

}

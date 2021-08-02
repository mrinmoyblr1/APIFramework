package coreJavaBrushUp;

public class ChildClass extends ParentClass {

	public void Engine() {
		System.out.println("Engin Code is implemented");
	}

	public static void main(String[] args) {

		ChildClass c = new ChildClass();
		c.Gear();
		c.AudioSystem();
		c.Breaks();
		c.Engine();

	}

}

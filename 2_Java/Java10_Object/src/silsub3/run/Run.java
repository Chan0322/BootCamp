package silsub3.run;

import silsub3.model.vo.Circle;

public class Run {

	public static void main(String[] args) {
		Circle c = new Circle();
		
		c.setRadius(2);
		System.out.println(c.getRadius());
		
		c.incrementRadius();
	}

}

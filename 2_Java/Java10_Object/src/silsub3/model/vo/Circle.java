package silsub3.model.vo;

public class Circle {
	public static final double PI = 3.14;
	private static int radius;
	
	public Circle() {}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public String getRadius() {
		double ra = 2*PI*radius;
		double space = PI*radius*radius;
		return "둘레: "+ra+", 넓이: "+space;
	}
	
	public void incrementRadius() {
		radius += 1;
		double ra = 2*PI*radius;
		double space = PI*radius*radius;
		String str = "반지름 1 증가된 둘레: "+ra+", 넓이: "+space;
		System.out.println(str);
	}
	
}

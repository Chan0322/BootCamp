package silsub2.run;

import silsub2.model.vo.Product;

public class Run {

	public static void main(String[] args) {
		Product p = new Product();
		p.setPName("갤럭시");
		p.setPrice(150);
		p.setBrand("삼성");
		
		System.out.println(p.informaotion(p.getPName(), p.getPrice(), p.getBrand()));
//		System.out.println(p.informaotion("갤럭시", 150, "삼성"));
	}

}

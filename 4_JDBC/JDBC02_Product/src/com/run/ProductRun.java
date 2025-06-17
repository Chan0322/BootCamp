package com.run;

import com.model.view.ProductView;

public class ProductRun {

	public static void main(String[] args) {
		// OracleDriver 외부에서 넣어줘야 함! 프로젝트 Build Path
		new ProductView().menu();
	}

}

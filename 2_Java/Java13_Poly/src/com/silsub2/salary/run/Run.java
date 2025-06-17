package com.silsub2.salary.run;

import com.silsub2.controller.Calculate;
import com.silsub2.controller.CalculateImpl;
import com.silsub2.salary.model.vo.PayTable;
import com.silsub2.salary.model.vo.Salary;
import com.silsub2.view.Output;
import com.silsub2.view.OutputImpl;

public class Run {

	public static void main(String[] args) {
		Salary[] pt = new Salary[3];
		pt[0] = new PayTable("소서노",750000,2,3);
		pt[1] = new PayTable("고주몽",800000,1,4);
		pt[2] = new PayTable("모팔모",650000,6,2);
		
		Calculate c = new CalculateImpl();
		c.calc(pt);
		
		Output o = new OutputImpl();
		o.out(pt);
	}

	
}

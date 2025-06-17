package com.silsub2.controller;

import com.silsub2.salary.model.vo.Salary;

public class CalculateImpl implements Calculate{
	//out()에서 계산 후 OutputInpl에 있는 out을 통해 결과를 출력해라.
	@Override
	public void calc(Salary[] sarr) {
		for(int i=0; i<sarr.length; i++) {
			// 가족수당
			if(sarr[i].getFamily()<3) {
				sarr[i].setFamilyP(sarr[i].getFamily()*20000);
			}else {
				sarr[i].setFamilyP(60000);
			}
			
			//시간외
			sarr[i].setOvertimeP(sarr[i].getOvertime()*5000);
			//세금
			sarr[i].setTax(sarr[i].getPay()/10);
			//성과금
			sarr[i].setIncenP((long)(sarr[i].getIncentive()*sarr[i].getPay()));
			//실수령
			sarr[i].setTotalPay(sarr[i].getPay() + sarr[i].getFamilyP() + sarr[i].getIncenP() + sarr[i].getOvertimeP() - sarr[i].getTax());
		}
	}

}

package com.collection.part01_list.listsort;

import java.util.Comparator;

//점수 오름차순
public class PointAsc implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		int point1 = ((Score)o1).getPoint();
		int point2 = ((Score)o2).getPoint();
		//음수 자리바꾸지 않겠다.
		//양수 자리바꾸겠다.
		
//		return point1-point2;
		if(point1 > point2) {
			return 1;
			//point1이 더 크기 때문에 자리를 바꾸기 위해 양수 리턴
		}else if(point1 < point2) {
			return -1;
		}else {
			return 0;
		}
	}

}

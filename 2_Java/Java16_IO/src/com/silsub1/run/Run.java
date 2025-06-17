package com.silsub1.run;

import com.io.silsub1.model.dao.FileIOTest;

public class Run {

	public static void main(String[] args) {
		new FileIOTest().fileSave();
		new FileIOTest().fileRead();
	}

}

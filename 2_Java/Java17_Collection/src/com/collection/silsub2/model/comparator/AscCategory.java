package com.collection.silsub2.model.comparator;

import java.util.Comparator;

import com.collection.silsub2.model.vo.Book;

public class AscCategory implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		return o1.getCategory() - o2.getCategory();
	}

}

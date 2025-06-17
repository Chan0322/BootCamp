package com.poly.part00_test.test05;

public class Samsung_TV implements Tv {
	private int vol;

	public Samsung_TV() {
		System.out.println("Samsung TV가 켜졌습니다.");
	}
	
	public void tvClosed() {
		System.out.println("tv가 꺼졌습니다.");
	}
	
	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}

	@Override
	public int volUp() {
		vol += 3;
		return vol;
	}

	@Override
	public int volDown() {
		vol -= 3;
		return vol;
	}
}

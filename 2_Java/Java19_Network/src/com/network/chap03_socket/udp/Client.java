package com.network.chap03_socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Client {
	// 데이터 수신
	public static void main(String[] args) throws IOException {
		//소켓
		DatagramSocket ds = new DatagramSocket(9999); // 포트 넘버
		System.out.println("클라이언트입니다");
		
		//저장할 배열 생성
		byte[] buff = new byte[1024];
		
		//패킷 수신
		DatagramPacket recievePac = new DatagramPacket(buff, buff.length);
		
		ds.receive(recievePac); // 넘어오는 데이터그램 패킷을 ds에 받아온다.
		
		//데이터 확인
		System.out.println(new String(recievePac.getData())); // byte 배열을 스트링으로 바꿔서 출력 
		
		//종료
		ds.close();
		ds.disconnect();
	}
}

package com.network.chap03_socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Server {
	// 데이터 발신
	public static void main(String[] args) throws IOException {
		//소켓 생성
		DatagramSocket ds = new DatagramSocket();
		System.out.println("서버입니다.");
		
		//보낼 data 준비
		byte[] buff="테스트 입니다.".getBytes();	//String 값을 byte 배열로 만듦.
		
		//datagramPacket 생성.   => 데이터 포장
		DatagramPacket sendPac = new DatagramPacket(buff, buff.length, InetAddress.getByName("localhost"), 9999);
		//(보내려는 데이터, 몇개 보낼 지 크기, 이름으로 가져오겠다., 포트넘버) // 받는 쪽의 포트 넘버도 동일해야 받을 수 있다.	// 실제적인 데이터가 들어 있음.
		
		//전송
		ds.send(sendPac); // 소켓으로 데이터그램 패킷을 내보낸다.
		
		//종료
		ds.close();
		ds.disconnect();
	}
}

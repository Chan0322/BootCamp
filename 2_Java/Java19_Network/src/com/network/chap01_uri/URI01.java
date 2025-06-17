package com.network.chap01_uri;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class URI01 {
	public static void main(String[] args) throws URISyntaxException, IOException {
		// URI 클래스
		URI u = new URI("https://www.google.com/search?q=%EC%82%AC%EA%B3%BC&oq=&gs_lcrp=EgZjaHJvbWUqBggAEEUYOzIGCAAQRRg7MgoIARAuGLEDGIAEMg0IAhAAGIMBGLEDGIAEMgoIAxAAGLEDGIAEMgcIBBAAGIAEMgcIBRAuGIAEMhAIBhAuGK8BGMcBGLEDGIAEMgcIBxAAGIAEMhAICBAuGIMBGNQCGLEDGIAEMhAICRAuGIMBGNQCGLEDGIAE0gELMzg5MzU2MWowajeoAgCwAgA&sourceid=chrome&ie=UTF-8");
		
		System.out.println(u.getScheme()); // 프로토콜
		System.out.println(u.getHost()); // url
		System.out.println(u.getQuery());
		
		URL url = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0azWb7Rl8nurvcSMYBgDVjG0YDP56OGYFaA&s");
		
		URLConnection urlConn = url.openConnection();
		
		//입력 스트림. 네트워크 상에 존재하는 img를 읽어온다.
		DataInputStream di = new DataInputStream(urlConn.getInputStream());
		
		//출력 스트림. 입력받은 이미지를 내 컴퓨터에 저장.
		FileOutputStream fo = new FileOutputStream("java.png");
		
		byte[] b = new byte[1];
		while(di.read(b,0,1) != -1) { //b에 인덱스 0부터 1개씩
			fo.write(b,0,1);	// 1개씩 출력
		}
		System.out.println("완료");
		di.close();
		fo.close();
	}
}

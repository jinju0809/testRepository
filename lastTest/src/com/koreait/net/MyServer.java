package com.koreait.net;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * 최초작성자 : 윤진주
 * 최초작성일 : 2021-02-25
 * 최종변경일 : 2021-02-25
 * 목적 : test용
 */
public class MyServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5000));
			while (true) {
				Socket socket = serverSocket.accept();
				InetSocketAddress address = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("MyServer가 연결되었습니다");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(serverSocket != null) {
				try{
					serverSocket.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

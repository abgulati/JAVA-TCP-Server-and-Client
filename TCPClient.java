/*Author: Abheek Gulati
For: NJIT class CS 656
*/

import java.io.*;
import java.net.*;

class TCPClient {
	public static void main(String argv[]) throws Exception {
		
		String sentence;
		String modifiedSentence;

		Socket clientSocket = new Socket("localhost", 6789);

		System.out.println("Enter the line you'd like to capitalize: ");

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));   //In from user
		sentence = inFromUser.readLine();
		
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());  //Send to server
		outToServer.writeBytes(sentence + '\n');

		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));  //Get from server
		modifiedSentence = inFromServer.readLine();

		System.out.println("From server: " + modifiedSentence);
		clientSocket.close();
	}
}

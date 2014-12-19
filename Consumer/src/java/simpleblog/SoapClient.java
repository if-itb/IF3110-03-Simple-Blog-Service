/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleblog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.soap.*;

public class SoapClient {
	
	public static String test() {
		return "works";
	}

	public static String SubmitPost(String user, String title, String date, String content) {

		String operation = "get_names";
		String urn = "framework";
		String destination = "http://simpleblogdarieza.herokuapp.com/api.php";

		try {
			// First create the connection
			SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection connection = soapConnFactory.createConnection();

			// Next, create the actual message
			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage message = messageFactory.createMessage();

			SOAPPart soapPart = message.getSOAPPart();
			SOAPEnvelope envelope = soapPart.getEnvelope();

			// Create and populate the body
			SOAPBody body = envelope.getBody();

			// Create the main element and namespace
			SOAPElement bodyElement = body.addChildElement(envelope.createName(operation, "http://simpleblogdarieza.herokuapp.com/", "urn:" + urn));

			bodyElement.addChildElement("user").addTextNode(user);
			bodyElement.addChildElement("title").addTextNode(user);
			bodyElement.addChildElement("date").addTextNode(user);
			bodyElement.addChildElement("content").addTextNode(user);

			// Save the message
			message.saveChanges();

			// Send the message and get the reply
			SOAPMessage reply = connection.call(message, destination);

			// Retrieve the result - no error checking is done: BAD!
			soapPart = reply.getSOAPPart();
			envelope = soapPart.getEnvelope();
			body = envelope.getBody();

			Node returnvalue = (Node) body.getChildElements().next();
			
			// Close the connection
			connection.close();
			
			return returnvalue.toString();

			/*if (returnvalue != null) {
				if (returnvalue.getChildNodes().item(0).getNodeName().equals("return")) {

					List<HashMap<String, String>> ReturnArray = new ArrayList<HashMap<String, String>>();
					// we have some values, trying to read them now
					for (int i = 0; i < returnvalue.getChildNodes().item(0).getChildNodes().getLength(); i++) {
						if (returnvalue.getChildNodes().item(0).getChildNodes().item(i).getNodeName().equals("item")) {
							HashMap<String, String> keyvaluepairs = new HashMap<String, String>();
							for (int j = 0; j < returnvalue.getChildNodes().item(0).getChildNodes().item(i).getChildNodes().getLength(); j++) {
								System.out.print("(" + returnvalue.getChildNodes().item(0).getChildNodes().item(i).getChildNodes().getLength() + "/" + j + ")");
								String key = returnvalue.getChildNodes().item(0).getChildNodes().item(i).getChildNodes().item(j).getNodeName();
								String value;
								if (returnvalue.getChildNodes().item(0).getChildNodes().item(i).getChildNodes().item(j).getChildNodes().getLength() == 1) {
									value = returnvalue.getChildNodes().item(0).getChildNodes().item(i).getChildNodes().item(j).getChildNodes().item(0).getNodeValue();
								} else {
									value = "";
								}

								keyvaluepairs.put(key, value);
								System.out.println("added " + key + " = " + value);
							}
							ReturnArray.add(keyvaluepairs);
						} else {
							System.out.println("No items ");
						}
					}
				} else {
					System.out.println("no return" + returnvalue.getChildNodes().item(0).getNodeName());
				}
			} else {
				System.out.println("nothing returned");
			}*/
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "err";
	}
}

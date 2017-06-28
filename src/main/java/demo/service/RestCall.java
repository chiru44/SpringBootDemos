package demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import demo.model.Menu;

/**
 * Rest service to get satisfactory limit of given customer
 * @author chiru
 *
 */

@RestController
public class RestCall {
	
	@RequestMapping(path= "/rest/{customer}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ObjectNode getSatisfacotry (@PathVariable String customer) throws IOException {
		System.out.println("hi");
		
			FileReader reader = new FileReader(
					new File("C:\\Users\\chiru\\git\\SpringBootDemos\\restaurant.txt"));
			BufferedReader br  = new BufferedReader(reader);
			String a= br.readLine();
			String b[]= a.split(" ");
			System.out.println("time given :" + b[0]);
			System.out.println("items in menu" + b[1]);
			new Menu(Integer.parseInt(b[1]));
			String line= null;
			int satisfacotry=0;
			int timeTaken=0;
			while ((line = br.readLine()) != null) {
				String tim[]= line.split(" ");
				timeTaken += Integer.parseInt(tim[1]);
				if(timeTaken > Integer.parseInt(b[0])) {
					break;
				}
				satisfacotry += Integer.parseInt(tim[0]);
			}
			
		return new ObjectMapper().createObjectNode().put("satisfactoryLimit", satisfacotry);
	}

}

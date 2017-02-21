package com.jorge;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WordController {

	@Value("${words}") String words; //Comment this line to test "BONUS - Multiple Clients"
	//String words = "icicle,refrigerator,blizzard,snowball"; //Uncomment this line to test "BONUS - Multiple Clients"
	
	@RequestMapping("/")
	public @ResponseBody String getWord() {
		String[] wordArray = words.split(",");
		int i = (int)Math.round(Math.random() * (wordArray.length - 1));
		return wordArray[i];
	}
}

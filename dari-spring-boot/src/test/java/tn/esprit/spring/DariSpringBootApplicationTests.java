package tn.esprit.spring;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.KindOfGood;
import tn.esprit.spring.entities.WishList;
import tn.esprit.spring.services.AchatLocationService;
import tn.esprit.spring.services.FavoriteAdService;
import tn.esprit.spring.services.IAdService;
import tn.esprit.spring.services.WishListService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DariSpringBootApplicationTests {
	
	@Autowired
	WishListService ws;

	@Autowired
	FavoriteAdService fs;
	
	@Autowired
	AchatLocationService as;
	
	@Autowired
	IAdService sa;
	
	@Test
	public void contextLoads() throws ParseException {
		
	}

}

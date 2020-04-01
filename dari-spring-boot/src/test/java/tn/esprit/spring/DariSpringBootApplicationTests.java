package tn.esprit.spring;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.services.AchatLocationService;
import tn.esprit.spring.services.FavoriteAdService;
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
	
	@Test
	public void contextLoads() throws ParseException {
		//ws.deleteWishList(1);
		//ws.retrieveAllWishLists();
		//ws.retrieveWishList("1");
		//fs.favoriserAnnonce(1,1);
		//fs.retrieveFavorite("2");
		//fs.deleteFavorite(1);
		//fs.getAllFavoritesByClient(1);
		//as.RentAds();
	}

}

package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Rent;
import tn.esprit.spring.entities.Sell;
import tn.esprit.spring.repository.RentRepository;
import tn.esprit.spring.repository.SellRepository;

@Service
public class AchatLocationServiceImpl implements AchatLocationService {

	public static final Logger L = LogManager.getLogger(AchatLocationServiceImpl.class);
	
	@Autowired
	SellRepository sellRepository;
	@Autowired
	RentRepository rentRepository;
	
	@Override
	public List<Sell> SellAds() {
		List<Sell> wls=(List<Sell>)sellRepository.findAll();
		for (Sell s : wls) {
			L.info("whishlist +++"+s);
		}
		return wls;	
	}
	
	@Override
	public List<Rent> RentAds() {
		List<Rent> wls=(List<Rent>)rentRepository.findAll();
		for (Rent s : wls) {
			L.info("whishlist +++"+s);
		}
		return wls;
	}
	

	@Override
	public List<Ad> FiltreMulticritère() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void Estimation() {
		// TODO Auto-generated method stub
		
	}
}

package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Rent;
import tn.esprit.spring.entities.RentingType;
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
	
		//////////////Filtre 1er niveau////////////////////
	
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
	public List<Rent> RentAdsTypeRent() {
		// TODO Auto-generated method stub
		List<Rent> list=(List<Rent>)rentRepository.findAll();
		List<Rent> list1= new ArrayList<>();
		for (Rent r : list){
			if (r.getRentingtype().equals(RentingType.RENT))
			{
				
				list1.add(r);
			}
		}
		L.info("whishlist +++"+list1);
		return list1;
	}
	
	@Override
	public List<Rent> RentAdsTypeH() {
		// TODO Auto-generated method stub
		List<Rent> list=(List<Rent>)rentRepository.findAll();
		List<Rent> list1= new ArrayList<>();
		for (Rent r : list){
			if (r.getRentingtype().equals(RentingType.HOLIDAYS_RENTING))
			{
				
				list1.add(r);
			}
		}
		L.info("whishlist +++"+list1);
		return list1;
	}
	@Override
	public List<Rent> RentAdsTypeTemp() {
		// TODO Auto-generated method stub
		List<Rent> list=(List<Rent>)rentRepository.findAll();
		List<Rent> list1= new ArrayList<>();
		for (Rent r : list){
			if (r.getRentingtype().equals(RentingType.TEMPORARY_RENTING))
			{
				
				list1.add(r);
			}
		}
		L.info("whishlist +++"+list1);
		return list1;
	}
	
//////////////Filtre 2eme niveau////////////////////

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

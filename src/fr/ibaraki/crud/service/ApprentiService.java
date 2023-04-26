package fr.ibaraki.crud.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibaraki.crud.entity.Apprenti;
import fr.ibaraki.crud.repository.ApprentiRepository;

@Service
public class ApprentiService {

    @Autowired
    private ApprentiRepository apprentiRepository;

    public List<Apprenti> getAllApprentis() {
        return apprentiRepository.findAll();
    }

    public Apprenti getApprentiById(int id) {
        return apprentiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Apprenti not found with id " + id));
    }

    public Apprenti createApprenti(Apprenti apprenti) {
    	if (this.getAllByEmail(apprenti.getEmail()).size() > 0) {
    		throw new EntityExistsException("Apprenti exists with same email " + apprenti.getEmail());
    	}
    	
    	if (this.getByName(apprenti.getFirstName(), apprenti.getLastName()).isPresent()) {
    		throw new EntityExistsException("Apprenti exists with same first name " + apprenti.getFirstName() + " and last name " + apprenti.getLastName());
    	}
    	
    	System.out.println(apprenti.toString());
        return apprentiRepository.save(apprenti);
    }
    
    public List<Apprenti> getAllByEmail(String email) {
    	return this.getAllApprentis().stream().filter(p -> p.getEmail().equals(email)).collect(Collectors.toList());
    }
    
    public Optional<Apprenti> getByName(String fName, String lName) {
    	return this.getAllApprentis().stream().filter(p -> p.getFirstName().equals(fName) && p.getLastName().equals(lName)).findFirst();
    }
    
    public List<Apprenti> getAllByPromotion(String promotion) {
    	return this.getAllApprentis().stream().filter(p -> p.getPropotion().equals(promotion)).collect(Collectors.toList());
    }
    
    public double getAbscentByPromotion(String promotion) {
    	int tot = 0;
    	List<Apprenti> prom = this.getAllByPromotion(promotion);
    	for (Apprenti app : prom) {
    		tot += app.getAbsences();
    	}
    	
    	return (double)tot / (double)prom.size();
    }

    public Apprenti updateApprenti(int id, Apprenti apprenti) {
        apprentiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Apprenti not found with id " + id));

        apprenti.setId(id);
        
        return apprentiRepository.save(apprenti);
    }

    public void deleteApprenti(int id) {
    	Apprenti apprenti = apprentiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Apprenti not found with id " + id));
    	
    	if (apprenti.getDelegue()) {
    		throw new EntityExistsException("Apprenti cannot be deleted when delegue is true");
    	}
    	
        apprentiRepository.deleteById(id);
    }

	public List<Apprenti> getAllSortedApprentis(String filter) {
		if (filter == null) return this.getAllApprentis();
		return this.getAllApprentis().stream().sorted(new Comparator<Apprenti>() {

			@Override
			public int compare(Apprenti o1, Apprenti o2) {
				if (filter.equals("lastName")) {
					return o1.getLastName().compareTo(o2.getLastName());
				} else if (filter.equals("abscence")) {
					return Integer.valueOf(o1.getAbsences()).compareTo(o2.getAbsences());
				} else {
					return 0;
				}
			}
		
		}).collect(Collectors.toList());
	}
}

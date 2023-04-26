package fr.ibaraki.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ibaraki.crud.entity.Apprenti;

public interface ApprentiRepository extends JpaRepository<Apprenti, Integer> {

	List<Apprenti> findAllByEmail(String email);
	
}
package demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import demo.domain.Team;

@Repository
public interface TeamDAO extends CrudRepository<Team,Long> {

	List<Team> findAll();
	
	Team findByName(String name);
	
}

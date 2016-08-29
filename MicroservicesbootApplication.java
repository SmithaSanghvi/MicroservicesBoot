package demo;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.TeamDAO;
import demo.domain.Player;
import demo.domain.Team;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan 
@EnableAutoConfiguration
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false) 
public class MicroservicesbootApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesbootApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		System.out.println("ind application class**************************");
   	    setRegisterErrorPageFilter(false);

		return builder.sources(MicroservicesbootApplication.class);
	}
	@PostConstruct
	public void init()
	{
		
		System.out.println("called pre initttttttttttttttttttttttttttttttt");
		
		Set<Player> players=new HashSet<>();
		players.add(new Player("Charlie Brown","pitcher"));
		players.add(new Player("Snoopy","shortstop"));
		
		Team team=new Team("California","Peanuts",players);
		
		System.out.println("created team peanuts********************************************************");
		
		teamDAO.save(team);
	}
	
	@Autowired TeamDAO teamDAO;
	
}

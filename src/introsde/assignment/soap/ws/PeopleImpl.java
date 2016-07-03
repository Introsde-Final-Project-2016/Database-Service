package introsde.assignment.soap.ws;

import introsde.assignment.soap.model.LifeStatus;
import introsde.assignment.soap.model.Person;
import introsde.assignment.soap.model.Goals;

import java.util.List;
import javax.jws.WebService;

//Service Implementation

@WebService(endpointInterface = "introsde.assignment.soap.ws.People",
	serviceName="PeopleService")
public class PeopleImpl implements People {

	@Override
	public Person readPerson(int id) {
		System.out.println("---> Reading Person by id = "+id);
		Person p = Person.getPersonById(id);
		return p;
	}
	
	@Override
	public Person updateP(Person person) {
		Person existing = Person.getPersonById(person.getIdPerson());
		
		if (person.getName() != null)
			existing.setName(person.getName());
		if (person.getLastname() != null)
			existing.setLastname(person.getLastname());
		if (person.getAge() != 0)
			existing.setAge(person.getAge());	
		if (person.getEmail() != null)
			existing.setEmail(person.getEmail());;			
		if (person.getGender() != null)
			existing.setGender(person.getGender());		
		Person.updatePerson(existing);
		return existing;
	}
	
	@Override
	public List<LifeStatus> getAllLifeStatus() {
		return LifeStatus.getAll();
	}

	@Override
	public LifeStatus readLifeStatus(int id2) {
		System.out.println("---> Reading Life Status by id = "+id2);
		LifeStatus ls = LifeStatus.getLifeStatusById(id2);
		return ls;
	}
	
	@Override
	public LifeStatus updateLs(LifeStatus ls) {
		LifeStatus existing2 = LifeStatus.getLifeStatusById(ls.getIdMeasure());
		if (ls.getMeasureName() != null)
			existing2.setMeasureName(ls.getMeasureName());
		if (ls.getValue() != null)
			existing2.setValue(ls.getValue()); 
		LifeStatus.updateLifeStatus(existing2);
		return existing2;
	}
	
	@Override
	public List<Goals> getAllGoals() {
		return Goals.getAll();
	}

	@Override
	public Goals readGoal(int id3) {
		System.out.println("---> Reading Goal by id = "+id3);
		Goals g = Goals.getGoalById(id3);
		return g;
	}
	
	@Override
	public Goals updateG(Goals g) {
		Goals existing3 = Goals.getGoalById(g.getIdGoal());
		if (g.getGoalName() != null)
			existing3.setGoalName(g.getGoalName());
		if (g.getGoalValue() != null)
			existing3.setGoalValue(g.getGoalValue());
		if (g.getMeasureType() != null)
			existing3.setMeasureType(g.getMeasureType()); 
		Goals.updateGoal(existing3);
		return existing3;
	}	

}

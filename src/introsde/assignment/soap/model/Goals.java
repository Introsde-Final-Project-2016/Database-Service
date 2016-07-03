package introsde.assignment.soap.model;

import introsde.assignment.soap.dao.LifeCoachDao;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;


/**
 * The persistent class for the "Goals" database table.
 * 
 */
@Entity
@Table(name="Goals")
@NamedQuery(name="Goals.findAll", query="SELECT g FROM Goals g")


//@XmlType(propOrder = {"idGoal", "goalName", "goalValue", "measureType"})
@XmlAccessorType(XmlAccessType.FIELD)
@Cacheable(false)

@XmlRootElement
public class Goals implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	// For sqlite in particular, you need to use the following @GeneratedValue annotation
	// This holds also for the other tables
	// SQLITE implements auto increment ids through named sequences that are stored in a 
	// special table named "sqlite_sequence"
	@GeneratedValue(generator="sqlite_goals")
	@TableGenerator(name="sqlite_goals", table="sqlite_sequence",
    pkColumnName="name", valueColumnName="seq",
    pkColumnValue="Goals")
		
	@Column(name="idGoal")
	private int idGoal;

	@Column(name="goalName")
	private String goalName;

	@Column(name="goalValue")
	private String goalValue;

	@Column(name="measureType")
	private String measureType;
		
	public Goals() {
	}
	
	public int getIdGoal() {
		return this.idGoal;
	}

	public void SetIdGoal(int idGoal) {
		this.idGoal = idGoal;
	}

	public String getGoalName() {
		return this.goalName;
	}

	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}

	public String getGoalValue() {
		return this.goalValue;
	}

	public void setGoalValue(String goalValue) {
		this.goalValue = goalValue;
	}

	public String getMeasureType() {
		return this.measureType;
	}

	public void setMeasureType(String measureType) {
		this.measureType = measureType;
	}
	
	// Database operations
	// Notice that, for this example, we create and destroy and entityManager on each operation. 
	// How would you change the DAO to not having to create the entity manager every time? 
	public static Goals getGoalById(int idGoal) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		Goals g = em.find(Goals.class, idGoal);
		LifeCoachDao.instance.closeConnections(em);
		return g;
	}
	
	public static List<Goals> getAll() {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
	    List<Goals> glist = em.createNamedQuery("Goals.findAll", Goals.class).getResultList();
	    LifeCoachDao.instance.closeConnections(em);
	    return glist;
	}
	
	public static Goals saveGoal(Goals g) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(g);
		tx.commit();
	    LifeCoachDao.instance.closeConnections(em);
	    return g;
	}
	
	public static Goals updateGoal(Goals g) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		g = em.merge(g);
		tx.commit();
		LifeCoachDao.instance.closeConnections(em);
		return g;	
	}
		
	public static void removeGoal(Goals g) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	    g=em.merge(g);
	    em.remove(g);
	    tx.commit();
	    LifeCoachDao.instance.closeConnections(em);
	}
}

package introsde.assignment.soap.ws;
import introsde.assignment.soap.model.LifeStatus;
import introsde.assignment.soap.model.Person;
import introsde.assignment.soap.model.Goals;


import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional

public interface People {
	//Person
    @WebMethod(operationName="readPerson")
    @WebResult(name="person") 
    public Person readPerson(@WebParam(name="personId") int id);
    
    @WebMethod(operationName="updatePerson")
    @WebResult(name="person") 
    public Person updateP(@WebParam(name="person") Person person);
    
    //LifeStatus
    @WebMethod(operationName="readAllLifeStatus")
    @WebResult(name="lifeStatus") 
    public List<LifeStatus> getAllLifeStatus();
    
    @WebMethod(operationName="readLifeStatus")
    @WebResult(name="lifeStatus") 
    public LifeStatus readLifeStatus(@WebParam(name="lsId") int id);
        
    @WebMethod(operationName="updateLifeStatus")
    @WebResult(name="lifeStatus") 
    public LifeStatus updateLs(@WebParam(name="lifeStatus") LifeStatus ls);
    
    //Goals
    @WebMethod(operationName="readAllGoals")
    @WebResult(name="goal") 
    public List<Goals> getAllGoals();
    
    @WebMethod(operationName="readGoal")
    @WebResult(name="goal") 
    public Goals readGoal(@WebParam(name="goalId") int id);
        
    @WebMethod(operationName="updateGoal")
    @WebResult(name="goal") 
    public Goals updateG(@WebParam(name="goal") Goals g);

   
    
    
}
    
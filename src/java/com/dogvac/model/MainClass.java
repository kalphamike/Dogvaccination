/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dogvac.model;

import com.dogvac.controler.GeneralDao;
import com.dogvac.intities.Actor;
import com.dogvac.intities.Disease;
import com.dogvac.intities.Dog;
import com.dogvac.intities.Vaccination;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.Facelet;
import javax.faces.view.facelets.FaceletContext;
import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//me
/**
 *
 * @author mike
 */
@SessionScoped
@ManagedBean(name = "Main")
public class MainClass {
private Actor mn  = new Actor();
private GeneralDao<Actor> mnDao = new GeneralDao<>(Actor.class);
private auth au = new auth();
private String action ="create";
//Nicole


private Dog dog = new Dog();
private GeneralDao<Dog> dogDao = new GeneralDao<>(Dog.class);
private Vaccination vac = new Vaccination();
private GeneralDao<Vaccination> vacDao = new GeneralDao<>(Vaccination.class);
private Disease dis = new Disease();
private GeneralDao<Disease> disDao = new GeneralDao<>(Disease.class);
 //

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

   


    public Actor getMn() {
        return mn;
    }

    

    public List<Actor> getMnDao() {
        return mnDao.listAll();
    }

    public void setMn(Actor mn) {
        this.mn = mn;
    }
    
    

    public auth getAu() {
        return au;
    }

    public void setAu(auth au) {
        this.au = au;
    }
    
    //===========================================
    //getters by nicole

    public Dog getDog() {
        return dog;
    }

    public List<Dog> getDogDao() {
        return dogDao.listAll();
    }

    public Vaccination getVac() {
        return vac;
    }

    public List<Vaccination> getVacDao() {
        return vacDao.listAll();
    }

    public Disease getDis() {
        return dis;
    }

    public List<Disease> getDisDao() {
        return disDao.listAll();
    }
    
    //Methode
    
    
    //======Save;delete and update
    
    
    
    
     public String CreateDisease(){
        try{
     disDao.create(dis);

     return "vet";
        }

        catch (Exception e){
            return "vet";

        }

     }
     
      public String createvaccine(){
        try{
     vacDao.create(vac);

     return "Vaccination";
        }

        catch (Exception e){
            return "Dog";

        }

     }
      public String createdog(){
        try{
            
            this.action="create";
     
     return "dogowner";
        }

        catch (Exception e){
            return "dogowner";

        }

     }

       public String updatedisease( ){
        try{
           
     disDao.update(dis);

     return "Dog";
        }

        catch (Exception e){
            return "Disease";

        }

     }
       
      public String Updatevaccine(){
        try{
     vacDao.update(vac);

     return "Vaccination";
        }

        catch (Exception e){
            return "Dog";

        }

     }
      public String updatedog(Dog dg){
        try{
            this.dog=dg;
            this.action="Update";
     

     return "dogowner";
        }

        catch (Exception e){
            return "dogowner";

        }

     }
      
      
      public String deletedog(Dog dg){
          dogDao.delete(dg);
      return "dogowner";
      }
      
      
       public String deletevaccine(Vaccination vac){
          vacDao.delete(vac);
      return "Vaccination";
      }
        public String deletedisease(Disease dis){
          disDao.delete(dis);
      return "Disease";
      }
   //=========================== 
    
    
    
    

    public String signupPage(){
    
    return "CreateAcc";
    }

    
    
   public String uSerCreate(){
       if(mn.getUserPassword().equals(mn.getUserConfrimPassword())){
          
         mnDao.create(mn);
          FacesMessage message =new  FacesMessage("Creation Successful");
          FacesContext.getCurrentInstance().addMessage(null, message);
          return "signup";
       }else{
            FacesMessage message =new  FacesMessage("Password not much");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "CreateAcc";
        }
       
    
   
   }
    

    
   public String ULogin(){
        try {
           String enterusernameMail=au.getUserMail();
           
       Actor ab = mnDao.findBySTRING_PK(enterusernameMail);
       
        String actorUsername = ab.getUserEmail();
        
        if ( enterusernameMail.equals(actorUsername)) {
             return "Home"; 
        } else {
            return "Wrong passowrd or Username ";
        }
       } catch (Exception e) {
            FacesMessage message =new  FacesMessage("Create An account");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "CreateAcc";
       }
    }
    
   public String dogupdating(){
        try {
            if(action.equals("create")){
                
                 dogDao.create(dog);
                     dog.setDogId("");
                    dog.setDogDob("");
                    dog.setDogNames("");
                     dog.setDogId("");
            
            }if (action.equals("Update")) {
             
                dogDao.update(dog);
                 dog.setDogId("");
                    dog.setDogDob("");
                    dog.setDogNames("");
                     dog.setDogId("");
            } 
            
            
             return "dogowner";
        } catch (Exception e) {
           FacesMessage message = new FacesMessage("Fail to save , maybe you are trying to save an existing ID");
            FacesContext.getCurrentInstance().addMessage(null, message);
           return "dogowner"; 
            
        }
    
    
    
    }
    
   
}
    
    
    


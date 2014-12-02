package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import play.db.jpa.Model;

@Entity
@Table(name="`User`") //This is necessary because User is a reserved word in PostGreSQL
public class User extends Model
{
  public String firstName;
  public String lastName;
  public String email;
  public String password;
  
  @OneToMany(cascade = CascadeType.ALL)
  public List<Donation> donations = new ArrayList<Donation>();

  public User(String firstName, String lastName, String email, String password)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  } 
  
  public static User findByEmail(String email)
  {
    return find("email", email).first();
  }  
  
  public boolean checkPassword(String password)
  {
    return this.password.equals(password);
  }  
}
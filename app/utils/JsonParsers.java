package utils;

import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Donation;
import models.User;

public class JsonParsers
{
  static Gson gson = new Gson();

  public static User json2User(String json)
  {
    return gson.fromJson(json, User.class);   
  }

  public static List<User> json2Users(String json)
  {
    Type collectionType = new TypeToken<List<User>>() {}.getType();
    return gson.fromJson(json, collectionType); 
  }

  public static String user2Json(Object obj)
  {
    return gson.toJson(obj);
  }  

  public static Donation json2Donation(String json)
  {
    return gson.fromJson(json, Donation.class);    
  }

  public static String donation2Json(Object obj)
  {
    return gson.toJson(obj);
  }  

  public static List<Donation> json2Donations(String json)
  {
    Type collectionType = new TypeToken<List<Donation>>() {}.getType();
    return gson.fromJson(json, collectionType);    
  }  
}
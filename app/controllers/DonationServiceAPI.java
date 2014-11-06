package controllers;

import play.*;
import play.mvc.*;
import utils.JsonParsers;

import java.util.*;

import com.google.gson.JsonElement;

import models.*;

public class DonationServiceAPI extends Controller
{
  public static void users()
  {
    List<User> users = User.findAll();
    renderJSON(JsonParsers.user2Json(users));
  }

  public static void user(Long id)
  {
    User user = User.findById(id);  
    if (user == null)
    {
      notFound();
    }
    else
    {
      renderJSON(JsonParsers.user2Json(user));
    }
  }

  public static void createUser(JsonElement body)
  {
    User user = JsonParsers.json2User(body.toString());
    user.save();
    renderJSON(JsonParsers.user2Json(user));
  }

  public static void deleteUser(Long id)
  {
    User user = User.findById(id);
    if (user == null)
    {
      notFound();
    }
    else
    {
      user.delete();
      renderText("success");
    }
  }

  public static void deleteAllUsers()
  {
    User.deleteAll();
    renderText("success");
  }    

  public static void donations()
  {
    List<Donation> donations = Donation.findAll();
    renderText(JsonParsers.donation2Json(donations));
  }

  public static void donation (Long id)
  {
   Donation donation = Donation.findById(id);
   renderJSON (JsonParsers.donation2Json(donation));
  }

  public static void createDonation(JsonElement body)
  {
    Donation donation = JsonParsers.json2Donation(body.toString());
    Donation newDonation = new Donation (donation.amount, donation.method);
    newDonation.save();
    renderJSON (JsonParsers.donation2Json(newDonation));
  }  


  public static void deleteDonation(Long id)
  {
    Donation donation = Donation.findById(id);
    if (donation == null)
    {
      notFound();
    }
    else
    {
      donation.delete();
      ok();
    }
  }  
}
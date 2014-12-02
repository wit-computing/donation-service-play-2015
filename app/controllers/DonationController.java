package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class DonationController extends Controller
{
  public static void index()
  {
    User user = Accounts.getCurrentUser();
    String prog = getPercentTargetAchieved();
    String progress = prog;
    Logger.info("Donation ctrler : user is " + user.email);
    Logger.info("Donation ctrler : percent target achieved " + progress);
    List<Donation> donations = user.donations;
    render(user, progress, donations);
  }

  public static void donate(int amountDonated, String methodDonated)
  {
    User user = Accounts.getCurrentUser();
    Logger.info("amount donated " + amountDonated + " " + "method donated " + methodDonated);
    Donation donation = new Donation(amountDonated, methodDonated);
    user.donations.add(donation);
    user.save();
    index();
  }

  private static long getDonationTarget()
  {
    return 20000;
  }

  public static String getPercentTargetAchieved()
  {
    List<Donation> allDonations = Donation.findAll();
    long total = 0;
    for (Donation donation : allDonations)
    {
      total += donation.amount;
    }
    long target = getDonationTarget();
    long percentachieved = (total * 100 / target);
    String progress = String.valueOf(percentachieved);
    Logger.info("Percent of target achieved (string) " + progress + " percentachieved (long)= " + percentachieved);
    return progress;
  }

  public static void renderReport()
  {
    User user = Accounts.getCurrentUser();
    List<Donation> donations = user.donations;
    render(donations);
  }
}

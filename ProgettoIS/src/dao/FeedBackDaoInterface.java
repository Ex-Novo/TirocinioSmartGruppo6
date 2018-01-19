package dao;

import bean.Feedback;

import java.util.ArrayList;


public interface FeedBackDaoInterface {
  public boolean inviaFeedBackStudente(Feedback fb);
  
  public boolean inviaFeedBackAzienda(Feedback fb);
  
  public ArrayList<Feedback> getFeedBacks(String piva,String matricola, int idTirocinio);

  ArrayList<Feedback> getFeedBacksAzienda(String piva);
}

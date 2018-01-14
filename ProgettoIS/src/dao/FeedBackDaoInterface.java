package dao;

import bean.Feedback;

public interface FeedBackDaoInterface {
	public boolean inviaFeedBackStudente(Feedback fb);
	
	public boolean inviaFeedBackAzienda(Feedback fb);
	
	public Feedback getFeedBack(String piva,String matricola, int idTirocinio);
}

package businessLogic;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import entity.Sua;

public class SuaBL {
	private static final SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
	private static Session session = sessionFactory.openSession();
	
	public static List<Sua> docTatCa(){
		Query<Sua> query = session.createQuery("select s from Sua s",Sua.class);
		return query.getResultList();
	}

}

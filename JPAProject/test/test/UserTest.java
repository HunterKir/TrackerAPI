package test;

import static junit.framework.TestCase.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.User;

public class UserTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private User u;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("TrackerAPI");
		em = emf.createEntityManager();
		u = em.find(User.class, 1);
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
		u = null;
	}
	
	@Test
	public void test_user_preset_connection() {
		System.out.println(u.getPresets());
		assertEquals(2, u.getPresets().size());
	}
}

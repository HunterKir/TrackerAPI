package test;

import static junit.framework.TestCase.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Button;

public class ButtonTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Button b;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("TrackerAPI");
		em = emf.createEntityManager();
		b = em.find(Button.class, 1);
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
		b = null;
	}
	
	@Test
	public void test_button_preset_connection() {
		assertEquals(1, b.getPreset().getId());
	}
}

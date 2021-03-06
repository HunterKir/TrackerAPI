package test;

import static junit.framework.TestCase.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Preset;

public class PresetTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Preset p;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("TrackerAPI");
		em = emf.createEntityManager();
		p = em.find(Preset.class, 1);
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
		p = null;
	}
	
	@Test
	public void test_preset_button_connection() {
		assertEquals(2, p.getButtons().size());
	}
	
	@Test
	public void test_preset_user_connection() {
		assertEquals(1, p.getUser().getId());
	}
}

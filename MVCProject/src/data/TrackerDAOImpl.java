package data;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Button;
import entities.Preset;
import entities.User;

@Repository
@Transactional
public class TrackerDAOImpl implements TrackerDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Set<Preset> index(int userId) {
		User u = em.find(User.class, userId);
		Set<Preset> list = u.getPresets();
		return list;
	}

	@Override
	public Preset showPreset(int presId) {
		return em.find(Preset.class, presId);
	}

	@Override
	public boolean deletePreset(int presId) {
		Preset p = em.find(Preset.class, presId);
		em.remove(p);
		if (em.find(Preset.class, presId) == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteButton(int buttonId) {
		String q = "DELETE FROM Button b WHERE id = :id";
		em.createQuery(q).setParameter("id", buttonId).executeUpdate();
		if (em.find(Button.class, buttonId) == null) {
			return true;
		}
		return false;
	}

	@Override
	public Preset createPreset(int userId, String json) {
		ObjectMapper mapper = new ObjectMapper();
		User u = em.find(User.class, userId);
		try {
			Preset p = mapper.readValue(json, Preset.class);
			p.setUser(u);
			em.persist(p);
			em.flush();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Button createButton(int presId, String json) {
		ObjectMapper mapper = new ObjectMapper();
		Preset p = em.find(Preset.class, presId);
		try {
			Button b = mapper.readValue(json, Button.class);
			b.setPreset(p);
			em.persist(b);
			em.flush();
			return b;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User createUser(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			User u = mapper.readValue(json, User.class);
			em.persist(u);
			em.flush();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Preset updatePreset(int presId, String json) {
		ObjectMapper mapper = new ObjectMapper();
		Preset oldP = em.find(Preset.class, presId);
		try {
			Preset newP = mapper.readValue(json, Preset.class);
			oldP.setName(newP.getName());
			return oldP;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User updateUser(int userId, String json) {
		ObjectMapper mapper = new ObjectMapper();
		User oldU = em.find(User.class, userId);
		try {
			User newU = mapper.readValue(json, User.class);
			oldU.setUsername(newU.getUsername());
			oldU.setPassword(newU.getPassword());
			return oldU;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Button getButton(int buttonId) {
		return em.find(Button.class, buttonId);
	}

	@Override
	public Button updateButton(int buttonId, String json) {
		ObjectMapper mapper = new ObjectMapper();
		Button oldB = em.find(Button.class, buttonId);
		try {
			Button newB = mapper.readValue(json, Button.class);
			oldB.setCount(newB.getCount());
			return oldB;
		} catch (Exception e) {
		}
		return null;
	}
	
}

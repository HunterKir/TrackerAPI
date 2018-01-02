package data;

import java.util.Set;

import entities.Button;
import entities.Preset;
import entities.User;

public interface TrackerDAO {
	public Set<Preset> index(int userId);
	public Preset showPreset(int presId);
	public boolean deletePreset(int presId);
	public boolean deleteButton(int buttonId);
	public Preset createPreset(int userId, String json);
	public Button createButton(int presId, String json);
	public User createUser(String json);
	public Preset updatePreset(int presId, String json);
	public User updateUser(int userId, String json);
	public Button getButton(int buttonId);
	public Button updateButton(int buttonId, String json);
}

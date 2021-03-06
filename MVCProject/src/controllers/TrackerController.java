package controllers;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.TrackerDAO;
import entities.Button;
import entities.Preset;
import entities.User;

@RestController
public class TrackerController {
	
	@Autowired
	private TrackerDAO dao;
	
	@RequestMapping(path="users/{userId}/presets", method=RequestMethod.GET)
	public Set<Preset> index(@PathVariable int userId) {
		return dao.index(userId);
	}
	
	@RequestMapping(path="users/{userId}/presets/{presId}", method=RequestMethod.GET)
	public Preset show(@PathVariable int userId, @PathVariable int presId) {
		return dao.showPreset(presId);
	}
	
	@RequestMapping(path="users/{userId}/presets/{presId}", method=RequestMethod.DELETE)
	public void deletePreset(@PathVariable int userId, @PathVariable int presId, HttpServletResponse res) {
		if (dao.deletePreset(presId)) {
			res.setStatus(200);
		}
		else {
			res.setStatus(400);
		}
	}
	
	@RequestMapping(path="users/{userId}/presets/{presId}/buttons/{buttonId}", method=RequestMethod.DELETE)
	public void deleteButton(@PathVariable int userId, @PathVariable int presId, @PathVariable int buttonId, HttpServletResponse res) {
		if (dao.deleteButton(buttonId)) {
			res.setStatus(200);
		}
		else {
			res.setStatus(400);
		}
	}
	
	@RequestMapping(path="users/{userId}/presets", method=RequestMethod.POST)
	public Preset createPreset(@PathVariable int userId, @RequestBody String json, HttpServletResponse res) {
		Preset p = dao.createPreset(userId, json);
		if (p == null) {
			res.setStatus(400);
		}
		else {
			res.setStatus(201);
		}
		return p;
	}
	
	@RequestMapping(path="users/{userId}/presets/{presId}/buttons", method=RequestMethod.POST)
	public Button createButton(@PathVariable int userId, @PathVariable int presId, @RequestBody String json, HttpServletResponse res) {
		Button b = dao.createButton(presId, json);
		if (b == null) {
			res.setStatus(400);
		}
		else {
			res.setStatus(201);
		}
		return b;
	}
	
	@RequestMapping(path="users", method=RequestMethod.POST)
	public User createUser(@RequestBody String json, HttpServletResponse res) {
		User u = dao.createUser(json);
		if (u == null) {
			res.setStatus(400);
		}
		else {
			res.setStatus(201);
		}
		return u;
	}
	
	@RequestMapping(path="users/{userId}/presets/{presId}", method=RequestMethod.PUT)
	public Preset updatePreset(@PathVariable int userId, @PathVariable int presId, @RequestBody String json, HttpServletResponse res) {
		Preset p = dao.updatePreset(presId, json);
		if (p == null) {
			res.setStatus(400);
		}
		else {
			res.setStatus(200);
		}
		return p;
	}
	@RequestMapping(path="users/{userId}", method=RequestMethod.PUT)
	public User updateUser(@PathVariable int userId, @RequestBody String json, HttpServletResponse res) {
		User u = dao.updateUser(userId, json);
		if (u == null) {
			res.setStatus(400);
		}
		else {
			res.setStatus(200);
		}
		return u;
	}
	
	@RequestMapping(path="users/{userId}/presets/{presId}/buttons/{buttonId}", method=RequestMethod.GET)
	public Button getButton(@PathVariable int userId, @PathVariable int presId, @PathVariable int buttonId) {
		return dao.getButton(buttonId);
	}
	
	@RequestMapping(path="users/{userId}/presets/{presId}/buttons/{buttonId}", method=RequestMethod.PUT)
	public Button updateButtton(@PathVariable int userId, @PathVariable int presId, @PathVariable int buttonId, @RequestBody String json, HttpServletResponse res) {
		Button b = dao.updateButton(buttonId, json);
		if (b == null) {
			res.setStatus(400);
		}
		else {
			res.setStatus(200);
		}
		return b;
	}
}

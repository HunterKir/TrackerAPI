package listener;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TimerTask;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UpdateDB extends TimerTask {
	private int userId;
	private int presId;
	private int buttonId;
	private int count;
	
	public UpdateDB(int user, int preset, int button) {
		this.userId = user;
		this.presId = preset;
		this.buttonId = button;
		System.out.println("updatedb created");
	}
	
	@Override
	public void run() {
		System.out.println("running update");
		URL url;
		StringBuilder sb = new StringBuilder();
		String response;
		try {
			url = new URL("http://18.216.163.200:8080/TrackerAPI/api/users/"+ userId + "/presets/" + presId + "/buttons/"+ buttonId);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("GET");
			BufferedInputStream stream = new BufferedInputStream(httpCon.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(stream));
			String inputLine = "";
			while ((inputLine = br.readLine()) != null) {
	            sb.append(inputLine);
	        }
	        response = sb.toString();
	        ObjectMapper mapper = new ObjectMapper();
	        Key b = mapper.readValue(response, Key.class);
	        count += b.getCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			url = new URL("http://18.216.163.200:8080/TrackerAPI/api/users/"+ userId + "/presets/" + presId + "/buttons/"+ buttonId);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("PUT");
			OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
			out.write("{\"count\": " + count + ",\"value\": 0}");
			out.close();
			httpCon.getInputStream();
			count = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateCount() {
		this.count++;
	}

}

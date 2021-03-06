package listener;

import java.util.Timer;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyListener implements NativeKeyListener {
	private int key;
	private UpdateDB update;
	private Timer timer = new Timer();
	
	public GlobalKeyListener(int key, int user, int preset, int button) {
		this.key = key;
		this.update = new UpdateDB(user, preset, button);
		System.out.println("listener created");
		timer.schedule(update, 0, 30000);
	}
	
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (e.getKeyCode() == key) {
			update.updateCount();
		}
	}
	
	public void forceUpdate() {
		update.run();
	}

	public void nativeKeyReleased(NativeKeyEvent e) {
//		System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
//		System.out.println("Key Released: " + e.getKeyCode());
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
//		System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
	}
}
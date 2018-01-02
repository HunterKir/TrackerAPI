package listener;

import java.util.Timer;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
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
		System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		System.out.println("Key Pressed: " + e.getKeyCode());

		if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
			try {
				update.updateCount();
				update.run();
				GlobalScreen.unregisterNativeHook();
				System.exit(1);
			} catch (NativeHookException ex) {
				ex.printStackTrace();
			}
		}
		if (e.getKeyCode() == key) {
			update.updateCount();
		}
	}

	public void nativeKeyReleased(NativeKeyEvent e) {
//		System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
//		System.out.println("Key Released: " + e.getKeyCode());
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
//		System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
	}
}
package listener;


import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class ExitListener implements NativeKeyListener {
	private int key;
	public boolean flag;
	
	
	public ExitListener(int key) {
		this.key = key;
		this.flag = false;
		System.out.println("exit listener created");
	}
	
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (e.getKeyCode() == key) {
			flag = true;
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
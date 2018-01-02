package listener;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class ListenerExe {
	public static void main(String[] args) {
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}
		for (int i = 0; i < args.length; i += 4) {
			int user = Integer.parseInt(args[i]);
			int preset = Integer.parseInt(args[i + 1]);
			int button = Integer.parseInt(args[i + 2]);
			int keyToCount = Integer.parseInt(args[i + 3]);
			GlobalScreen.addNativeKeyListener(new GlobalKeyListener(keyToCount, user, preset, button));
		}
		System.out.println("loading complete");
	}
}
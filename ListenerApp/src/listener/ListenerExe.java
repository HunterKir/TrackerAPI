package listener;

import java.util.ArrayList;
import java.util.List;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class ListenerExe {
	private static List<GlobalKeyListener> list = new ArrayList<>();
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
			GlobalKeyListener gkl = new GlobalKeyListener(keyToCount, user, preset, button);
			GlobalScreen.addNativeKeyListener(gkl);
			list.add(gkl);
		}
		ExitListener exit = new ExitListener(1);
		GlobalScreen.addNativeKeyListener(exit);
		System.out.println("loading complete");
		while (true) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (exit.flag) {
				System.out.println("   Shutting Down");
				for (GlobalKeyListener globalKeyListener : list) {
					globalKeyListener.forceUpdate();
				}
				System.exit(1);
			}
		}
	}
}
package listener;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ListenerExeTest extends Application{
	private static List<GlobalKeyListener> list = new ArrayList<>();
	public static void main(String[] args) {
		Application.launch(args);
//		try {
//			GlobalScreen.registerNativeHook();
//		}
//		catch (NativeHookException ex) {
//			System.err.println("There was a problem registering the native hook.");
//			System.err.println(ex.getMessage());
//
//			System.exit(1);
//		}
//		for (int i = 0; i < args.length; i += 4) {
//			int user = Integer.parseInt(args[i]);
//			int preset = Integer.parseInt(args[i + 1]);
//			int button = Integer.parseInt(args[i + 2]);
//			int keyToCount = Integer.parseInt(args[i + 3]);
//			GlobalKeyListener gkl = new GlobalKeyListener(keyToCount, user, preset, button);
//			GlobalScreen.addNativeKeyListener(gkl);
//			list.add(gkl);
//		}
//		ExitListener exit = new ExitListener(1);
//		GlobalScreen.addNativeKeyListener(exit);
//		System.out.println("loading complete");
//		while (true) {
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			if (exit.flag) {
//				System.out.println("   Shutting Down");
//				for (GlobalKeyListener globalKeyListener : list) {
//					globalKeyListener.forceUpdate();
//				}
//				System.exit(1);
//			}
//		}
	}
	private int counter = 0;
	private String text = "Times Pressed : " + counter;
	@Override
	public void start(Stage stage) throws Exception {
        Button button = new Button();
        Button button2 = new Button();
        button2.setText("test");
        button.setText(text);
        button.setOnAction((ActionEvent event) -> {incrementCounter();button.setText(text);});
        VBox box = new VBox();
        box.setSpacing(10);
        box.setPadding(new Insets(0, 20, 10, 20));
        box.getChildren().addAll(button, button2);
        Scene scene = new Scene(box, 300, 300);
        stage.setTitle("TrackerAPI"); 
        stage.setScene(scene); 
        stage.sizeToScene(); 
        stage.show();
		
	}
	final private void incrementCounter() {
		text = "Times Pressed : " + ++counter;
	}
}
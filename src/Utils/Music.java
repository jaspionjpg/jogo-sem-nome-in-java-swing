package Utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Music implements Runnable {
	String file;
	
	public Music(String file) {
		this.file = file;
	}

	@Override
	public void run() {
		try {
			FileInputStream in = new FileInputStream(file);
			Player p = new Player(in);
			p.play();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
}
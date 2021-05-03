package Control;


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonido {
	// objetos soportados

//	private JButton jButton;
	private Clip clip;
//	// paquete donde se encuentran los archivos de sonido WAV
	private String path = "/Sonidos/";

	// metodo que reproduce un sonido del paquete WAV
	public void daleplay(String value) {
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getClass().getResource(path + value + ".wav")));
			clip.start();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}

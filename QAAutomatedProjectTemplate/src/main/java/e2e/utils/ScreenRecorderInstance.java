package e2e.utils;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.monte.screenrecorder.ScreenRecorder;

public class ScreenRecorderInstance {

	private static ScreenRecorderInstance screenRecorder;
	
	private GraphicsConfiguration gc;
	private ScreenRecorder recorder;
	
	private ScreenRecorderInstance() throws IOException, AWTException {
		 gc = GraphicsEnvironment
	                .getLocalGraphicsEnvironment()
	                .getDefaultScreenDevice()
	                .getDefaultConfiguration();
		 
		 setUpDefualtVideoConfiguration();
		
	}
	
	
	private void setUpDefualtVideoConfiguration() throws IOException, AWTException {
		recorder = new ScreenRecorder(gc);
	}
	
	public ScreenRecorderInstance getInstance() throws IOException, AWTException {
		if (null == screenRecorder) {
			screenRecorder = new ScreenRecorderInstance();
		}
		return screenRecorder;
	}
	
	public void startRecording() throws IOException {
		recorder.start();
	}
	
	
	public void setMovieLocation(String location) {

	}
	public void stopRecording() throws IOException {
		 recorder.stop();
	        List<File> createdMovieFiles = recorder.getCreatedMovieFiles();
	        for(File movie : createdMovieFiles){
	            System.out.println("New movie created: " + movie.getAbsolutePath());
	        }
	}

}

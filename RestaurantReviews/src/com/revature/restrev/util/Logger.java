package com.revature.restrev.util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *Class that takes in any events I want to record and write it to some file
 * @author MarielleNolasco
 *	
 */
public class Logger {
	
	private void writeToFile(String message) {
		// try with resources block - opens a resource then closes it once the code block finishes execution
		try (FileWriter writer = new FileWriter(LocalDate.now().toString()+".log", true)){
			writer.append(message+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void log(LogLevel logLevel, String message) {
		Log newLog = new Log(logLevel, LocalDateTime.now(), message);
		writeToFile(newLog.toString());
	}
	
	private class Log{
		LogLevel logLevel; 
		LocalDateTime timestamp; 
		String message;
		
		public Log(LogLevel logLevel, LocalDateTime timestamp, String message) {
			super();
			this.logLevel = logLevel;
			this.timestamp = timestamp;
			this.message = message;
		}
		@Override
		public String toString() {
			return logLevel + "\t" + timestamp + "\t" + message ;
		}
		
	}
	//enum is a type that allows you to set constant values
	public enum LogLevel{
		info, debug, verbose, warning, fatal, error
	}

}

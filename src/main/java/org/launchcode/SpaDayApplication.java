package org.launchcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class SpaDayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaDayApplication.class, args);
	}

//	@EventListener({ApplicationReadyEvent.class})
//	void applicationReadyEvent() {
//		System.out.println("Application started, launching browser.");
//		browse("http://localhost:8080");	// Replace with desired URL.
//	}

	public static void browse(String url) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URI(url));
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Runtime.getRuntime().exec("open " + url);		// MacOS
//				Runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);	// Windows
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

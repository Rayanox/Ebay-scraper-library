package com.rb.scrappers;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rb.config.AppConfig;
import com.rb.modele.Event;

@Component
public class ScrappingFacade {

	private WebDriver driver;
	private LoginDelegate loginDelegate;

	@Autowired
	private AppConfig config;

	public ScrappingFacade() throws Exception {
		this.driver = new ChromeDriver();
	}

	@PostConstruct
	public void initiateScrapper() {
		this.loginDelegate = new LoginDelegate(driver);
		this.loginDelegate.logIn(config.username, config.password);
	}

	/*
	 * FACADE METHODS
	 */

	public double GetRatioForEvent(Event event) throws Exception {
		checkPlaceholdersNeeded();

		System.err.println("'GetRatioForEvent' not implemented yet. Returning 0");
		return 0;
	}

	public ArrayList<Event> GatherNewEvents() throws Exception {
		checkPlaceholdersNeeded();

		System.err.println("'GetRatioForEvent' not implemented yet. Returning an empty list");
		return new ArrayList<>();
	}

	/*
	 * PRIVATES METHODS
	 */

	private void checkPlaceholdersNeeded() throws Exception {
		if (config.username == null || config.password == null) {
			throw new Exception(
					"At least one of the placeholders needed in 'ScrappingFacade' is missing. (ex: ${facebook.username}, ${facebook.password}");
		}

	}
}

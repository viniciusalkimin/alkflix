package model;

import java.time.format.DateTimeFormatter;

public class Movie implements Content{
	
	private String name;
	private Integer timeDuration;
	private DateTimeFormatter dataLancamento;
	private Genre genre;
	private StateOfContent stateOfContent = StateOfContent.UNINITIALIZED;

	

}

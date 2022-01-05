package model;

import java.time.format.DateTimeFormatter;

public class Serie implements Content {
	
	private String name;
	private Integer numberOfSeasons;
	private Integer numberOfEpisodies;
	private DateTimeFormatter dataLancamento;
	private Genre genre;
	private StateOfContent stateOfContent = StateOfContent.UNINITIALIZED;

}

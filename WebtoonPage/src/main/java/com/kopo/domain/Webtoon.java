package com.kopo.domain;

public class Webtoon {
	private String name;
	private String imagPath;
	private String ranking;
	private String website;
	private String author;
	private String description;
	private int hits;
	private String releaseDay;
	private String condition;
	private String genre;
	
	
	
	public Webtoon(String name, String imagPath) {
		super();
		this.name = name;
		this.imagPath = imagPath;
	}
	
	public Webtoon() {//기본생성자
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagPath() {
		return imagPath;
	}

	public void setImagPath(String imagPath) {
		this.imagPath = imagPath;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getReleaseDay() {
		return releaseDay;
	}

	public void setReleaseDay(String releaseDay) {
		this.releaseDay = releaseDay;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	
	
	
}

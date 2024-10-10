package PoJoPracticeGetters;

public class AllDetails {
	
	private String instructor;
	private String url;
	private String services;
	private String expertise;
	private Courses courses;
	private String linkedIn;
	public Courses getCourses() {
		return courses;
	}
	public void setCourses(Courses courses) {
		this.courses = courses;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	
	private String getInstructor()
	{
		return instructor;
	}
	public void setInstructor(String instructor)
	{
		this.instructor = instructor;
	}
	private String setLinkedIn()
	{
		return linkedIn;
	}
	public void getLinkedIn(String linkedIn)
	{
		this.linkedIn = linkedIn;
	}
}

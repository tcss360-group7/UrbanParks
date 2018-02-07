package model;
import java.time.LocalDate;

public class Job {
	
	/**
	 * The job's ID generated using java's hashCode function.
	 */
	private final int myJobID;
	
	/**
	 * The job's start date.
	 */
	private LocalDate myStartDate;
	
	/**
	 * The job's end date.
	 */
	private LocalDate myEndDate;
	
	/**
	 * The park name this job will be at.
	 */
	private String myParkName;
	
	/**
	 * The park manager that manages this park.
	 */
	private ParkManager myPM;
	
	/**
	 * The job's location: city and  state (for example: Seattle, WA)
	 */
	private String myLocation;
	
	/**
	 * Constructs a job using start date, end date, park name, park manager, and location.
	 * @param theStartDate The job's start date
	 * @param theEndDate The job's end date
	 * @param theParkName The park name this job will be at.
	 * @param thePM The park manager that manages this job.
	 * @param theLocation The job's location: city and  state (for example: Seattle, WA)
	 */
	public Job(final LocalDate theStartDate, final LocalDate theEndDate, final String theParkName,
			final ParkManager thePM, final String theLocation) {
		myStartDate = theStartDate;
		myEndDate = theEndDate;
		myParkName = theParkName;
		myPM = thePM;
		myJobID = this.hashCode();
		myLocation = theLocation;
	}
	
	/**
	 * Returns the job ID.
	 * @return The job ID
	 */
	public int getJobID() {
		return myJobID;
	}
	
	/**
	 * Returns the job's start date.
	 * @return The job's start date
	 */
	public LocalDate getStartDate() {
		return myStartDate;
	}
	
	/**
	 * Sets the job's start date.
	 * @param myStartDate The start date
	 */
	public void setStartDate(final LocalDate myStartDate) {
		this.myStartDate = myStartDate;
	}
	
	/**
	 * Returns the job's end date.
	 * @return The job's end date
	 */
	public LocalDate getEndDate() {
		return myEndDate;
	}

	/**
	 * Set the job's end date.
	 * @param myEndDate The job's end date
	 */
	public void setEndDate(final LocalDate myEndDate) {
		this.myEndDate = myEndDate;
	}
	
	/**
	 * Returns the park name this job will be at.
	 * @return The park name this job will be at
	 */
	public String getParkName() {
		return myParkName;
	}
	
	/**
	 * Sets the park name this job will be at.
	 * @param myParkName The park name this job will be at
	 */
	public void setParkName(final String myParkName) {
		this.myParkName = myParkName;
	}

	/**
	 * Returns the park manager that manages this park.
	 * @return
	 */
	public ParkManager getPM() {
		return myPM;
	}

	/**
	 * Sets the park manager that manages this park.
	 * @param myPM
	 */
	public void setPM(final ParkManager myPM) {
		this.myPM = myPM;
	}

	/**
	 * Returns the location of this job.
	 * @return the location of this job
	 */
	public String getMyLocation() {
		return myLocation;
	}

	/**
	 * Set the location of this job.
	 * @param myLocation the location of this job
	 */
	public void setMyLocation(String myLocation) {
		this.myLocation = myLocation;
	}
}

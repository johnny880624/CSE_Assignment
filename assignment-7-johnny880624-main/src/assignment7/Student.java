package assignment7;

public class Student {
	private String firstName;
	private String lastName;
	private int id;
	private int attempted_credits;
	private int passing_credits;
	private double totalGradeQualityPoints;
	private double bearBucksBalance;
		
	// constructor
	public Student(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.attempted_credits = 0;
        this.passing_credits = 0;
        this.totalGradeQualityPoints = 0;
        this.bearBucksBalance = 0;
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getTotalAttemptedCredits() {
		return this.attempted_credits;
	}
	
	public int getTotalPassingCredits() {
		return this.passing_credits;
	}
	
	public double calculateGradePointAverage() {
		return this.totalGradeQualityPoints / this.attempted_credits;
	}
	
	public void submitGrade(double grade, int credits) {
		this.attempted_credits = this.attempted_credits + credits;
		if (grade >= 1.7) {
			this.passing_credits = this.passing_credits + credits;
		}
		this.totalGradeQualityPoints = this.totalGradeQualityPoints + (grade * credits); 		
	}
	
	public String getClassStanding() {
		if (this.passing_credits < 30) {
			return "First Year";
		} else if (this.passing_credits < 60) {
			return "Sophomore";
		} else if (this.passing_credits < 90) {
			return "Junior";
		} else {
			return "Senior";
		}	
	}
	
	public boolean isEligibleForPhiBetaKappa() {
		if (this.calculateGradePointAverage() >= 3.6 && this.passing_credits >= 98) {
			return true;
		} else if(this.calculateGradePointAverage() >= 3.8 && this.passing_credits >= 75) {
			return true;
		} else {
			return false;
		}
	}
	
	public void depositBearBucks(double amount) {
		this.bearBucksBalance += amount;
	}
	
	public void deductBearBucks(double amount) {
		this.bearBucksBalance -= amount;
	}
	
	public double getBearBucksBalance() {
		return this.bearBucksBalance;
	}
	
	public double cashOutBearBucks() {
		if (this.bearBucksBalance >= 10) {
			double temp_value = this.bearBucksBalance -10;
			this.bearBucksBalance = 0;
			return temp_value;
		} else {
			this.bearBucksBalance = 0;
			return 0;
		}
	}
	
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		if (isHyphenated) {
			 Student legacy = new Student(firstName, this.lastName +"-"+ otherParent.lastName, id);
			 legacy.depositBearBucks(this.cashOutBearBucks());
			 legacy.depositBearBucks(otherParent.cashOutBearBucks());
			 return legacy;
		}
		else {
			Student legacy = new Student(firstName, this.lastName, id);
			legacy.depositBearBucks(this.cashOutBearBucks());
			legacy.depositBearBucks(otherParent.cashOutBearBucks());
			return legacy;
		}
	}

	public String toString() {
		return this.getFullName() +this.getId();
	}
}

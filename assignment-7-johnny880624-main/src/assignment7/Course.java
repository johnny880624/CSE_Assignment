package assignment7;

public class Course {
	// instance variable
	private String name;
	private int credits;
	private int capacity;
	Student[] inclassStudent;
	int remainingSeat;
	int index;
	
	
	public Course(String name, int credits, int capacity) {
		this.name = name;
		this.credits = credits;
		this.capacity = capacity;
		this.inclassStudent = new Student[capacity];
		this.index = 0;
		this.remainingSeat = capacity;
		
	}
	
	public String getName() {
		return this.name;
	}
	public int getCredits() {
		return this.credits;
	}
	public int getCapacity() {
		return this.capacity;
	}
	
	public int getSeatsRemaining() {
		return this.remainingSeat;
	}
	
	public boolean addStudent(Student s) {
		boolean canAdd = true;
		if (this.remainingSeat >0) {
			for (int i = 0; i< this.index; i++) {
				if (this.inclassStudent[i] == s && canAdd == true) {
					// meaning this student has already signed up for this course so we don't have to do
					// it again.
					canAdd = false;
				}
			}
			
			// if there is truly some available seats left, we add the input student in the class list 
			// and return true. representing that student successfully enrolls in the class.
			if (canAdd == true) {
				this.inclassStudent[this.index] = s;
				this.index ++;
				this.remainingSeat --;
				return true;
			}
		}	
		// return false represents we can not enroll this student again because he/she has already in the class.
		if (canAdd == false) {
			return false;
		}
		// There no available seat left for additional students to add in. 
		return false;
	}
	
	
	public boolean addStudent1(Student s) {
        if (this.remainingSeat > 0) {
            for (int i = 0; i < this.index; i++) {
                if (this.inclassStudent[i]== s) {
                    return false; // Student already enrolled
                }
            }

            this.inclassStudent[this.index] = s;
            this.index++;
            this.remainingSeat--;
            return true;
        }
        return false; // No seats remaining
    }
	
	public Student getStudentAt(int index) {
		return inclassStudent[index];

	}
	
	public String generateRoster() {
		String rosterList = "";
		for (int i=0; i < this.index; i++) {
			rosterList = rosterList +", " + inclassStudent[i].getFullName();
		}
		return rosterList;
	}
	
	public double calculateAverageGPA() {
		double totalGPA = 0.0;
		for (int i=0; i < this.index; i++) {
			totalGPA = totalGPA + inclassStudent[i].calculateGradePointAverage();
		}
		return totalGPA/this.index;
	}
	
	public String toString() {
		return this.getName()+ this.getCredits();
	}
}

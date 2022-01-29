import Exceptions.InvalidStudentException;

public class Student {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    ScoresAndCourses[] scoresAndCourses;
    private Integer scoresAndCoursesIndex = 0;

    public Student(String username, String password, String firstName, String lastName) {
    }


    public void saveCourseAndScore(ScoresAndCourses scoresAndCourses) {
        this.scoresAndCourses[scoresAndCoursesIndex++] = scoresAndCourses;
    }

    public Student(String userName, String password, String firstName, String lastName, ScoresAndCourses[] scoresAndCourses) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.scoresAndCourses = scoresAndCourses;
    }

    public ScoresAndCourses[] getScoresAndCourses() {
        return scoresAndCourses;
    }

    public void setScoresAndCourses(ScoresAndCourses[] scoresAndCourses) {
        this.scoresAndCourses = scoresAndCourses;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void InvalidStudent(){
       throw new InvalidStudentException("there is no student with this index! ");
    }

}

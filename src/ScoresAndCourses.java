import Exceptions.InvalidCourseException;
import Exceptions.InvalidScoreException;
import Exceptions.InvalidStudentException;
import Exceptions.InvalidUnitException;

public class ScoresAndCourses {
    private Integer score;
    private String course;
    private Integer unit;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public ScoresAndCourses(Integer score, String course, Integer unit) {
        scoreValidator(score);
        unitValidator(unit);
        this.score = score;
        this.course = course;
        this.unit = unit;
    }

    public void scoreValidator(Integer score) {
        if (!(score < 21) && !(score >= 0)) {
            throw new InvalidScoreException("Invalid score entered , score must be between 0 and 20 ");
        }

    }

    public void unitValidator(Integer unit) {
        if (!(unit > 0) && !(unit < 5)) {
            throw new InvalidUnitException("Invalid unit entered , unit must be between 1 and 4 ");
        }
    }
    public void InvalidCourseList(){
        throw new InvalidStudentException("there is no course in CourseList! ");
    }
    public void InvalidCourse(){
        throw new InvalidCourseException("there is no with that name ");
    }
}

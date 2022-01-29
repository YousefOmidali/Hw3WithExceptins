import Exceptions.InvalidScoreException;
import Exceptions.InvalidStudentException;
import Exceptions.InvalidUnitException;

public class Methods {
    private Student[] student;
    private Master[] master;
    private Employee[] employee = new Employee[20000];
    private ScoresAndCourses[] listOfCourses = new ScoresAndCourses[50000];
    private Integer studentIndex = 0;
    private Integer masterIndex = 0;
    private Integer employeeIndex = 0;
    private Integer listOfCoursesIndex = 0;


    public void signUpStudent(Student student) {
        this.student[studentIndex] = student;
        studentIndex++;
    }

    public void removeStudent(Integer index) {
        this.student[index] = student[studentIndex];
        student[studentIndex] = null;
        studentIndex--;
    }

    public void editStudent(Integer index, String firstName, String lastName, String username, String password) {
        student[index].setFirstName(firstName);
        student[index].setLastName(lastName);
        student[index].setUserName(username);
        student[index].setPassword(password);
    }

    public void signUpMaster(Master master) {
        this.master[masterIndex] = master;
        masterIndex++;
    }

    public void removeMaster(Integer index) {
        for (int i =(index+1) ; i < masterIndex ; i++) {
            master[index]=master[i];
            index++;
        }
        master[(masterIndex-1)]=null;
        masterIndex--;
    }

    public void editMaster(Integer index,Master master) {
        this.master[index].setFirstName(master.getFirstName());
        this.master[index].setLastName(master.getLastName());
        this.master[index].setUserName(master.getUserName());
        this.master[index].setPassword(master.getPassword());
        this.master[index].setMasterLevel(master.getMasterLevel());
        this.master[index].setTedadJalasatTadris(master.getTedadJalasatTadris());
    }

    public void signUpEmployee(Employee employee) {
        this.employee[employeeIndex] = employee;
        employeeIndex++;
    }

    public void removeEmployee(Integer index) {
        for (int i =(index+1) ; i < employeeIndex ; i++) {
            employee[index]=employee[i];
        }
        employee[(employeeIndex-1)]=null;
        employeeIndex--;
    }

    public void editEmployee(Integer index,Employee employee) {
        this.employee[index].setFirstName(employee.getFirstName());
        this.employee[index].setLastName(employee.getLastName());
        this.employee[index].setUserName(employee.getUserName());
        this.employee[index].setPassword(employee.getPassword());
        this.employee[index].setSalary(employee.getSalary());
    }

    public void viewEmployeeSalaryAndInfo(Integer index) {
        System.out.println(employee[index].toString());
    }

    public void addCourse(String courseName, Integer unit) {
        this.listOfCourses[listOfCoursesIndex].setCourse(courseName);
        listOfCourses[listOfCoursesIndex].setUnit(unit);
        listOfCoursesIndex++;
    }

    public void editCourse(Integer courseIndex, String newCurseName, Integer unit) {
        listOfCourses[courseIndex].setCourse(newCurseName);
        listOfCourses[courseIndex].setUnit(unit);
    }

    public void removeCourse(Integer courseIndex) {
        for (int i =(courseIndex+1) ; i < listOfCoursesIndex ; i++) {
            listOfCourses[courseIndex]=listOfCourses[i];
            courseIndex++;
        }
        master[(listOfCoursesIndex-1)]=null;
        listOfCoursesIndex--;
    }

    public void studentInfo(Integer studentIndex) {
            System.out.println(student[studentIndex]);

    }

    public void viewCourseList() {
        for (int i = 0; i < listOfCoursesIndex; i++) {
            System.out.println(listOfCourses[i].getCourse());
        }
    }

    public String scoreAverage(Integer studentIndex) {
        int avg = 0;
        String stats;
        int i;
        for (i = 0; i < student[studentIndex].getScoresAndCourses().length; i++) {
            avg += student[studentIndex].getScoresAndCourses()[i].getScore();
        }
        avg = avg / ++i;
        if (avg>=18)
            stats="you can take upto 24 units";
        else stats="you can take upto 20 units";
        return stats ;
    }

    public Boolean passCourseCheck(Integer studentIndex, String courseName) {
        boolean stats = true;
        for (int i = 0; i < student[studentIndex].getScoresAndCourses().length; i++) {
            if (student[studentIndex].getScoresAndCourses()[i].getCourse().equals(courseName)
                    && student[studentIndex].getScoresAndCourses()[i].getScore() < 10) {
                stats = false;
                break;
            }
        }
        return stats;
    }

    public String viewCoursesAndScoresToStudent(Integer studentIndex) {   //namaayesh dars ha va nomarate student
        String showTakkenCoursesAndScores = "";
        for (int i = 0; i < student[studentIndex].getScoresAndCourses().length; i++) {
            showTakkenCoursesAndScores += student[studentIndex].getScoresAndCourses()[i].getCourse() + ": " +
                    student[studentIndex].getScoresAndCourses()[i] + " \n";

        }
        return showTakkenCoursesAndScores;
    }

    public void masterInfo(Integer masterIndex) {
        System.out.println(master[masterIndex]);
    }

    public void scoreRegister(Integer studentIndex, String courseName, Integer score) {
        for (int i = 0; i < student[studentIndex].getScoresAndCourses().length; i++) {
            if (student[studentIndex].getScoresAndCourses()[i].getCourse().equals(courseName) &&
                    student[studentIndex].getScoresAndCourses()[i].getScore().equals(null)) {
                student[studentIndex].getScoresAndCourses()[i].setScore(score);
            }
        }
    }

    public Integer paySlip(Integer masterIndex, Integer tedadTermeTadris) {
        Integer salary = 0;
        if (master[masterIndex].getMasterLevel().equals(MasterLevel.HEIATELMI)) {
            salary = 7000000;
            salary += (tedadTermeTadris * 1000000);
        } else if (master[masterIndex].getMasterLevel().equals(MasterLevel.HAGHOTADRIS))
            salary = (tedadTermeTadris * 1000000);

        return salary;
    }

    public Boolean masterCheck(String username, String password) {
        Boolean status=false;
        for (int i = 0; i < masterIndex; i++) {
            if (master[i].getUserName().equals(username) && master[i].getPassword().equals(password))
                status =true;
        }
        return status;
    }
    public Boolean studentCheck(String username, String password) {
        boolean status = false;
        for (int i = 0; i < studentIndex; i++) {
            if (student[i].getUserName().equals(username) && student[i].getPassword().equals(password))
                status=true;
        }
        return status;
    }
    public Boolean employeeCheck(String username, String password) {
        Boolean status = false;
        for (int i = 0; i < employeeIndex; i++) {
            if (employee[i].getUserName().equals(username) && employee[i].getPassword().equals(password))
                status=true;
        }
        return status;
    }



    public static void showLoginMenu() {
        System.out.println("***************Login Menu***************" + "\nWhat are you? \n1.Student \n2.Master \n3.Employee ");
    }
    public static void studentMenu() {
        System.out.println("***************Student Menu***************" + "\n1.Student Info \n2.Courses List \n3.Units check \n4.Exit");
    }
    public static void masterMenu() {
        System.out.println("***************Master Menu***************" + "\n1.Master Info \n2.Score register \n3.View PaySlip \n4.Exit");
    }
    public static void employeeMenu() {
        System.out.println("***************Employee Menu***************" + "\n1.Student register \n2.Delete student \n3.Edit student info's" +
                 "\n4.Master register \n5.Delete master \n6.Edit master's info " +
                        "\n7.Employee register \n8.Delete employee \n9.Edit employees info " +
                                "\n10.Add a course \n11.Delete course \n12.Edit course" +
                                       "\n13.Employees payslip and info  \n.Exit");
    }

    public void signUpStudent(String username, String password, String firstName, String lastName) {
    }
}

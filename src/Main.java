import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Methods methods = new Methods();
        boolean stats1 = true ;
        boolean stats2 = false;
        int inputNumber = -1, salary, unit;
        String firstName, lastName, username, password, courseNameInMain;


        while (stats1) {
            methods.showLoginMenu();
            int loginStats = -1;
            inputNumber = scanner.nextInt();
            scanner.nextLine();
            if (inputNumber == 1) {
                System.out.println("Please enter your username: ");
                username = scanner.nextLine();
                System.out.println("Please enter your password: ");
                password = scanner.nextLine();
                if (inputNumber == 1) {
                    loginStats = methods.studentCheck(username, password);
                    if (loginStats == 1) {
                        stats1 = false;
                        stats2 = true;
                        break;
                    }
                }


            } else if (inputNumber == 2) {
                System.out.println("Please enter your username: ");
                username = scanner.nextLine();
                System.out.println("Please enter your password: ");
                password = scanner.nextLine();
                loginStats = methods.masterCheck(username, password);
                if (loginStats == 1) {
                    stats1 = false;
                    stats2 = true;
                    break;
                }
            } else if (inputNumber == 3) {
                System.out.println("Please enter your username: ");
                username = scanner.nextLine();
                System.out.println("Please enter your password: ");
                password = scanner.nextLine();
                loginStats = methods.employeeCheck(username, password);
                if (loginStats == 1) {
                    stats1 = false;
                    stats2 = true;
                    break;
                }
            } else {
                System.out.println("Wrong number");
            }
        }
        while (stats2) {
            int order;
            int index;
            int studentIndexInMain;
            int score;
            int tedadJalasatTadris;
            String courseName;
            System.out.println("please enter your student index: ");
            index = scanner.nextInt();
            if (inputNumber == 1) {
                methods.studentMenu();
                order = scanner.nextInt();
                if (order == 1)
                    methods.studentInfo(index);
                else if (order == 2)
                    methods.viewCourseList();
                else if (order == 3) {
                    System.out.println(methods.scoreAverage(index));
                    System.out.println("Check that can you take a course? Enter the course name: "); // check baraye bar nadashtane yek dars , 2 bar
                    courseNameInMain = scanner.nextLine();
                    if (methods.passCourseCheck(index, courseNameInMain))
                        System.out.println("Allowed");
                    else System.out.println("You have passed this course once! ");

                } else if (order == 4) {
                    stats1 = true;
                    stats2 = false;
                    break;
                } else System.out.println("Wrong number! ");
            } else if (inputNumber == 2) {
                methods.masterMenu();
                order = scanner.nextInt();
                System.out.println("please enter your Master index: ");
                index = scanner.nextInt();
                if (order == 1)
                    methods.masterInfo(index);
                else if (order == 2) {
                    System.out.println("Enter the student's Index: ");
                    studentIndexInMain = scanner.nextInt();
                    System.out.println("Enter course name: ");
                    courseName = scanner.nextLine();
                    System.out.println("Enter the score: ");
                    score = scanner.nextInt();
                    methods.scoreRegister(studentIndexInMain, courseName, score);
                } else if (order == 3) {
                    System.out.println("Please enter number session you have teached: ");
                    tedadJalasatTadris = scanner.nextInt();
                    System.out.println(methods.paySlip(index, tedadJalasatTadris));
                } else if (order == 4) {
                    stats1 = true;
                    stats2 = false;
                    break;
                } else if (inputNumber == 3) {
                    methods.employeeMenu();
                    order = scanner.nextInt();
                    if (order == 1) {
                        System.out.println("Enter student's first name:");
                        firstName = scanner.nextLine();
                        System.out.println("Enter student's last name:");
                        lastName = scanner.nextLine();
                        System.out.println("Enter student's username :");
                        username = scanner.nextLine();
                        System.out.println("Enter student's password: ");
                        password = scanner.nextLine();
                        Student student = new Student(username, password, firstName, lastName, null);
                        methods.signUpStudent(student);
                        System.out.println("Done! ");
                    }
                    if (order == 2) {
                        System.out.println("Enter student's Index: ");
                        index = scanner.nextInt();
                        methods.removeStudent(index);
                    }
                    if (order == 3) {
                        System.out.println("Enter student's Index: ");
                        index = scanner.nextInt();
                        System.out.println("Enter student's first name:");
                        firstName = scanner.nextLine();
                        System.out.println("Enter student's last name:");
                        lastName = scanner.nextLine();
                        System.out.println("Enter student's username :");
                        username = scanner.nextLine();
                        System.out.println("Enter student's password: ");
                        password = scanner.nextLine();
                        methods.editStudent(index, firstName, lastName, username, password);
                    }
                    if (order == 4) {
                        System.out.println("Enter student's first name:");
                        firstName = scanner.nextLine();
                        System.out.println("Enter student's last name:");
                        lastName = scanner.nextLine();
                        System.out.println("Enter student's username :");
                        username = scanner.nextLine();
                        System.out.println("Enter student's password: ");
                        password = scanner.nextLine();
                        System.out.println("Enter the level of master: ");
                        String masterLevel = scanner.nextLine().toUpperCase();
                        if (masterLevel.equals("HAGHOTADRIS")) {
                            Master master = new Master(username, password, firstName, lastName, null, MasterLevel.HAGHOTADRIS);
                            methods.signUpMaster(master);
                        } else if (masterLevel.equals("HEIATELMI")) {
                            Master master = new Master(username, password, firstName, lastName, null, MasterLevel.HEIATELMI);
                            methods.signUpMaster(master);
                        }
                    }
                    if (order == 5) {
                        System.out.println("Enter master's Index: ");
                        index = scanner.nextInt();
                        methods.removeMaster(index);
                    }

                    if (order == 6) {
                        System.out.println("Please enter master's Index: ");
                        index = scanner.nextInt();
                        System.out.println("Enter master's first name:");
                        firstName = scanner.nextLine();
                        System.out.println("Enter master's last name:");
                        lastName = scanner.nextLine();
                        System.out.println("Enter master's username :");
                        username = scanner.nextLine();
                        System.out.println("Enter master's password: ");
                        password = scanner.nextLine();
                        System.out.println("Enter the level of master: ");
                        String masterLevel = scanner.nextLine().toUpperCase();
                        if (masterLevel.equals("HAGHOTADRIS")) {
                            Master master = new Master(username, password, firstName, lastName, null, MasterLevel.HAGHOTADRIS);
                            methods.editMaster(index, master);
                        } else if (masterLevel.equals("HEIATELMI")) {
                            Master master = new Master(username, password, firstName, lastName, null, MasterLevel.HEIATELMI);
                            methods.editMaster(index, master);
                        }
                    }

                    if (order == 7) {
                        System.out.println("Enter employee's first name:");
                        firstName = scanner.nextLine();
                        System.out.println("Enter employee's last name:");
                        lastName = scanner.nextLine();
                        System.out.println("Enter employee's username :");
                        username = scanner.nextLine();
                        System.out.println("Enter employee's password: ");
                        password = scanner.nextLine();
                        System.out.println("Enter employee's salary:  ");
                        salary = scanner.nextInt();
                        Employee employee = new Employee(username, password, firstName, lastName, salary);
                        methods.signUpEmployee(employee);
                    }
                    if (order == 8) {
                        System.out.println("Enter employee's Index: ");
                        index = scanner.nextInt();
                        methods.removeEmployee(index);
                    }
                    if (order == 9) {
                        System.out.println("Enter employee's Index: ");
                        index = scanner.nextInt();
                        System.out.println("Enter employee's first name:");
                        firstName = scanner.nextLine();
                        System.out.println("Enter employee's last name:");
                        lastName = scanner.nextLine();
                        System.out.println("Enter employee's username :");
                        username = scanner.nextLine();
                        System.out.println("Enter employee's password: ");
                        password = scanner.nextLine();
                        System.out.println("Enter employee's salary:  ");
                        salary = scanner.nextInt();
                        Employee employee = new Employee(username, password, firstName, lastName, salary);
                        methods.editEmployee(index, employee);
                    }
                    if (order == 10) {
                        System.out.println("Enter cours name: ");
                        courseNameInMain = scanner.nextLine();
                        System.out.println("Enter number of course unit: ");
                        unit = scanner.nextInt();
                        methods.addCourse(courseNameInMain, unit);
                    }
                    if (order == 11) {
                        System.out.println("Enter the index of course: ");
                        index = scanner.nextInt();
                        methods.removeCourse(index);
                    }
                    if (order == 12) {
                        System.out.println("Enter course index: ");
                        index = scanner.nextInt();
                        System.out.println("Enter course new name: ");
                        courseNameInMain = scanner.nextLine();
                        System.out.println("Enter course's unit: ");
                        unit = scanner.nextInt();
                        methods.editCourse(index, courseNameInMain, unit);
                    }
                    if (order == 13) {
                        System.out.println("Enter employee Index: ");
                        index = scanner.nextInt();
                        methods.viewEmployeeSalaryAndInfo(index);
                        if (order == 14) {
                            stats2 = false;
                            stats1 = true;
                        }
                    }
                }
            }
        }
    }
}

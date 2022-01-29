import Exceptions.*;
import com.sun.media.sound.InvalidFormatException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Methods methods = new Methods();
        boolean stats1 = true;
        boolean stats2 = false;
        int inputNumber = -1, salary, unit;
        String firstName = "", lastName = "", username = "", password = "", courseNameInMain = "", masterLevel = "";


        while (stats1) {
            methods.showLoginMenu();
            int loginStats = -1;
            try {
                inputNumber = scanner.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("invalid input! ");
            } catch (InputMismatchException e) {
                System.out.println("invalid input! ");
            }

            scanner.nextLine();
            if (inputNumber == 1) {
                System.out.println("Please enter your username: ");
                username = scanner.nextLine();
                System.out.println("Please enter your password: ");
                password = scanner.nextLine();
                if (methods.studentCheck(username, password)) {
                    stats1 = false;
                    stats2 = true;
                    break;
                }else System.out.println("Wrong username or password ");


            } else if (inputNumber == 2) {
                System.out.println("Please enter your username: ");
                username = scanner.nextLine();
                System.out.println("Please enter your password: ");
                password = scanner.nextLine();
                if (methods.masterCheck(username, password)) {
                    stats1 = false;
                    stats2 = true;
                    break;
                }
            } else if (inputNumber == 3) {
                System.out.println("Please enter your username: ");
                username = scanner.nextLine();
                System.out.println("Please enter your password: ");
                password = scanner.nextLine();
                if (methods.employeeCheck(username, password)) {
                    stats1 = false;
                    stats2 = true;
                    break;
                }
            }
        }
        while (stats2) {
            int order = 0;
            int index = 0;
            int studentIndexInMain = 0;
            int score = 0;
            int tedadJalasatTadris = 0;
            String courseName = "";
            System.out.println("please enter your studentIndex: ");
            try {
                index = scanner.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("invalid input! ");
            } catch (InputMismatchException e) {
                System.out.println("invalid input! ");
            }

            scanner.nextLine();
            if (inputNumber == 1) {
                methods.studentMenu();
                try {
                    order = scanner.nextInt();
                } catch (NumberFormatException e) {
                    System.out.println("invalid input! ");
                } catch (InputMismatchException e) {
                    System.out.println("invalid input! ");
                }
                if (order == 1) {
                    try {
                        methods.studentInfo(index);
                    } catch (NullPointerException e) {
                        System.out.println("Null pointer exception");
                    } catch (InputMismatchException e) {
                        System.out.println("invalid input! ");
                    }
                } else if (order == 2) {
                    try {
                        methods.viewCourseList();
                    } catch (NullPointerException e) {
                        System.out.println("Null pointer exception");
                    } catch (InputMismatchException e) {
                        System.out.println("invalid input! ");
                    }
                } else if (order == 3) {
                    try {
                        System.out.println(methods.scoreAverage(index));
                    } catch (NullPointerException e) {
                        System.out.println("Null pointer exception");
                    } catch (InputMismatchException e) {
                        System.out.println("invalid input! ");
                    }
                    System.out.println("Check if you can  take a specific course? Enter the course name: "); // check baraye bar nadashtane yek dars , 2 bar
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
                try {
                    order = scanner.nextInt();
                    System.out.println("please enter your Master index: ");
                    index = scanner.nextInt();
                } catch (NumberFormatException e) {
                    System.out.println("input must be a DIGIT! ");
                } catch (InputMismatchException e) {
                    System.out.println("invalid input! ");
                }
                if (order == 1)

                    try {
                        methods.masterInfo(index);
                    } catch (NullPointerException e) {
                        System.out.println("Null pointer exception");;
                    }
                else if (order == 2) {
                    try {
                        System.out.println("Enter the student's Index: ");
                        studentIndexInMain = scanner.nextInt();
                        System.out.println("Enter course name: ");
                        courseName = scanner.nextLine();
                        System.out.println("Enter the score: ");
                        score = scanner.nextInt();
                        methods.scoreRegister(studentIndexInMain, courseName, score);
                    } catch (NumberFormatException e) {
                        System.out.println("Input must be a DIGIT! ");
                    } catch (InputMismatchException e) {
                        System.out.println("invalid input! ");
                    }
                } else if (order == 3) {

                    try {
                        System.out.println("Please enter number session you have teached: ");
                        tedadJalasatTadris = scanner.nextInt();
                        System.out.println(methods.paySlip(index, tedadJalasatTadris));
                    } catch (NumberFormatException e) {
                        System.out.println("Input must be a DIGIT! ");
                    } catch (NullPointerException e) {
                        System.out.println("");;
                    } catch (InputMismatchException e) {
                        System.out.println("invalid input! ");
                    }
                } else if (order == 4) {
                    stats1 = true;
                    stats2 = false;
                    break;
                } else if (inputNumber == 3) {
                    try {
                        methods.employeeMenu();
                        order = scanner.nextInt();
                    } catch (NumberFormatException e) {
                        System.out.println("Input must be a DIGIT! ");
                    }

                    if (order == 1) {
                        System.out.println("Enter student's first name:");
                        firstName = scanner.nextLine();
                        System.out.println("Enter student's last name:");
                        lastName = scanner.nextLine();
                        System.out.println("Enter student's username :");
                        username = scanner.nextLine();
                        System.out.println("Enter student's password: ");
                        password = scanner.nextLine();
                        Student student = new Student(username, password, firstName, lastName);
                        methods.signUpStudent(student);
                        System.out.println("Done! ");
                    }
                    if (order == 2) {
                        System.out.println("Enter student's Index: ");

                        try {
                            index = scanner.nextInt();
                            methods.removeStudent(index);
                        } catch (NumberFormatException e) {
                            System.out.println("Input must be a DIGIT! ");
                        } catch (NullPointerException e) {
                            System.out.println("Wrong student index (catch null pointer exception )");
                        } catch (InputMismatchException e) {
                            System.out.println("invalid input! ");
                        }
                    }
                    if (order == 3) {
                        try {
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
                        } catch (NumberFormatException e) {
                            System.out.println("Input must be a DIGIT! ");
                        } catch (InputMismatchException e) {
                            System.out.println("invalid input! ");
                        }

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
                        masterLevel = scanner.nextLine().toUpperCase();
                        if (masterLevel.equals(MasterLevel.HAGHOTADRIS)) {
                            Master master = new Master(username, password, firstName, lastName, 0, MasterLevel.HAGHOTADRIS);
                            methods.signUpMaster(master);
                        } else if (masterLevel.equals(MasterLevel.HEIATELMI)) {
                            Master master = new Master(username, password, firstName, lastName, 0, MasterLevel.HEIATELMI);
                            methods.signUpMaster(master);
                        }
                    }
                    if (order == 5) {
                        System.out.println("Enter master's Index: ");
                        try {
                            index = scanner.nextInt();
                            methods.removeMaster(index);
                        } catch (NumberFormatException e) {
                            System.out.println("Input must be a DIGIT! ");
                        } catch (NullPointerException e) {
                            System.out.println("wrong master index (catch NullPointer Exception)");
                        } catch (InputMismatchException e) {
                            System.out.println("invalid input! ");
                        }
                    }

                    if (order == 6) {
                        try {
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
                            masterLevel = scanner.nextLine().toUpperCase();
                        } catch (NumberFormatException e) {
                            System.out.println("Input must be a DIGIT! ");
                        } catch (InputMismatchException e) {
                            System.out.println("invalid input! ");
                        }

                        if (masterLevel.equals("HAGHOTADRIS")) {
                            Master master = new Master(username, password, firstName, lastName, null, MasterLevel.HAGHOTADRIS);
                            methods.editMaster(index, master);
                        } else if (masterLevel.equals("HEIATELMI")) {
                            Master master = new Master(username, password, firstName, lastName, null, MasterLevel.HEIATELMI);
                            methods.editMaster(index, master);
                        }
                    }

                    if (order == 7) {
                        try {
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
                        } catch (NumberFormatException e) {
                            System.out.println("Input must be a DIGIT! ");
                        } catch (InputMismatchException e) {
                            System.out.println("invalid input! ");
                        }

                    }
                    if (order == 8) {

                        try {
                            System.out.println("Enter employee's Index: ");
                            index = scanner.nextInt();
                            methods.removeEmployee(index);
                        } catch (NumberFormatException e) {
                            System.out.println("Input must be a DIGIT! ");
                        } catch (NullPointerException e) {
                            System.out.println("wrong index! (nullPointerException)");
                        } catch (InputMismatchException e) {
                            System.out.println("invalid input! ");
                        }
                    }
                    if (order == 9) {
                        try {
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
                        } catch (NumberFormatException e) {
                            System.out.println("Input must be a DIGIT! ");
                        } catch (NullPointerException e) {
                            System.out.println("Wrong index! (NullPointerException)");
                        }

                    }
                    if (order == 10) {
                        try {
                            System.out.println("Enter course name: ");
                            courseNameInMain = scanner.nextLine();
                            System.out.println("Enter number of course unit: ");
                            unit = scanner.nextInt();
                            methods.addCourse(courseNameInMain, unit);
                        } catch (NumberFormatException e) {
                            System.out.println("Input must be a DIGIT! ");
                        }

                    }
                    if (order == 11) {
                        try {
                            index = scanner.nextInt();
                            methods.removeCourse(index);
                            System.out.println("Enter the index of course: ");
                        } catch (InvalidCourseException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            System.out.println("Invalid course (wrong index entered!) ");//nullPointerException
                        }


                    }
                    if (order == 12) {
                        try {
                            System.out.println("Enter course index: ");
                            index = scanner.nextInt();
                            System.out.println("Enter course new name: ");
                            courseNameInMain = scanner.nextLine();
                            System.out.println("Enter course's unit: ");
                            unit = scanner.nextInt();
                            methods.editCourse(index, courseNameInMain, unit);
                        } catch (InvalidCourseException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            System.out.println("Invalid course (wrong index!)");//NullPointerException
                        }

                    }
                    if (order == 13) {
                        try {
                            System.out.println("Enter employee Index: ");
                            index = scanner.nextInt();
                            methods.viewEmployeeSalaryAndInfo(index);
                            if (order == 14) {
                                stats2 = false;
                                stats1 = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Input must be a DIGIT! ");
                        } catch (InvalidEmployeeException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }
}

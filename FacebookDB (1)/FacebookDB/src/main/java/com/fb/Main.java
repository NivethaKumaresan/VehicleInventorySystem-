package com.fb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        while (true) {
            System.out.println("1. Register User");
            System.out.println("2. Login User");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number (1-3).");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter First Name: ");
                String firstName = scanner.nextLine();
                System.out.print("Enter Last Name: ");
                String lastName = scanner.nextLine();
                System.out.print("Enter Username: ");
                String userName = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();  // Get plain password
                
                // Ensure password is not null or empty
                if (password == null || password.trim().isEmpty()) {
                    System.out.println("Password cannot be empty!");
                    continue;
                }

                System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
                String dobString = scanner.nextLine();

                LocalDate dob;
                try {
                    dob = LocalDate.parse(dobString, DateTimeFormatter.ISO_LOCAL_DATE);
                } catch (Exception e) {
                    System.out.println("Invalid date format! Please use YYYY-MM-DD.");
                    continue;
                }

                System.out.print("Enter Gender: ");
                String gender = scanner.nextLine();
                System.out.print("Enter Mobile Number: ");
                String mobileNumber = scanner.nextLine();
                System.out.print("Enter Address: ");
                String address = scanner.nextLine();

                registerUser(session, firstName, lastName, userName, password, dob, gender, mobileNumber, address);
            } else if (choice == 2) {
                System.out.print("Enter Username: ");
                String userName = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();

                boolean isAuthenticated = loginUser(session, userName, password);
                if (isAuthenticated) {
                    System.out.println("Login Successful! Welcome, " + userName);
                } else {
                    System.out.println("Invalid Username or Password.");
                }
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }

        session.close();
        factory.close();
        scanner.close();
    }

    public static void registerUser(Session session, String firstName, String lastName, String userName, 
                                    String password, LocalDate dob, String gender, String mobileNumber, String address) {
        // Ensure password is not null
        if (password == null || password.trim().isEmpty()) {
            System.out.println("Error: Password cannot be empty.");
            return;
        }

        // Encrypt the password
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

        session.beginTransaction();

        // Create user with hashed password
        UserInfo user = new UserInfo(firstName, lastName, userName, hashedPassword, dob, gender, mobileNumber, address);
        session.save(user);

        session.getTransaction().commit();
        System.out.println("User Registered Successfully!");
    }

    public static boolean loginUser(Session session, String userName, String password) {
        UserInfo user = session.createQuery("FROM UserInfo WHERE userName = :userName", UserInfo.class)
                               .setParameter("userName", userName)
                               .uniqueResult();

        if (user == null) {
            return false; // User not found
        }

        // Verify hashed password
        return BCrypt.checkpw(password, user.getPassword());
    }
}

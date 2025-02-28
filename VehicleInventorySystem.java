import java.util.*;
public class VehicleInventorySystem {
    //import java.util.*;



    // User POJO class
    static class User {
        private String firstName;
        private String lastName;
        private String username;
        private String password;

        public User(String firstName, String lastName, String username, String password) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getFirstName() {
            return firstName;
        }
    }

    // Vehicle POJO class
    static class Vehicle {
        private String model;
        private int manufacturingYear;
        private double price;

        public Vehicle(String model, int manufacturingYear, double price) {
            this.model = model;
            this.manufacturingYear = manufacturingYear;
            this.price = price;
        }

        public String getModel() {
            return model;
        }

        public int getManufacturingYear() {
            return manufacturingYear;
        }

        public double getPrice() {
            return price;
        }
    }

    // IUser interface
    interface IUser {
        void addUser(User user);

        User authenticateUser(String username, String password);
    }

    // IVehicle interface
    interface IVehicle {
        void addVehicle(Vehicle vehicle);

        List<Vehicle> getSortedVehicles(String sortBy);
    }

    // UserImpl class implements IUser interface
    static class UserImpl implements IUser {
        private List<User> users = new LinkedList<>();

        @Override
        public void addUser(User user) {
            users.add(user);
        }

        @Override
        public User authenticateUser(String username, String password) {
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return user;
                }
            }
            return null; // User not found
        }
    }

    // VehicleImpl class implements IVehicle interface
    static class VehicleImpl implements IVehicle {
        private List<Vehicle> vehicles = new LinkedList<>();

        @Override
        public void addVehicle(Vehicle vehicle) {
            vehicles.add(vehicle);
        }

        @Override
        public List<Vehicle> getSortedVehicles(String sortBy) {
            List<Vehicle> vehicleList = new ArrayList<>(vehicles);

            if (sortBy.equalsIgnoreCase("mfgyear")) {
                // Sort by manufacturing year
                Collections.sort(vehicleList, Comparator.comparingInt(Vehicle::getManufacturingYear));
            } else if (sortBy.equalsIgnoreCase("price")) {
                // Sort by price
                Collections.sort(vehicleList, Comparator.comparingDouble(Vehicle::getPrice));
            }

            return vehicleList;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create instances of UserImpl and VehicleImpl
        IUser userImpl = new UserImpl();
        IVehicle vehicleImpl = new VehicleImpl();

        // Predefined vehicles
        vehicleImpl.addVehicle(new Vehicle("Toyota", 2019, 5000));
        vehicleImpl.addVehicle(new Vehicle("Suzuki", 2016, 3500));
        vehicleImpl.addVehicle(new Vehicle("Benz", 2021, 6000));
        vehicleImpl.addVehicle(new Vehicle("Kia", 2020, 4500));

        // User registration
        System.out.println("Welcome to AUTOSHOP WORLD!!!");
        System.out.println("Please signup with your details");

        System.out.print("Please enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Please enter your second name: ");
        String lastName = scanner.nextLine();

        System.out.print("Please enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Please enter your password: ");
        String password = scanner.nextLine();

        User newUser = new User(firstName, lastName, username, password);
        userImpl.addUser(newUser);
        System.out.println("Thank you… your registration success!!!");

        // User login
        System.out.println("Please sign in with your details");
        System.out.print("Please enter your username: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Please enter your password: ");
        String loginPassword = scanner.nextLine();

        User authenticatedUser = userImpl.authenticateUser(loginUsername, loginPassword);

        if (authenticatedUser != null) {
            System.out.println(authenticatedUser.getFirstName() + "!!!! Welcome to Autoshop world");

            // Show available vehicles
            System.out.println("\nList of Available Vehicles:");
            List<Vehicle> vehicles = vehicleImpl.getSortedVehicles("mfgyear");
            for (Vehicle v : vehicles) {
                System.out.println(v.getModel() + " " + v.getManufacturingYear() + " " + v.getPrice());
            }

            // Sorting option
            System.out.print("\nPlease enter your input to sort results (Ex: mfgyear or price): ");
            String sortInput = scanner.nextLine();

            List<Vehicle> sortedVehicles = vehicleImpl.getSortedVehicles(sortInput);
            for (Vehicle v : sortedVehicles) {
                System.out.println(v.getModel() + " " + v.getManufacturingYear() + " " + v.getPrice());
            }
        } else {
            System.out.println("Invalid credentials, please try again.");
        }

        scanner.close();
    }
}

    


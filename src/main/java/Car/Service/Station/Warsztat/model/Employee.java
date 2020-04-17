package Car.Service.Station.Warsztat.model;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int superAdmin;
    private int telephoneNumber;
    private String notes;
    private double hourlyRate;
    private double quantityHours;

    public Employee() {
    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(String firstName, String lastName, String email, String password, int superAdmin, int telephoneNumber, String notes, double hourlyRate, double quantityHours) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.superAdmin = superAdmin;
        this.telephoneNumber = telephoneNumber;
        this.notes = notes;
        this.hourlyRate = hourlyRate;
        this.quantityHours = quantityHours;
    }

    public Employee(int id, String firstName, String lastName, String email, String password, int superAdmin, int telephoneNumber, String notes, double hourlyRate, double quantityHours) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.superAdmin = superAdmin;
        this.telephoneNumber = telephoneNumber;
        this.notes = notes;
        this.hourlyRate = hourlyRate;
        this.quantityHours = quantityHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(int superAdmin) {
        this.superAdmin = superAdmin;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getQuantityHours() {
        return quantityHours;
    }

    public void setQuantityHours(double quantityHours) {
        this.quantityHours = quantityHours;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", superAdmin=" + superAdmin +
                ", telephoneNumber=" + telephoneNumber +
                ", Notes='" + notes + '\'' +
                ", hourlyRate=" + hourlyRate +
                ", quantityHours=" + quantityHours +
                '}';
    }
}

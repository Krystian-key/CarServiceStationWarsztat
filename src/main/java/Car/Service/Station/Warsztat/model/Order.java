package Car.Service.Station.Warsztat.model;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    private int id;
    private Date acceptedDate;
    private Date planedDate;
    private Date startDate;
    private String descriptionProblems;
    private String descriptionRepair;
    private double repairCost;
    private double partsCost;
    private int hourlyRate;
    private double repairHours;
    private int employeesId;
    private int clientsId;
    private int vehiclesId;

    public Order() {
    }

    public Order(Date acceptedDate, Date planedDate, Date startDate, String descriptionProblems, String descriptionRepair, double repairCost, double partsCost, int hourlyRate, double repairHours) {
        this.acceptedDate = acceptedDate;
        this.planedDate = planedDate;
        this.startDate = startDate;
        this.descriptionProblems = descriptionProblems;
        this.descriptionRepair = descriptionRepair;
        this.repairCost = repairCost;
        this.partsCost = partsCost;
        this.hourlyRate = hourlyRate;
        this.repairHours = repairHours;
    }

    public Order(int id) {
        this.id = id;
    }

    public Order(int id, int employeesId, int clientsId, int vehiclesId) {
        this.id = id;
        this.employeesId = employeesId;
        this.clientsId = clientsId;
        this.vehiclesId = vehiclesId;
    }

    public Order(int id, Date acceptedDate, Date planedDate, Date startDate, String descriptionProblems, String descriptionRepair, double repairCost, double partsCost, int hourlyRate, double repairHours, int employeesId, int clientsId, int vehiclesId) {
        this.id = id;
        this.acceptedDate = acceptedDate;
        this.planedDate = planedDate;
        this.startDate = startDate;
        this.descriptionProblems = descriptionProblems;
        this.descriptionRepair = descriptionRepair;
        this.repairCost = repairCost;
        this.partsCost = partsCost;
        this.hourlyRate = hourlyRate;
        this.repairHours = repairHours;
        this.employeesId = employeesId;
        this.clientsId = clientsId;
        this.vehiclesId = vehiclesId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(Date acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    public Date getPlanedDate() {
        return planedDate;
    }

    public void setPlanedDate(Date planedDate) {
        this.planedDate = planedDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getDescriptionProblems() {
        return descriptionProblems;
    }

    public void setDescriptionProblems(String descriptionProblems) {
        this.descriptionProblems = descriptionProblems;
    }

    public String getDescriptionRepair() {
        return descriptionRepair;
    }

    public void setDescriptionRepair(String descriptionRepair) {
        this.descriptionRepair = descriptionRepair;
    }

    public double getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(double repairCost) {
        this.repairCost = repairCost;
    }

    public double getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(double partsCost) {
        this.partsCost = partsCost;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getRepairHours() {
        return repairHours;
    }

    public void setRepairHours(double repairHours) {
        this.repairHours = repairHours;
    }

    public int getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(int employeesId) {
        this.employeesId = employeesId;
    }

    public int getClientsId() {
        return clientsId;
    }

    public void setClientsId(int clientsId) {
        this.clientsId = clientsId;
    }

    public int getVehiclesId() {
        return vehiclesId;
    }

    public void setVehiclesId(int vehiclesId) {
        this.vehiclesId = vehiclesId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", acceptedDate=" + acceptedDate +
                ", planedDate=" + planedDate +
                ", startDate=" + startDate +
                ", descriptionProblems='" + descriptionProblems + '\'' +
                ", descriptionRepair='" + descriptionRepair + '\'' +
                ", repairCost=" + repairCost +
                ", partsCost=" + partsCost +
                ", hourlyRate=" + hourlyRate +
                ", repairHours=" + repairHours +
                ", employeesId=" + employeesId +
                ", clientsId=" + clientsId +
                ", vehiclesId=" + vehiclesId +
                '}';
    }
}

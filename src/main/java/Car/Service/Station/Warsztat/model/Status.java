package Car.Service.Station.Warsztat.model;

public class Status {
    private int id;
    private int status;
    private int orderId;

    public Status() {
    }

    public Status(int id) {
        this.id = id;
    }

    public Status(int id, int status, int orderId) {
        this.id = id;
        this.status = status;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", status=" + status +
                ", orderId=" + orderId +
                '}';
    }
}

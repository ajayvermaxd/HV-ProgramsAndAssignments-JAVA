import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private String orderId;
    private String itemId;
    private int quantity;
    private String status;
    private String orderDate;
    private String customerTableName;

    public Order(int orderId, String itemId, int quantity, String customerTableName) {
        this.orderId = String.format("%04d", orderId); // Formatting to 4-digit
        this.itemId = itemId;
        this.quantity = quantity;
        this.status = "order accepted";
        this.customerTableName = customerTableName;
        this.orderDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date()); // Storing current date
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = String.format("%04d", orderId);
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerTableName() {
        return customerTableName;
    }

    public void setCustomerTableName(String customerTableName) {
        this.customerTableName = customerTableName;
    }
}

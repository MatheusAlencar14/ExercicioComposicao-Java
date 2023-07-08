package entities;

public class OrderItem {

    private Integer quantity;
    private Double price;
    private Double subTotal;

    public OrderItem() {
    }

    public OrderItem(Integer quantity, Double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public Double subTotal(Integer quantity, Double price) {
        this.subTotal = quantity * price;
        return subTotal;
    }

    @Override
    public String toString() {
        return "Quantity: " + quantity + ", Subtotal: " + subTotal;
    }
}

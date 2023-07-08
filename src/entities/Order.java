package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private OrderStatus status;

    private List<OrderItem> items = new ArrayList<>();

    private Client client;

    private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        double total = 0;
        for (OrderItem oi : items) {
            total += oi.subTotal();
        };
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Descrição do pedido: \n");
        sb.append("Data do pedido: " + sdf2.format(getMoment()) + "\n");
        sb.append("Status do pedido: " + getStatus() + "\n");
        sb.append(client + "\n");
        sb.append("Itens do pedido: \n");
        for (OrderItem oi : items) {
            sb.append(oi.getProduct().getName());
            sb.append(", R$ " + String.format("%.2f", oi.getPrice()));
            sb.append(", Quantidade: " + oi.getQuantity());
            sb.append(", Subtotal: " + String.format("%.2f", oi.getSubTotal()));
            sb.append("\n");
        }
        sb.append("Preço total: " + total());
        return sb.toString();
    }
}

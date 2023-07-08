package application;

import entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProgramOrder {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Product product = new Product();
        OrderItem item = new OrderItem();

        System.out.println("Digite os dados do cliente: ");
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Data de Nascimento: ");
        Date birthDate = sdf1.parse(sc.nextLine());

        Client c1 = new Client(name, email, birthDate);

        System.out.println();
        System.out.println("Digite os dados do pedido: ");
        System.out.print("Status: ");
        String status = sc.nextLine();
        System.out.print("Quantos itens no pedido? ");
        int quantityItems = sc.nextInt();
        Order order = new Order(new Date(), OrderStatus.valueOf(status), c1);
        System.out.println();

        for (int i = 0; i < quantityItems; i++) {
            System.out.println("Digite os dados do item #" + (i + 1) + ": ");
            System.out.print("Nome do produto: ");
            sc.nextLine();
            String nameItem = sc.nextLine();
            System.out.print("Preço do produto: ");
            double priceItem = sc.nextDouble();
            System.out.print("Quantidade: ");
            int quantityItem = sc.nextInt();
            product = new Product(nameItem, priceItem);
            item = new OrderItem(quantityItem, priceItem, product);
            item.subTotal();
            order.addItem(item);
            System.out.println();
        }

        System.out.println();
        System.out.println(order);

        sc.close();
    }
}

import java.io.*;


class Product implements Serializable {
    private static final long serialVersionUID = 1L; // Serial version UID
    private int id;
    private String name;
    private String category;
    private double price;


    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
    public void printDetails() {
        System.out.println("Product ID: " + id);
        System.out.println("Product Name: " + name);
        System.out.println("Product Category: " + category);
        System.out.println("Product Price: " + price);
    }
}

public class Deserialization{
    public static void main(String[] args) {
        serializeProduct();

        Product product = deserializeProduct();
        if (product != null) {
            System.out.println("Deserialized Product Details:");
            product.printDetails();
        }
}
    private static void serializeProduct() {
        try (FileOutputStream fileOut = new FileOutputStream("product.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) 
            Product product = new Product(101, "Laptop", "Electronics", 1500.00);
            out.writeObject(product);
            System.out.println("Product object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Product deserializeProduct() {
        try (FileInputStream fileIn = new FileInputStream("product.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Product product = (Product) in.readObject();
            System.out.println("Product object deserialized successfully.");
            return product;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

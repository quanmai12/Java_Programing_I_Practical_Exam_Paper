import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product(); // Tạo đối tượng với giá trị mặc định

        System.out.println("=== WAREHOUSE MANAGEMENT SYSTEM ===");
        
        // 3a. Nhập thông tin từ bàn phím
        System.out.print("Product ID : ");
        product.setId(Integer.parseInt(scanner.nextLine()));

        System.out.print("PRODUCT NAME: ");
        product.setName(scanner.nextLine());

        System.out.print("THUMBNAIL URL: ");
        product.setThumbnail(scanner.nextLine());

        System.out.print("PRICE: ");
        product.setPrice(Double.parseDouble(scanner.nextLine()));

        System.out.print("QUANTITY: ");
        product.setQty(Integer.parseInt(scanner.nextLine()));

        System.out.print("DESCRIPTION: ");
        product.setDescription(scanner.nextLine());

        // Hiển thị thông tin vừa nhập
        product.displayInfo();

        // Tiến hành nghiệp vụ đặt hàng
        System.out.println("\n=== PROCEED YOUR ORDER     ===");
        System.out.print("Please enter the quantity you wish to purchase.: ");
        int orderQty = Integer.parseInt(scanner.nextLine());

        // Kiểm tra và đặt hàng theo đúng logic
        if (product.checkAvailability(orderQty)) {
            System.out.println("-> Stock is sufficient! Order is being processed...");
            double totalCost = product.placeOrder(orderQty);
            
            System.out.println("-> ORDER SUCCESSFUL!");
            System.out.println("-> Total amount to be paid: $" + totalCost);
            System.out.println("-> Updated inventory levels: " + product.getQty());
        } else {
            System.out.println("-> ORDER FAILED: Insufficient stock or invalid quantity (must be > 0).");
        }

        scanner.close(); 
    }
}
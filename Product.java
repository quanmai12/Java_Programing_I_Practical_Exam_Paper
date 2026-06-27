public class Product {
    // 1a. Khai báo các trường dữ liệu (Fields)
    private int id;
    private String name;
    private String thumbnail;
    private double price;
    private int qty;
    private String description;

    // 1b. Constructor mặc định (khởi tạo giá trị mặc định)
    public Product() {
        this.id = 0;
        this.name = "Unknown";
        this.thumbnail = "";
        this.price = 0.0;
        this.qty = 0;
        this.description = "No description";
    }

    // Constructor đầy đủ tham số (Tặng thêm để code chuyên nghiệp hơn)
    public Product(int id, String name, String thumbnail, double price, int qty, String description) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.setPrice(price); // Gọi setter để tận dụng logic validate
        this.setQty(qty);     // Gọi setter để tận dụng logic validate
        this.description = description;
    }

    // 1c. Getters và Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getThumbnail() { return thumbnail; }
    public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }

    public double getPrice() { return price; }
    // Validate: Giá không được âm
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("[Warning] Prices cannot be negative. Automatically resets to 0..");
            this.price = 0.0;
        }
    }

    public int getQty() { return qty; }
    // Validate: Số lượng không được âm
    public void setQty(int qty) {
        if (qty >= 0) {
            this.qty = qty;
        } else {
            System.out.println("[Warning] Inventory levels cannot be negative. Automatically resets to 0.");
            this.qty = 0;
        }
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    // 1d. Hiển thị thông tin sản phẩm
    public void displayInfo() {
        System.out.println("\n--- PRODUCT INFORMATION ---");
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Thumbnail: " + this.thumbnail);
        System.out.println("Price: $" + this.price);
        System.out.println("Stock Quantity: " + this.qty);
        System.out.println("Description: " + this.description);
        System.out.println("--------------------------");
    }

    // 2a. Kiểm tra số lượng tồn kho
    public boolean checkAvailability(int expectedQty) {
        // Hợp lệ nếu số lượng đặt > 0 và nhỏ hơn hoặc bằng số lượng tồn kho
        return (expectedQty > 0 && expectedQty <= this.qty);
    }

    // 2b. Tiến hành đặt hàng
    public double placeOrder(int orderQty) {
        // Luôn gọi checkAvailability trước khi trừ kho
        if (checkAvailability(orderQty)) {
            this.qty -= orderQty; // Trừ số lượng tồn kho
            return this.price * orderQty; // Trả về tổng tiền
        } else {
            System.out.println("Error: Invalid order quantity or stock exceeds available quantity!");
            return 0.0;
        }
    }
}
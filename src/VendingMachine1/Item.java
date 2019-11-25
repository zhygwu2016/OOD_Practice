package VendingMachine1;

public enum Item {

    COKE("Coke",25),

    PEPSI("Pepsi",35),

    FANTA("Fanta", 45);

    private String name;

    private int price;

    Item(final String name, final int price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }
}

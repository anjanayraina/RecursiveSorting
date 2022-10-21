import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
    private String name;
    private String acNo;
    private double numPurchased;
    private double totalCost;
    private ArrayList<String> tvsPurchased;

    public Customer() {
        tvsPurchased = new ArrayList<>();
    }

    public Customer(String name, String acNo){
        tvsPurchased = new ArrayList<>();
        this.name = name;
        this.acNo = acNo;

    }

    public Customer(String name, String acNo, double numPurchased, ArrayList<String> tvsPurchased) {
        this.name = name;
        this.acNo = acNo;
        this.numPurchased = numPurchased;
        this.tvsPurchased = tvsPurchased;
    }

    public double getTotalCost() {
        calculateCost();
        return ((int)(totalCost*100))/100.0;
    }

    public String getName() {
        return name;
    }
String localDir = System.getProperty("user.dir");
    public void setName(String name) {
        this.name = name;
    }

    public String getAcNo() {
        return acNo;
    }

    public void setAcNo(String acNo) {
        this.acNo = acNo;
    }

    public double getNumPurchased() {
        return numPurchased;
    }

    public void setNumPurchased(double numPurchased) {
        this.numPurchased = numPurchased;
    }

    public ArrayList<String> getTvsPurchased() {
        return tvsPurchased;
    }

    public void setTvsPurchased(ArrayList<String> tvsPurchased) {
        this.tvsPurchased = tvsPurchased;
    }

    @Override
    public String toString() {
        String str = "Checkout Receipt:\n" +
                "Customer: "+name+"\n" +
                "Account Number: "+acNo+"\n" +
                "Purchased "+numPurchased+" TVs for $"+getTotalCost();

        for(String s: tvsPurchased)
            str+="\n"+s;
        return str;
    }

    public void calculateCost(){
        totalCost = 199.95*numPurchased;
        totalCost = totalCost+totalCost*0.06;
    }
}

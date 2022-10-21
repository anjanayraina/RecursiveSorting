import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CustomerData implements Iterable<Customer>, Serializable {

    private List<Customer> customers;

    public CustomerData() {
        customers = new LinkedList<Customer>();
    }

    @Override
    public Iterator<Customer> iterator() {
        return customers.iterator();
    }

    public void addCustomer(Customer c){
        customers.add(c);
    }

    public void removeCustomer(String accNo){
        for(Customer c: customers)
        {
            if(c.getAcNo().equalsIgnoreCase(accNo)){
                customers.remove(c);
            }
        }
    }

    public void updateCustomer(String accNo, String name){
        for(Customer c: customers){
            if(c.getAcNo().equalsIgnoreCase(accNo)){
                c.setName(name);
            }
        }
    }

    public Customer findCustomer(String accNo){
        for(Customer c: customers){
            if(c.getAcNo().equalsIgnoreCase(accNo)){
                return c;
            }
        }
        return null;
    }

    public int size(){
        return customers.size();
    }

    public void display(){
        System.out.println("Customer List:");
        int counter = 1;
        for(Customer c: customers){
            System.out.printf("%-10s%d%-2s%-22s%-8s%-10s%s\n",
                    "Customer",counter++,":",c.getName(),"Account",
                    "Number:", c.getAcNo());
        }
    }
}

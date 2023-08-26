package ru.otus;


import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    private final TreeMap<Customer, String> customerData = new TreeMap<>(Comparator.comparing(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        var firstCustomer = customerData.firstKey();

        return Map.entry(getCopyCustomer(firstCustomer), customerData.get(firstCustomer));
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        var nextCustomer = customerData.higherKey(customer);

        return nextCustomer != null
                ? Map.entry(getCopyCustomer(nextCustomer), customerData.get(nextCustomer))
                : null;
    }

    public void add(Customer customer, String data) {
        customerData.put(customer, data);
    }

    private Customer getCopyCustomer(Customer customer) {
        return new Customer(customer.getId(), customer.getName(), customer.getScores());
    }
}

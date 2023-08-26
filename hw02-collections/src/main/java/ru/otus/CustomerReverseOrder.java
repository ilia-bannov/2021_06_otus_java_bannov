package ru.otus;


import java.util.LinkedHashMap;
import java.util.Map;

public class CustomerReverseOrder {

    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    private final Map<Integer, Customer> customers = new LinkedHashMap<>();
    private static Integer index = 0;

    public void add(Customer customer) {
        customers.put(index++, customer);
    }

    public Customer take() {
        return customers.get(--index);
    }
}

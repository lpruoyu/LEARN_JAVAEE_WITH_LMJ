package coder.lp.five_crms.data;

import coder.lp.five_crms.bean.Customer;

import java.util.ArrayList;
import java.util.List;

public final class DataManage {

    private DataManage() {
    }

    private static final List<Customer> list = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            list.add(new Customer("张三" + i, 18 + i, (((i & 1) == 1)) ? 1.7f + i : 1.6f + i));
        }
    }

    public static void addCustomer(String name, Integer age, Float tall) {
        list.add(new Customer(name, age, tall));
    }

    public static List<Customer> getCustomers() {
        return list;
    }

}

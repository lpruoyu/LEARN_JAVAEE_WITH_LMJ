package programmer.lp.resume.util;

import programmer.lp.resume.bean.Contact;
import programmer.lp.resume.dao.impl.ContactDaoImpl;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    }

    public static void testContactSearch() {
        ContactDaoImpl daoImpl = new ContactDaoImpl();
        Contact.Search search = new Contact.Search();

//        search.pageIndex = 3;

        search.keyWord = "8";
        final Date beginDay = new Date();
        final Date endDay = new Date();
        beginDay.setYear(190);
        beginDay.setMonth(8);
        beginDay.setDate(19);
        endDay.setYear(199);
        endDay.setMonth(8);
        endDay.setDate(20);
        search.beginDay = beginDay;
        search.endDay = endDay;
        final List<Contact> list = daoImpl.list(search);
        for (Contact contact : list) {
            System.out.println(contact.getJson());
        }
    }

}

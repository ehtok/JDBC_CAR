package service;

import bean.Car;
import dao.ImplDao;

import java.sql.SQLException;

public class Runner {


    public static void main(String[] args) throws SQLException {
        Car car = new Car(3, "BMW", "BLack", "5500$");
        Car car1 = new Car(4,"Lada","Blue","2000$");
        ImplDao implDao = new ImplDao();
        implDao.getId(new Car(), 3);
        //  implDao.delete(Person.class, 1);
        // implDao.getAll(Person.class);
        //  implDao.update(car);
       // implDao.save(car1);


    }
}

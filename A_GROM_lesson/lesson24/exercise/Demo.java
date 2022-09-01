package A_GROM_lesson.lesson24.exercise;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Sys system1=new Sys(11,"....");
        GeneralDAO<Sys> systemDAO=new GeneralDAO<>();
        systemDAO.save(system1);
        System.out.println(Arrays.deepToString(systemDAO.getAll()));
        systemDAO.save(system1);
        System.out.println(Arrays.deepToString(systemDAO.getAll()));

        System.out.println(" ");

        GeneralDAO<Tool> toolDAO=new GeneralDAO<>();
        Tool tool=new Tool("dfldfjd","....");
        toolDAO.save(tool);
        System.out.println(Arrays.deepToString(toolDAO.getAll()));
        toolDAO.save(tool);
        System.out.println(Arrays.deepToString(toolDAO.getAll()));

        System.out.println(" ");

        GeneralDAO<Order> orderDAO=new GeneralDAO<>();
        Order order=new Order("dfdf","dfdfdf");
        orderDAO.save(order);
        System.out.println(Arrays.deepToString(orderDAO.getAll()));

    }
}

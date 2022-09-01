package A_GROM_lesson.lesson22.repository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        User user1=new User(1001,"Danya","234234234234dfd");
        UserRepository.save(user1);
        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        User user2=new User(1003,"Nata","23234234dfd");
        UserRepository.save(user2);
        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        User user3=new User(1004,"B_readMe.Test","232dfd4234dfd");
        UserRepository.save(user3);
        System.out.println(Arrays.deepToString(UserRepository.getUsers()));



    }

}

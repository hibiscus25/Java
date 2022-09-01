package A_GROM_lesson.lesson13;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        UserRepository userRepository=new UserRepository();
    //test 0
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

    //test save
        //cохранение юзера+
        User user=new User(1001,"Ann","1wewew");
        userRepository.save(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //сохранение того же юзера+
        userRepository.save(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //когда нет места в массиве+
        int n=15;
        while(n>0){
            User user1=new User(n,"Ann","123kjsljd");
            System.out.println(userRepository.save(user1));
            n--;
        }
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //когда сохраняем null+
        userRepository.save(null);

    //test update
        //обновление юзера
        user=new User(1001,"Anna","eredfdfdfd");
        userRepository.update(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //когда нет юзера на обновление
        user=new User(999,"Anna","eredfdfdfd");
        System.out.println(userRepository.update(user));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //когда обновляем null
        System.out.println(userRepository.update(null));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
    }
}

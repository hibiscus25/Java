package A_GROM_lesson.lesson15.A_HW.lesson15A;

public class Demo {
    public static void main(String[] args) {
        User user = new User(1l, "Ким", "1234045");
        User user1 = new User(2l, "Минсу", "1234055");
        User user2 = new User(3l, "Пак", "1234077");
        User user3 = new User(4l, "Енсе", "1234999");
        User user4 = new User(5l, "Ким", "1234045");
        User user5 = new User(7l, "Пак", "1234077");
        User user6 = new User(9l, "Ким", "1234045");
        User user7 = new User(10l, "Минсу", "1234055");
        User[] users = {user, user1, user2, user3, null, user4, null, user5, user6, user7};

        UserRepository userRepository = new UserRepository(users);

        //проверка findUser
        System.out.println(userRepository.findUser(new User(7l, "Пак", "1234077")));
        System.out.println(userRepository.findUser(null));

        //проверка save
//        System.out.println(userRepository.save(null));
//        System.out.println(userRepository.save(new User(11l, "Минсу", "1234055")));
//        System.out.println();
//        for (User el : users) {
//            System.out.println(el);
//        }

        //проверка delete - удаляет всех юзеров, у кого есть такое id
//        userRepository.delete(2l);
//        for (User us : users) {
//            System.out.println(us);
//        }

        //проверка update
//        System.out.println(userRepository.update(null));
//        System.out.println(userRepository.update(new User(11l, "Минсу", "1234055")));
//        System.out.println(userRepository.update(new User(9l, "Новый Минсу", "new-1234055")));
//        for (User us : users) {
//            System.out.println(us);
//        }
    }
}
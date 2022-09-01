package A_GROM_lesson.lesson27.A_HW.lesson27B;

public class Demo {
    public static void main(String[] args) throws Exception{
        User user = new User(0l, "Ким", "1234045");
        User user1 = new User(1l, "Минсу", "1234055");
        User user2 = new User(2l, "Пак", "1234077");
        User user3 = new User(3l, "Енсе", "1234999");
        User user4 = new User(4l, "Ким", "1234045");
        User user5 = new User(5l, "Пак", "1234077");
        User user6 = new User(6l, "Ким", "1234045");
        User user7 = new User(7l, "Минсу", "1234055");

        try{
            UserRepository.save(user);
            UserRepository.save(user1);
            UserRepository.save(user2);
            UserRepository.save(user3);
            UserRepository.save(user4);
            UserRepository.save(user5);
            UserRepository.save(user6);
            UserRepository.save(user7);
            UserRepository.save(new User(8l, "Минсу", "1234055"));
            UserRepository.save(new User(9l, "Минсу", "1234055"));
            System.out.println(UserRepository.update(new User(8l, "_", "")));
        }
        catch(Exception e){
            System.err.println("Error3: "+e.getMessage());
        }
        System.out.println(UserRepository.getUsers().toString());
    }
}
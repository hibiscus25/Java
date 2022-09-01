package G_JUnit;

import G_JUnit.java.Sex;
import G_JUnit.java.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;



public class A_UserTest {
    private User user;
    private User user1;
    private User user2;

    private User userNotAdd;
    private User userNotAdd1;


    @Before             // cоздает тестовые данные перед каждым запуском @Test
    public void setUp() throws Exception {
        user = new User("Евгений", 35, Sex.MALE);
        user1 = new User("Марина", 34, Sex.FEMALE);
        user2 = new User("Алина", 7, Sex.FEMALE);

        userNotAdd = new User("", 0, null);
        userNotAdd1 = new User(null, 0, null);
    }


    @Test
    public void getAllUsers() {
        //создаем список expected и заполняем его данными нашего метода
        List<User> expected = User.getAllUsers();

        //создаем список actual в него помещаем данные для сравнения
        //то что мы предпологиаем метод должен вернуть
        List<User> actual = new ArrayList<>();
            actual.add(user);
            actual.add(user1);
            actual.add(user2);

        //запускаем тест, в случае если список expected и actual не будут равны
        //тест будет провален, о результатах теста читаем в консоли
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getAllUsers_NO_NULL() {
        Assert.assertNotNull(User.getAllUsers());
    }


    @Test
    public void getAllUsers_MALE() {
        List<User> expected = User.getAllUsers(Sex.MALE);
        List<User> actual = new ArrayList<>();
            actual.add(user);

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getAllUsers_MALE_NO_NULL() {
        Assert.assertNotNull(User.getAllUsers(Sex.MALE));
    }


    @Test
    public void getAllUsers_FEMALE() {
        List<User> expected = User.getAllUsers(Sex.FEMALE);
        List<User> actual = new ArrayList<>();
            actual.add(user1);
            actual.add(user2);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getAllUsers_FEMALE_NO_NULL() {
        Assert.assertNotNull(User.getAllUsers(Sex.FEMALE));
    }


    @Test
    public void getHowManyUsers() {
        int expected = User.getHowManyUsers();
        int actual = 3;
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getHowManyUsers_MALE() {
        int expected = User.getHowManyUsers(Sex.MALE);
        int actual = 1;
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getHowManyUsers_FEMALE() {
        int expected = User.getHowManyUsers(Sex.FEMALE);
        int actual = 2;
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getAllAgeUsers() {
        int expected = User.getAllAgeUsers();
        int actual = 35 + 34 + 7;
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getAllAgeUsers_MALE() {
        Assert.assertEquals(User.getAllAgeUsers(Sex.MALE), 35);
    }


    @Test
    public void getAllAgeUsers_FEMALE() {
        int expected = User.getAllAgeUsers(Sex.FEMALE);
        int actual = 34 + 7;
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void newUser_EMPTY_NAME() {
        for (User user : User.getAllUsers()) {
            if (user.getName() != null && user.getName().isEmpty()) {
                Assert.fail("Попытка создания пользователя с пустым именем");
            }
        }
    }


    @Test
    public void newUser_AGE_ZERO() {
        for (User user : User.getAllUsers()) {
            if (user.getAge() <= 0) {
                Assert.fail("Попытка создания пользователя c не допустимым возрастом");
            }
        }
    }


    @Test
    public void newUser_SEX_NO_NULL() {
        for (User user : User.getAllUsers()) {
            if (user.getSex() == null) {
                Assert.fail("Попытка создания пользователя с указанием пола = null");
            }
        }
    }
}
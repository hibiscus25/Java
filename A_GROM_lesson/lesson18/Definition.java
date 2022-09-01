package A_GROM_lesson.lesson18;

public class Definition {
    private void notifyUsers(String[] userEmails){

        for(String email: userEmails){

            //обработка ошибки
            try{
                //send email to user-error
                System.out.println("Email "+email+" was sent");
            }catch(Exception e){
                //how should I handle exception
                System.out.println("Email "+email+" was not sent");
            }finally {

            }

            //1
            //2
            //3

        }
    }
}

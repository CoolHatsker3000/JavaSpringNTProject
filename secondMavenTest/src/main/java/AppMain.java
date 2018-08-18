import dao.UserDAO;
import entity.UserEntity;
import mappers.TabMapper;
import models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.UserService;
import utilities.QueryConstructor;

import java.util.List;
import java.util.Locale;


public class AppMain {
    public static void print(String st){
        System.out.println(st);
    }
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
        /*
        UserDAO ud=(UserDAO) ctx.getBean(UserDAO.class);
        List<UserEntity> UList=ud.getAll();
        for (UserEntity te:
                UList) {
            System.out.println(te.getUserId());
        }
        UserEntity us=ud.getByID(9993332299l);
        System.out.println(us.getUserId());
        */
        UserService userService=ctx.getBean(UserService.class);
        List<User> models=userService.getAll();
        for (User user:
             models) {
            System.out.println(user.getUserId());
        }
    }
}

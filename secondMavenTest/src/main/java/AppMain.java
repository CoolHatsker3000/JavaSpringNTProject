import dao.TariffDAO;
import dao.UserDAO;
import dao.UserTariffDAO;
import entity.TariffEntity;
import entity.UserEntity;
import entity.UserTariffEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.TariffAttrsAndInfoService;

import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        /*
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
        UserDAO userDAO=(UserDAO) ctx.getBean(UserDAO.class);
        UserEntity userEntity=new UserEntity(960,"pass1",0);
        UserEntity user=userDAO.selectUser(userEntity);
        System.out.println(user.getUserId());

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
        TariffAttrsAndInfoService service=ctx.getBean(TariffAttrsAndInfoService.class);
        System.out.println(service.getAttrInfo(2));
        */
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
        TariffDAO dao=ctx.getBean(TariffDAO.class);
        List<TariffEntity> tars=dao.getAll();
        for (TariffEntity te:tars
             ) {
            System.out.println(te.getTariffName());
        }
        dao.create(new TariffEntity(2,"Suka2"));
    }
}

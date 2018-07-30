import DAO.TariffDAOImpl;
import DAO.interfaces.TariffDAO;
import DAO.interfaces.UserTariffDAO;
import entity.TariffEntity;
import entity.UserTariffEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Locale;

public class AppMain {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
        TariffDAO tid=(TariffDAO) ctx.getBean(TariffDAOImpl.class);
        List<TariffEntity> TEList=tid.getAll();
        for (TariffEntity te:
                TEList) {
            System.out.println(te.getTariff_name());
        }
        UserTariffDAO utd=(UserTariffDAO) ctx.getBean(UserTariffDAO.class);
        List<UserTariffEntity> ute=utd.getAll();
        System.out.println(ute);


    }
}

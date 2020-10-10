import com.itheima.service.impl.IndexServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        //2.获取对象
        IndexServiceImpl indexService = (IndexServiceImpl) ac.getBean("indexService");

        System.out.println(indexService);
    }

}

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication(scanBasePackages = {"*.*"})
public class StudyMain {
    public static void main(String[] args) {
        //System.setProperty("DEPLOY_ENV", "dev");// TODO  上线前请去掉此句，在本机设置好环境变量也可去掉此句
        SpringApplication.run(StudyMain.class, args);
    }
}

package pages;

import com.dmgt.context.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailOnline {

@Autowired
Base base;

    public HomePage homePage(){
        return new HomePage(base);
    }
    public SportsPage SportsPage(){
        return new SportsPage(base);
    }


}

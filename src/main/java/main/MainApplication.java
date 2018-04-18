package main;

import child1.ChildContext1;
import child2.ChildContext2;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import root.RootContext;

public class MainApplication {
    public static void main(String[] args) {
        SpringApplicationBuilder appBuilder =
                new SpringApplicationBuilder()
                        .parent(RootContext.class)
                        .child(ChildContext1.class)
                        .sibling(ChildContext2.class).web(WebApplicationType.NONE).bannerMode(Banner.Mode.OFF);

        ConfigurableApplicationContext applicationContextChild2  = appBuilder.run();
        applicationContextChild2.setId("child2");
        /*((ConfigurableApplicationContext)applicationContext.getParent()).setId("root");*/
//
//        for (String bdn: applicationContext.getBeanDefinitionNames()) {
//            System.out.println("bdn = " + bdn);
//        }
    }
}

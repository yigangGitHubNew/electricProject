package org.spring.springboot;

import org.spring.springboot.event.MyApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
@SpringBootApplication
public class Application implements EmbeddedServletContainerCustomizer{

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
    	SpringApplication app = new SpringApplication(Application.class);
    	app.addListeners(new MyApplicationStartedEventListener());
    	app.run(args);
    }

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8088);
	}
    
    
}

package com.fjx.myYuQue;

// import org.mybatis.spring.annotation.MapperScan;
// import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;//新增
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.stereotype.Component;

// @MapperScan(value = "com.fjx.myYuQue.mapper.DocMapper")
// @SpringBootApplication(exclude= {DataSourceAutoConfiguration.class}, scanBasePackages = {"com.fjx"})//修改
@SpringBootApplication
public class MyYuQueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyYuQueApplication.class, args);
	}

}

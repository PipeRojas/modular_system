/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.researchgroup.modularsystem;

import edu.eci.researchgroup.modularsystem.ModularSystemApplication.SecurityConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Julian David Devia Serna
 */
@Configuration
@ComponentScan({ "edu.eci.researchgroup.web.*" })
@Import({SecurityConfiguration.class})
public class AppConfig {

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://ec2-54-225-104-61.compute-1.amazonaws.com:5432/dp7bium67ib3s?sslmode=require");
        driverManagerDataSource.setUsername("mzmyntsmpdxzgg");
        driverManagerDataSource.setPassword("0c3453217f36d2cb4e7fd1e7580db41305115432318183e538b4eb0a2d34ccc9");
        return driverManagerDataSource;
    }
    @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
        return new BCryptPasswordEncoder();
    	//return NoOpPasswordEncoder.getInstance();
    }
}

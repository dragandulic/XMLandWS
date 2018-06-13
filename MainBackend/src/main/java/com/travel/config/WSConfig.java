package com.travel.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WSConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean messageDispatcherServletAdmin(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/adminws/*");
	}
	
	
	@Bean
	public ServletRegistrationBean messageDispatcherServletUser(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/reguserws/*");
	}
	@Bean(name = "admin")
	public DefaultWsdl11Definition wsdlAdmin(XsdSchema adminSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("AdminPort");
		wsdl11Definition.setLocationUri("/adminws");
		wsdl11Definition.setTargetNamespace("http://www.travel.com/admin");
		wsdl11Definition.setSchema(adminSchema);
		return wsdl11Definition;
	}
	
	@Bean
	public ServletRegistrationBean messageDispatcherServletAccommodation(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/accommodationws/*");
	}
	
	@Bean
	public ServletRegistrationBean messageDispatcherServletRoom(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/roomws/*");
	}
	
	
	
	@Bean
	public XsdSchema adminSchema() {
		return new SimpleXsdSchema(new ClassPathResource("schemas/Admin.xsd"));
	}
	
	@Bean(name = "regUser")
	public DefaultWsdl11Definition wsdlRegUser(XsdSchema regUserSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("RegUSerPort");
		wsdl11Definition.setLocationUri("/reguserws");
		wsdl11Definition.setTargetNamespace("http://www.travel.com/reguser");
		wsdl11Definition.setSchema(regUserSchema);
		return wsdl11Definition;
	}
	@Bean
	public XsdSchema regUserSchema() {
		return new SimpleXsdSchema(new ClassPathResource("schemas/RegUser.xsd"));
	}
	
	@Bean(name = "accommodation")
	public DefaultWsdl11Definition wsdlAccommodation(XsdSchema accommodationSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("AccommodationPort");
		wsdl11Definition.setLocationUri("/accommodationws");
		wsdl11Definition.setTargetNamespace("http://www.travel.com/accommodation");
		wsdl11Definition.setSchema(accommodationSchema);
		return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema accommodationSchema() {
		return new SimpleXsdSchema(new ClassPathResource("schemas/Accommodation.xsd"));
	}
	
	@Bean(name = "room")
	public DefaultWsdl11Definition wsdlRoom(XsdSchema roomSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("RoomPort");
		wsdl11Definition.setLocationUri("/roomws");
		wsdl11Definition.setTargetNamespace("http://www.travel.com/room");
		wsdl11Definition.setSchema(roomSchema);
		return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema roomSchema() {
		return new SimpleXsdSchema(new ClassPathResource("schemas/Room.xsd"));
	}
	
	
	
	
	
}

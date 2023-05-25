package com.hospital.data.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hospital.data.entity.Doctor;
import com.hospital.data.entity.MedicalHistory;
import com.hospital.data.entity.MedicalObservation;
import com.hospital.data.entity.Person;

public class SessionFactoryUtil 
{
	private static SessionFactory sessionFactory=null;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
		Configuration cfg	=  new Configuration();
		cfg.setProperties(MysqlConnection.getMysqlDbConnection());
		cfg.addAnnotatedClass(Person.class);
		cfg.addAnnotatedClass(Doctor.class);
		cfg.addAnnotatedClass(MedicalHistory.class);
		cfg.addAnnotatedClass(MedicalObservation.class);
		sessionFactory = cfg.buildSessionFactory();
		}
		return sessionFactory;
	}
}

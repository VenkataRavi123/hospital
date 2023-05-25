package com.hospital.data.repository;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hospital.data.entity.Doctor;
import com.hospital.data.entity.Person;
import com.hospital.data.util.SessionFactoryUtil;

public class HospitalRepository 
{
	public void save(List<Doctor>doctor)
	{
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		doctor.forEach(e-> {
			
			List<Person> p=e.getPerson();
			p.forEach(e2->{
			e2.setDoctor(doctor);
		});
			
			session.save(e);
		});
		
		
		transaction.commit();

		
	}

}

package com.seakie;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession session = factory.openSession();
		
		List<Question> lst = session.selectList("Question.getAll");

		for (Question question : lst) {
			System.out.println(question.getContent());
		}
		session.commit();
		session.close();
	}

}

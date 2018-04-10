package com.gaia3d.pgjdbc;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyBatisTest {

	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void 마이바티스설정() {
		System.out.println(sqlFactory);
	}
	
	@Test
	public void 세션설정() {
		try(SqlSession session = sqlFactory.openSession()) {
			System.out.println(session);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

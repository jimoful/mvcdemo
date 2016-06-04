package com.fw.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fw.model.Enterprise;
import com.fw.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-dao.xml")
public class StudentMapperTest {

	@Autowired
	private StudentMapper studentMapper;

	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	@Test
	public void testSelectBySno() throws Exception {
		Student st = new Student();
		st.setSno("201322450530");

		Student st2 = studentMapper.selectBySno(st);
		System.out.println(st2);
	}

	@Test
	public void testSelectBySid() throws Exception {
		Student st = new Student();
		st.setSid(1);

		Student st2 = studentMapper.selectBySid(st);
		System.out.println(st2);
	}

	@Test
	public void testFindFollowingEnterpriseList() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", 0);
		map.put("limit", 3);
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		ids.add(4);
		ids.add(5);
		map.put("ids", ids);
		List<Enterprise> list = studentMapper.findFollowingEnterpriseList(map);
		System.out.println(list);
	}
}

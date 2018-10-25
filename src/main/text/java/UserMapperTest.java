import com.mapper.UserMapper;
import com.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class UserMapperTest {
	private ApplicationContext applicationContext;

	@Before
	public void before() throws IOException {
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/applicationContext-dao.xml");
	}

	@Test
	public void testfindUserByName() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext
				.getBean("userMapper");
		User user=new User();
		user.setUsername("陈");
		List<User> list = userMapper.findUserByName(user);
		System.out.println(list);
	}

}

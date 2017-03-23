package metier;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entite.Nationalite;

public class NationaliteServiceImplTest {
	
	private static NationaliteService service;
	
	@BeforeClass
	public static void loadContext()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		service = (NationaliteService) context.getBean("NationaliteService");
	}
	
	@Before
	public void setUp() throws Exception {
		service = new NationaliteServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRecupToutesNationalites() {
		//fail("Not yet implemented");
	}

	@Test
	public void testRecupNationaliteParId() {
		Nationalite nationalite = service.recupNationaliteParId(1);
		assertTrue("Afghanistan".equals(nationalite.getLibelleNationalite()));
		fail("Not yet implemented");
	}

}

package metier;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import entite.Nationalite;

public class NationaliteServiceImplTest {
	
	private NationaliteService service;
	
	@Before
	public void setUp() throws Exception {
		service = new NationaliteServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRecupToutesNationalites() {
		fail("Not yet implemented");
	}

	@Test
	public void testRecupNationaliteParId() {
		Nationalite nationalite = service.recupNationaliteParId(1);
		assertTrue("Afghanistant".equals(nationalite.getLibelleNationalite()));
		fail("Not yet implemented");
	}

}
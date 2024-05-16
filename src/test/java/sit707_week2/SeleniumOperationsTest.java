package sit707_week2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SeleniumOperationsTest {
	SeleniumOperations ins;

	@Test
	public void testStudentIdentity() {
		String studentId = "222207899";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Vishuddha Samarasekara";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Before
	public void setup() {
		ins = new SeleniumOperations();
	}

	@After
	public void close() {
		ins.driverclose();
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testUsernameEmptyPasswordEmpty() {
		thrown.expect(IllegalArgumentException.class);
		String results = ins.bunnings_registration_page(null, null);
		Assert.assertNull(results);
	}

	@Test
	public void testUsernameEmptyPasswordWrong() {
		thrown.expect(IllegalArgumentException.class);
		String results = ins.bunnings_registration_page(null, "qweasd");
		Assert.assertNull(results);
	}
	@Test
	public void testUsernameEmptyPasswordValid() {
		thrown.expect(IllegalArgumentException.class);
		String results = ins.bunnings_registration_page(null, "@gz2kx2en3Vh@uM");
		Assert.assertNull(results);
	}

	@Test
	public void testUsernameWrongPasswordEmpty() {
		thrown.expect(IllegalArgumentException.class);
		String results = ins.bunnings_registration_page("wrong@gmail.com", null);
		Assert.assertNull(results);
	}
	@Test
	public void testUsernameValidPasswordEmpty() {
		thrown.expect(IllegalArgumentException.class);
		String results = ins.bunnings_registration_page("s222207899@deakin.edu.au", null);
		Assert.assertNull(results);
	}

	@Test
	public void testUsernameWrongPasswordWrong() {
		String results = ins.bunnings_registration_page("wrong@gmail.com", "qweasd");
		Assert.assertEquals(results, "Login fails");
		System.out.println("Email Invalid + Password Invalid = Result Login fails");
	}
	@Test
	public void testUsernameValidPasswordWrong() {
		String results = ins.bunnings_registration_page("s222207899@deakin.edu.au", "qweasd");
		Assert.assertEquals(results, "Login fails");
		System.out.println("Eail valid + Password Invalid = Result Login fails");
	}
	@Test
	public void testUsernameWrongPasswordValid() {
		String results = ins.bunnings_registration_page("wrong@gmail.com", "@gz2kx2en3Vh@uM");
		Assert.assertEquals(results, "Login fails");
		System.out.println("Eail Invalid + Password valid = Result Login fails");
	}
	@Test
	public void testUsernameValidPasswordValid() {
		String results = ins.bunnings_registration_page("s222207899@deakin.edu.au", "@gz2kx2en3Vh@uM");
		Assert.assertEquals(results, "Login succeed");
		System.out.println("Eail Invalid + Password valid = Result Login Success");
	}
}

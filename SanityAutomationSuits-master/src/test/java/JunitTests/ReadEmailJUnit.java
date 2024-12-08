package JunitTests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.utility.ReadEmail;

public class ReadEmailJUnit {
	public static ReadEmail read = new ReadEmail();

	@Test
	public static void f() {

		read.getOtp("Purchase Transaction OTP");

	}

}

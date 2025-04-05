package practice;

//import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ToLearnAssertion {
	@Test
	public void sample() {
		
		System.out.println("---Step1---");
		System.out.println("---Step2---");
		
		//Validation using hard assert
		//Assert.assertEquals(false, true);
		
		//Validate with Soft Assert
		SoftAssert as = new SoftAssert();
		as.assertEquals(false, true); //faield
		
		System.out.println("---Step3---");
		System.out.println("---Step4---");
		as.assertAll();
		
	}

}

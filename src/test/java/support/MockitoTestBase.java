package support;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class MockitoTestBase {
		
	/**
	 * Initializes Mockito mocks.
	 */
	@BeforeMethod(alwaysRun=true, description="Initialize mocks.")
	public void initMock() {
	    MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Validates framework usage.
	 */
	@AfterMethod(alwaysRun=true, description="Validates framework usage.")
	public void validateFrameworkUsage() {
	    Mockito.validateMockitoUsage();
	}

}

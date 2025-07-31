package com.ipacs.qa.icm.tests;

import org.testng.annotations.Test;

import com.ipacs.qa.baseclass.TestBase;
import com.ipacs.qa.icm.pages.PolicyAndProcedures;

public class PolicyandProceduresTest extends TestBase 
{ 

	PolicyAndProcedures policyandprocedures;

		
	
	
		  @Test(priority=1)
	  
		  public void validateCorrectUsernameandCorrectPassword() throws Exception
		  {
			  policyandprocedures.login("partnercode","username", "password"); 
		  Thread.sleep(8000);
		  policyandprocedures.clickPolicyAndProcedures();
		  }
		  
		
		  

}
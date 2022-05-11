package APITesting.com.api;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import API.businessfn.APIUtils;

public class APITest
{
    protected static final Logger log = Logger.getLogger(APITest.class);

    APIUtils apiUtils = new APIUtils();

    @BeforeTest
    public void urlCheck()
    {
        apiUtils.con();
    }

    @Test(priority = 0)
    public void acceptenceTest_StatusCode()
    {
        try {
            apiUtils.acceptenceCriteriaValidation_StatusCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void acceptenceCriteriaValidation_Name()
    {
        try {
            apiUtils.acceptenceCriteriaValidation_Name();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void acceptenceCriteriaValidation_CanRelist()
    {
        try {
            apiUtils.acceptenceCriteriaValidation_CanRelist();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void acceptenceCriteriaValidation_Description()
    {
        try {
            apiUtils.acceptenceCriteriaValidation_Description();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

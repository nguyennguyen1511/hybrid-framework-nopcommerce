package commons;

import java.io.File;

public class GlobalConstants {
	//url
	//usernam
	//password
	//user/pass
	//server-environment
	public static final String PORTAL_DEV_URL ="https://demo.nopcommerce.com";
	public static final String ADMIN_DEV_URL = "https://admin-demo.nopcommerce.com";
	public static final String PORTAL_STAGING_URL ="https://demo.nopcommerce.com";
	public static final String ADMIN_STAGING_URL = "https://admin-demo.nopcommerce.com";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAGDROP_HTML5 = PROJECT_PATH + File.separator + "dagDrophtml5";
	public static final String REPORTING_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;
	
	public static final String DB_DEV_URL ="32.18.252.185:9865";
	public static final String DB_DEV_USER ="AUTOMATION";
	public static final String DB_DEV_PASS ="Abcd@123";
	
	public static final String DB_STAGING_URL ="32.18.252.185:9865";
	public static final String DB_STAGING_USER ="AUTOMATION";
	public static final String DB_STAGING_PASS ="Abcd@123";
	
	public static final long SHORT_TIMEOUT =5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAIL= 3;

}

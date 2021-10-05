package javaBasic;

import org.apache.commons.exec.OS;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_12_String {

	public static void main(String[] args) {
		//khai báo kiểu nguyên thủy
		String s1 = "cat";
		//tạo ra 1 vùng nhớ mới
		s1 = "Dog";
		String s2 = s1;
		//khai báo kiểu đối tượng
		String s3 = new String("cat");
		
		// tìm hiểu các phương thức của String
		
		System.setProperty("webdriver.gecko.driver", "/browser/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		
		String schoolName = "Automation Testing Advance";
		String courseName = "AUTOMATION TESTING";
		String schoolAddress = "HCM";
		
		System.out.println("Độ dài = " + schoolName.length());
		System.out.println("Lấy ra 1 kí tự = " + schoolName.charAt(0));
		System.out.println("Nối chuỗi = " + schoolName.concat(schoolAddress));
		System.out.println("Nối chuỗi = " + schoolName + schoolAddress);
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equals("Automation Testing"));
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tương đối = " + schoolName.equalsIgnoreCase(courseName));
		//StarsWith/endsWith/contains
		System.out.println("Có bắt đầu bằng 1 kí tự/1 chuỗi = " + schoolName.startsWith("A"));
		System.out.println("Có bắt đầu bằng 1 kí tự/1 chuỗi = " + schoolName.startsWith("Automation"));
		System.out.println("Có chứa bằng 1 kí tự/1 chuỗi = " + schoolName.contains("A"));
		System.out.println("Có chứa bằng 1 kí tự/1 chuỗi = " + schoolName.endsWith("Advance"));
		System.out.println("Vị trí 1 kí tự/1 chuỗi = " + schoolName.indexOf("Auto"));
		System.out.println("Tách 1 kí tự/1 chuỗi = " + schoolName.substring(11,15));
		
		//tách chuỗi thành mảng dựa vào 1 kí tự/1 chuỗi
		String result ="Viewing 48 of 320 results";
		String results[] = result.split("");
		System.out.println(results[1]);
		
		//replace
		String productPrice = "$100.00";
		productPrice = productPrice.replace("$", "");
		System.out.println(productPrice);
		//convert qua float
		float productPriceF = Float.parseFloat(productPrice);
		System.out.println(productPriceF);
		
		//convert qua string
		productPrice = String.valueOf(productPriceF);
		
		
		String osName = System.getProperty("os.name");
		System.out.println(osName);
		//window 10
		//Handle multiple OS: MAC/Windows
		if (osName.toLowerCase().contains("windows")){
			Keys Key = Keys.CONTROL;
		}else {
			Keys key = Keys.COMMAND;
		}
		
		String driverInstanceName = driver.toString();
		System.out.println(driverInstanceName);
		//FirefoxDriver
		//Close browser/driver
		if (driverInstanceName.contains("intenetexployer")) {
			//sleep cung them 5s
		}
		
		String helloWorld = "  \n Hellow World	";
		System.out.println(helloWorld.trim());
		
		
		helloWorld = " ";
		System.out.println(helloWorld.isEmpty());
		//System.out.println(helloWorld.isBlank());
		
		//Dynamic locator
		//dai dien cho 1 chuoi :%s
		//%b %d %t
		String dynamicXpath = "//button[@id='%s'";
		System.out.println("Click to login button" + dynamicXpath.format(dynamicXpath, "login"));
		System.out.println("Click to search button" + dynamicXpath.format(dynamicXpath, "search"));
		System.out.println("Click to register button" + dynamicXpath.format(dynamicXpath, "register"));
	}

}

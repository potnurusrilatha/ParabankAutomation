package parabank_testautomation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Reporter;

public class CommonRLoan {
	public static void log(String logtype,String msg) {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY:hh:mm:ss");
		String date=sdf.format(d).toString();
		Reporter.log(date+"|"+logtype+"|"+msg+	"<br>",true	);
	}

}



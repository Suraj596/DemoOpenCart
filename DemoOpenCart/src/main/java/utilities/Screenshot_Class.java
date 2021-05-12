package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Screenshot_Class {
	public static void screenshot(WebDriver driver) throws IOException {
		
        Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
        ImageIO.write(s.getImage(),"PNG",new File("./Screenshot/Takescreenshot"+timestamp()+".png"));
        System.out.println("The screenshot is taken");
        
	}

	public static String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
}

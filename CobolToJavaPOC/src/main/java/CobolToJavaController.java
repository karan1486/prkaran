import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/CobolToJavaController")
public class CobolToJavaController {


	@Value("${RPVFPO0Z}")
	String DOMAIN_NAME;
	
@RequestMapping(value = "/convert", method = RequestMethod.GET)
public void convertCobolToJava(){
	System.out.println(DOMAIN_NAME);
	
}
}

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;


public class velocity {

	/**
	 * @param args
	 */
	public   void sd() {
		// TODO Auto-generated method stub
		try {
			VelocityEngine ve = new VelocityEngine();
			ve.init();
			Template t = ve.getTemplate("hellosite.vm");
			VelocityContext context = new VelocityContext();
			
			Hashtable ht=new Hashtable();
			 ht.put("one", "ma");
			 ht.put("two", "sc");
			 ht.put("three", "ds");
			context.put("map", ht); 
			 
			StringWriter writer = new StringWriter();
			t.merge(context, writer);
			System.out.println( writer.toString() ); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}  
	}

}

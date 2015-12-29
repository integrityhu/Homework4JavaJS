import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/*
 * http://docs.oracle.com/javase/7/docs/technotes/guides/scripting/programmer_guide/#scriptvars
 * 
 */
public class Homework4JavaJS {

	public static void main(String[] args) {
		Person p = new Person();
		p.setAge((byte) 35);
		p.setName("Korda Sándor");
		p.setId(1);

		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine engine = engineManager.getEngineByName("javascript");

		// Java 7 -> Mozilla Rhino
		// Java 8 -> Nashorn ->
		// http://www.oracle.com/technetwork/articles/java/jf14-nashorn-2126515.html

		try {
			engine.put("c", 4);
			engine.put("f", 5);
			engine.eval("function sum(a, b) { return a + b; }; f = sum(f,c);");
			System.out.println(engine.eval("sum(1, 2);"));
			System.out.println(engine.get("f"));
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}

}

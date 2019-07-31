package ini.test.typing;

import ini.parser.IniParser;
import ini.type.AstAttrib;
import junit.framework.TestCase;

public class TestArrays extends TestCase {

	public TestArrays(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testWrongReturnTypeInRecursiveFunction() {
		try {
			IniParser parser = IniParser.parseCode(
					"function main() { @init() {"+
					"	a[\"a\"] = 1"+
					"	a[\"b\"] = 1.2"+ 
					"} }");
			assertEquals("expected 0 errors: "+parser.errors, 0, parser.errors.size());
			AstAttrib attrib = parser.attrib();
			assertEquals("expected 2 error: "+attrib.errors, 2, attrib.errors.size());
			assertEquals("wrong type of error: "+attrib.errors, "type mismatch: 'Int' is not compatible with 'Float'", attrib.errors.get(0).message);
			assertEquals("wrong type of error: "+attrib.errors, "type mismatch: 'Int' is not compatible with 'Float'", attrib.errors.get(1).message);
		} catch (Exception e) {
			fail();
		}
	}

	public void testWrongParameterType() {
		try {
			IniParser parser = IniParser.parseCode(
					"function main() { @init() { f(1.2) } }"+
					"function f(n) { @end() { return n+1 } }");
			assertEquals("expected 0 errors: "+parser.errors, 0, parser.errors.size());
			AstAttrib attrib = parser.attrib();
			assertEquals("expected 2 error: "+attrib.errors, 2, attrib.errors.size());
			assertEquals("wrong type of error: "+attrib.errors, "type mismatch: 'Float' is not compatible with 'Int'", attrib.errors.get(0).message);
			assertEquals("wrong type of error: "+attrib.errors, "type mismatch: 'Float' is not compatible with 'Int'", attrib.errors.get(1).message);
		} catch (Exception e) {
			fail();
		}
	}
	
	public void testPolymorphicFunction() {
		try {
			IniParser parser = IniParser.parseCode(
					"function main() { @init() { println(f([1,3])) println(f(\"13\")) } }"+
					"function f(l) { @end() { swap(l[0],l[1]) return l } }");
			assertEquals("expected 0 errors: "+parser.errors, 0, parser.errors.size());
			AstAttrib attrib = parser.attrib();
			assertEquals("expected 0 error: "+attrib.errors, 0, attrib.errors.size());
		} catch (Exception e) {
			fail();
		}
	}

	public void testWrongPolymorphicFunctionInvocation() {
		try {
			IniParser parser = IniParser.parseCode(
					"function main() { @init() { println(f([1,3])) println(f(\"13\")) println(f(1.2)) } }"+
					"function f(l) { @end() { swap(l[0],l[1]) return l } }");
			assertEquals("expected 0 errors: "+parser.errors, 0, parser.errors.size());
			AstAttrib attrib = parser.attrib();
			assertEquals("expected 3 error: "+attrib.errors, 3, attrib.errors.size());
			assertEquals("wrong type of error: "+attrib.errors, "type mismatch", attrib.errors.get(0).message.substring(0,13));
			assertEquals("wrong type of error: "+attrib.errors, "type mismatch", attrib.errors.get(1).message.substring(0,13));
			assertEquals("wrong type of error: "+attrib.errors, "type mismatch", attrib.errors.get(2).message.substring(0,13));
		} catch (Exception e) {
			fail();
		}
	}
	
}
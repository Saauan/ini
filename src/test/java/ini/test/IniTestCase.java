package ini.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ini.Main;
import ini.parser.IniParser;
import ini.type.AstAttrib;
import junit.framework.TestCase;

public abstract class IniTestCase extends TestCase {

	static final Logger logger = LoggerFactory.getLogger("test");

	private ByteArrayOutputStream outputStream;
	private PrintStream out;

	public IniTestCase(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		outputStream = new ByteArrayOutputStream();
		out = new PrintStream(outputStream);
		//System.setOut(out);
	}

	protected void parseAndAttribCode(String code, Consumer<IniParser> parsingAssertions, Consumer<AstAttrib> attribAssertions) {
		try {
			IniParser parser = IniParser.createParserForCode(null, null, code);
			parser.parse();
			parsingAssertions.accept(parser);
			AstAttrib attrib = Main.attrib(parser);
			attribAssertions.accept(attrib);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	protected void parseAndAttribFile(String file, Consumer<IniParser> parsingAssertions, Consumer<AstAttrib> attribAssertions) {
		try {
			IniParser parser = IniParser.createParserForFile(null, null, file);
			parser.parse();
			parsingAssertions.accept(parser);
			AstAttrib attrib = Main.attrib(parser);
			attribAssertions.accept(attrib);
		} catch (Exception e) {
			fail();
		}
	}
	
	protected void testFile(String file, BiConsumer<IniParser, String> assertions) {
		testFile(file, 0, null, assertions);
	}

	protected void testFile(String file, String node, BiConsumer<IniParser, String> assertions) {
		testFile(file, 0, node, assertions);
	}

	protected void testFile(String file, long sleepTime, BiConsumer<IniParser, String> assertions) {
		testFile(file, sleepTime, null, assertions);
	}

	protected void testFile(String file, long sleepTime, String node, BiConsumer<IniParser, String> assertions) {
		try {
			IniParser parser = file == null ? IniParser.createParserForCode(null, null, "process main() {}") : IniParser.createParserForFile(null, null, file);
			if (node != null) {
				parser.env.deamon = true;
				parser.env.node = node;
			}
			parser.parse();
			assertEquals("expected 0 errors: " + parser.errors, 0, parser.errors.size());
			Main.evalMainFunction(parser, null);
			if (sleepTime > 0) {
				Thread.sleep(sleepTime);
			}
			if (assertions != null) {
				assertions.accept(parser, outputStream.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	protected String getOut() {
		return outputStream.toString();
	}
	
}
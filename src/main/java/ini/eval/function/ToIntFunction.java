package ini.eval.function;

import ini.ast.Invocation;
import ini.eval.IniEval;
import ini.eval.data.Data;
import ini.eval.data.RawData;
import ini.parser.IniParser;
import ini.type.AstAttrib;
import ini.type.Type;

public class ToIntFunction extends BuiltInExecutable {

	public ToIntFunction(IniParser parser) {
		super(parser, "to_int", "data");
	}

	@Override
	public void eval(IniEval eval) {
		Data d = getArgument(eval, 0);
		if(d.getValue() instanceof String) {
			eval.result = new RawData(Integer.parseInt(d.getValue()));
		} else {
			eval.result = new RawData(getArgument(eval, 0).getNumber().intValue());
		}
	}

	@Override
	public Type getFunctionalType(AstAttrib attrib, Invocation invocation) {
		return attrib.parser.types.createFunctionalType(attrib.parser.types.INT, attrib.parser.types.ANY);
	}	
	
}

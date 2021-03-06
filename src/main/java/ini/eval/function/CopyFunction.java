package ini.eval.function;

import ini.ast.Invocation;
import ini.eval.IniEval;
import ini.eval.data.Data;
import ini.eval.data.RawData;
import ini.parser.IniParser;
import ini.type.AstAttrib;
import ini.type.Type;

public class CopyFunction extends BuiltInExecutable {

	public CopyFunction(IniParser parser) {
		super(parser, "copy", "data");
	}
	
	@Override
	public void eval(IniEval eval) {
		Data d = new RawData(null);
		d.copyData(getArgument(eval, 0));
		eval.result = d;
	}

	@Override
	public Type getFunctionalType(AstAttrib attrib, Invocation invocation) {
		Type functionType = new Type(attrib.parser.types,"function");
		Type t = new Type(attrib.parser.types);
		functionType.setReturnType(t);
		functionType.addTypeParameter(t);
		return functionType;
	}
	
}

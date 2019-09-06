package ini.eval.function;

import ini.eval.IniEval;
import ini.parser.IniParser;
import ini.type.AstAttrib;
import ini.type.Type;
import ini.type.TypingConstraint.Kind;

public class WaitFunction extends BuiltInExecutable {

	public WaitFunction(IniParser parser) {
		super(parser, "wait", "data");
	}

	@Override
	public void eval(IniEval eval) {
		eval.result = getArgument(eval, 0).getIfAvailable();
	}

	@Override
	public Type getFunctionalType(AstAttrib attrib) {
		Type t = attrib.parser.types.createType();
		return attrib.parser.types.createFunctionalType(t, t);
	}

	@Override
	protected void buildTypingConstraints() {
		addTypingConstraint(Kind.EQ, getParameterType(0), getReturnType());
	}
	
}

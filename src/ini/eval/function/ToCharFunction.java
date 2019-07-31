package ini.eval.function;

import ini.ast.Expression;
import ini.ast.Invocation;
import ini.eval.IniEval;
import ini.eval.data.Data;
import ini.eval.data.RawData;
import ini.parser.IniParser;
import ini.type.Type;
import ini.type.TypingConstraint;

import java.util.List;

public class ToCharFunction extends IniFunction {

	@Override
	public Data eval(IniEval eval, List<Expression> params) {
		return new RawData((char)eval.eval(params.get(0)).getNumber().byteValue());
	}

	@Override
	public Type getType(IniParser parser,
			List<TypingConstraint> constraints, Invocation invocation) {
		Type t = new Type(parser);
		constraints.add(new TypingConstraint(TypingConstraint.Kind.LTE, t,
				parser.ast.DOUBLE, invocation, invocation));
		return parser.ast.getFunctionalType(parser.ast.CHAR, t);
	}
	
}
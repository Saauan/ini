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

public class ParseNumberFunction extends IniFunction {

	@Override
	public Data eval(IniEval eval, List<Expression> params) {
		return new RawData(Double.parseDouble(((String)eval.eval(params.get(0)).getValue())));
	}

	@Override
	public Type getType(IniParser parser,
			List<TypingConstraint> constraints, Invocation invocation) {
		return parser.types.createFunctionalType(parser.types.DOUBLE, parser.types.STRING);
	}

}

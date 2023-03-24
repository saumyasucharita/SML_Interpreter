
public class WhileExp extends Expr{
	public final Expr condition;
	public final Expr body;
	public static Value returnVal;
	public WhileExp(Expr _condition, Expr _body) {
		condition = _condition;
		body = _body;
	}
	public Value eval(Env e) throws EvalError{
		Value cond_val = condition.eval(e);
		if (cond_val instanceof BoolVal)  
		{
			while(((BoolVal) cond_val).value) {
				returnVal =  body.eval(e);
				cond_val = condition.eval(e); 
			}
		}
		else 
			throw new EvalError("Evaluation error: While condition should be of boolean type");
		return returnVal;
	}
	public String toString() {
	    return "while " + condition.toString() + " do " + body.toString();
	  }
}

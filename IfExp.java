
public class IfExp extends Expr{
	public final Expr condition;
	public final Expr then_expr;
	public final Expr else_expr;
	public IfExp(Expr _condition, Expr _then_expr, Expr _else_expr) {
		condition = _condition;
		then_expr = _then_expr;
		else_expr = _else_expr;
	}
	public Value eval(Env e) throws EvalError{
		Value cond_val = condition.eval(e);
		if (cond_val instanceof BoolVal)  
		{
			if(((BoolVal) cond_val).value == true)
			{
				return then_expr.eval(e);
			}
			else
			{
				return else_expr.eval(e);
			}
		}
		else 
			throw new EvalError("Evaluation error: If condition should be of boolean type");
	}
	public String toString() {
	    return "if" + condition.toString() + "then" + then_expr.toString() + "else" + else_expr.toString();
	  }
}


public class LetValExp extends Expr{
	public final String id;
	public final Expr arg1;
	public final Expr arg2;
	
	public LetValExp(String _id, Expr _arg1, Expr _arg2) {
		id = _id;
		arg1 = _arg1;
		arg2 = _arg2;
	}
	public Value eval(Env e) throws EvalError{
		Value v1 = arg1.eval(e);
		Env e2 = e.addBinding(id, v1);
		return arg2.eval(e2);
	}
	public String toString() {
		return "let val "+id+" = "+arg1+" in "+arg2+" end";
	}
}


public class VarExp extends Expr{
	public final String var;
	public VarExp(String _var) {
		var = _var;
	}
	public Value eval(Env e) throws UnboundVar {
		Value v = e.lookup(var); //lookup() here or in actions of .jj file
		return v;
	}
	public String toString() {
		return var.toString();
	}
}

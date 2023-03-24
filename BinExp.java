
public class BinExp extends Expr{
	public final BinOp bin_op; 
	public final Expr arg1;
	public final Expr arg2;
	public static Value result = null;

	public BinExp(BinOp _op, Expr _arg1, Expr _arg2) {
		bin_op = _op;
		arg1 = _arg1;
		arg2 = _arg2;
	}

	public Value eval(Env e) throws EvalError {
		Value left = arg1.eval(e);
		Value right = arg2.eval(e);
		switch(bin_op){
		case PLUS:
		{
			if((left instanceof IntVal)&&(right instanceof IntVal)) {
			result = new IntVal(((IntVal)left).value+((IntVal)right).value);
			break;
			}
			else
				throw new EvalError("Evaluation error: case PLUS: Arguments should be of integer types");
			
		}
		case MINUS:
		{
			if((left instanceof IntVal)&&(right instanceof IntVal)) {
			result = new IntVal(((IntVal)left).value-((IntVal)right).value);
			break;
			}
			else
				throw new EvalError("Evaluation error: case MINUS: Arguments should be of integer types");
			}
		case TIMES:
		{
			if((left instanceof IntVal)&&(right instanceof IntVal)) {
				result = new IntVal(((IntVal)left).value*((IntVal)right).value);
				break;
			}
			else
				throw new EvalError("Evaluation error: case TIMES: Arguments should be of integer types");
		}
		case DIV:
		{
			if((left instanceof IntVal)&&(right instanceof IntVal)) {
				result = new IntVal(((IntVal)left).value/((IntVal)right).value);
				break;
			}
			else
				throw new EvalError("Evaluation error: case DIV: Arguments should be of integer types");
		}
		case EQ:
		{
			if((left instanceof IntVal)&&(right instanceof IntVal)) {
				result = new BoolVal(((IntVal)left).value == ((IntVal)right).value);
				break;
			}
			else
				throw new EvalError("Evaluation error: case EQ: Arguments should be of integer types");
		}
		case LT:
		{
			if((left instanceof IntVal)&&(right instanceof IntVal)) {
				result = new BoolVal(((IntVal)left).value < ((IntVal)right).value);
				break;
			}
			else
				throw new EvalError("Evaluation error: case LT: Arguments should be of integer types");
		}
		case AND:// Short circuiting
		{
			if((left instanceof BoolVal)&&(right instanceof BoolVal)) {
				if(((BoolVal)left).value == false) {
					result = new BoolVal(((BoolVal)left).value);
				}
				else
				{
					result = new BoolVal(((BoolVal)right).value);
				}
				break;
			}
			else
				throw new EvalError("Evaluation error: case AND: Arguments should be of boolean types");
		}
		case OR:// Short circuiting
		{
			if((left instanceof BoolVal)&&(right instanceof BoolVal)) {
				if(((BoolVal)left).value == true) {
					result = new BoolVal(((BoolVal)left).value);
				}
				else
				{
					result = new BoolVal(((BoolVal)right).value);
				}
				break;
			}
			else
				throw new EvalError("Evaluation error: case OR: Arguments should be of boolean types");

		}
		default:
			return result;
			//throw new EvalError("Evaluation error: Incompatible arg types: In binary expression");
		}
		return result;
		}
	public String toString() {
		return arg1 + " " + bin_op + " " + arg2;
	}	 

}

// Generated from C:/Users/Moham/Desktop/cool/COOL Parser/src\Parsing.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link ParsingVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class ParsingBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements ParsingVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	private int temp;
	private int label;
	@Override public T visitStart(ParsingParser.StartContext ctx) {
		temp = 1;
		label = 1;
		return visitChildren(ctx);
	}


	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitClassDef(ParsingParser.ClassDefContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitFunction(ParsingParser.FunctionContext ctx) {
		System.out.println(ctx.ID().getText()+":");
		System.out.println("BeginFunc");
		visit(ctx.expr());
		System.out.println("EndFunc");
		return null;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitVarDef(ParsingParser.VarDefContext ctx) {
		if(ctx.children.size() > 3){
			String exprValue = (String) visit(ctx.expr());
			System.out.printf("%s = %s\n", ctx.ID().getText(), exprValue);
		}
		return null; }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitParam(ParsingParser.ParamContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSub(ParsingParser.SubContext ctx) {
		String expr1Value = (String) visit(ctx.expr(0));
		String expr2Value = (String) visit(ctx.expr(1));
		System.out.printf("t%d = %s - %s\n", temp, expr1Value, expr2Value);
		return (T) String.valueOf("t" + temp++);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitString(ParsingParser.StringContext ctx) {

		return (T) ctx.STRING().getText(); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitMul(ParsingParser.MulContext ctx) {
		String expr1Value = (String) visit(ctx.expr(0));
		String expr2Value = (String) visit(ctx.expr(1));
		System.out.printf("t%d = %s * %s\n", temp, expr1Value, expr2Value);
		return (T) String.valueOf("t" + temp++);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitLteq(ParsingParser.LteqContext ctx) {
		String rightValue = (String) visit(ctx.expr(0));
		String leftValue = (String) visit(ctx.expr(1));
		System.out.printf("t%d = %s <= %s\n", temp, rightValue, leftValue);
		return (T) ("t" + (temp++));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitNum(ParsingParser.NumContext ctx) {
		return (T) ctx.NUM().getText();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitStaticCall(ParsingParser.StaticCallContext ctx) {
		int paramSize = ctx.expr().size();
		String params[] = new String[paramSize];
		for(int i=0; i < paramSize; ++i)
			params[i] = (String) visit(ctx.expr(i));
		for(int i=0; i < paramSize; ++i)
			System.out.println("param " + params[i]);
		System.out.printf("t%d = call %s, %d\n", temp, ctx.ID().getText(), paramSize);
		return (T) String.valueOf("t" + (temp++));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitLt(ParsingParser.LtContext ctx) {
		String rightValue = (String) visit(ctx.expr(0));
		String leftValue = (String) visit(ctx.expr(1));
		System.out.printf("t%d = %s < %s\n", temp, rightValue, leftValue);
		return (T) ("t" + (temp++));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitWhile(ParsingParser.WhileContext ctx) {
		String boolValue = (String) visit(ctx.expr(0));
		System.out.printf("L%d:\n", label);
		System.out.printf("ifFalse %s goto L%d\n", boolValue, label + 1);
		visit(ctx.expr(1));
		System.out.printf("goto L%d\n", label++);
		System.out.printf("L%d:\n", label);
		return null;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSwitch(ParsingParser.SwitchContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDiv(ParsingParser.DivContext ctx) {
		String expr1Value = (String) visit(ctx.expr(0));
		String expr2Value = (String) visit(ctx.expr(1));
		System.out.printf("t%d = %s / %s\n", temp, expr1Value, expr2Value);
		return (T) ("t" + temp++);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitNot(ParsingParser.NotContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitNewObject(ParsingParser.NewObjectContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBlock(ParsingParser.BlockContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitLet(ParsingParser.LetContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitId(ParsingParser.IdContext ctx) {
		return (T) ctx.ID().getText();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitIf(ParsingParser.IfContext ctx) {
		String boolValue = (String) visit(ctx.expr(0));
		System.out.printf("ifFalse %s goto L%d\n", boolValue, label);
		visit(ctx.expr(1));
		System.out.printf("goto L%d\n", label + 1);
		System.out.printf("L%d:\n", label++);
		visit(ctx.expr(2));
		System.out.printf("L%d:\n", label++);
		return null;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAdd(ParsingParser.AddContext ctx) {
		String expr1Value = (String) visit(ctx.expr(0));
		String expr2Value = (String) visit(ctx.expr(1));
		System.out.printf("t%d = %s + %s\n", temp, expr1Value, expr2Value);
		return (T) ("t" + temp++);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitVoid(ParsingParser.VoidContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitInvert(ParsingParser.InvertContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitFactExpr(ParsingParser.FactExprContext ctx) {
		String exprValue = (String) visit(ctx.expr());
		System.out.printf("t%d = %s\n", temp, exprValue);
		return (T) ("t" + (temp++));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitFalse(ParsingParser.FalseContext ctx) {
		return (T) ctx.FALSE().getText();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitEqual(ParsingParser.EqualContext ctx) {
		String rightValue = (String) visit(ctx.expr(0));
		String leftValue = (String) visit(ctx.expr(1));
		System.out.printf("t%d = %s = %s\n", temp, rightValue, leftValue);
		return (T) ("t" + (temp++));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitObjectCall(ParsingParser.ObjectCallContext ctx) {
		int paramSize = ctx.expr().size();
		String params[] = new String[paramSize-1];
		for(int i=1; i < paramSize; ++i)
			params[i-1] = (String) visit(ctx.expr(i));
		for(int i=0; i < paramSize-1; ++i)
			System.out.println("param " + params[i]);
		System.out.printf("t%d = call %s, %d\n", temp, ctx.ID().getText(), paramSize);
		return (T) String.valueOf("t" + (temp++));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitTrue(ParsingParser.TrueContext ctx) {
		return (T) ctx.TRUE().getText();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAssign(ParsingParser.AssignContext ctx) {
		String exprValue = (String) visit(ctx.expr());
		System.out.printf("%s = %s\n", ctx.ID().getText(), exprValue);
		return null;
	}
}
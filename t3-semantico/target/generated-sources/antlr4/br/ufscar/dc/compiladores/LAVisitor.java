// Generated from java-escape by ANTLR 4.11.1
package br.ufscar.dc.compiladores;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LAParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LAVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LAParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(LAParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#declaracao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao(LAParser.DeclaracaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#expressaoAritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressaoAritmetica(LAParser.ExpressaoAritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#termoAritmetico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermoAritmetico(LAParser.TermoAritmeticoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#fatorAritmetico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFatorAritmetico(LAParser.FatorAritmeticoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#expressaoRelacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressaoRelacional(LAParser.ExpressaoRelacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#termoRelacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermoRelacional(LAParser.TermoRelacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComando(LAParser.ComandoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#comandoAtribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoAtribuicao(LAParser.ComandoAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#comandoEntrada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoEntrada(LAParser.ComandoEntradaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#comandoSaida}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoSaida(LAParser.ComandoSaidaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#comandoCondicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoCondicao(LAParser.ComandoCondicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#comandoRepeticao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoRepeticao(LAParser.ComandoRepeticaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LAParser#subAlgoritmo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubAlgoritmo(LAParser.SubAlgoritmoContext ctx);
}
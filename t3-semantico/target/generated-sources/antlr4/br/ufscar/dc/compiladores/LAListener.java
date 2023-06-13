// Generated from java-escape by ANTLR 4.11.1
package br.ufscar.dc.compiladores;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LAParser}.
 */
public interface LAListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LAParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(LAParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(LAParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(LAParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(LAParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#expressaoAritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoAritmetica(LAParser.ExpressaoAritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#expressaoAritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoAritmetica(LAParser.ExpressaoAritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#termoAritmetico}.
	 * @param ctx the parse tree
	 */
	void enterTermoAritmetico(LAParser.TermoAritmeticoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#termoAritmetico}.
	 * @param ctx the parse tree
	 */
	void exitTermoAritmetico(LAParser.TermoAritmeticoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#fatorAritmetico}.
	 * @param ctx the parse tree
	 */
	void enterFatorAritmetico(LAParser.FatorAritmeticoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#fatorAritmetico}.
	 * @param ctx the parse tree
	 */
	void exitFatorAritmetico(LAParser.FatorAritmeticoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#expressaoRelacional}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoRelacional(LAParser.ExpressaoRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#expressaoRelacional}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoRelacional(LAParser.ExpressaoRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#termoRelacional}.
	 * @param ctx the parse tree
	 */
	void enterTermoRelacional(LAParser.TermoRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#termoRelacional}.
	 * @param ctx the parse tree
	 */
	void exitTermoRelacional(LAParser.TermoRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(LAParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(LAParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#comandoAtribuicao}.
	 * @param ctx the parse tree
	 */
	void enterComandoAtribuicao(LAParser.ComandoAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#comandoAtribuicao}.
	 * @param ctx the parse tree
	 */
	void exitComandoAtribuicao(LAParser.ComandoAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#comandoEntrada}.
	 * @param ctx the parse tree
	 */
	void enterComandoEntrada(LAParser.ComandoEntradaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#comandoEntrada}.
	 * @param ctx the parse tree
	 */
	void exitComandoEntrada(LAParser.ComandoEntradaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#comandoSaida}.
	 * @param ctx the parse tree
	 */
	void enterComandoSaida(LAParser.ComandoSaidaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#comandoSaida}.
	 * @param ctx the parse tree
	 */
	void exitComandoSaida(LAParser.ComandoSaidaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#comandoCondicao}.
	 * @param ctx the parse tree
	 */
	void enterComandoCondicao(LAParser.ComandoCondicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#comandoCondicao}.
	 * @param ctx the parse tree
	 */
	void exitComandoCondicao(LAParser.ComandoCondicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#comandoRepeticao}.
	 * @param ctx the parse tree
	 */
	void enterComandoRepeticao(LAParser.ComandoRepeticaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#comandoRepeticao}.
	 * @param ctx the parse tree
	 */
	void exitComandoRepeticao(LAParser.ComandoRepeticaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LAParser#subAlgoritmo}.
	 * @param ctx the parse tree
	 */
	void enterSubAlgoritmo(LAParser.SubAlgoritmoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LAParser#subAlgoritmo}.
	 * @param ctx the parse tree
	 */
	void exitSubAlgoritmo(LAParser.SubAlgoritmoContext ctx);
}
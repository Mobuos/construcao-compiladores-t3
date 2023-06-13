package br.ufscar.dc.compiladores;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;

import br.ufscar.dc.compiladores.LAParser.FatorAritmeticoContext;
import br.ufscar.dc.compiladores.LAParser.TermoAritmeticoContext;

public class LASemanticoUtils {
    public static List<String> errosSemanticos = new ArrayList<>();
    
    public static void adicionarErroSemantico(Token t, String mensagem) {
        int linha = t.getLine();
        int coluna = t.getCharPositionInLine();
        errosSemanticos.add(String.format("Erro %d:%d - %s", linha, coluna, mensagem));
    }
    
    public static ExemploTabelaDeSimbolos.TipoLA verificarTipo(ExemploTabelaDeSimbolos tabela, LAParser.ExpressaoAritmeticaContext ctx) {
        ExemploTabelaDeSimbolos.TipoLA ret = null;
        for (TermoAritmeticoContext ta : ctx.termoAritmetico()) {
            ExemploTabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, ta);
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != ExemploTabelaDeSimbolos.TipoLA.INVALIDO) {
                adicionarErroSemantico(ctx.start, "Expressão " + ctx.getText() + " contém tipos incompatíveis");
                ret = ExemploTabelaDeSimbolos.TipoLA.INVALIDO;
            }
        }

        return ret;
    }

    public static ExemploTabelaDeSimbolos.TipoLA verificarTipo(ExemploTabelaDeSimbolos tabela, LAParser.TermoAritmeticoContext ctx) {
        ExemploTabelaDeSimbolos.TipoLA ret = null;

        for (FatorAritmeticoContext fa : ctx.fatorAritmetico()) {
            ExemploTabelaDeSimbolos.TipoLA aux = verificarTipo(tabela, fa);
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != ExemploTabelaDeSimbolos.TipoLA.INVALIDO) {
                adicionarErroSemantico(ctx.start, "Termo " + ctx.getText() + " contém tipos incompatíveis");
                ret = ExemploTabelaDeSimbolos.TipoLA.INVALIDO;
            }
        }
        return ret;
    }

    public static ExemploTabelaDeSimbolos.TipoLA verificarTipo(ExemploTabelaDeSimbolos tabela, LAParser.FatorAritmeticoContext ctx) {
        if (ctx.NUMINT() != null) {
            return ExemploTabelaDeSimbolos.TipoLA.INTEIRO;
        }
        if (ctx.NUMREAL() != null) {
            return ExemploTabelaDeSimbolos.TipoLA.REAL;
        }
        if (ctx.VARIAVEL() != null) {
            String nomeVar = ctx.VARIAVEL().getText();
            if (!tabela.existe(nomeVar)) {
                adicionarErroSemantico(ctx.VARIAVEL().getSymbol(), "Variável " + nomeVar + " não foi declarada antes do uso");
                return ExemploTabelaDeSimbolos.TipoLA.INVALIDO;
            }
            return verificarTipo(tabela, nomeVar);
        }
        // se não for nenhum dos tipos acima, só pode ser uma expressão
        // entre parêntesis
        return verificarTipo(tabela, ctx.expressaoAritmetica());
    }
    
    public static ExemploTabelaDeSimbolos.TipoLA verificarTipo(ExemploTabelaDeSimbolos tabela, String nomeVar) {
        return tabela.verificar(nomeVar);
    }    
}

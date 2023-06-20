package br.ufscar.dc.compiladores;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import br.ufscar.dc.compiladores.LAParser.TipoContext;
import br.ufscar.dc.compiladores. LAParser.Tipo_basicoContext;
import br.ufscar.dc.compiladores.LAParser.Tipo_variavelContext;
import br.ufscar.dc.compiladores.LAParser.VariavelContext;
import br.ufscar.dc.compiladores.TabelaDeSimbolos.TipoDeclaracao;
public class LASemanticoUtils {
    public static List<String> errosSemanticos = new ArrayList<>();
    
    public static void adicionarErroSemantico
    (
        Token t,
        String mensagem
    ) 
    {
        int linha = t.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }

    public static TipoDeclaracao verificarTipo
    (
        TabelaDeSimbolos tabela,
        Tipo_basicoContext ctx)
    {
        if (ctx.LITERAL() != null){
            return TipoDeclaracao.LITERAL;
        }
        else if (ctx.INTEIRO() != null){
            return TipoDeclaracao.INTEIRO;
        }
        else if (ctx.LOGICO() != null){
            return TipoDeclaracao.LOGICO;
        }
        else if (ctx.REAL() != null){
            return TipoDeclaracao.REAL;
        }
        else {
            return TipoDeclaracao.INVALIDO;
        }
    }

    public static TipoDeclaracao verificarTipo
    (
        TabelaDeSimbolos tabela,
        Tipo_variavelContext ctx
    )
    {
        TipoDeclaracao tipo;

        // Caso haja o simbolo de ponteiro antes é declarado como ponteiro.
        if (ctx.PONTEIRO() != null){
            return TipoDeclaracao.PONTEIRO;
        }

        // Caso seja um identificador, é um registro,
        // então é necessário ver se o tipo de registro existe.
        else if (ctx.IDENT() != null) {
            if (!tabela.existe(ctx.IDENT().getText())){
                return TipoDeclaracao.INVALIDO;
            }
            else{
                tipo = TipoDeclaracao.REGISTRO;
            }
        }
        
        // É uma variável de tipo básico.
        else {
            tipo = verificarTipo(tabela, ctx.tipo_basico());
        }

        
        return tipo;
    }

    public static TipoDeclaracao verificarTipo
    (
        TabelaDeSimbolos tabela,
        TipoContext ctx
    )
    {
        // if (ctx.tipo_variavel() != null){
            return verificarTipo(tabela, ctx.tipo_variavel());
        // }
        // else{
        //     return verificarTipo(tabela, ctx.registro());
        // }
    }

    public static TipoDeclaracao verificarTipo
    (
        TabelaDeSimbolos tabela,
        VariavelContext ctx
    )
    {
        TipoDeclaracao tipo = verificarTipo(tabela, ctx.tipo());

        ctx.identificador().forEach(ident -> {
            if (tabela.existe(ident.getText())){
                adicionarErroSemantico(
                    ctx.tipo().start,
                    "identificador " + ident.getText() + " ja declarado anteriormente"
                    );
            }
            else{
                tabela.adicionar(ident.getText(), tipo);
            }
        });

        if (tipo == TipoDeclaracao.INVALIDO){
            adicionarErroSemantico(ctx.tipo().start, "tipo " + ctx.tipo().getText() + " nao declarado" );
        }

        return tipo;
    }
}

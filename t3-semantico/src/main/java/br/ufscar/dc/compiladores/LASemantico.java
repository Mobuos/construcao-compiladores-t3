package br.ufscar.dc.compiladores;

import java.util.LinkedList;

import br.ufscar.dc.compiladores.LAParser.Declaracao_funcoesContext;
import br.ufscar.dc.compiladores.LAParser.Declaracao_variaveisContext;
import br.ufscar.dc.compiladores.LAParser.DeclaracoesContext;
import br.ufscar.dc.compiladores.LAParser.IdentificadorContext;

public class LASemantico extends LABaseVisitor<Void> {

    Escopo escopo = new Escopo();

    @Override
    public Void visitDeclaracoes
    (
        DeclaracoesContext ctx
    ) 
    {
        escopo.criarNovoEscopo();
        return super.visitDeclaracoes(ctx);
    }

    @Override
    public Void visitDeclaracao_funcoes
    (
        Declaracao_funcoesContext ctx
    )
    {
        TabelaDeSimbolos tabelaAtual = escopo.escopoAtual();

        if (ctx.PROCEDIMENTO() != null){
            String nome = ctx.PROCEDIMENTO().getText();

            // TODO: Colocar erro semântico caso o nome do procedimento já exista.
            if (tabelaAtual.existe(nome)){
                
            }
        }
        else if (ctx.FUNCAO() != null){
            String nome = ctx.FUNCAO().getText();
            
            // TODO: Colocar erro semântico caso o nome do procedimento já exista.
            if (tabelaAtual.existe(nome)){
            }
        }

        return super.visitDeclaracao_funcoes(ctx);
    }

    @Override
    public Void visitDeclaracao_variaveis
    (
        Declaracao_variaveisContext ctx
    )
    {
        TabelaDeSimbolos tabela = escopo.escopoAtual();

        if (ctx.DECLARE() != null){
            String nome = ctx.DECLARE().getText();

            // TODO: Colocar erro que já exista a variável.
            if (tabela.existe(nome)){
                System.out.println("Variavel " + nome + "ja esta declarada");
            }
            else{
                LASemanticoUtils.verificarTipo(tabela, ctx.variavel());
            }
        }
        return super.visitDeclaracao_variaveis(ctx);
    }

    @Override
    public Void visitIdentificador
    (
        IdentificadorContext ctx
    ) 
    {
        LinkedList<TabelaDeSimbolos> tabelas = escopo.recuperarTodosEscopos();
        String nome = ctx.IDENT().get(0).getText();
        boolean existeVariavel = false;

        for ( TabelaDeSimbolos tabela: tabelas){
            if (tabela.existe(nome)){
                existeVariavel = true;
                break;
            }
        }

        if (!existeVariavel){
            LASemanticoUtils.adicionarErroSemantico(ctx.start, "identificador " + nome + " nao declarado" );
        }

        return super.visitIdentificador(ctx);
    }
}
// ------------  Paquete e importaciones ------------
package analizadorStatpy; 

import java_cup.runtime.*;

%%	
//-------> Directivas (No tocar)

%public 
%class Lexer
%cup
%char
%line
%column
%unicode
%ignorecase


%init{ 
    yyline = 1;
    yycolumn =1;
%init} 

// ------> Expresiones Regulares 

entero = [0-9]+
cadena = [\"][^\"\n]*[\"]
caracter = [\'][^\'\n][\']
decimal = [0-9]+\.[0-9]+
comentlinea = (\/\/)(.+)*
comentmultilinea = [/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]
id = [A-Za-z_][A-Za-z0-9_]*

%%

// ------------  Reglas Lexicas -------------------

"="       { func.Funcion.addTokensStatpy(yytext(), "Signo igual", yyline, yycolumn);
            return new Symbol(sym.IGUAL, yycolumn, yyline, yytext()); }
";"       { func.Funcion.addTokensStatpy(yytext(), "Dos puntos", yyline, yycolumn);
            return new Symbol(sym.PUNTOYCOMA, yycolumn, yyline, yytext()); }
"{"       { func.Funcion.addTokensStatpy(yytext(), "Llave abre", yyline, yycolumn);
            return new Symbol(sym.LLAVE_A, yycolumn, yyline, yytext()); }
"}"       { func.Funcion.addTokensStatpy(yytext(), "Llave cierra", yyline, yycolumn);
            return new Symbol(sym.LLAVE_C, yycolumn, yyline, yytext()); }
"("       { func.Funcion.addTokensStatpy(yytext(), "Parentesis abre", yyline, yycolumn);
            return new Symbol(sym.PARENTESIS_A, yycolumn, yyline, yytext()); }
")"       { func.Funcion.addTokensStatpy(yytext(), "Parentesis cierra", yyline, yycolumn);
            return new Symbol(sym.PARENTESIS_C, yycolumn, yyline, yytext()); }
">"       { func.Funcion.addTokensStatpy(yytext(), "Mayor que", yyline, yycolumn);
            return new Symbol(sym.MAYOR, yycolumn, yyline, yytext()); } 
"<"       { func.Funcion.addTokensStatpy(yytext(), "Menor que", yyline, yycolumn);
            return new Symbol(sym.MENOR, yycolumn, yyline, yytext()); } 
">="      { func.Funcion.addTokensStatpy(yytext(), "Mayor igual", yyline, yycolumn);
            return new Symbol(sym.MAYORIGUAL, yycolumn, yyline, yytext()); }
"<="      { func.Funcion.addTokensStatpy(yytext(), "Menor igual", yyline, yycolumn);
            return new Symbol(sym.MENORIGUAL, yycolumn, yyline, yytext()); }
"=="      { func.Funcion.addTokensStatpy(yytext(), "Igual igual", yyline, yycolumn);
            return new Symbol(sym.IGUAL_IGUAL, yycolumn, yyline, yytext()); }
"!="      { func.Funcion.addTokensStatpy(yytext(), "Diferente de", yyline, yycolumn);
            return new Symbol(sym.DISTINTO, yycolumn, yyline, yytext()); }
"."       { func.Funcion.addTokensStatpy(yytext(), "Punto", yyline, yycolumn);
            return new Symbol(sym.PUNTO, yycolumn, yyline, yytext()); }
":"       { func.Funcion.addTokensStatpy(yytext(), "Dos puntos", yyline, yycolumn);
            return new Symbol(sym.DOSPUNTOS, yycolumn, yyline, yytext()); }
"+"       { func.Funcion.addTokensStatpy(yytext(), "Signo más", yyline, yycolumn);
            return new Symbol(sym.SUMA, yycolumn, yyline, yytext()); }
"-"       { func.Funcion.addTokensStatpy(yytext(), "Signo menos", yyline, yycolumn);
            return new Symbol(sym.RESTA, yycolumn, yyline, yytext()); }
"*"       { func.Funcion.addTokensStatpy(yytext(), "Signo por", yyline, yycolumn);
            return new Symbol(sym.MULTIPLICACION, yycolumn, yyline, yytext()); }
"/"       { func.Funcion.addTokensStatpy(yytext(), "Signo división", yyline, yycolumn);
            return new Symbol(sym.DIVISION, yycolumn, yyline, yytext()); }
"&&"      { func.Funcion.addTokensStatpy(yytext(), "Comparador AND", yyline, yycolumn);
            return new Symbol(sym.AND, yycolumn, yyline, yytext()); }
"||"      { func.Funcion.addTokensStatpy(yytext(), "Comparador OR", yyline, yycolumn);
            return new Symbol(sym.OR, yycolumn, yyline, yytext()); }
"!"       { func.Funcion.addTokensStatpy(yytext(), "Signo negación", yyline, yycolumn);
            return new Symbol(sym.NOT, yycolumn, yyline, yytext()); }
"$"       { func.Funcion.addTokensStatpy(yytext(), "Signo de dolar", yyline, yycolumn);
            return new Symbol(sym.SYMBOLODOLAR, yycolumn, yyline, yytext()); }
","       { func.Funcion.addTokensStatpy(yytext(), "Signo coma", yyline, yycolumn);
            return new Symbol(sym.COMA, yycolumn, yyline, yytext()); }
"["       { func.Funcion.addTokensStatpy(yytext(), "Corchete abre", yyline, yycolumn);
            return new Symbol(sym.CORCHETE_A, yycolumn, yyline, yytext()); }
"]"       { func.Funcion.addTokensStatpy(yytext(), "Corchete cierra", yyline, yycolumn);
            return new Symbol(sym.CORCHETE_C, yycolumn, yyline, yytext()); }
"++"      { func.Funcion.addTokensStatpy(yytext(), "Signo incremento", yyline, yycolumn);
            return new Symbol(sym.INCREMENTO, yycolumn, yyline, yytext()); }

"int"       { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada para tipo entero", yyline, yycolumn);
              return new Symbol(sym.INT, yycolumn, yyline, yytext()); } 
"double"    { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada para tipo decimal", yyline, yycolumn);
              return new Symbol(sym.DOUBLE, yycolumn, yyline, yytext()); } 
"char"      { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada para tipo caracter", yyline, yycolumn);
              return new Symbol(sym.CHAR, yycolumn, yyline, yytext()); } 
"bool"      { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada para tipo boleano", yyline, yycolumn);
              return new Symbol(sym.BOOL, yycolumn, yyline, yytext()); } 
"string"    { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada para tipo cadena", yyline, yycolumn);
              return new Symbol(sym.STRING, yycolumn, yyline, yytext()); } 
"void"      { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada", yyline, yycolumn);
              return new Symbol(sym.VOID, yycolumn, yyline, yytext()); } 
"main"      { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada main", yyline, yycolumn);
              return new Symbol(sym.MAIN, yycolumn, yyline, yytext()); } 
"if"        { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada if", yyline, yycolumn);
              return new Symbol(sym.IF, yycolumn, yyline, yytext()); } 
"else"      { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada else", yyline, yycolumn);
              return new Symbol(sym.ELSE, yycolumn, yyline, yytext()); } 
"switch"    { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada switch", yyline, yycolumn);
              return new Symbol(sym.SWITCH, yycolumn, yyline, yytext()); } 
"case"      { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada case", yyline, yycolumn);
              return new Symbol(sym.CASE, yycolumn, yyline, yytext()); } 
"default"   { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada if", yyline, yycolumn);
              return new Symbol(sym.DEFAULTID, yycolumn, yyline, yytext()); } 
"break"     { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada break", yyline, yycolumn);
              return new Symbol(sym.BREAK, yycolumn, yyline, yytext()); } 
"for"       { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada for", yyline, yycolumn);
              return new Symbol(sym.FOR, yycolumn, yyline, yytext()); } 
"while"     { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada while", yyline, yycolumn);
              return new Symbol(sym.WHILE, yycolumn, yyline, yytext()); } 
"do"        { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada do", yyline, yycolumn);
              return new Symbol(sym.DO, yycolumn, yyline, yytext()); } 
"true"      { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada true", yyline, yycolumn);
              return new Symbol(sym.TRUE, yycolumn, yyline, yytext()); } 
"false"     { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada false", yyline, yycolumn);
              return new Symbol(sym.FALSE, yycolumn, yyline, yytext()); } 
"console"   { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada console", yyline, yycolumn);
              return new Symbol(sym.CONSOLE, yycolumn, yyline, yytext()); } 
"write"     { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada write", yyline, yycolumn);
              return new Symbol(sym.WRITE, yycolumn, yyline, yytext()); } 
"graficapie" { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada grafica pie", yyline, yycolumn);
               return new Symbol(sym.FUNC_GPIE, yycolumn, yyline, yytext()); }
"definirglobales" { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada raficas globales", yyline, yycolumn);
                    return new Symbol(sym.FUNC_GLOBALES, yycolumn, yyline, yytext()); }
"graficabarras" { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada grafica barras", yyline, yycolumn);
                  return new Symbol(sym.FUNC_GBARRAS, yycolumn, yyline, yytext()); }
"ejex" { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada eje x", yyline, yycolumn);
         return new Symbol(sym.EJEX, yycolumn, yyline, yytext()); }
"valores" { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada valores", yyline, yycolumn);
            return new Symbol(sym.VALORES, yycolumn, yyline, yytext()); }
"titulo" { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada titulos", yyline, yycolumn);
           return new Symbol(sym.TITULO, yycolumn, yyline, yytext()); }
"titulox" { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada titulos x", yyline, yycolumn);
            return new Symbol(sym.TITULOX, yycolumn, yyline, yytext()); }
"tituloy" { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada titulo y", yyline, yycolumn);
            return new Symbol(sym.TITULOY, yycolumn, yyline, yytext()); }
"newvalor" { func.Funcion.addTokensStatpy(yytext(), "Palabra reservada newvalor", yyline, yycolumn);
             return new Symbol(sym.NEWVALOR, yycolumn, yyline, yytext()); }

{entero}    { func.Funcion.addTokensStatpy(yytext(), "Numeros enteros", yyline, yycolumn);
              return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); } 
{cadena}    { func.Funcion.addTokensStatpy(yytext(), "Cadenas de texto", yyline, yycolumn);
              return new Symbol(sym.CADENA, yycolumn, yyline, yytext()); } 
{caracter}  { func.Funcion.addTokensStatpy(yytext(), "Caracter", yyline, yycolumn);
                return new Symbol(sym.CARACTER, yycolumn, yyline, yytext()); } 
{decimal}   { func.Funcion.addTokensStatpy(yytext(), "Numeros decimales", yyline, yycolumn);
              return new Symbol(sym.DECIMALES, yycolumn, yyline, yytext()); }
{id}         { func.Funcion.addTokensStatpy(yytext(), "Nombres de variables", yyline, yycolumn);
               return new Symbol(sym.ID, yycolumn, yyline, yytext()); }
{comentlinea} {}
{comentmultilinea} {}


//------> Ingorados 
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}

//------> Errores Léxicos 
.           	{ System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); 
                func.Funcion.addErrListaStatpy( yytext() , "Error Lexico no se reconocio el caracter" , yyline, yycolumn);}

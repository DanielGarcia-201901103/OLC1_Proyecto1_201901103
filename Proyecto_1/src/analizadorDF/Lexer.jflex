// ------------  Paquete e importaciones ------------
package analizadorDF; 

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

entero = -?[0-9]+
cadena = [\"][^\"\n]*[\"]
//caracter = [\'][^\'\n][\']
decimal = -?[0-9]+\.[0-9]+
comentlinea = (\!)(.+)*
comentmultilinea =\<\![^<!]*[^!>]*\!\>
id = [A-Za-z_][A-Za-z0-9_]*

%%

// ------------  Reglas Lexicas -------------------

"="       { funcionalidad.Funcion.addTokensDataF(yytext(), "Signo igual", yyline, yycolumn);
            return new Symbol(sym.IGUAL, yycolumn, yyline, yytext()); }
";"       { funcionalidad.Funcion.addTokensDataF(yytext(), "Dos puntos", yyline, yycolumn);
            return new Symbol(sym.PUNTOYCOMA, yycolumn, yyline, yytext()); }
"("       { funcionalidad.Funcion.addTokensDataF(yytext(), "Parentesis abre", yyline, yycolumn);
            return new Symbol(sym.PARENTESIS_A, yycolumn, yyline, yytext()); }
")"       { funcionalidad.Funcion.addTokensDataF(yytext(), "Parentesis cierra", yyline, yycolumn);
            return new Symbol(sym.PARENTESIS_C, yycolumn, yyline, yytext()); }
">"       { funcionalidad.Funcion.addTokensDataF(yytext(), "Mayor que", yyline, yycolumn);
            return new Symbol(sym.MAYOR, yycolumn, yyline, yytext()); } 
"<"       { funcionalidad.Funcion.addTokensDataF(yytext(), "Menor que", yyline, yycolumn);
            return new Symbol(sym.MENOR, yycolumn, yyline, yytext()); } 
":"       { funcionalidad.Funcion.addTokensDataF(yytext(), "Dos puntos", yyline, yycolumn);
            return new Symbol(sym.DOSPUNTOS, yycolumn, yyline, yytext()); }
","       { funcionalidad.Funcion.addTokensDataF(yytext(), "Signo coma", yyline, yycolumn);
            return new Symbol(sym.COMA, yycolumn, yyline, yytext()); }
"["       { funcionalidad.Funcion.addTokensDataF(yytext(), "Corchete abre", yyline, yycolumn);
            return new Symbol(sym.CORCHETE_A, yycolumn, yyline, yytext()); }
"]"       { funcionalidad.Funcion.addTokensDataF(yytext(), "Corchete cierra", yyline, yycolumn);
            return new Symbol(sym.CORCHETE_C, yycolumn, yyline, yytext()); }
"-"       { funcionalidad.Funcion.addTokensDataF(yytext(), "Guion Medio", yyline, yycolumn);
            return new Symbol(sym.GUION_MEDIO, yycolumn, yyline, yytext()); }
"@"       { funcionalidad.Funcion.addTokensDataF(yytext(), "Arroba", yyline, yycolumn);
            return new Symbol(sym.ARROBA, yycolumn, yyline, yytext()); }

"program"       { funcionalidad.Funcion.addTokensDataF(yytext(), "Palabra Reservada", yyline, yycolumn);
              return new Symbol(sym.R_PROGRAM, yycolumn, yyline, yytext()); } 
"end"    { funcionalidad.Funcion.addTokensDataF(yytext(), "Palabra Reservada", yyline, yycolumn);
              return new Symbol(sym.R_END, yycolumn, yyline, yytext()); } 
"char"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Cadena", yyline, yycolumn);
              return new Symbol(sym.R_CHAR, yycolumn, yyline, yytext()); } 
"var"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Declaracion de variables", yyline, yycolumn);
              return new Symbol(sym.R_VAR, yycolumn, yyline, yytext()); }  
"double"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Decimal", yyline, yycolumn);
              return new Symbol(sym.R_DOUBLE, yycolumn, yyline, yytext()); }  
"arr"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Id Arreglos", yyline, yycolumn);
              return new Symbol(sym.R_ARR, yycolumn, yyline, yytext()); }  
"sum"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Suma", yyline, yycolumn);
              return new Symbol(sym.R_SUM, yycolumn, yyline, yytext()); }  
"res"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Resta", yyline, yycolumn);
              return new Symbol(sym.R_RES, yycolumn, yyline, yytext()); }  
"mul"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Multiplicacion", yyline, yycolumn);
              return new Symbol(sym.R_MUL, yycolumn, yyline, yytext()); }  
"div"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Division", yyline, yycolumn);
              return new Symbol(sym.R_DIV, yycolumn, yyline, yytext()); }  
"mod"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Modulo", yyline, yycolumn);
              return new Symbol(sym.R_MOD, yycolumn, yyline, yytext()); }  
"media"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Media", yyline, yycolumn);
              return new Symbol(sym.R_MEDIA, yycolumn, yyline, yytext()); }  
"mediana"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Mediana", yyline, yycolumn);
              return new Symbol(sym.R_MEDIANA, yycolumn, yyline, yytext()); }  
"moda"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada para Moda", yyline, yycolumn);
              return new Symbol(sym.R_MODA, yycolumn, yyline, yytext()); }  
"varianza"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Varianza", yyline, yycolumn);
              return new Symbol(sym.R_VARIANZA, yycolumn, yyline, yytext()); }  
"max"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Maximo", yyline, yycolumn);
              return new Symbol(sym.R_MAX, yycolumn, yyline, yytext()); }  
"min"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Minimo", yyline, yycolumn);
              return new Symbol(sym.R_MIN, yycolumn, yyline, yytext()); }  
"console"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Impresion", yyline, yycolumn);
              return new Symbol(sym.R_CONSOLE, yycolumn, yyline, yytext()); } 
"print"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Impresion", yyline, yycolumn);
              return new Symbol(sym.R_PRINT, yycolumn, yyline, yytext()); }  
"column"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Impresion Arreglos", yyline, yycolumn);
              return new Symbol(sym.R_COLUMN, yycolumn, yyline, yytext()); }  
"exec"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Ejecución Grafica", yyline, yycolumn);
              return new Symbol(sym.R_EXEC, yycolumn, yyline, yytext()); }  
"values"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Graficacion", yyline, yycolumn);
              return new Symbol(sym.R_VALUES, yycolumn, yyline, yytext()); }  
"titulo"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Graficacion", yyline, yycolumn);
              return new Symbol(sym.R_TITULO, yycolumn, yyline, yytext()); }   
"label"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Graficacion", yyline, yycolumn);
              return new Symbol(sym.R_LABEL, yycolumn, yyline, yytext()); }  
"ejex"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Graficacion", yyline, yycolumn);
              return new Symbol(sym.R_EJEX, yycolumn, yyline, yytext()); }  
"ejey"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Graficacion", yyline, yycolumn);
              return new Symbol(sym.R_EJEY, yycolumn, yyline, yytext()); }  
"titulox"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Graficacion", yyline, yycolumn);
              return new Symbol(sym.R_TITULOX, yycolumn, yyline, yytext()); }  
"tituloy"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Graficacion", yyline, yycolumn);
              return new Symbol(sym.R_TITULOY, yycolumn, yyline, yytext()); }  
"histogram"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Histograma", yyline, yycolumn);
              return new Symbol(sym.R_HISTOGRAM, yycolumn, yyline, yytext()); }  
"graphline"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Grafica Linea", yyline, yycolumn);
              return new Symbol(sym.R_GLINE, yycolumn, yyline, yytext()); }  
"graphpie"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Grafica Pie", yyline, yycolumn);
              return new Symbol(sym.R_GPIE, yycolumn, yyline, yytext()); }  
"graphbar"      { funcionalidad.Funcion.addTokensDataF(yytext(), "Reservada Grafica Barras", yyline, yycolumn);
              return new Symbol(sym.R_GBAR, yycolumn, yyline, yytext()); } 

{entero}    { funcionalidad.Funcion.addTokensDataF(yytext(), "Double", yyline, yycolumn);
              return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); } 
{cadena}    { funcionalidad.Funcion.addTokensDataF(yytext(), "String", yyline, yycolumn);
              return new Symbol(sym.CADENA, yycolumn, yyline, yytext()); }  
{decimal}   { funcionalidad.Funcion.addTokensDataF(yytext(), "Double", yyline, yycolumn);
              return new Symbol(sym.DECIMALES, yycolumn, yyline, yytext()); }
{id}         { funcionalidad.Funcion.addTokensDataF(yytext(), "Identificador", yyline, yycolumn);
               return new Symbol(sym.ID, yycolumn, yyline, yytext()); }
{comentlinea} {}
{comentmultilinea} {}


//------> Ingorados 
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}

//------> Errores Léxicos 
.           	{ System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); 
                funcionalidad.Funcion.addErroresLista( "Léxico" , "El carácter \"" + yytext() + "\" no pertenece al lenguaje", yyline, yycolumn);}

/**
 * Si dimostra un utilizzo della classe {@link java.lang.ThreadLocal}.
 * <p>
 * Questa class fornisce variabili <i>thread-local</i>, ossia locali al thread.
 * Queste variabili differiscono dalle loro controparti usuali nel fatto che
 * ogni thread che vi accede, attraverso i metodi
 * {@link java.lang.ThreadLocal#get()} e
 * {@link java.lang.ThreadLocal#set(Object)} "vede" una sua propria copia della
 * variabile, inizializzata indipendentemente per ogni thread. Le istanze di
 * questa classe sono tipicamente campi privati e statici che vogliono associare
 * uno stato per ogni thread.
 */
package org.gmnz.ddi.ch15.threadlocal;


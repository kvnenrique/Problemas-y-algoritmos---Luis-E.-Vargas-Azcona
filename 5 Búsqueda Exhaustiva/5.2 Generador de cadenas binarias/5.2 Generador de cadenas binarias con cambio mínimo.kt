package org.example

// Just to be able to use the {!} operator to switch between 0 and 1
operator fun Int.not(): Int {
    return when (this) {
        1 -> 0
        0 -> 1
        else -> this
    }
}

fun main() {
    val C = mutableListOf(0, 0, 0)
    val n = C.size

    generate(n, C)
}

fun generate(n: Int, C: MutableList<Int>) {
    if (n == 0) {
        println(C.joinToString(" ", "", ""))
    } else {
        /**
         * La implementación del código en el libro contiene un error, se muestra el 
         * llamado recursivo a la función generate() de la siguientes manera:
         *      generate(i, C)
         * No se especifica en ningún lugar que el valor de {i} debe ser equivalennte
         * a {n-1}
         */
        generate(n-1, C)
        C[n-1] = !C[n-1]
        generate(n-1, C)
    }
}
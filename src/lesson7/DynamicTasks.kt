@file:Suppress("UNUSED_PARAMETER")

package lesson7

import kotlin.math.max

/**
 * Наибольшая общая подпоследовательность.
 * Средняя
 *
 * Дано две строки, например "nematode knowledge" и "empty bottle".
 * Найти их самую длинную общую подпоследовательность -- в примере это "emt ole".
 * Подпоследовательность отличается от подстроки тем, что её символы не обязаны идти подряд
 * (но по-прежнему должны быть расположены в исходной строке в том же порядке).
 * Если общей подпоследовательности нет, вернуть пустую строку.
 * Если есть несколько самых длинных общих подпоследовательностей, вернуть любую из них.
 * При сравнении подстрок, регистр символов *имеет* значение.
 */
// Т = O(N*M)
// R = O(N*M)
fun longestCommonSubSequence(first: String, second: String): String {
    val mas = Array(first.length + 1) { Array(second.length + 1) { 0 } }
    for (i in first.length - 1 downTo 0)
        for (j in second.length - 1 downTo 0)
            mas[i][j] = if (first[i] == second[j]) mas[i + 1][j + 1] + 1 else max(mas[i + 1][j], mas[i][j + 1])
    val result = StringBuilder()
    var i = 0
    var j = 0
    while (i < first.length && j < second.length && mas[i][j] != 0) {
        when {
            first[i] == second[j] -> {
                result.append(first[i])
                i++
                j++
            }
            mas[i][j] == mas[i + 1][j] -> i++
            else -> j++
        }
    }
    return result.toString()
}

/**
 * Наибольшая возрастающая подпоследовательность
 * Сложная
 *
 * Дан список целых чисел, например, [2 8 5 9 12 6].
 * Найти в нём самую длинную возрастающую подпоследовательность.
 * Элементы подпоследовательности не обязаны идти подряд,
 * но должны быть расположены в исходном списке в том же порядке.
 * Если самых длинных возрастающих подпоследовательностей несколько (как в примере),
 * то вернуть ту, в которой числа расположены раньше (приоритет имеют первые числа).
 * В примере ответами являются 2, 8, 9, 12 или 2, 5, 9, 12 -- выбираем первую из них.
 */

// Т = O(N*N)
// R = O(N)
fun longestIncreasingSubSequence(list: List<Int>): List<Int> {
    val result = ArrayList<Int>()
    if (list.isEmpty()) return result
    val prev = IntArray(list.size)
    val d = IntArray(list.size)
    for (i in list.indices) {
        d[i] = 1
        prev[i] = -1
        for (j in 0..i)
            if (list[j] < list[i] && d[j] + 1 > d[i]) {
                d[i] = d[j] + 1
                prev[i] = j
            }
    }
    var pos = 0
    var len = d[0]
    for (i in list.indices)
        if (d[i] > len) {
            pos = i
            len = d[i]
        }
    while (pos != -1) {
        result.add(0, list[pos])
        pos = prev[pos]
    }
    return result
}

/**
 * Самый короткий маршрут на прямоугольном поле.
 * Средняя
 *
 * В файле с именем inputName задано прямоугольное поле:
 *
 * 0 2 3 2 4 1
 * 1 5 3 4 6 2
 * 2 6 2 5 1 3
 * 1 4 3 2 6 2
 * 4 2 3 1 5 0
 *
 * Можно совершать шаги длиной в одну клетку вправо, вниз или по диагонали вправо-вниз.
 * В каждой клетке записано некоторое натуральное число или нуль.
 * Необходимо попасть из верхней левой клетки в правую нижнюю.
 * Вес маршрута вычисляется как сумма чисел со всех посещенных клеток.
 * Необходимо найти маршрут с минимальным весом и вернуть этот минимальный вес.
 *
 * Здесь ответ 2 + 3 + 4 + 1 + 2 = 12
 */
fun shortestPathOnField(inputName: String): Int {
    TODO()
}

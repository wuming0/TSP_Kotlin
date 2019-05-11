/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package core.algorithms.sa.temperatures

import core.algorithms.sa.ITemperature
import kotlin.math.max

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
class PolynomialSchedule constructor(
        private val startTemperature: Double,
        private val alpha: Double = 2.0,
        private val maxTemperature: Double = startTemperature
) : ITemperature {

    override fun getTemperature(timePoint: Int): Double {
        return Math.pow(max(0.0, 1 - timePoint / maxTemperature), alpha) * startTemperature
    }
}
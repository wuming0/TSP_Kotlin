/*
 * Copyright (c) 2019.
 * 有问题请联系：wumingdemail@163.com
 */

package problems.TSP

import core.IProblem
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.RuntimeException
import java.nio.file.NotDirectoryException
import java.nio.file.Paths

/**
 *@作者:Zhichao Wu
 *@时间:2019/4/22
 */
class TSPProblem constructor(
        city: Int = 50
) : IProblem<IntArray> {
    lateinit var cities: Array<Pair<String, Pair<Double, Double>>>
    private lateinit var citiesDistance: Array<DoubleArray>

    init {
        initCity(city)
        computeDistance()
    }

    private fun initCity(cityCount: Int) {
        val resourceRoot = Paths.get((this.javaClass.getResource("/")
                ?: throw NotDirectoryException("")).toURI()).toString()
        val data = ArrayList<Pair<String, Pair<Double, Double>>>()

        val reader = BufferedReader(InputStreamReader(FileInputStream(Paths.get(resourceRoot, "中国城市经纬度.csv").toFile())))
        reader.use {
            var line = reader.readLine()
            while (data.size < cityCount && line != null) {
                line = reader.readLine()
                data.add(parseLine(line))
            }
        }
        cities = Array(data.size) { data[it] }
    }

    private fun parseLine(line: String): Pair<String, Pair<Double, Double>> {
        var cityName = ""
        var cityLongitude = 0.0
        val cityLatitude: Double
        val builder = StringBuilder()
        var count = 0
        for (elem in line) {
            if (elem == '\t') {
                when (count) {
                    1 -> cityName = builder.toString()
                    2 -> {
                        try {
                            cityLongitude = builder.toString().toDouble()
                        } catch (e: Exception) {
                            throw RuntimeException("无法解析：$line")
                        }
                    }
                }
                count++
                builder.delete(0, builder.length)
            } else {
                builder.append(elem)
            }
        }
        if (count == 3) {
            try {
                cityLatitude = builder.toString().toDouble()
            } catch (e: Exception) {
                throw RuntimeException("无法解析：$line")
            }
        } else {
            throw RuntimeException("无法解析：$line")
        }
        return Pair(cityName, Pair(cityLongitude, cityLatitude))
    }

    private fun computeDistance() {
        citiesDistance = Array(cities.size) { DoubleArray(cities.size) }
        for (i in 0 until citiesDistance.size) {
            for (j in i until citiesDistance.size) {
                if (i == j) {
                    citiesDistance[i][j] = 0.0
                } else {
                    citiesDistance[i][j] = 6371004 * Math.acos(
                            Math.sin(cities[i].second.second / 180 * Math.PI) *
                                    Math.sin(cities[j].second.second / 180 * Math.PI) +
                                    Math.cos(cities[i].second.second / 180 * Math.PI) *
                                    Math.cos(cities[j].second.second / 180 * Math.PI) *
                                    Math.cos((cities[i].second.first - cities[j].second.first) / 180 * Math.PI)
                    )
                }
                citiesDistance[j][i] = citiesDistance[i][j]
            }
        }
    }

    val citiesCount get() = cities.size

    override fun evaluate(solution: IntArray): Double {
        var result=-citiesDistance[solution[0]][solution[solution.size-1]]
        for (i in 0 until solution.size-1){
            result-=citiesDistance[solution[i]][solution[i+1]]
        }
        return result
    }

    fun getTripFoot(solution: IntArray):String{
        if (solution.isEmpty()){
            return ""
        }
        val result=StringBuilder()
        result.append(cities[solution[0]])
        for (i in 1 until solution.size){
            result.append("->${cities[solution[i]]}")
        }
        return result.toString()
    }
}
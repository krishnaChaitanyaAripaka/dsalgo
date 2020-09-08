package com.chaitu.javaconcepts

object EqualsHashcode {
    @JvmStatic
    fun main(args: Array<String>) {

        var map = mutableMapOf<Drink, String>()

        val pepsi1 = Drink(2020, "Pepsi")
        val coke1 = Drink(2020, "Coke")
        val pepsi2 = Drink(2021, "Pepsi")
        val coke2 = Drink(2020, "Coke")

        map.put(coke1, "Yahoo")
        map.put(coke2, "Hurray")

        print("===========\n")
        println("coke equals : ${coke1 == coke2}")
    }

    class Drink(year: Int, var brand: String) {

        override fun hashCode(): Int {
            println("Drink class hashCode impl")
            return brand.hashCode()
        }

        override fun equals(other: Any?): Boolean {
            println("Drink class equals impl")

            if (other == null) return false

            if (this::class.java != other::class.java) return false

            val otherInstance = other as Drink
            return this.hashCode() == otherInstance.hashCode()
        }
    }
}

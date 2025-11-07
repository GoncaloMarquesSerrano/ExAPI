package pt.ipt.dam2025.exapi.model

class Model {

    data class DogFactResponse(
        val data: List<DogFact>
    )

    data class DogFact(
        val attributes: DogFactAttributes
    )

    data class DogFactAttributes(
        val body: String
    )
}